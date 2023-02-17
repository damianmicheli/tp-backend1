package com.dh.g2.service;

import com.dh.g2.domain.Wallet;
import lombok.Builder;
import lombok.Data;

public interface WalletCreationCommand {

    Wallet execute(Data data);

    @lombok.Data
    @Builder
    class Data{
        String documentNumber;
        String documentType;
        String coinCode;
    }
}
