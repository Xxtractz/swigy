package swingy;

import swingy.utils_swingy.SwingyUtils;

import java.util.Scanner;

public class PlayGame {
    private SwingyUtils utils = new SwingyUtils();
    public static void main(String[] args) {
//        final GameController console = new GameController("console");
        PlayGame game = new PlayGame();
        game.initiateGame();
    }

    private void initiateGame(){
        header();
        do {
            prompt();
        } while (true);
    }

    private void header(){
        utils.printAsterix(75);
        System.out.println("\n\t\t\t\t\t\t\t Welcome To Swing \t\t\t\t\n".toUpperCase());
        utils.printAsterix(75);
    }

    private void prompt(){
        Scanner input = new Scanner(System.in);

    }
}
