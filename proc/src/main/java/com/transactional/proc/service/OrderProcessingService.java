package com.transactional.proc.service;

import com.transactional.proc.entity.Order;
import com.transactional.proc.entity.Product;
import com.transactional.proc.handler.InventoryHandler;
import com.transactional.proc.handler.OrderHandler;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    private final OrderHandler orderHandler;
    private final InventoryHandler inventoryHandler;

    public OrderProcessingService(OrderHandler orderHandler, InventoryHandler inventoryHandler) {
        this.orderHandler = orderHandler;
        this.inventoryHandler = inventoryHandler;
    }

    public Order placeOrder(Order order) {
        // Save the order
        Order savedOrder = orderHandler.saveOrder(order);

        // Update inventory based on the order
        Product product=inventoryHandler.getProductById(2L);
        



        return savedOrder;
    }
}
