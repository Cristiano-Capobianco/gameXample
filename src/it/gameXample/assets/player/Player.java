package it.gameXample.assets.player;

import it.gameXample.assets.enemies.Enemy;
import it.gameXample.assets.enums.Type;
import it.gameXample.assets.equipments.Weapon;

public class Player {
    protected String name;
    protected double hp;
    protected double stamina;
    protected Type type;

    protected int damage;

    protected int resistance;

    protected Weapon weapon;



    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.stamina = 50;
        type = Type.GENERIC;

        damage = 10;
        resistance = 10;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (this.type == weapon.getType()) {
            this.weapon = weapon;
        }
    }

    public String toString () {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina;
    }

    protected double calculateDamage () {
        if(weapon != null) {
            return damage + weapon.getDamage();
        }
        return damage;
    }

    public void attackEnemy (Enemy enemy) {
        double playerDamage = calculateDamage();
        double totalDamage = playerDamage - enemy.getResistance();

        double enemyHp = enemy.getHp();

        enemy.setHp(enemyHp - totalDamage);
    }
}
