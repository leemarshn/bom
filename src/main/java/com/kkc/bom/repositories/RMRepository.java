package com.kkc.bom.repositories;

import com.kkc.bom.model.RawMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Tuesday 03 May 2022 - 5:40 PM
 */

@Repository
public interface RMRepository extends CrudRepository<RawMaterial, Long> {
}
