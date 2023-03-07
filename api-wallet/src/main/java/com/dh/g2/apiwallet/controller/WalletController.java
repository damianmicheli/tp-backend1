package com.dh.g2.apiwallet.controller;

import com.dh.g2.apiwallet.models.Wallet;
import com.dh.g2.apiwallet.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    IWalletService walletService;

    @GetMapping()
    public ResponseEntity<List<String>> getAllBalances(@RequestParam String idType, @RequestParam int idNum  ) {
        return new ResponseEntity<>(walletService.getAllBalances(idType, idNum), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody Wallet wallet) {
        return ResponseEntity.ok(walletService.create(wallet));
    }


}
