package com.dh.g2.apiwallet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Currency {
    @Id
    private Long idCurrency;
    @Column
    private String description;

}
