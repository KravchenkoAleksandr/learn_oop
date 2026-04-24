package task2;

import java.util.HashSet;
import java.util.Set;

public class StoreItems {

    private Set<Item> listIvailableItems;

    public StoreItems() {
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
