package it.gameXample.assets.player;

import it.gameXample.assets.enums.Type;

public class WizardPlayer extends Player {

    public WizardPlayer(String name) {
        super(name);
        this.type = Type.WIZARD;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina + "\nTipo " + type;
    }
}

