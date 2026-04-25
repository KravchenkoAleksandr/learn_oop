package shop;

import java.util.List;

public class Shop {

    private final List<Product> productsShop;

    public Shop(List<Product> productsShop) {
        this.productsShop = productsShop;
    }

    public void printProducts() {
        for (Product product : productsShop) {
            System.out.println(product.getName());
        }
    }

    public Product findProduct(String name) {
        for (Product product : productsShop) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new RuntimeException("Продукт не найден");
    }
}
