package com.kkc.bom.service;

import com.kkc.bom.model.CostOfGoods;
import com.kkc.bom.model.ProductModel;
import com.kkc.bom.model.RawMaterial;
import com.kkc.bom.repositories.CogRepo;
import com.kkc.bom.repositories.ProductRepo;
import com.kkc.bom.repositories.RMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Sunday 08 May 2022 - 6:30 AM
 */
@Service
public class FileHandlerService {

    @Autowired
    private RMRepository rmRepository;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CogRepo cogRepo;

    public void save(String name) {
        List<RawMaterial> rawMaterialList = FileHandlerCSV.processRawMCSV(name);
        rmRepository.saveAll(rawMaterialList);
    }

    public void saveProducts(String name){
        List<ProductModel> productModelList = FileHandlerCSV.processProductsCSV(name);
        productRepo.saveAll(productModelList);

    }

    public ByteArrayInputStream load() {
        List<CostOfGoods> costOfGoods = cogRepo.findAll();
        ByteArrayInputStream in = FileHandlerCSV.cogToCSV(costOfGoods);
        return in;
    }

}
