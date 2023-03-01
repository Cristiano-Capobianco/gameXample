package it.gameXample.boards;

import it.gameXample.assets.enemies.Enemy;

public class EnemyGenerator {

    public  static Enemy[] generateEnemies() {
        return new Enemy[] {
            new Enemy("Goblin"),
            new Enemy("Lupo"),
            new Enemy("Ragno"),
            new Enemy("Orso"),
            new Enemy("Pirata"),
        };
    }
}
