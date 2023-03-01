package it.gameXample.assets.equipments;

import it.gameXample.assets.enums.Type;

public class Weapon {

    protected String name;

    protected int damage;

    protected Type type;
    public Weapon(String name) {
        this(name,5);
    }

    public Weapon(String name, int damage) {
        this.name = name;
        type = Type.GENERIC;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
