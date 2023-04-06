package com.dh.g2.apicard.event;

import com.dh.g2.apicard.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewWalletEventConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_WALLET)
    public void listenNewWalletEvent(NewWalletEventConsumer.Message message) {
        System.out.println("We have a notification of a new wallet with user id : " + message.idType + " " + message.idNum);
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
