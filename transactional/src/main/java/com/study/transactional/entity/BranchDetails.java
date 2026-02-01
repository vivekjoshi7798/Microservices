package com.study.transactional.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "branch_details")
@Data
public class BranchDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String branchCode;

    private String branchName;
    private String ifscCode;
    private String address;
    private String city;
    private String state;

    // One branch → many accounts
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Account> accounts;
}