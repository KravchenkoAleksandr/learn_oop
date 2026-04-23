package combat_system;

public class Game {
    private final Player player;
    private final Enemy enemy;

    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle() {

        while (player.getHp() > 0 && enemy.getHp() > 0) {
            player.attack(enemy);

            if (enemy.getHp() <= 0) {
                enemy.die();
                player.won();
                break;
            }
            enemy.attack(player);

            if (player.getHp() <= 0) {
                player.die();
                enemy.won();
                break;
            }

        }
    }
}
