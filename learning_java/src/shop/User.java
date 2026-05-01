package shop;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<CartItem> productListUser;
    private int money;

    public User(int money) {
        this.productListUser = new ArrayList<>();
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addPurchasedProducts(List<CartItem> cart) {
        productListUser.addAll(cart);
        System.out.println("Вы купили: ");
        double total = 0;
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.getProduct().getName() + " " + cartItem.getQuantity());
            total += cartItem.getProduct().getPrice();
        }
        System.out.println("Стоимость: " + total);

    }

    public void buy(int summary) {
        money -= summary;
    }
}
