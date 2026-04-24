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

    public void reduceGold(int price) {
        gold -= price;
    }

    public void useItem(String name) {
        Item item = inventory.getItem(name);
        System.out.println("Наношу урон " + item.getDamage());
    }

}
