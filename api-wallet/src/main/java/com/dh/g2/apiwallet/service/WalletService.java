package com.dh.g2.apiwallet.service;

import com.dh.g2.apiwallet.models.Wallet;
import com.dh.g2.apiwallet.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService implements IWalletService {

    @Autowired
    private IWalletRepository walletRepository;


    @Override
    public Long create(Wallet wallet) {
        Wallet walletCreated = walletRepository.save(wallet);
        return walletCreated.getId();
    }

/*
    @Override
    public Wallet find(String idType, int idNum) {
        Wallet walletFounded = walletRepository.findByIdTypeAndIdNum(idType, idNum);
        return null;
    }*/

    @Override
    public String update(String idType, int idNum, Double balance) {

        return null;
    }

    @Override
    public Double getBalanceByCurrency(String idType, int idNum, int idCurrency) {
        return null;
    }

    @Override
    public List<String> getAllBalances(String idType, int idNum) {
        List<Wallet> wallets = walletRepository.findAllByIdTypeAndIdNum(idType, idNum);

        List<String> allBalances = new ArrayList<>();

        for(Wallet wallet: wallets) {
            allBalances.add(wallet.getCurrency().getDescription()+" "+wallet.getBalance());
        }

        return allBalances;
    }
}
