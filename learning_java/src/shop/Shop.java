package shop;

import java.util.List;

public class Shop {

    private List<Product> productsShop;

    public void printProducts() {
        int count = 0;
        for (Product product : productsShop) {
            System.out.println(count + "." + product.getName());
            count++;
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
