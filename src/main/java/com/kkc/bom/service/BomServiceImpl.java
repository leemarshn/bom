package com.kkc.bom.service;

import com.kkc.bom.model.BOM;
import com.kkc.bom.model.CostOfGoods;
import com.kkc.bom.model.RawMaterial;
import com.kkc.bom.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Thursday 05 May 2022 - 8:29 AM
 */
@Service
public class BomServiceImpl implements BomService {
    public static final double taxRate = 0.16;
    public static final double adminRate = 0.4;
    public static final double wholesaleRate = 0.4;
    public static final double retailRate = 0.7;


    @Autowired
    private BOMRepository bomRepository;

    @Autowired
    private CogRepo cogRepo;

    @Autowired
    private RMRepository rmRepository;



    @Override
    public double getCostOfGoods(Long id) {
        double cog = 0;
        if (bomRepository.getCostOfGoods(id)!=null)
            cog = bomRepository.getCostOfGoods(id);
        return cog;
    }


    @Override
    public double getProductionCost(double costOfGoods) {
        return costOfGoods + (costOfGoods * adminRate);
    }

    @Override
    public double getWholeSaleCost(double costOfGoods) {
        double productionCost = getProductionCost(costOfGoods);
        return productionCost + (productionCost * wholesaleRate);
    }

    @Override
    public double getRetailCost(double costOfGoods) {
        double retailPrice = getProductionCost(costOfGoods);
        return retailPrice + (retailPrice*retailRate);
    }

    @Override
    public double getRetailCostVAT(double costOfGoods) {
        return getRetailCost(costOfGoods) + (getRetailCost(costOfGoods) * taxRate);
    }

    @Override
    public double getWholesaleCostVat(double costOfGoods) {
       return getWholeSaleCost(costOfGoods)+(getWholeSaleCost(costOfGoods) * taxRate);
    }


    @Override
    public String getNumberFormat(Double value) {
        BigDecimal bd = BigDecimal.valueOf(value);

        BigDecimal bdd = bd.setScale(0, RoundingMode.HALF_UP);
        int num = bdd.intValue();
        int rounded_value= num;
        int mod = num %10;
        int diff = 10 - mod;

        if (mod >= 5){
            rounded_value = rounded_value + diff;
        } else if (mod<5){
            rounded_value = rounded_value - mod;
        }

        return NumberFormat.getInstance().format(rounded_value);
    }

    @Override
    public void deleteBOM(long id) {
        BOM bom = bomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid BOM Id:" + id));

        try {
            Long pid = bomRepository.getProductIDbyBOMId(bom.getId());
            Long cid = cogRepo.getCoGbyProductID(pid);
            double rm_cost = bom.getRawMaterial().getRm_cost();
            int count = bom.getMeasure();
            CostOfGoods costOfGoods = cogRepo.findById(( cid))
                                            .orElseThrow(() -> new IllegalArgumentException("Invalid COG Id:" + id));

            bomRepository.delete(bom);
            costOfGoods.setCost(costOfGoods.getCost()-(rm_cost*count));

            cogRepo.save(costOfGoods);
        }catch (NullPointerException e){

            System.out.println(bom.getId());
        }
    }



}
