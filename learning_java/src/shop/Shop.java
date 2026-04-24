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


}
