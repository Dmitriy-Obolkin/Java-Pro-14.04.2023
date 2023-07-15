package homeworks.hw19.Product;

import java.time.LocalDate;

public class Tea extends Product{
    public Tea(double price, LocalDate dateAdded) {
        super(ProductType.TEA, price, dateAdded);
    }

}
