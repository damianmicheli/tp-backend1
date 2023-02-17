package com.dh.g2.service.impl;

import com.dh.g2.domain.Wallet;
import com.dh.g2.domain.enums.DocumentType;
import com.dh.g2.repository.WalletJpaRepository;
import com.dh.g2.service.WalletCreationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletCreationService implements WalletCreationCommand {

    private final WalletJpaRepository walletJpaRepository;

    @Autowired
    public WalletCreationService(WalletJpaRepository walletJpaRepository) {
        this.walletJpaRepository = walletJpaRepository;
    }

    @Override
    public Wallet execute(Data data) {
        Wallet wallet = Wallet.builder()
                .documentNumber(data.getDocumentNumber())
                .documentType(DocumentType.getFromValue(data.getDocumentType()))
                .coinCode(data.getCoinCode())
                .build();
        return walletJpaRepository.save(wallet);
    }
}
