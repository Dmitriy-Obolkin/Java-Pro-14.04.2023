package src.main.homeworks.hw19.Product;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Product {
    private static int nextId = 0;

    private final int id;
    private final ProductType type;
    private double price;
    private final LocalDate dateAdded;

    public Product(ProductType type, double price, LocalDate dateAdded){
        this.id = nextId++;
        this.type = type;
        this.price = price;
        this.dateAdded = dateAdded;
    }


    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Type: " + this.getType()
                + ", Price: " + this.getPrice()
                + ", Date Added: " + this.getDateAdded();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Product product = (Product) obj;
        return getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

