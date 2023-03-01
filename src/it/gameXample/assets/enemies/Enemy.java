package it.gameXample.assets.enemies;

import it.gameXample.assets.Character;

public class Enemy extends Character {

    public Enemy(String name) {
        this.name = name;
        hp = 100;
        stamina = 50;
        damage = 5;
        resistance = 5;
    }

    public String toString () {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina;
    }
    @Override
    protected double calculateDamage() {
        return damage;
    }
}
