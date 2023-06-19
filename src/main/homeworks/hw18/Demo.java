package src.main.homeworks.hw18;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Apple", 100, true));
        products.add(new Product("Banana", 50, true));
        products.add(new Product("Book", 80, false));
        products.add(new Product("Tea", 200, false));
        products.add(new Product("Book", 400, false));
        products.add(new Product("Apple", 105, false));
        products.add(new Product("Milk", 120, false));
        products.add(new Product("Cheese", 300, true));
        products.add(new Product("Tea", 250, true));
        products.add(new Product("Book", 340, true));
        products.add(new Product("Banana", 70, false));
        products.add(new Product("Book", 90, true));
        products.add(new Product("Cheese", 30, false));
        products.add(new Product("Tea", 130, false));
        products.add(new Product("Coffee", 250, true));
        products.add(new Product("Apple", 95, false));
        products.add(new Product("Banana", 55, true));
        products.add(new Product("Apple", 20, false));
        products.add(new Product("Book", 140, true));
        products.add(new Product("Book", 350, true));

        System.out.println("All products: ");
        for (Product product : products) {
            System.out.println(product);
        }

        //1.2
        System.out.println("\nBooks with a price over 250: ");
        List<Product> books = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .filter(book -> book.getPrice() > 250)
                .peek(System.out::println)
                .toList();

        //2.2
        System.out.println("\nBooks with the possibility of applying a discount and the new price of -10%: ");
        List<Product> books2 = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .filter(book -> book.isDiscountAvailable())
                .peek((book) -> book.applyDiscount(10))
                .peek(System.out::println)
                .toList();

        System.out.println("\n");

    }
}
