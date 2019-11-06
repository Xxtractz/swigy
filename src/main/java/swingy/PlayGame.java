package swingy;

import swingy.utils_swingy.SwingyUtils;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayGame {
    int size;   // Horizontal and Vertical Axis
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
        printMap(20,"");

    }

    private void printMap(int boardSize, String Player){
        int vertical;      // Vertical Axis
        int horizontal;      // Horizontal Axis

        this.size = boardSize/2;
        String player;
        String Velian;

        String[][] board = new String[this.size][this.size];
            for(horizontal = 0;horizontal  < this.size; horizontal++) {
                for (vertical = 0; vertical < this.size; vertical++) {
                    board[horizontal][vertical] = null;
                }
            }
        board[4][4] ="H";

//        System.out.println(Arrays.deepToString(board));
//        System.exit(1);
//        Prints Map
        for(horizontal = 0;horizontal  < this.size; horizontal++){
            for (vertical = 0; vertical < this.size ; vertical++) {
                if (board[horizontal][vertical] == null)
                {
//                    assert board[horizontal][vertical] != null;
//                    board[horizontal][vertical].remove("null");
//                    board[horizontal][vertical].add(".");
//                    System.out.print("| "+ board[horizontal][vertical]  + " ");
                    System.out.print("| . ");
                }
                else {
                    System.out.print("| "+ board[horizontal][vertical]  + " ");
                }
            }
            if (vertical == this.size) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.exit(0);
    }
}
