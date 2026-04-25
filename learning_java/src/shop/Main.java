package shop;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CartItem solmon = new CartItem(new Product("Лосось", 1200), 3);
        CartItem cheese = new CartItem(new Product("Сыр", 250), 4);
        CartItem carrot = new CartItem(new Product("Морковь", 60), 2);
        CartItem bread = new CartItem(new Product("Хлеб", 125), 1);

        Shop shop = new Shop();
        shop.addProductToShop(solmon);
        shop.addProductToShop(cheese);
        shop.addProductToShop(carrot);
        shop.addProductToShop(bread);

        User user = new User(1500);

        Cart cart = new Cart();

        Order order = new Order(shop, cart, user);

        order.createOrder(sc);

        order.buyOrder();
    }
}
