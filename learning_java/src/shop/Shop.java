package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<CartItem> productsShop = new ArrayList<>();

    public Shop() {
    }

    public void printProducts() {
        for (CartItem product : productsShop) {
            System.out.println(product.getProduct().getName());
        }
    }

    public CartItem findProduct(String name) {
        for (CartItem product : productsShop) {
            if (product.getProduct().getName().equals(name)) {
                return new CartItem(product.getProduct(), product.getQuantity());
            }
        }
        throw new RuntimeException("Продукт не найден"); // нужно ловить
    }


    public boolean isAvailable(CartItem product, int need) {
        return product.getQuantity() >= need;
    }

    public void addProductToShop(CartItem product) {
        productsShop.add(product);
    }

    public void addProductFromCart(CartItem product, int value) {
        product.addQuantity(value);
    }

    public void deleteProductFromShop(CartItem product, int quantity) {
        if (product.getQuantity() == 1) {
            productsShop.remove(product);
        } else {
            product.deleteQuantity(quantity);
        }
    }
}
