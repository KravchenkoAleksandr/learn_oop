package task2;

public class Player {

    private String nickname;
    private Integer gold;
    private Inventory inventory;

    public Player(String nickname, Integer gold, Inventory inventory) {
        this.nickname = nickname;
        this.gold = gold;
        this.inventory = inventory;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Player(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isBuy(String answer) {
        return answer.equalsIgnoreCase("да");
    }

    public void pickupItem(Item item) {
        checkItem(item);
        inventory.getItems().add(item);
    }

    private void checkItem(Item item) {
        if (inventory.getItems().contains(item)) {
            System.out.println("У вас есть данный предмет");
        }
    }

    public void useItem(String name) {
        Item item = UtilClass.getItem(inventory.getItems(), name);
        System.out.println("Использую " + item.getName());
    }

}
