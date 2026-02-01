package com.study.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@IdClass(WalletAccountId.class)
@AllArgsConstructor
@NoArgsConstructor
public class WalletAccount {

    @Id
    private Long accountID;

    @Id
    private String pan ;

    private Double balance;

    private String status;

    private Boolean kycDone;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    @JsonBackReference
    private Customer customer;

}
