package com.dh.g2.apicard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CURRENCY")
public class Currency implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String idCurrency;
    private String description;

}
