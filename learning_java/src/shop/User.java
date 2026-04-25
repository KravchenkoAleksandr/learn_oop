package shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private List<CartItem> productListUser = new ArrayList<>();
    private int money;

    public User(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addPurchasedProducts(List<CartItem> cart) {
        productListUser.addAll(cart);
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.getProduct().getName() + " " + cartItem.getQuantity());
        }
    }

    public void buy(int summary) {
        money -= summary;
    }
}
