package com.dh.g2.apicard.repository;

import com.dh.g2.apicard.models.CreditCard;
import com.dh.g2.apicard.models.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovementRepository extends MongoRepository<Movement, String> {



}
