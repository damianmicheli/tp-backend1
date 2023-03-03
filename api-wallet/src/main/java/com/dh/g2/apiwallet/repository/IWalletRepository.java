package com.dh.g2.apiwallet.repository;

import com.dh.g2.apiwallet.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAllByIdTypeAndIdNum(String idType, int idNum);


}
