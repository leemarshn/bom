package com.kkc.bom.repositories;

import com.kkc.bom.model.CostOfGoods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 06 May 2022 - 11:41 AM
 */

public interface COGRepository {
    void saveCog(Long id);
//    String formatNumber(Number nm);
   // Long findByProductId(Long id);
}
