package com.dh.g2.apicard.exceptions;

public enum MessageError {
    CUSTOMER_WITH_CARD("El cliente no puede tener mas de una tarjeta"),
    CUSTOMER_NOT_HAVE_CARD("El cliente no tiene tarjeta de credito registrada"),
    CUSTOMER_NOT_FOUNDS("El cliente no tiene fondos suficientes VERASSSSS"),
    CUSTOMER_SERVICE_UNAVAILABLE("Por favor, vuelva a intentarlo más tarde. En este momento no podemos responder a su pedido");

    String message;

    MessageError(String message) {
        this.message = message;
    }

}
