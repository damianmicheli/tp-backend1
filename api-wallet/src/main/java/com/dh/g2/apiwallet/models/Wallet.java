package com.dh.g2.apiwallet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_currency", referencedColumnName = "idCurrency")
    @JsonIgnore
    private Currency currency;


    @NonNull
    @Column(name = "balance")
    private Double balance;

}
