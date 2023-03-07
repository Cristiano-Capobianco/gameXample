package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.enemies.Enemy;
import it.gameXample.assets.player.Player;
import it.gameXample.assets.enums.Type;
import it.gameXample.boards.interfaces.Startable;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Greenland  implements Startable {

    private static final String SEPARATOR = "-------------";

    private Scanner input;      //per ricevere l'input dell'utente

    private PrintStream ui;      // per stampare a video

    private Player player;       // creo un campo di tipo generico player

    private ArrayList<Enemy> enemies;

    public Greenland(InputStream inputStream, PrintStream ui) {
        this.input = new Scanner(inputStream);
        this.ui = ui;

        enemies = EnemyGenerator.generateEnemies();
    }
    @Override
    public void startGame() {
        ui.println("Benvenuto nella prateria!");
        printSeparator();
        createPlayer();
        printSeparator();
        ui.println(player);
        printSeparator();
        // sessione di gioco
        boolean exit = false;
        boolean completed = false;
        do {
            Action moveAction = Command.createMoveAction(player);
            int choice = makeChoice(moveAction);

            if (choice == 0){
                exit = true;
            }

            else if (choice !=4) {
                searchEnemy();
            }
            completed = isAllDefeated();
            printSeparator();
        }while (!exit && !completed);
        if (completed) {
            ui.println("Complimenti hai completato la Prateria");
        }
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
            int choice = makeChoice(typeAction);
            player = Type.getPlayer(choice, playerName);
        }
        else {                                     // Se sono già in sessione il player esiste
            if (player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }

    private void searchEnemy() {
        int randomNr = ThreadLocalRandom.current().nextInt(1,101);                  //genero un numero tra 1 e 100(compreso)
        if (randomNr < 80) {                                                                     //verifico se la probabilità di incontrare un nemico è verificata (random < 80 -> 80%)
            int  randomIndex = ThreadLocalRandom.current().nextInt(0, enemies.size());      // trovo un nemico casuale
            Enemy encounteredEnemy = enemies.get(randomIndex);
            if (encounteredEnemy != null) {
                ui.println("Ti sei imbattuto in un " + encounteredEnemy.getName());                //contollo se il nemico incontrato è già morto in precednza
                fightEnemy(encounteredEnemy);
                if (encounteredEnemy.getHp() <= 0){
                    enemies.remove(encounteredEnemy);            //se il nemico arriva ad hp = 0, allora lo cancelliamo dall'array
                }
            }
        }
    }

    private void fightEnemy(Enemy enemy) {
        Action attackAction = Command.createAttackAction();
        int choice;
        do {
            choice = makeChoice(attackAction);
            if (choice == 1) {
                player.attack(enemy);
                enemy.attack(player);
                ui.println(enemy);
                printSeparator();
                ui.println(player);
                printSeparator();
                if (enemy.getHp() <= 0) {
                    ui.println("Hai ucciso il " + enemy.getName());
                    printSeparator();
                }
            }
        }while (enemy.getHp() > 0 && choice != 2);

    }

    private boolean isAllDefeated() {
        return enemies.isEmpty();
    }

    private int makeChoice(Action action) {
        boolean isValid = false;
        int choice = 0;
        do {
            try {
                ui.print(action);
                choice = input.nextInt();
                ui.println(action.getAnswer(choice));
                isValid = true;
            }catch (InputMismatchException e) {
                ui.println("La scelta non è valida. Ritentare");
                input.next();
            }catch (Exception e) {
                ui.println(e.getMessage());
            }
        }while (!isValid);
        return choice;
    }
}