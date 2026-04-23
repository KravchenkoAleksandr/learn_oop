package combat_system;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10, 50, "Воин");
        Enemy enemy = new Enemy(8, 50, "Хищник");
        Game game = new Game(player, enemy);

        game.startBattle();

    }
}
