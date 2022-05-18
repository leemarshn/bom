package com.kkc.bom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 8:46 PM
 */


@Entity
@Table(name = "raw_materials")
@Getter
@Setter
@NoArgsConstructor
public class RawMaterial implements Serializable {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "rm_id_generator",
            sequenceName = "rm_id_sequence",
            initialValue = 1000
    )
    private Long id;
    private String rm_name;
//    private String rm_unit;
    private double rm_cost;

    public RawMaterial(String rm_name, double rm_cost) {
        this.rm_name = rm_name;
        this.rm_cost = rm_cost;
    }
}