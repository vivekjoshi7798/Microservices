package com.transactional.proc.handler;


import com.transactional.proc.entity.Order;
import com.transactional.proc.repository.OrderRepo;

public class OrderHandler {

    private final OrderRepo orderRepo;

    public OrderHandler(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}

