package com.dh.g2.apicard.controller;


import com.dh.g2.apicard.exceptions.CardException;
import com.dh.g2.apicard.exceptions.MessageError;
import com.dh.g2.apicard.model.CreditCard;
import com.dh.g2.apicard.model.Movement;
import com.dh.g2.apicard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api/creditcard")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;


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

    @PostMapping("/save")
    //@ResponseStatus(value = HttpStatus.CREATED)
    String saveCreditCard(@RequestBody CreditCard creditCard ) throws CardException {
        try {
            creditCardService.save(creditCard.getIdType(), creditCard.getIdNumber());
            return creditCard.getIdNumber();
        } catch (Exception e) {
            //throw new CardException(MessageError.CUSTOMER_SERVICE_UNAVAILABLE);
            return e.getLocalizedMessage();
        }
    }

    @GetMapping("/find")
    @ResponseStatus(value = HttpStatus.FOUND)
    CreditCard findCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.find(creditCard.getIdType(), creditCard.getIdNumber());
    }

    @PutMapping("/debit")
    public void debit(@RequestBody Movement movement) throws CardException {
        this.creditCardService.debit(movement);
    }

}
