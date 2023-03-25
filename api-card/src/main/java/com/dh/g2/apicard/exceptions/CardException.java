package com.dh.g2.apicard.exceptions;

public class CardException extends Exception{
    public CardException(MessageError message) {
        super(String.valueOf(message));
    }
}
