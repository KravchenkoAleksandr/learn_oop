package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart implements Entity {

    private final List<CartItem> productsUser;
    private int total;


    public Cart() {
        productsUser = new ArrayList<>();
    }

    public List<CartItem> getProductsUser() {
        return new ArrayList<>(productsUser);
    }

    public int getTotal() {
        return total;
    }

    public void printProductsInCart() {
        System.out.println("Содержимое корзины:");
        for (CartItem product : productsUser) {
            System.out.println("Продукта: " + product.getProduct().getName() +
                    " Количество: " + product.getQuantity());
        }
        System.out.println("Цена: " + total);
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Нельзя добавить ноль продуктов");
        }
        CartItem cartItem = findProduct(product.getName());
        if (cartItem != null) {
            cartItem.addQuantity(quantity);
        } else {
            productsUser.add(new CartItem(product, quantity));
        }
    }


    public void deleteProduct(String name, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Нельзя удалить ноль продуктов");
        }

        CartItem cartItem = findProduct(name);

        if (cartItem == null) return;

        if (quantity > cartItem.getQuantity()) {
            throw new IllegalArgumentException("Нельзя удалить больше,чем есть в корзине");
        }

        if (cartItem.getQuantity() == quantity) {
            productsUser.remove(cartItem);
        } else {
            cartItem.deleteQuantity(quantity);
        }
    }

    public boolean isAvailable(int remains, int need) {
        return remains >= need;
    }

    @Override
    public int getRemains(Product product) {
        CartItem cartItem = findProduct(product.getName());
        return cartItem != null ? cartItem.getQuantity() : 0;
    }

    public CartItem findProduct(String name) {
        for (CartItem cartItem : productsUser) {
            if (cartItem.getProduct().getName().equalsIgnoreCase(name)) {
                return cartItem;
            }
        }
        return null;
    }

    public void calcSummary() {
        total = 0;
        for (CartItem pr : productsUser) {
            total += pr.getProduct().getPrice() * pr.getQuantity();
        }
    }

    public void clearCart() {
        productsUser.clear();
        total = 0;
    }
}
