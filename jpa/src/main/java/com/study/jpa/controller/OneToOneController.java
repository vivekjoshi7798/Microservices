package com.study.jpa.controller;

import com.study.jpa.entity.Address;
import com.study.jpa.entity.Customer;
import com.study.jpa.repository.AddressRepository;
import com.study.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/onetoone")
public class OneToOneController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;


    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer) {

        if (customer.getAddress() != null) {
            customer.getAddress().setCustomer(customer);
        }

        if (customer.getWalletAccount() != null) {
            customer.getWalletAccount().setCustomer(customer);
        }

        return customerRepository.save(customer);
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @GetMapping("/getAddress/{id}")
    public Customer getAddress(@PathVariable Long id) {
        Address address= addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return  address.getCustomer();
    }

    @GetMapping("/getALl")
    public List<Customer> getALl() {
    return  customerRepository.findAll();

    }



}
