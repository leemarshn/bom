package com.kkc.bom.service;

import com.kkc.bom.model.CostOfGoods;
import com.kkc.bom.model.ProductModel;
import com.kkc.bom.model.RawMaterial;
import com.kkc.bom.repositories.BomService;
import com.kkc.bom.repositories.RMRepository;
import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Sunday 08 May 2022 - 6:11 AM
 */

public class FileHandlerCSV {

    public final static String DOCUMENT_ROOT ="/home/oracle/Documents/lenhac/bom/src/main/resources/documents/";



    public static List<RawMaterial> processRawMCSV(InputStream fileName) {
        //String path =DOCUMENT_ROOT.concat(fileName);
        List<RawMaterial> materialList = new ArrayList<>();
        try (
                //Reader reader = Files.newBufferedReader(Paths.get(path));
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileName, "UTF-8"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180 .withFirstRecordAsHeader().withHeader("rm_cost", "rm_name")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
//            csvParser.iterator().next();
            for (CSVRecord record : csvParser) {
                RawMaterial rm = new RawMaterial(record.get("rm_name"), Double.parseDouble(record.get("rm_cost")));
                materialList.add(rm);
            }
            return materialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<ProductModel> processProductsCSV(String fileName) {
        String path =DOCUMENT_ROOT.concat(fileName);
        List<ProductModel> productModelList = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path) );
                CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180 .withFirstRecordAsHeader().withHeader("name")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
//            csvParser.iterator().next();
            for (CSVRecord record : csvParser) {
                ProductModel productModel = new ProductModel(record.get("name"));
                productModelList.add(productModel);
            }
            return productModelList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
//356678
    //sort water color puzzles
    //geomatery dash
    //motor x3
    //3D bowl

    static ByteArrayInputStream cogToCSV(List<CostOfGoods> costOfGoods) {
        BomService bomService = new BomServiceImpl();

        final CSVFormat format = CSVFormat.DEFAULT.withHeader("name", "COG", "Production", "Wholesale", "Whole +VAT", "retail", "Retail + VAT");
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (CostOfGoods cog : costOfGoods) {
                double cost = cog.getCost();
                String base_cost    = bomService.getNumberFormat(cog.getCost());
                String p_cost       = bomService.getNumberFormat(bomService.getProductionCost(cost));
                String w_cost       = bomService.getNumberFormat(bomService.getWholeSaleCost(cost));
                String wVat_cost    = bomService.getNumberFormat(bomService.getWholesaleCostVat(cost));
                String r_cost       = bomService.getNumberFormat(bomService.getRetailCost(cost));
                String rVat_cost    = bomService.getNumberFormat(bomService.getRetailCostVAT(cost));

                List<String> data = Arrays.asList(
                        cog.getProductModel().getP_name(),
                        base_cost,
                        p_cost,
                        w_cost,
                        wVat_cost,
                        r_cost,
                        rVat_cost
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
