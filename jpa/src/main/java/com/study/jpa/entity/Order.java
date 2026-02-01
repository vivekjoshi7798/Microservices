package com.study.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_details")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
    @JsonBackReference
    public Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products= new ArrayList<>();

}
