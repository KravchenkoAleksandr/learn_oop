package task2;

public class Game {
    private final StoreItem storeItem;
    private final Player player;

    public Game(Player player, StoreItem storeItem) {
        this.player = player;
        this.storeItem = storeItem;
    }

    public void sellItem(boolean answer) {
        if (!answer) return;

        System.out.println("Введите название предмета , который хотите купить");
        String nameItem = UtilClass.inputMessage();
        Item item = UtilClass.getItem(storeItem.getListIvailableItems(), nameItem);
        if (player.getGold() < item.getPrice()) {
            throw new RuntimeException("У вас недостаточно золота для покупки " + nameItem);
        }
        player.pickupItem(item);
        storeItem.deleteItem(item);
    }
}
