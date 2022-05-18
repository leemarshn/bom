package com.kkc.bom.repositories;

import com.kkc.bom.model.CostOfGoods;
import com.kkc.bom.model.ProductModel;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 06 May 2022 - 11:53 AM
 */
@Repository
public interface CogRepo extends JpaRepository<CostOfGoods, Long> {
    @Query("SELECT p.id  from CostOfGoods p where p.productModel.id=?1")
    Long getCoGbyProductID(Long id);
    @Query("SELECT p.productModel.id  from CostOfGoods p where p.productModel.id=?1")
    Long getCogByProductId(Long id);

    @Modifying(clearAutomatically = true)
    @Query("Update CostOfGoods c SET c.productModel.id=?1, c.cost=?2 WHERE c.productModel.id=?1")
    void updateCog(Long id, double cost);



}
