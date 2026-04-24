package task2;

public class Main {
    public static void main(String[] args) {
        Item sword = new Item("меч", 15, 30);
        Inventory inventory = new Inventory();
        Player player = new Player("king", 150, inventory);

        Store storeItem = new Store();
        storeItem.addItem(sword);

        Game game = new Game(player, storeItem);

        System.out.println("Иммитирую игровую ситуацию, игрок подходит к магазину купить предмет," +
                " нажимает кнопку чтоб посмотреть товары");
        //печатается список доступных предметов в магазине

        UtilClass.printListItems(storeItem.getListIvailableItems());

        System.out.println("Хотите ли вы купить предмет");
        //Он решает купить один из предметов
        String answer = UtilClass.inputMessage();
        boolean isNeed = game.isBuy(answer);
        if (isNeed) {
            game.purchase();
        }

        //Далее ситуация когда нужно взять предмет из инвентаря

        System.out.println("Какой предмет хотите использовать?");
        UtilClass.printListItems(player.getInventory().getItems());
        String currentItem = UtilClass.inputMessage();
        player.useItem(currentItem);
    }
}
