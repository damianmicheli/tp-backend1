package com.dh.g2.web.rest.model.out;

import com.dh.g2.domain.Wallet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletRestResponse {
    @Id
    private String documentNumber;
    private String documentType;

    private String coinCode;

    public static WalletRestResponse fromDomain(Wallet wallet){
        return WalletRestResponse.builder()
                .documentNumber(wallet.getDocumentNumber())
                .documentType(wallet.getDocumentType().name())
                .coinCode(wallet.getCoinCode())
                .build();
    }
}
