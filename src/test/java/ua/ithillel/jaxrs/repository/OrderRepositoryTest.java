package ua.ithillel.jaxrs.repository;

import ua.ithillel.jaxrs.model.Product;
import ua.ithillel.jaxrs.model.Order;
import ua.ithillel.jaxrs.exceptions.OrderAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class OrderRepositoryTest {

    private OrderRepository orderRepository;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setUp() {
        orderRepository = new OrderRepository();

        Product product1 = new Product(1, "Product1", 10.0);
        Product product2 = new Product(2, "Product2", 20.0);

        List<Product> products1 = List.of(product1);
        List<Product> products2 = List.of(product1, product2);

        order1 = new Order(1, new Date(), products1, 10.0);
        order2 = new Order(2, new Date(), products2, 30.0);

        orderRepository.orders.add(order1);
        orderRepository.orders.add(order2);
    }

    @Test
    public void testGetOrderById_existingId_returnsOrder() {
        assertEquals(order1, orderRepository.getOrderById(1));
        assertEquals(order2, orderRepository.getOrderById(2));
    }

    @Test
    public void testGetOrderById_nonExistingId_returnsNull() {
        assertNull(orderRepository.getOrderById(3));
    }

    @Test
    public void testGetAllOrders_returnsAllOrders() {
        assertEquals(List.of(order1, order2), orderRepository.getAllOrders());
    }

    @Test
    public void testAddOrder_newOrder_addsOrder() throws OrderAlreadyExistsException {
        Product product3 = new Product(3, "Product3", 15.0);
        Order order3 = new Order(3, new Date(), List.of(product3), 15.0);

        orderRepository.addOrder(order3);

        assertEquals(3, orderRepository.orders.size());
        assertEquals(order3, orderRepository.getOrderById(3));
    }

    @Test
    public void testAddOrder_existingOrderId_throwsException() {
        Product product3 = new Product(3, "Product3", 15.0);
        Order order3 = new Order(1, new Date(), List.of(product3), 15.0);

        assertThrows(OrderAlreadyExistsException.class, () -> orderRepository.addOrder(order3));
        assertEquals(2, orderRepository.orders.size());
    }

    @Test
    public void testUpdateOrder_existingOrder_updatesOrder() {
        Product product3 = new Product(3, "Product3", 15.0);
        Order newOrder = new Order(1, new Date(), List.of(product3), 15.0);

        Order updatedOrder = orderRepository.updateOrder(1, newOrder);

        assertEquals(newOrder.getDate(), updatedOrder.getDate());
        assertEquals(newOrder.getProducts(), updatedOrder.getProducts());
        assertEquals(newOrder.getCost(), updatedOrder.getCost(), 0.01);
    }

    @Test
    public void testUpdateOrder_nonExistingOrder_returnsNull() {
        Product product3 = new Product(3, "Product3", 15.0);
        Order newOrder = new Order(3, new Date(), List.of(product3), 15.0);

        Order updatedOrder = orderRepository.updateOrder(3, newOrder);

        assertNull(updatedOrder);
    }

    @Test
    public void testRemoveOrder_existingOrder_removesOrder() {
        Order removedOrder = orderRepository.removeOrder(1);

        assertEquals(order1, removedOrder);
        assertNull(orderRepository.getOrderById(1));
        assertEquals(1, orderRepository.orders.size());
    }

    @Test
    public void testRemoveOrder_nonExistingOrder_returnsNull() {
        Order removedOrder = orderRepository.removeOrder(3);

        assertNull(removedOrder);
        assertEquals(2, orderRepository.orders.size());
    }
}
