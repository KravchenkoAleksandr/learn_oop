package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> productsUser;
    private int summary;


    public Cart() {
        productsUser = new ArrayList<>();
    }

    public List<CartItem> getProductsUser() {
        return new ArrayList<>(productsUser);
    }

    public int getSummary() {
        return summary;
    }

    public void addProduct(CartItem product, int quantity) {
        productsUser.add(product);
        product.addQuantity(quantity);
    }

    public void deleteProduct(CartItem product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Вы хотите удалить количество продукта больше ,чем в корзине");
        }
        if (product.getQuantity() == 1) {
            productsUser.remove(product);
        } else {
            product.deleteQuantity(quantity);
        }
    }

    public void calcSummary() {
        summary = 0;
        for (CartItem pr : productsUser) {
            summary += pr.getProduct().getPrice();
        }
    }

    public void clearCart() {
        productsUser.clear();
        summary = 0;
    }
}
