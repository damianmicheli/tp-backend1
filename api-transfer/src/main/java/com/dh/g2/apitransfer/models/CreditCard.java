package com.dh.g2.apitransfer.models;

import java.math.BigDecimal;

public class CreditCard {               // Tarjeta de Crédito

    private String cardNumber;          // Número de Tarjeta
    private String idType;              // Tipo de Documento
    private String idNumber;            // Número de Documento
    private Currency currency;          // Moneda
    private BigDecimal limit;           // Límite Calificado
    private BigDecimal usedLimit;       // Límite Consumido
    private BigDecimal availableLimit;  // Límite Disponible


}
