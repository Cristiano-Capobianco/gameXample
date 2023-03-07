package it.gameXample.boards;

import it.gameXample.assets.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyGenerator {

    public  static ArrayList<Enemy> generateEnemies() {
        return new ArrayList<>(List.of(
                new Enemy("Goblin"),
                new Enemy("Lupo"),
                new Enemy("Ragno"),
                new Enemy("Orso"),
                new Enemy("Pirata")
        ));
    }
}
