package it.gameXample.assets.enemies;

public class Enemy {

    protected String name;

    protected double hp;

    protected double stamina;

    protected int damage;

    protected int resistance;

    public Enemy(String name) {
        this.name = name;
        hp = 100;
        stamina = 50;
        damage = 5;
        resistance = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public String toString () {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina;
    }
}
