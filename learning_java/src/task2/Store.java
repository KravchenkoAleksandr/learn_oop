package task2;

import java.util.HashSet;
import java.util.Set;

public class Store {

    private final Set<Item> listIvailableItems;

    public Store() {
        this.listIvailableItems = new HashSet<>();
    }

    public Set<Item> getListIvailableItems() {
        return listIvailableItems;
    }

    public void addItem(Item item) {
        listIvailableItems.add(item);
    }

    public void deleteItem(Item item) {
        listIvailableItems.remove(item);
    }
}
