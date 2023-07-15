package homeworks.hw19.Product;

import java.time.LocalDate;

public class Apple extends Product{
    public Apple(double price, LocalDate dateAdded) {
        super(ProductType.APPLE, price, dateAdded);
    }

}
