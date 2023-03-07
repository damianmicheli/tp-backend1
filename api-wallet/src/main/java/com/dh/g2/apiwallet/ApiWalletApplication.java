package com.dh.g2.apiwallet;

import com.dh.g2.apiwallet.models.Currency;
import com.dh.g2.apiwallet.models.Wallet;
import com.dh.g2.apiwallet.repository.ICurrencyRepository;
import com.dh.g2.apiwallet.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ApiWalletApplication {


//	@Autowired
//	private static ICurrencyRepository currencyRepository;
//
//	@Autowired
//	private static IWalletRepository walletrepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiWalletApplication.class, args);
//		Currency currency = currencyRepository.save(new Currency(1l, "crypto-dh"));
//		walletrepository.save(new Wallet(1l,"DNI", 11222333, currency,0.0));
//		walletrepository.save(new Wallet(null,"Pasaporte", 9998213, currency,10.0));
	}

}
