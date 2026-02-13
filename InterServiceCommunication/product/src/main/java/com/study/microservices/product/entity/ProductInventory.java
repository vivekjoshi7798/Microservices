package com.study.microservices.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventory {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    private Integer availableStock;
    private Integer reservedStock;
}
