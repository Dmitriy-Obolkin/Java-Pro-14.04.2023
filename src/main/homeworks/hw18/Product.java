package src.main.homeworks.hw18;

public class Product {
    private String type;
    private int price;

    public Product(String type, int price){
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Type: " + this.getType() + ", Price: " + this.getPrice();
    }
}

