package com.dh.g2.domain.enums;

import java.util.Arrays;

public enum DocumentType {
    NATIONAL_ID("national_id");

    private String name;

    DocumentType(String name){
        this.name = name;
    };

    public static DocumentType getFromValue(String value){
        return Arrays.stream(DocumentType.values())
                .filter(document -> document.name.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid document type"));
    }
}
