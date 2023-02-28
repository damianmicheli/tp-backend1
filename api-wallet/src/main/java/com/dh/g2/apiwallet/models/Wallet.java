package com.dh.g2.apiwallet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "id_type")
    private String idType;
    @NonNull
    @Column(name = "id_num")
    private int idNum;
    @NonNull
    @Column(name = "id_currency")
    private int idCurrency;
    @NonNull
    @Column(name = "balance")
    private Double balance;

}
