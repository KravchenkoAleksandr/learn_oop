package shop;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Product> productListUser = new ArrayList<>();
    private int money;

    public User(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addPurchasedProducts(List<Product> cart) {
        productListUser.addAll(cart);
    }

    public void buy(int summary) {
        money -= summary;
    }
}
