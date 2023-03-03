package com.dh.g2.apiwallet.repository;

import com.dh.g2.apiwallet.models.Wallet;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Long> {

   Wallet findbyIdTypeAndIdNum(String idType,int idNum);

}
