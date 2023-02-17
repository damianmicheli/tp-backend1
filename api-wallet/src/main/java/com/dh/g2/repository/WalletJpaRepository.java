package com.dh.g2.repository;

import com.dh.g2.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletJpaRepository extends JpaRepository<Wallet, String>, JpaSpecificationExecutor<Wallet> {
}
