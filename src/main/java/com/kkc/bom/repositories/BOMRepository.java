package com.kkc.bom.repositories;

import com.kkc.bom.model.BOM;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Monday 02 May 2022 - 12:34 AM
 */
@Repository
public interface BOMRepository extends CrudRepository<BOM, Long> {
   @Query("SELECT m  from BOM m where m.productModel.id=?1")
   List<BOM> findBOMById(Long id);
   @Query("SELECT SUM (bm.rawMaterial.rm_cost * bm.measure) from BOM bm WHERE bm.productModel.id=?1")
   Double getCostOfGoods(Long id);
   @Query("SELECT pid.productModel.id FROM BOM pid WHERE pid.id=?1")
   Long getProductIDbyBOMId(long bomID);



}
