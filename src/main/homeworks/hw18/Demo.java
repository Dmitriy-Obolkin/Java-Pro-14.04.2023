package src.main.homeworks.hw18;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Random rand = new Random();


        products.add(new Product(1,"Apple", 100, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(2, "Banana", 50, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(3,"Book", 140, false, LocalDate.now().minusDays(372)));
        products.add(new Product(4,"Tea", 200, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(5,"Book", 400, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(6,"Apple", 105, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(7,"Milk", 120, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(8,"Cheese", 300, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(9,"Tea", 250, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(10,"Book", 75, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(11,"Banana", 70, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(12,"Book", 60, true, LocalDate.now().minusDays(380)));
        products.add(new Product(13,"Cheese", 30, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(14,"Tea", 130, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(15,"Coffee", 250, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(16,"Apple", 95, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(17,"Banana", 55, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(18,"Apple", 20, false, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(19,"Book", 50, true, LocalDate.now().minusDays(rand.nextInt(21))));
        products.add(new Product(20,"Book", 350, true, LocalDate.now().minusDays(rand.nextInt(21))));

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
                .filter(Product::isDiscountAvailable)
                .map(Product::new)
                .peek(book -> book.applyDiscount(10))
                .peek(System.out::println)
                .toList();

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
                .toList();

        //5.2
        LocalDate firstDayOfThisYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        double totalCost = products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("book"))
                .filter(product -> product.getPrice() <= 75)
                .filter(product -> !product.getDateAdded().isBefore(firstDayOfThisYear))
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("\nTotal cost: " + totalCost);

        //6.2
        System.out.println("\nProduct dictionary by type:");
        Map<String, List<Product>> productsByType = products.stream()
                .collect(Collectors.groupingBy(Product::getType));
        System.out.println(productsByType);

        System.out.println();
    }
}
