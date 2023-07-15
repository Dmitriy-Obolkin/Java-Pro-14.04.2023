package homeworks.hw19.StreamAPI;

import homeworks.hw19.Product.*;
import homeworks.hw19.Test.AfterSuite;
import homeworks.hw19.Test.BeforeSuite;
import homeworks.hw19.Test.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApiMethodsTest {
    private StreamApiMethods streamApiMethods;

    private List<Product> products;

    @BeforeSuite
    public void setUp(){
        System.out.println("Starting tests!\n");
        streamApiMethods = new StreamApiMethods();

        products = new ArrayList<>();
        products.add(new Apple(100, LocalDate.of(2022, 6, 12)));
        products.add(new Apple(105, LocalDate.of(2023, 5, 14)));
        products.add(new Apple(95, LocalDate.of(2023, 6, 22)));
        products.add(new Apple(20, LocalDate.of(2023, 6, 13)));
        products.add(new Book(140, LocalDate.of(2022, 2, 26)));
        products.add(new Book(400, LocalDate.of(2023, 6, 25)));
        products.add(new Book(75, LocalDate.of(2023, 6, 21)));
        products.add(new Book(60, LocalDate.of(2023, 4, 5)));
        products.add(new Book(50, LocalDate.of(2023, 5, 29)));
        products.add(new Book(350, LocalDate.of(2023, 4, 20)));
        products.add(new Tea(200, LocalDate.of(2023, 6, 8)));
        products.add(new Tea(250, LocalDate.of(2023, 5, 3)));
        products.add(new Tea(130, LocalDate.of(2023, 6, 19)));

        System.out.println("All products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    /*@BeforeSuite
    public void testErrSecondBeforeSuite(){
        System.out.println("Hello, world!");
    }*/

    @Test(priority = 5)
    public void getBooksAbovePrice_test(){
        List<Product> expected = Arrays.asList(products.get(4), products.get(5), products.get(9));

        List<Product> actual = streamApiMethods.getBooksAbovePrice(products, 100);
        for (Product product: actual) {
            System.out.println(product);
        }

        assert actual.equals(expected) : "Method getBooksAbovePrice_test failed!";
        System.out.println("Method getBooksAbovePrice_test done!\n");
    }

    @Test(priority = 1)
    public void getProductWithMinPrice_test(){
        Book expected = (Book) products.get(8);

        Book actual = (Book) streamApiMethods.getProductWithMinPrice(products, ProductType.BOOK);
        System.out.println("\nThe book with the min price: \n" + actual);

        assert actual.equals(expected) : "Method getProductWithMinPrice_test failed!";
        System.out.println("Method getProductWithMinPrice_test done!\n");
    }

    @Test(priority = 5)
    public void getLastThreeAddedProducts_test(){
        List<Product> expected = Arrays.asList(products.get(5), products.get(2), products.get(6));

        List<Product> actual = streamApiMethods.getLastThreeAddedProducts(products);
        System.out.println("\nThe last three added products: ");
        for (Product product: actual) {
            System.out.println(product);
        }

        assert actual.equals(expected) : "Method getLastThreeAddedProducts_test failed!";
        System.out.println("Method getLastThreeAddedProducts_test done!\n");
    }

    /*@Test(priority = 10)
    public void AssertionError_test(){
        Book expected = (Book) products.get(5);

        Book actual = (Book) streamApiMethods.getProductWithMinPrice(products, ProductType.BOOK);
        System.out.println("\nAssertionError Test: The book with the min price: \n" + actual);

        assert actual.equals(expected) : "Method AssertionError_test failed!";
        System.out.println("Method AssertionError_test done!\n");
    }*/

    @AfterSuite
    public void tearDown(){
        System.out.println("Tests done!");
    }
}
