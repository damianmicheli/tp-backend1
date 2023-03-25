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
public interface MarginsFeign {

    @GetMapping("/calculate/{documentType}/{documentValue}")
    public CalificationDTO calculateCalification(@PathVariable String documentType, @PathVariable String documentValue);

    @Getter
    @Setter
    public class CalificationDTO {

        private String documentType;
        private String documentValue;
        private BigDecimal totalMargin;
        private BigDecimal totalMarginAdditional;
        private List<Sublimit> sublimits;

        @Getter
        @Setter
        public static class Sublimit{
            private Concept concept;
            private BigDecimal totalMargin;
        }

        public enum Concept {
            CARD
        }
    }

}
