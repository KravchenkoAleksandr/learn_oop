package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Product> products;
    private int summary;


    public Cart() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getSummary() {
        return summary;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    public void calcSummary() {
        summary = 0;
        for (Product pr : products) {
            summary += pr.getPrice();
        }
    }

    public void clearCart() {
        products.clear();
        summary = 0;
    }
}
