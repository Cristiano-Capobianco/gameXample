import it.gameXample.boards.Greenland;
import it.gameXample.boards.interfaces.Startable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Startable board = new Greenland(System.in, System.out);
        board.startGame();
    }
}