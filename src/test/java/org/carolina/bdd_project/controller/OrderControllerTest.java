package org.carolina.bdd_project.controller;

import org.carolina.bdd_project.service.OrderService;
import org.carolina.bdd_project.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private Order order;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
        order.setCustomerName("John Doe");
    }

    @Test
    public void testCreateOrder() {
        when(orderService.saveOrder(any(Order.class))).thenReturn(order);

        Order createdOrder = orderController.createOrder(order);
        assertEquals("John Doe", createdOrder.getCustomerName());
    }

    @Test
    public void testFindOrder() {
        when(orderService.getOrderById(1L)).thenReturn(order);

        Order foundOrder = orderController.getOrder(1L);
        assertEquals("John Doe", foundOrder.getCustomerName());
    }
}
