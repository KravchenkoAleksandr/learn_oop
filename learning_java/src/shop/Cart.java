package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;
    private int summary;


    public Cart(int summary) {
        products = new ArrayList<>();
        this.summary = summary;
    }

    public int getSummary() {
        return summary;
    }

    public void addProduct(String name) {
        Product product = findProduct(name);
        products.add(product);
    }

    public void deleteProduct(String name) {
        Product product = findProduct(name);
        products.remove(product);
    }

    private Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new RuntimeException("Продукт не найден");
    }

    public void addProductsInCartUser(List<Product> userCart) {
        userCart.addAll(products);
    }

    public void calcSummary() {
        for (Product pr : products) {
            summary += pr.getPrice();
        }
    }

    public void clearCart() {
        products.clear();
        summary = 0;
    }
}
