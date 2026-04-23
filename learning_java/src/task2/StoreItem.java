package task2;

import java.util.ArrayList;
import java.util.List;

public class StoreItem {

    private List<Item> listIvailableItems;

    public StoreItem() {
        this.listIvailableItems = new ArrayList<>();
    }

    public List<Item> getListIvailableItems() {
        return listIvailableItems;
    }

    public void addItem(Item item) {
        listIvailableItems.add(item);
    }

    public void deleteItem(Item item) {
        listIvailableItems.remove(item);
    }
}
