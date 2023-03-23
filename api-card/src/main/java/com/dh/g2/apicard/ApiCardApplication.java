package com.dh.g2.apicard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCardApplication.class, args);
	}

}
