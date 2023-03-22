package com.dh.g2.apicard.models;



import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CREDIT_CARD")
public class CreditCard implements Serializable{               // Tarjeta de Crédito

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String cardNumber;          // Número de Tarjeta
    private String idType;              // Tipo de Documento
    private String idNumber;            // Número de Documento
    private Currency currency;          // Moneda
    private BigDecimal limit;           // Límite Calificado
    private BigDecimal usedLimit;       // Límite Consumido
    private BigDecimal availableLimit;  // Límite Disponible

}
