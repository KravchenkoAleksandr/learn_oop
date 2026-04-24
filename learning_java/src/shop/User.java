package shop;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Product> productListUser = new ArrayList<>();
    private int money;

    public User(List<Product> productListUser, int money) {
        this.productListUser = productListUser;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addProductsInCartUser(List<Product> cart) {
        productListUser.addAll(cart);
    }

    public void buy(int summary) {
        money -= summary;
    }
}
