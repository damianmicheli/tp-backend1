package com.dh.g2.Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Customer {

    private String typeId;
    private int numId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;


}
