package it.gameXample.assets.player;

import it.gameXample.assets.enums.Type;

public class WarriorPlayer extends Player {

    public WarriorPlayer(String name) {
        super(name);
        this.type = Type.WARRIOR;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina + "\nTipo " + type;
    }
}
