package combat_system;

public abstract class AbstractCharacter {

    private int damage;
    private int hp;
    private String name;

    public AbstractCharacter(int damage, int hp, String name) {
        this.damage = damage;
        this.hp = hp;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void attack(AbstractCharacter target) {
        target.takeDamage(this.damage);
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }


    public void won() {
        System.out.println(name + " выиграл");
    }


    public void die() {
        System.out.println(name + " погиб");
    }
}
