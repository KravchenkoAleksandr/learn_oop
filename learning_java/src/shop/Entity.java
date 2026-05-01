package shop;

public interface Entity {
    boolean isAvailable(int remains, int need);

    int getRemains(Product product);
}
