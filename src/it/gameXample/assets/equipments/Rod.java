package it.gameXample.assets.equipments;

import it.gameXample.assets.enums.Type;

public class Rod extends Weapon {

    public Rod(String name) {
        super(name);
        type = Type.WIZARD;
    }

    public Rod(String name, int damage) {
        super(name, damage);
        type = Type.WIZARD;
    }
}
