package com.kkc.bom.service;

import com.kkc.bom.model.CostOfGoods;
import com.kkc.bom.model.ProductModel;
import com.kkc.bom.repositories.BomService;
import com.kkc.bom.repositories.COGRepository;
import com.kkc.bom.repositories.CogRepo;
import com.kkc.bom.repositories.ProductRepo;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 06 May 2022 - 11:43 AM
 */
@Service
@Transactional
public class CogService implements COGRepository {
    @Autowired
    private BomService bomService;

    @Autowired
    private CogRepo cogRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public void saveCog(Long id) {
        Optional<ProductModel> productModel = productRepo.findById(id);
        CostOfGoods costOfGoods = new CostOfGoods();
        double cog =  bomService.getCostOfGoods(id);
        costOfGoods.setCost(cog);
        costOfGoods.setProductModel(productModel.get());
        if (cogRepo.getCogByProductId(id)!=null){
            cogRepo.updateCog(id, cog);
        }else {
            cogRepo.save(costOfGoods);
        }
    }




}
