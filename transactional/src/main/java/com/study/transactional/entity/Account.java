package com.study.transactional.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountHolderName;

    private String accountType;
    private BigDecimal balance;
    private String currency;
    private String branchCode;
    private String ifscCode;
    private String status;
    private Boolean kycCompleted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Version
    private int version;

    // Many accounts → one customer
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    // Many accounts → one branch
    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private BranchDetails branch;
}
