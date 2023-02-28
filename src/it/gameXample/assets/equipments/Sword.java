package it.gameXample.assets.equipments;

import it.gameXample.assets.enums.Type;

public class Sword extends Weapon{


    public Sword(String name) {
        super(name);
        type = Type.WARRIOR;
    }

    public Sword(String name, int damage) {
        super(name, damage);
        type = Type.WARRIOR;
    }
}
