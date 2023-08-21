package ua.ithillel.jaxrs.exceptions;

public class OrderAlreadyExistsException extends Exception{
    public OrderAlreadyExistsException(int orderId) {
        super("Order with ID " + orderId + " already exists!");
    }
}
