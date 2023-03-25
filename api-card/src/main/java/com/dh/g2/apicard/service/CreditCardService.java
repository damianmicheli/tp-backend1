package com.dh.g2.apicard.service;

import com.dh.g2.apicard.client.MarginsFeign;
import com.dh.g2.apicard.exceptions.CardException;
import com.dh.g2.apicard.exceptions.MessageError;
import com.dh.g2.apicard.model.CreditCard;
import com.dh.g2.apicard.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;
    @Autowired
    private MarginsFeign marginsFeign;

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


    public String save(String idType, String idNumber) throws CardException {

        if (creditCardRepository.findByIdTypeAndIdNumber(idType, idNumber).isPresent()) {
            throw new CardException(MessageError.CUSTOMER_WITH_CARD);
        }
        CreditCard creditCard = new CreditCard();
        creditCard.setIdType(idType);
        creditCard.setIdNumber(idNumber);
        creditCard.setCardNumber(idNumber + Math.random()*Math.pow(10,6));
        //MarginsFeign.CalificationDTO calificationDTO = marginsFeign.calculateCalification(creditCard.getIdType(), creditCard.getIdNumber());
        //BigDecimal totalMarginCard = calificationDTO.getSublimits().stream().filter(sublimit -> sublimit.getConcept().name().equals(MarginsFeign.CalificationDTO.Concept.CARD)).findFirst().get().getTotalMargin();
        //creditCard.setLimit(totalMarginCard);
        //creditCard.setAvailableLimit(totalMarginCard);
        //creditCard.setUsedLimit(BigDecimal.ZERO);
        creditCardRepository.save(creditCard);
        return creditCard.getIdNumber();

    }

    //@Retry(name = "retry Card")
    //@CircuitBreaker(name = "clientCard", fallbackMethod = "findCardFallBack")
    public CreditCard find(String idType, String idNumber) {
        return creditCardRepository.findByIdTypeAndIdNumber(idType, idNumber).get();
    }
    public MarginsFeign.CalificationDTO findCardFallBack(String idNumber, Throwable t) throws Exception {
        throw new Exception("Not Found Card");
    }



}
