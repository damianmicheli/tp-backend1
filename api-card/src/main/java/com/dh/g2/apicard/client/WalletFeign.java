package com.dh.g2.apicard.client;

import com.dh.g2.apicard.config.LoadBalancerConfiguration;
import lombok.*;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "api-wallet")
@LoadBalancerClient(value="api-wallet", configuration= LoadBalancerConfiguration.class)
public interface WalletFeign {


    @GetMapping()
    public ResponseEntity<List<String>> getAllBalances(@RequestParam String idType, @RequestParam int idNum  );


    @Getter
    @Setter
    public class WalletDTO {

        private Long id;
        private String idType;
        private int idNum;
        private Currency currency;
        private Double balance;

        public class Currency {

        }

    }
}
