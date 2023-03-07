package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.actions.Option;
import it.gameXample.assets.player.Player;
import it.gameXample.assets.enums.Type;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Command {

    public static Action createMoveAction(Player player){
        LinkedHashMap<Integer, Option> options = new LinkedHashMap<>();
        options.put(1,new Option("Vai avanti", "Sei andato avanti"));
        options.put(2,new Option("Vai a destra", "Sei andato a destra"));
        options.put(3,new Option("Vai a sinistra", "Sei andato a sinistra"));
        options.put(4,new Option("Dettagli giocatore", player.toString()));
        options.put(0,new Option("Esci", "Sei uscito dal gioco"));

        return new Action("Cosa vuoi fare ?", options);
    }

    public static Action createPlayerTypeAction() {
        LinkedHashMap<Integer, Option> options = new LinkedHashMap<>();
        options.put(Type.WARRIOR.getValue(), new Option("Guerriero", "Hai scelto il Guerriero"));
        options.put(Type.WIZARD.getValue(), new Option("Mago", "Hai scelto il Mago"));

        return new Action("Che ruolo vuoi avere ?", options);
    }

    public static Action createAttackAction () {
        LinkedHashMap<Integer, Option> options = new LinkedHashMap<>();
        options.put(1,new Option("Attacca", "Hai attacato il nemico"));
        options.put(2,new Option("Scappa", "Sei scappato"));

        return new Action("Cosa vuoi fare ?", options);
    }

}
