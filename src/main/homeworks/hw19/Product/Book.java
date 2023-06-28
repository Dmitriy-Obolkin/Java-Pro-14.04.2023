package src.main.homeworks.hw19.Product;

import java.time.LocalDate;

public class Book extends Product{

    public Book(double price, LocalDate dateAdded) {
        super(ProductType.BOOK, price, dateAdded);
    }

}
