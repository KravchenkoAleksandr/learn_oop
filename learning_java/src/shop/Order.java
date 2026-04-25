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
        String quantity;
        while (true) {
            shop.printProducts();
            System.out.println("Введите название продукта или exit");
            inputUser = sc.nextLine().trim();

            if ("exit".equals(inputUser)) break;

            CartItem product = shop.findProduct(inputUser);

            System.out.println("Продукт:" + product.getProduct().getName() +
                    "|| оставшееся количество: " + product.getQuantity());
            System.out.println("Введите количество продукта");

            quantity = sc.nextLine().trim();

            int count = Integer.parseInt(quantity);

            if (!shop.isAvailable(product, count)) {
                System.out.println("Товара:" + product.getProduct().getName() +
                        " осталось " + product.getQuantity());
            }

            product.setQuantity(0);//обнуляем для добавления нужного количества

            cart.addProduct(product, count);
            cart.calcSummary();

            shop.deleteProductFromShop(product, count);
        }
    }


    public void deleteProductFromOrder(CartItem product, int value) {
        cart.deleteProduct(product, value);
        cart.calcSummary();

        shop.addProductFromCart(product, value);
    }

    public void buyOrder() {
        if (user.getMoney() < cart.getSummary()) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        user.buy(cart.getSummary());
        user.addPurchasedProducts(cart.getProductsUser());

        cart.clearCart();
    }
}
