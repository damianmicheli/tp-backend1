package com.dh.g2.apiwallet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_type",unique=true)
    @NonNull
    private String idType;
    @NonNull
    @Column(name = "id_num", unique = true)
    private int idNum;
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_currency", referencedColumnName = "idCurrency")
    @JsonIgnore
    private Currency currency;

    @NonNull
    @Column(name = "balance")
    private Double balance;

}
