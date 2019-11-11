package swingy;

import swingy.utils_swingy.SwingyUtils;
import java.util.*;

import static java.lang.Integer.*;

public class PlayGame {
    int size;   // row and column Axis
    private String heroName;
    private String heroType;
    private int herolevel;
    private int exp;
    private int att;
    private int def;
    private int hp;
    private int heroX;
    private int heroY;
    private SwingyUtils utils = new SwingyUtils();
    private Scanner Input = new Scanner(System.in);
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
        printStats();
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
        playerName = Input.nextLine().toUpperCase();
        utils.printAsterix(75);
    }

    private void printHeroOpt(){
        System.out.println(
                "\033[0;33m"+this.playerName.toUpperCase()+"\033[0m"+
                        "!, Please Select Below, to Proceed\n" +
                        "1. Create a New Hero\n" +
                        "2. Select previous Hero");
        int Att = Input.nextInt();
        if (Att == 1) {
            utils.printAsterix(75);
            selectHeroOpt(Att);
        }else if (Att == 2) {
            utils.printAsterix(75);
            selectHeroOpt(Att);
        } else {
            System.err.println("Invalid Entry... Please try Again");
            printHeroOpt();
        }
    }

    private void selectHeroOpt(int Att){
        if (Att == 1)
            createHero();
        else if(Att == 2)
            System.out.println("2 was selected");
        else {
            System.err.println("You have entered an invalid Entry... \nPlease try again");
            printHeroOpt();
        }
    }

    private void createHero(){
        System.out.print("Lets Create your Hero.!!\n");
        utils.printAsterix(75);
        promptHeroName();
        promptHeroType();
        utils.printAsterix(75);
        setHerolevel(1);
        setExperience(0);
    }
    public void promptHeroName(){
        this.Input.nextLine();
        System.out.print("Please enter Hero Name: ");
        String _heroName = this.Input.nextLine();
        if(_heroName.length() < 2){
            System.err.println("Invalid Length,Please try again");
            promptHeroName();
        }
        setHeroName(_heroName);
        utils.printAsterix(75);
    }

    private void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    private void promptHeroType(){
        System.out.print("Please Choose Hero Type\n" +
                "1. Thor\n" +
                "2. Iron Man\n" +
                "3. Black Panther\n");
        int _heroType = Input.nextInt();
        switch (_heroType){
            case 1:
                setHeroType("Thor");
                setHeroAttribute(100,55,120);
                break;
            case 2:
                setHeroType("Iron Man");
                setHeroAttribute(75,60,120);
                break;
            case 3:
                setHeroType("Black Panther");
                setHeroAttribute(45,100,120);
                break;
            default:
                System.err.println("Invalid Entry....");
                promptHeroType();
        }
    }
    private void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    private void setHerolevel(int herolevel) {
        this.herolevel = herolevel;
    }

    private void setExperience(int exp) {
        this.exp = exp;
    }

    private void setHeroAttribute(int attack, int defence, int hitpoints) {
        this.att = attack;
        this.def = defence;
        this.hp = hitpoints;
    }

    private void printStats(){
        System.out.println(utils.textRed("Player     : ")+utils.textBlue(this.playerName)
                        +utils.textRed("\nHeroName   : ")+utils.textBlue(this.heroName)
                        +utils.textRed("\nHero Class : ")+utils.textBlue(this.heroType)
                        +utils.textRed("\nXP         : ")+utils.textBlueInt(this.exp)
                        +utils.textRed("\nLevel      : ")+utils.textBlueInt(this.herolevel)
                        +utils.textRed("\nAttack     : ")+utils.textBlueInt(this.att)
                        +utils.textRed("\nDefence    : ")+utils.textBlueInt(this.def)
                        +utils.textRed("\nHit Points : ")+utils.textBlueInt(this.hp));
        utils.printAsterix(75);
    }


    private void setHeroX(int heroX) {
        this.heroX = heroX;
    }

    public void setHeroY(int heroY) {
        this.heroY = heroY;
    }

    private void setCoordinates(int x, int y){
        setHeroX(x);
        setHeroY(y);
    }

    private void printMap(int level, String Player){
        int column;      // column Axis
        int row;      // row Axis

        int boardSize = (int) ((level -1) * 5 + 10 - (level*0.02));
        setCoordinates(boardSize/2,boardSize/2);
        String player;
        String Velian;

        String[][] board = new String[boardSize][boardSize];
            for(row = 0;row  < boardSize; row++) {
                for (column = 0; column < boardSize; column++) {
                    board[row][column] = null;
                }
            }
        board[heroX][heroY] ="\033[0;33mH\033[0m";
            board[3][3] = "\033[31mV\033[0m";

//        Prints Map
        for(row = 0;row  < boardSize; row++){
            for (column = 0; column < boardSize ; column++) {
                if (board[row][column] == null)
                {
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
