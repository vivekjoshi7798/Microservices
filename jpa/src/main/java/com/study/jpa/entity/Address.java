package com.study.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String city;


    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    @JsonBackReference
    private Customer customer;
}
