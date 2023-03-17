package com.dh.g2.apicard.controller;


import com.dh.g2.apicard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditcard/")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;





}
