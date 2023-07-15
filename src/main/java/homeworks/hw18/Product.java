package homeworks.hw18;

import java.time.LocalDate;

public class Product {
    private final int id;
    private final String type;
    private double price;
    private final boolean discountAvailable;
    private final LocalDate dateAdded;

    public Product(int id, String type, double price, boolean discountAvailable, LocalDate dateAdded){
        this.id = id;
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = dateAdded;
    }

    public Product(Product otherProduct){
        this.id = otherProduct.getId();
        this.type = otherProduct.getType();
        this.price= otherProduct.getPrice();
        this.discountAvailable = otherProduct.isDiscountAvailable();
        this.dateAdded = otherProduct.getDateAdded();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getId() {
        return id;
    }

    private void setPrice(double newPrice){
        if(newPrice<0){
            throw new IllegalArgumentException("The price must be greater than 0");
        }
        price = newPrice;
    }

    public void applyDiscount(double discountPercentage) {
        if(discountPercentage >= 100){
            throw new IllegalArgumentException("The discount should be less than 100%");
        }

        if (isDiscountAvailable()) {
            double discountAmount = price * discountPercentage / 100;
            setPrice(price - discountAmount);
        }
    }


    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Type: " + this.getType()
                + ", Price: " + this.getPrice()
                + ", Discount Available: " + this.isDiscountAvailable()
                + ", Date Added: " + this.getDateAdded();
    }
}

