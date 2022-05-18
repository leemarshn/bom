package com.kkc.bom.repositories;

import com.kkc.bom.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 10:02 PM
 */
@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Long> {
//    ProductModel save(ProductModel productModel);
}
