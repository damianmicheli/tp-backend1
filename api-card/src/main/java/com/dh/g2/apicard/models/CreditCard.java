package com.dh.g2.apicard.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CreditCard {               // Tarjeta de Crédito

    private String cardNumber;          // Número de Tarjeta
    private String idType;              // Tipo de Documento
    private String idNumber;            // Número de Documento
    private Currency currency;          // Moneda
    private BigDecimal limit;           // Límite Calificado
    private BigDecimal usedLimit;       // Límite Consumido
    private BigDecimal availableLimit;  // Límite Disponible

}
