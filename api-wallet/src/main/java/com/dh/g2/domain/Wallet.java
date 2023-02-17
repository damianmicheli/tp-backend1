package com.dh.g2.domain;

import com.dh.g2.domain.enums.DocumentType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallets")
@Builder
@Data
public class Wallet {

    @Id
    @Column(unique = true)
    String documentNumber;
    DocumentType documentType;

    String coinCode;

    public Wallet() {
    }

    public Wallet(String documentNumber, DocumentType documentType, String coinCode) {
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.coinCode = coinCode;
    }
}
