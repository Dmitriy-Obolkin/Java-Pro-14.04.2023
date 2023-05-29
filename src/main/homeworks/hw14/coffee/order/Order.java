package src.main.homeworks.hw14.coffee.order;

public class Order {
    private final int orderNumber;
    private final String customerName;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName(){
        return customerName;
    }

    @Override
    public String toString() {
        return "Order number: " + orderNumber + ", Customer: " + customerName;
    }

}
