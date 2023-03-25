package com.dh.g2.apicard.client;


import com.dh.g2.apicard.config.LoadBalancerConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "api-margins")
@LoadBalancerClient(value="api-margins", configuration= LoadBalancerConfiguration.class)
public interface MarginsServiceClient {

    @GetMapping("/calculate/{documentType}/{documentValue}")
    public CalificationDTO calculateCalification(@PathVariable String documentType, @PathVariable String documentValue);

    @Getter
    @Setter
    public class CalificationDTO {

        private String documentType;
        private String documentValue;
        private BigDecimal totalMargin;
        private BigDecimal totalMarginAdditional;
        private EconomicActivity economicActivity;
        private RiskLevel riskLevel;
        private CustomerCategory customerCategory;
        private List<Sublimit> sublimits;

        @Getter
        @Setter
        public static class Sublimit{
            private Concept concept;
            private BigDecimal totalMargin;
        }

        public enum CustomerCategory {
            BASIC,PREMIUM
        }

        public enum EconomicActivity {
            ForestProduction,
            Agriculture,
            Industry,
            Trade,
            Tourism,
            Bank,
            Education,
            ProductionSupportServices,
            CattleRaising,
            Fishing
        }

        public enum Concept {
            CARD,LOAN,CHECK
        }

        public enum RiskLevel {
            HIGH,LIGHT,MEDIUM
        }
    }

}
