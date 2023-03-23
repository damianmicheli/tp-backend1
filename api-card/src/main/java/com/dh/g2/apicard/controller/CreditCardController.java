package com.dh.g2.apicard.controller;


import com.dh.g2.apicard.model.CreditCard;
import com.dh.g2.apicard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditcard/")
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
    ResponseEntity<CreditCard> saveCreditCard(@RequestBody String idType, String idNumber) {
        return ResponseEntity.ok().body(creditCardService.save(idType, idNumber));
    }

    @GetMapping("/find")
    ResponseEntity<CreditCard> findCreditCard(@RequestBody String idType, String idNumber) {
        return ResponseEntity.ok().body(creditCardService.find(idType, idNumber));
    }



}
