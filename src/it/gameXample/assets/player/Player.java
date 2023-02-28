package it.gameXample.assets.player;

import it.gameXample.assets.enums.Type;

public class Player {
    protected String name;
    protected double hp;
    protected double stamina;
    protected Type type;

    protected int damage;

    protected int resistance;

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

    public String toString () {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina;
    }
}
