package shop;

public class Product {
    private final String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }
}
