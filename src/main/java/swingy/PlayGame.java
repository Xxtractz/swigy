package swingy;

import swingy.utils_swingy.SwingyUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    private SwingyUtils utils = new SwingyUtils();
    Scanner Input = new Scanner(System.in);
    String playerName = "";

    ArrayList<String> playerAttr = new ArrayList<String>( );

    public static void main(String[] args) {
//        final GameController console = new GameController("console");
        PlayGame game = new PlayGame();
        game.initiateGame();
    }

    private void initiateGame(){
        header();
        do {
            Start();
        } while (true);
    }

    private void header(){
        utils.printAsterix(75);
        System.out.println("\n\t\t\t\t\t\t\t Welcome To Swing \t\t\t\t\n".toUpperCase());
        utils.printAsterix(75);
    }

    private void Start(){
        getUser();

        getPlayerAttr();
    }

    private void getUser(){
        System.out.println("Hi, please enter your Username?");
        playerName = Input.nextLine();
        utils.printAsterix(75);
    }

    private void getPlayerAttr(){
        System.out.println(this.playerName+", please Select Hero");

        System.out.println("Hero\t\t\tGunMan\t\t\tSwordMan\n" +
                            "*******\t\t\t*******\t\t\t********\n" +
                            "Xpr\t\t\t\t100px\t\t\t100px");
        String Att = Input.nextLine();
        playerAttr.add(Att);

    }
}
