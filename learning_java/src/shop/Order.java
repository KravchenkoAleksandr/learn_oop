package shop;

import java.util.Objects;
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

    public void shopping(Scanner sc) {
        while (true) {
            inputEnter(sc);
            System.out.println("""
                    Меню:
                    1.Начать покупки
                    2.Продолжить покупки
                    3.Удалить товар из корзины
                    4.Просмотр товаров в корзине
                    5.Купить товары из корзины
                    6.Выйти из магазина""");
            int count;
            while (true) {
                String input = sc.nextLine().trim();

                if (!input.matches("-?\\d+")) {
                    System.out.println("Введите число");
                } else {
                    count = Integer.parseInt(input);
                    break;
                }
            }
            makeMenuItem(sc, count);
            if (count == 6) break;
        }
    }

    public void makeMenuItem(Scanner sc, int item) {
        switch (item) {
            case 1, 2 -> createOrder(sc);
            case 3 -> deleteProductFromOrder(sc);
            case 4 -> cart.printProductsInCart();
            case 5 -> buyOrder();
            case 6 -> System.out.println("До свидания!");
            default -> System.out.println("Неверный пункт меню");
        }
    }

    public void createOrder(Scanner sc) {
        while (true) {
            shop.printProducts();
            String userInput = inputProduct(sc);
            if ("выход".equalsIgnoreCase(userInput)) break;
            Product product = getUserProduct(sc, userInput);
            if (product == null) {
                System.out.println("Такого продукта нет");
                continue;
            }
            int remains = shop.getRemains(product);
            int inputUserQuantity = getInputQuantity(sc, remains, shop);
            cart.addProduct(product, inputUserQuantity);
            cart.calcSummary();
            shop.deleteProductFromShop(product, inputUserQuantity);
        }
    }


    private Product getUserProduct(Scanner sc, String inputUser) {
        return shop.findProduct(inputUser);
    }

    public void deleteProductFromOrder(Scanner sc) {
        while (true) {
            cart.printProductsInCart();
            String userInput = inputProduct(sc);
            if ("выход".equalsIgnoreCase(userInput)) break;
            Product product = getProductDeletedFromCart(sc, userInput);
            if (product == null) {
                System.out.println("Такого продукта нет");
                continue;
            }
            int remains = cart.getRemains(product);
            int inputQuantity = getInputQuantity(sc, remains, cart);
            cart.deleteProduct(product.getName(), inputQuantity);
            cart.calcSummary();
            shop.addProductFromCart(product, inputQuantity);
        }
    }

    private Product getProductDeletedFromCart(Scanner sc, String userInput) {
        CartItem cartItem = cart.findProduct(userInput);
        if (cartItem == null) {
            return null;
        }
        return cartItem.getProduct();
    }

    private String inputProduct(Scanner sc) {
        String inputUser;
        System.out.println("Введите название продукта или выход");
        while (true) {
            inputUser = sc.nextLine().trim();// нужно проверить что ввели слово

            if (!inputUser.matches("^\\p{L}+$")) {
                System.out.println("Введите название продукта");
                continue;
            }
            break;
        }
        return inputUser;
    }

    private int getInputQuantity(Scanner sc, int remains, Entity entity) {
        int quantity;
        while (true) {
            quantity = inputQuantity(sc);
            if (!entity.isAvailable(remains, quantity)) {
                System.out.println("Количество превышает остаток");
            } else {
                break;
            }
        }
        return quantity;
    }

    private int inputQuantity(Scanner sc) {
        String quantity;
        int count;
        while (true) {
            System.out.println("Введите количество");
            quantity = sc.nextLine().trim();

            if (!quantity.matches("-?\\d+")) {
                System.out.println("Введите число");
                continue;
            }
            count = Integer.parseInt(quantity);
            if (count <= 0) {
                System.out.println("Введите нужное количество продуктов");
                continue;
            }
            break;
        }
        return count;
    }


    public void buyOrder() {
        if (user.getMoney() < cart.getTotal()) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        user.buy(cart.getTotal());
        user.addPurchasedProducts(cart.getProductsUser());

        cart.clearCart();
    }

    private static void inputEnter(Scanner sc) {
        String input = "not empty";
        while (!input.isEmpty()) {
            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
            input = sc.nextLine();
        }
    }
}
