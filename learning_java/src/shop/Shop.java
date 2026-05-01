package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Entity {
    private final List<CartItem> productsShop;

    public Shop() {
        this.productsShop = new ArrayList<>();
    }

    public void printProducts() {
        System.out.println("Ассортимент магазина:");
        for (CartItem product : productsShop) {
            System.out.println("Название продукта: " + product.getProduct().getName() +
                    " Количество: " + product.getQuantity() +
                    " Цена: " + product.getProduct().getPrice());
        }
    }

    public Product findProduct(String name) {
        for (CartItem cartItem : productsShop) {
            if (cartItem.getProduct().getName().equalsIgnoreCase(name)) {
                return cartItem.getProduct();
            }
        }
        return null;
    }


    public int getRemains(Product product) {
        CartItem cartItem = findProductInShop(product);
        return cartItem != null ? cartItem.getQuantity() : 0;
    }

    public boolean isAvailable(int remains, int need) {
        return remains >= need;
    }

    public void addProductToShop(CartItem cartItem) {
        productsShop.add(cartItem);
    }

    public void addProductFromCart(Product product, int quantity) {
        CartItem cartItem = findProductInShop(product);
        if (cartItem != null) {
            cartItem.addQuantity(quantity);
        } else {
            productsShop.add(new CartItem(product, quantity));
        }
    }

    public void deleteProductFromShop(Product product, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }
        CartItem cartItem = findProductInShop(product);

        if (cartItem == null) return;

        if (cartItem.getQuantity() < count) {
            throw new IllegalArgumentException("Нельзя удалить продуктов больше,чем есть в магазине");
        }

        if (cartItem.getQuantity() == count) {
            productsShop.remove(cartItem);
            return;
        }
        cartItem.deleteQuantity(count);
    }

    private CartItem findProductInShop(Product product) {
        for (CartItem cartItem : productsShop) {
            if (cartItem.getProduct().equals(product)) {
                return cartItem;
            }
        }
        return null;
    }
}
