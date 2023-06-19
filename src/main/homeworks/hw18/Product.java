package src.main.homeworks.hw18;

public class Product {
    private final String type;
    private double price;
    private final boolean discountAvailable;

    public Product(String type, double price, boolean discountAvailable){
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
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
        return "Type: " + this.getType() + ", Price: " + this.getPrice();
    }
}

