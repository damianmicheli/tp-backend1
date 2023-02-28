package com.dh.g2.apicustomer.controller;

import com.dh.g2.apicustomer.models.Customer;
import com.dh.g2.apicustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer){
         return new ResponseEntity(service.save(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> search(@RequestBody String idType, int idNum){
        return new ResponseEntity(service.find(idType, idNum), HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<?> modify(@RequestBody Customer customer){
        service.update(customer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
