package ua.ithillel.jaxrs.model;

import java.util.Objects;

public class Product {

    private Integer id;
    private String name;
    private double cost;

    public Product(){

    }

    public Product(Integer id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public double getCost() { return cost; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) { this.name = name; }
    public void setCost(double cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', cost=" + cost + "}";
    }
}
