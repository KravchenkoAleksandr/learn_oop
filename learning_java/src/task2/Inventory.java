package task2;

import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private Set<Item> items;

    public Inventory() {
        this.items = new HashSet<>();
    }

    public Set<Item> getItems() {
        return items;
    }

    public void pickupItem(Item item) {
        if (checkItem(item.getName())) {
            return;
        }
        items.add(item);
    }

    private boolean checkItem(String nameItem) {
        for (Item item : items) {
            if (item.getName().equals(nameItem)) {
                System.out.println("У вас есть данный предмет");
                return true;
            }
        }
        return false;
    }
}
