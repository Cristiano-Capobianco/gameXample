package it.gameXample.assets.enemies;

import it.gameXample.assets.Character;
import it.gameXample.assets.interfaces.Striker;

public class Enemy extends Character implements Striker {

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

    @Override
    public void attack(Character character) {
        double totalDamage = damage - character.getResistance();
        if (totalDamage <= 1) {
            totalDamage = 1;
        }
        double remainHp = character.getHp() - totalDamage;
        character.setHp(remainHp);
    }
}
