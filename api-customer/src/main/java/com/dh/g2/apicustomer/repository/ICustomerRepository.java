package com.dh.g2.apicustomer.repository;

import com.dh.g2.apicustomer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository <Customer, Long>{

    Customer findByIdTypeAndIdNum(String idType, int idNum);

}
