package com.dh.g2.apiwallet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Currency {


    @Id
    private int idCurrency;
    @Column
    private String description;


}
