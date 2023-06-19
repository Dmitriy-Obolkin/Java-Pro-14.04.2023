package src.main.homeworks.hw18;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Random rand = new Random();


        products.add(new Product("Apple", 100, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Banana", 50, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 140, false, LocalDate.now().minusDays(rand.nextInt(372))));
        products.add(new Product("Tea", 200, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 400, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Apple", 105, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Milk", 120, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Cheese", 300, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Tea", 250, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 75, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Banana", 70, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 60, true, LocalDate.now().minusDays(rand.nextInt(380))));
        products.add(new Product("Cheese", 30, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Tea", 130, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Coffee", 250, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Apple", 95, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Banana", 55, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Apple", 20, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 50, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product("Book", 350, true, LocalDate.now().minusDays(rand.nextInt(21))));

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
                .collect(Collectors.toList());

        //2.2
        System.out.println("\nBooks with the possibility of applying a discount and the new price of -10%: ");
        List<Product> books2 = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .filter(Product::isDiscountAvailable)
                .map(Product::new)
                .peek(book -> book.applyDiscount(10))
                .peek(System.out::println)
                .collect(Collectors.toList());

        //3.2, 3.3
        Product bookWithMinPrice = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [Type: book] not found"));
        System.out.println("\nThe book with the min price: \n" + bookWithMinPrice);

        //4.2
        System.out.println("\nThe last three products added: ");
        List<Product> lastThreeProducts = products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //5.2
        LocalDate firstDayOfThisYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        double totalCost = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .filter(product -> product.getPrice() <= 75)
                .filter(product -> !product.getDateAdded().isBefore(firstDayOfThisYear))
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("\nTotal cost: " + totalCost);

        //6.
    }
}
