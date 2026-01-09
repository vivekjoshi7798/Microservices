package com.transactional.proc.handler;

import com.transactional.proc.entity.Product;
import com.transactional.proc.repository.InventoryRepo;

public class InventoryHandler {

    public final InventoryRepo inventoryRepo;
    public InventoryHandler(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public Product updateProductDetails(Product product) {
     return inventoryRepo.save(product);
        // Implementation for updating product details
    }
    public Product saveProduct(Product product) {
        return inventoryRepo.save(product);
    }

   public Product getProductById(Integer id) {
        return inventoryRepo.findById(id).orElseThrow(()->new RuntimeException(""));
    }
}
