package task2;

public class Game {
    private final Store storeItem;
    private final Player player;

    public Game(Player player, Store storeItem) {
        this.player = player;
        this.storeItem = storeItem;
    }

    public void purchase() {
        System.out.println("Введите название предмета , который хотите купить");
        String nameItem = UtilClass.inputMessage();
        Item item = UtilClass.getItem(storeItem.getListIvailableItems(), nameItem);
        if (player.getGold() < item.getPrice()) {
            throw new RuntimeException("У вас недостаточно золота для покупки " + nameItem);
        }
        player.reduceGold(item.getPrice());
        player.getInventory().pickupItem(item);
        storeItem.deleteItem(item);
    }

    public boolean isBuy(String answer) {
        return answer.equalsIgnoreCase("да");
    }
}
