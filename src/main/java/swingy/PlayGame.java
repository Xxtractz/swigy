package swingy;

import swingy.utils_swingy.SwingyUtils;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayGame {
    int size;   // row and column Axis
    String heroName;
    int herolevel;
    int exp;
    int att;
    int def;
    int hp;
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

    private void Start(){
        getUser();

        printHeroOpt();
        initHero();
        printMap(this.herolevel,"");
    }

//    Header
    private void header(){
        System.out.println((
                        "/************************************************************************************/\n" +
                        "/*                                                                                  */\n" +
                        "/*                             Welcome To Swingy                                    */\n" +
                        "/*                                                                                  */\n" +
                        "/************************************************************************************/").toUpperCase());
    }

//    Get User Prompt
    private void getUser(){
        System.out.print("Hi, Welcome to Swingy, Please enter your Name: ");
        playerName = Input.nextLine();
        utils.printAsterix(75);
    }

    private void printHeroOpt(){
        System.out.println(
                "\033[0;33m"+this.playerName.toUpperCase()+"\033[0m"+
                        ", Please Select Below\n" +
                        "1. Create a New Hero\n" +
                        "2. Select previous Hero");
        int Att = Input.nextInt();
        selectHeroOpt(Att);
    }
    private void selectHeroOpt(int Att){
        if (Att == 1){
            System.out.println("1 was selected");
        }
        else if(Att == 2){
            System.out.println("2 was selected");
        }
        else {
            System.err.println("You have entered an invalid Entry... \nPlease try again");
            printHeroOpt();
        }
        utils.printAsterix(75);
    }


    private void initHero(){
        this.heroName = "Batman";
        this.herolevel = 1;
    }

    private void printMap(int level, String Player){
        int column;      // column Axis
        int row;      // row Axis

        int boardSize = (int) ((level -1) * 5 + 10 - (level*0.02));
        int center = boardSize/2;
        String player;
        String Velian;

        String[][] board = new String[boardSize][boardSize];
            for(row = 0;row  < boardSize; row++) {
                for (column = 0; column < boardSize; column++) {
                    board[row][column] = null;
                }
            }
        board[center][center] ="\033[0;33mH\033[0m";
            board[3][3] = "\033[31mV\033[0m";

//        Prints Map
        for(row = 0;row  < boardSize; row++){
            for (column = 0; column < boardSize ; column++) {
                if (board[row][column] == null)
                {
//                    assert board[row][column] != null;
//                    board[row][column].remove("null");
//                    board[row][column].add(".");
//                    System.out.print("| "+ board[row][column]  + " ");
                    System.out.print("| . ");
                }
                else {
                    System.out.print("| "+ board[row][column]  + " ");
                }
            }
            if (column == boardSize) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.exit(0);
    }
}
