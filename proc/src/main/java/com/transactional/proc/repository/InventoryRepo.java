package com.transactional.proc.repository;


import com.transactional.proc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Product, Integer> {

}

