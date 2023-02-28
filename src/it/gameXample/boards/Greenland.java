package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.player.Player;
import it.gameXample.assets.enums.Type;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {

    private static final String SEPARATOR = "-------------";

    private Scanner input;      //per ricevere l'input dell'utente

    private PrintStream ui;      // per stampare a video

    private Player player;       // creo un campo di tipo generico player

    public Greenland(InputStream inputStream, PrintStream ui) {
        this.input = new Scanner(inputStream);
        this.ui = ui;
    }

    public void startGame() {
        ui.println("Benvenuto nella prateria!");
        printSeparator();
        createPlayer();
        printSeparator();
        ui.println(player);
        printSeparator();
        // sessione di gioco
        boolean exit = false;
        do {
            Action moveAction = Command.createMoveAction(player);
            ui.print(moveAction);
            int choice = input.nextInt();
            ui.println(moveAction.getAnswer(choice));
            if (choice == 0){
                exit = true;
            }
            printSeparator();
        }while (!exit);
        ui.println("Grazie per aver giocato " + player.getName() + "!");
    }

    private void printSeparator() {
        ui.println(SEPARATOR);
    }

    private void createPlayer() {
        if (player == null) {                        // Se ho appena iniziato il player è null
            ui.print("Come ti chiami ? - ");
            String playerName = input.nextLine();

            Action typeAction = Command.createPlayerTypeAction();
            ui.print(typeAction);
            int choice = input.nextInt();
            ui.println(typeAction.getAnswer(choice));
            player = Type.getPlayer(choice, playerName);
        }
        else {                                     // Se sono già in sessione il player esiste
            if (player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }
}