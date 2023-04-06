package com.dh.g2.apicard.event;

import com.dh.g2.apicard.config.RabbitMQConfig;
import com.dh.g2.apicard.model.CreditCard;
import com.dh.g2.apicard.repository.ICreditCardRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewWalletEventConsumer {

    @Autowired
    ICreditCardRepository creditCardRepository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_WALLET)
    public void listenNewWalletEvent(NewWalletEventConsumer.Message message) {
        System.out.println("We have a notification of a new wallet with user id : " + message.getIdType() + " " + String.valueOf(message.getIdNum()));
        CreditCard creditCard = new CreditCard();
        creditCard.setIdType(message.getIdType());
        creditCard.setIdNumber(String.valueOf(message.getIdNum()));
        creditCard.setCardNumber("123456789");
        creditCardRepository.save(creditCard);
        System.out.println("We have a notification of a new wallet with user id : " + message.getIdType() + " " + String.valueOf(message.getIdNum()));
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
