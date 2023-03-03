package com.dh.g2.apiwallet.service;

import com.dh.g2.apiwallet.controller.exceptions.EmptyFieldException;
import com.dh.g2.apiwallet.models.Wallet;
import com.dh.g2.apiwallet.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private IWalletRepository walletRepository;



/*    POST (crear)
PUT (modificar todos los campos excepto el tipo y número de
            documento)
DELETE (solo baja lógica)
GET (por tipo y número de documento)*/

    public Wallet create (Wallet wallet)  {

        Wallet foundWallet = walletRepository.findbyIdTypeAndIdNum(wallet.getIdType(),wallet.getIdNum());
        if(foundWallet != null){
            throw new CreatingExistingEntityException("Wallets' IDs are auto-generated, you cannot specify it");
        }
        return walletRepository.save(wallet);
    }



}
