package com.dh.g2.apicard.repository;

import com.dh.g2.apicard.model.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICreditCardRepository extends MongoRepository<CreditCard, String> {

    Optional <CreditCard> findByIdTypeAndIdNumber(String idType, String idNumber);

}
