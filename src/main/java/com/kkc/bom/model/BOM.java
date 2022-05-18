package com.kkc.bom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 9:13 PM
 */

@Entity
@Table(name = "bill_of_materials")
@Getter
@Setter
@NoArgsConstructor
public class BOM {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "rm_id_generator",
            sequenceName = "rm_id_sequence",
            initialValue = 1000
    )
    private Long id;
    @ManyToOne
    private RawMaterial rawMaterial;
    @ManyToOne
    private ProductModel productModel;
    private int measure;


}
