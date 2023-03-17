package com.dh.g2.apicard.service;

import com.dh.g2.apicard.models.CreditCard;
import com.dh.g2.apicard.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private ICreditCardRepository repository;

    public CreditCard save(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    public CreditCard find(String idType, String idNumber) {
        return repository.findByIdTypeAndIdNumber(idType, idNumber);
    }


}
