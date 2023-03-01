package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.actions.Option;
import it.gameXample.assets.player.Player;
import it.gameXample.assets.enums.Type;

public class Command {

    public static Action createMoveAction(Player player){
        Option[] options = new Option[]{
                new Option(1,"Vai avanti", "Sei andato avanti"),
                new Option(2,"Vai a destra", "Sei andato a destra"),
                new Option(3,"Vai a sinistra", "Sei andato a sinistra"),
                new Option(4,"Dettagli giocatore", player.toString()),
                new Option(0,"Esci", "Sei uscito dal gioco"),
        };

        return new Action ("Cosa vuoi fare", options);
    }

    public static Action createPlayerTypeAction() {
        Option[] options = new Option [] {
                new Option(Type.WARRIOR.getValue(), "Guerriero", "Hai scelto il Guerriero"),
                new Option(Type.WIZARD.getValue(), "Mago", "Hai scelto il Mago")
        };

        return new Action("Che ruolo vuoi avere?", options);
    }

    public static Action createAttackAction () {
        Option[] options = new Option[] {
                new Option(1,"Attacca","Hai attaccato il nemico"),
                new Option(2, "Scappa","Sei scappato"),
        };
        return new Action("Cosa vuoi fare?", options);
    }

}
