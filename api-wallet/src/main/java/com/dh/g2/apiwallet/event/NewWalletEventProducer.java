package com.dh.g2.apiwallet.event;

import com.dh.g2.apiwallet.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewWalletEventProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishNewWalletEvent(NewWalletEventProducer.Message message) {
        //queue.publish(message)
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_WALLET, message);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Message {
        private String idType;
        private int idNum;
        //private String mesa;
    }

}
