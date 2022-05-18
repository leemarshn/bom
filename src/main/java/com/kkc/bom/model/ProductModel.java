package com.kkc.bom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 6:53 PM
 */
@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_sequence",
            initialValue = 1000
    )
    private Long id;
    private String p_name;
//    private String size;
//    private double price_regulator;


    public ProductModel(String p_name) {
        this.p_name = p_name;
    }
}
