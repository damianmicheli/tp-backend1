package com.dh.g2.apicard.service;

import com.dh.g2.apicard.client.MarginsServiceClient;
import com.dh.g2.apicard.model.CreditCard;
import com.dh.g2.apicard.model.Currency;
import com.dh.g2.apicard.repository.ICreditCardRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;
    @Autowired
    private MarginsServiceClient marginsServiceClient;

    /*
    Las operaciones básicas que va tener que implementar este microservicio son:
    ● POST (crear tarjeta con límites) para esto vamos a consumir api-margins
    ● GET (por tipo y número de documento) - consultar tarjetas con sus montos de calificado y disponible
    ● POST (debitar, se debe pasar todos los datos de movimiento, e internamente hacer el débito)
    ● POST(pagar tarjeta, se pasa Numero de tarjeta, Tipo y Número de documento):
       1) Se consulta api-wallet si tiene disponible para pagar
       2) Se debita el dinero de api-wallet
       3) Se devuelve el límite disponible
       4) En caso de no haber disponible se lanza un error.
    */



    public CreditCard save(String idType, String idNumber) {
        // TODO: Validar si el usuario ya tiene una tarjeta creada/asignada
        // TODO: Consultar a api-margins el limite para esta nueva tarjeta
        if(creditCardRepository.findByIdTypeAndIdNumber(idType,idNumber) != null) {
            CreditCard creditCard = new CreditCard( idNumber+"123456", idType, idNumber, new Currency("1","ARS"), null,null,null /*limit, usedLimit, availableLimit*/);
            return creditCardRepository.save(creditCard);
        }
        return null;
    }

    //@Retry(name = "retry Card")
    //@CircuitBreaker(name = "clientCard", fallbackMethod = "findCardFallBack")
    public CreditCard find(String idType, String idNumber) {
        return creditCardRepository.findByIdTypeAndIdNumber(idType, idNumber);
    }
    public MarginsServiceClient.CalificationDTO findCardFallBack(String idNumber, Throwable t) throws Exception {
        throw new Exception("Not Found Card");
    }



}
