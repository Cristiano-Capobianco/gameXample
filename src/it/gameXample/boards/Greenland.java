package it.gameXample.boards;

import it.gameXample.assets.Player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {

    private static final String SEPARATOR = "-------------";

    private static final int GO_AHEAD = 1;
    private static final int GO_RIGHT = 2;
    private static final int GO_LEFT = 3;
    private static final int PLAYER_DETAILS = 4;
    private static final int EXIT_GAME = 0;

    private Scanner input;      //per ricevere l'input dell'utente

    private PrintStream ui;      // per stampare a video

    private Player player;

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
            int answer = askQuestion();
            switch (answer) {
                case GO_AHEAD:
                    ui.println("sei andato avanti");
                    break;
                case GO_RIGHT:
                    ui.println("sei andato a destra");
                    break;
                case GO_LEFT:
                    ui.println("sei andato a sinistra");
                    break;
                case PLAYER_DETAILS:
                    ui.println(player);
                    break;
                case EXIT_GAME:
                    ui.println("sei uscito dal gioco");
                    exit = true;
                    break;
                default:
                    ui.println("Il comando " + answer + " non è valido");
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
            player = new Player(playerName);
        } else                                      // Se sono già in sessione il player esiste
            if (player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
    }

    private  int askQuestion() {
        ui.println("Cosa vuoi fare ? ");
        ui.println(" [" + GO_AHEAD + " ] - vai avanti");
        ui.println(" [" + GO_RIGHT + " ] - vai a destra");
        ui.println(" [" + GO_LEFT + " ] - vai a sinistra");
        ui.println(" [" + PLAYER_DETAILS + " ] - dettagli personaggio");
        ui.println(" [" + EXIT_GAME + " ] - esci");

        ui.print("Risposta: ");
        return input.nextInt();
    }
}