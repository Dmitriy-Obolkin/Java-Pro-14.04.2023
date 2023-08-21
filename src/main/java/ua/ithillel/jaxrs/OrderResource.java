package ua.ithillel.jaxrs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ua.ithillel.jaxrs.exceptions.OrderAlreadyExistsException;
import ua.ithillel.jaxrs.model.Order;
import ua.ithillel.jaxrs.repository.OrderRepository;

import java.util.List;

@ApplicationScoped
@Path("orders")
public class OrderResource {
    @Inject
    private OrderRepository orderRepository;

    // /orders
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Order> getAll(){
        return orderRepository.getAllOrders();
    }

    // /orders/1
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Order getById(@PathParam("id") Integer id) {
        return orderRepository.getOrderById(id);
    }

    // /orders
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String add(Order order) {
        try {
            orderRepository.addOrder(order);
            return "Order successfully added";
        } catch (OrderAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    // /orders/1
    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Order update(@PathParam("id") Integer id, Order newOrder) {
        return orderRepository.updateOrder(id, newOrder);
    }

    // /orders/1
    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Order delete(@PathParam("id") Integer id) {
        return orderRepository.removeOrder(id);
    }
}
