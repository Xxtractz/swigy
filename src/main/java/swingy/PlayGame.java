package swingy;

import swingy.utils_swingy.SwingyUtils;

import javax.crypto.spec.PSource;
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
        printMap(10,"");

    }

    private void printMap(int boardSize, String Player){
        int size;   // Horizontal and Vertical Axis
        int x;      // Vertical Axis
        int y;      // Horizontal Axis

        size = boardSize/2;
        String Grid [][] = {{}};
        String player;
        String Velian;

//        Prints Map
        for(y = 0;y  < size; y++){
            for (x = 0; x < size ; x++) {
                System.out.print("| "+ Grid[x][0] + " ");
            }
            if (x == size) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
