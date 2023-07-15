package homeworks.hw19.StreamAPI;

import homeworks.hw19.Product.Product;
import homeworks.hw19.Product.ProductType;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamApiMethods {

    //hw18_1.2
    public <T extends Product> List<T> getBooksAbovePrice(List<T> products, double priceThreshold){
        System.out.printf("\nBooks with a price over %.2f:\n", priceThreshold);
        return products.stream()
                .filter(product -> product.getType() == ProductType.BOOK)
                .filter(book -> book.getPrice() > priceThreshold)
                .toList();
    }

    //hw18_3.2, 3.3
    public <T extends Product> T getProductWithMinPrice(List<T> products, ProductType type){
        return products.stream()
                .filter(product -> product.getType() == type)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [Type: " + type + "] not found"));
    }

    //hw18_4.2
    public <T extends Product> List<T> getLastThreeAddedProducts(List<T> products){
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }
}
