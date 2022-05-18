package com.kkc.bom.repositories;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Thursday 05 May 2022 - 8:33 AM
 */
public interface BomService {

    double getCostOfGoods(Long id);
    double getProductionCost(double costOfGoods);
    double getWholeSaleCost(double costOfGoods);
    double getRetailCost(double costOfGoods);
    double getRetailCostVAT(double costOfGoods);
    double getWholesaleCostVat(double costOfGoods);
    String  getNumberFormat(Double value);
    void deleteBOM(long id);

}
