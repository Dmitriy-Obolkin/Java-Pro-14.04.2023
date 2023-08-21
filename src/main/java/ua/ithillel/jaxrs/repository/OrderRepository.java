package ua.ithillel.jaxrs.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ua.ithillel.jaxrs.exceptions.OrderAlreadyExistsException;
import ua.ithillel.jaxrs.model.Order;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrderRepository  {

    protected List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Order getOrderById(Integer id) {
        return  orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) throws OrderAlreadyExistsException {
        if (getOrderById(order.getId()) != null) {
            throw new OrderAlreadyExistsException(order.getId());
        }
        orders.add(order);
    }

    public Order updateOrder(Integer id, Order newOrder){
        Order existingOrder = getOrderById(id);

        if (existingOrder != null) {
            existingOrder.setDate(newOrder.getDate());
            existingOrder.setProducts(newOrder.getProducts());
            existingOrder.setCost(newOrder.getCost());
        }

        return existingOrder;
    }

    public Order removeOrder(Integer id) {
        Order existingOrder = getOrderById(id);

        if (existingOrder != null) {
            orders.remove(existingOrder);
        }

        return existingOrder;
    }
}
