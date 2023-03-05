package com.dh.g2.apiwallet.service;

import com.dh.g2.apiwallet.models.Wallet;

import java.util.List;

public interface IWalletService {

    Long create(Wallet wallet);
    //Wallet find(String idType, int idNum);
    String update(String idType, int idNum, Double balance);
    Double getBalanceByCurrency(String idType, int idNum, int idCurrency);
    List<String> getAllBalances(String idType, int idNum);

}
