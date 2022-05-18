package com.kkc.bom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 06 May 2022 - 11:29 AM
 */

@Entity
@Table(name = "cost_of_goods")
@Getter
@Setter
@NoArgsConstructor
public class CostOfGoods implements Serializable{
    @Id
    @GeneratedValue(generator = "costooo")
    @SequenceGenerator(
            name = "rm_id_generator",
            sequenceName = "rm_id_sequence",
            initialValue = 1000
    )
    private Long id;
    @ManyToOne
    private ProductModel productModel;
    private double cost;
}
