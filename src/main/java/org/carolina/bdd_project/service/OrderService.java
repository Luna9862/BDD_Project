package org.carolina.bdd_project.service;

import org.carolina.bdd_project.model.Order;
import org.carolina.bdd_project.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Read
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // List all
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
