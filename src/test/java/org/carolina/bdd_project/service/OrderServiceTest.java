package org.carolina.bdd_project.service;

import org.carolina.bdd_project.model.Order;
import org.carolina.bdd_project.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        order = new Order();
        order.setCustomerName("John Doe");
        order.setProducts(new ArrayList<>());
    }

    @Test
    public void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.saveOrder(order);
        assertNotNull(createdOrder);
        assertEquals("John Doe", createdOrder.getCustomerName());
    }

    @Test
    public void testFindOrderById() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);
        assertNotNull(foundOrder);
        assertEquals("John Doe", foundOrder.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        doNothing().when(orderRepository).deleteById(anyLong());

        orderService.deleteOrder(1L);
        verify(orderRepository, times(1)).deleteById(1L);
    }
}
