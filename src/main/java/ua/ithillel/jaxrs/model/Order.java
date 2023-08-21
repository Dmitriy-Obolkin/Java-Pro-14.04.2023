package ua.ithillel.jaxrs.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private Integer id;
    private Date date;
    private List<Product> products;
    private double cost;

    public Order() {

    }

    public Order(Integer id, Date date, List<Product> products, double cost) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.cost = cost;
    }

    public Integer getId() { return id; }
    public Date getDate() { return date; }
    public double getCost() { return cost; }
    public List<Product> getProducts() { return products; }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setDate(Date date) { this.date = date; }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", date=" + date + ", cost=" + cost + ", products=" + products + "}";
    }
}
