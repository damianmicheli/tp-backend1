package com.dh.g2.apiwallet.repository;

import com.dh.g2.apiwallet.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Long> {
}
