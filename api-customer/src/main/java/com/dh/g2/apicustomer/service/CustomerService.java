package com.dh.g2.apicustomer.service;

import com.dh.g2.apicustomer.models.Customer;
import com.dh.g2.apicustomer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private ICustomerRepository repository;

    public Customer save(Customer customer ){
        return repository.save(customer);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Customer find(String idType, int idNum){
       return repository.findByIdTypeAndIdNum(idType, idNum);
    }

    public void update(Customer customerUpdate){
        Customer customerInToDB= find(customerUpdate.getIdType(), customerUpdate.getIdNum());
        customerInToDB.setBirthDate(customerUpdate.getBirthDate());
        customerInToDB.setFirstName(customerUpdate.getFirstName());
        customerInToDB.setLastName(customerUpdate.getLastName());
        customerInToDB.setGender(customerUpdate.getGender());
    }
}
