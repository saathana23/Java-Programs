class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }
}

public class HealthGame {
    public static void main(String[] args) {
        Character player = new Character(100);

        player.takeDamage(30);
        System.out.println("Health after damage: " + player.getHealth());

        player.heal(50);
        System.out.println("Health after healing: " + player.getHealth());

        player.takeDamage(150);
        System.out.println("Final health: " + player.getHealth());
    }
}