package shop;

import java.util.Scanner;

public class Order {

    private final Shop shop;
    private final Cart cart;
    private final User user;

    public Order(Shop shop, Cart cart, User user) {
        this.shop = shop;
        this.cart = cart;
        this.user = user;
    }

    public void createOrder(Scanner sc) {
        String inputUser;
        while (true) {
            System.out.println("Введите название продукта или exit");
            shop.printProducts();

            inputUser = sc.nextLine();

            if ("exit".equals(inputUser)) break;

            cart.addProduct(shop.findProduct(inputUser));
            cart.calcSummary();
        }
    }

    public void buyOrder() {
        if (user.getMoney() < cart.getSummary()) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        user.buy(cart.getSummary());
        user.addPurchasedProducts(cart.getProducts());
        cart.clearCart();
    }

    public void deleteProductFromCart(Scanner sc) {
        //в учебных целях удаляю по одному товару
        //пользователь вводит в консоль название товара
        String input = "";
        input = sc.nextLine();
        cart.deleteProduct(input);
        cart.calcSummary();
    }
}
