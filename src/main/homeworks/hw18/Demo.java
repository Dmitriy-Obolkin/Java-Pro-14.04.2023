package src.main.homeworks.hw18;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Apple", 100));
        products.add(new Product("Banana", 50));
        products.add(new Product("Book", 80));
        products.add(new Product("Tea", 200));
        products.add(new Product("Book", 400));
        products.add(new Product("Apple", 105));
        products.add(new Product("Milk", 120));
        products.add(new Product("Cheese", 300));
        products.add(new Product("Tea", 250));
        products.add(new Product("Book", 340));
        products.add(new Product("Banana", 70));
        products.add(new Product("Book", 90));
        products.add(new Product("Cheese", 30));
        products.add(new Product("Tea", 130));
        products.add(new Product("Coffee", 250));
        products.add(new Product("Apple", 95));
        products.add(new Product("Banana", 55));
        products.add(new Product("Apple", 20));
        products.add(new Product("Book", 140));
        products.add(new Product("Book", 350));

        System.out.println("All products: ");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nBooks with a price over 250: ");
        List<Product> books = products.stream()
                .filter(p -> p.getType().toLowerCase().equals("book"))
                .filter(p -> p.getPrice() > 250)
                .peek(System.out::println)
                .toList();


    }
}
