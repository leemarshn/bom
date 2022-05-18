package com.kkc.bom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author - LeeN
 * PROJECT NAME: bom
 * CREATED ON: Friday 29 April 2022 - 9:05 PM
 */

@Entity
@Table(name = "default_rates")
@Getter
@Setter
@NoArgsConstructor
public class DefaultRates implements Serializable {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "rm_id_generator",
            sequenceName = "rm_id_sequence",
            initialValue = 1000
    )
    private Long id;
    private double wholesale_markup;
    private double retail_markup;
    private double admin_markup;
    private int tax_rate;
    private double rate_per_hour;

}
