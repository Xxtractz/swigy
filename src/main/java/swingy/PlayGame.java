package swingy;

import swingy.utils_swingy.SwingyUtils;
import java.util.*;

import static java.lang.Integer.*;

public class PlayGame {
    private String heroName;
    private String heroType;
    private int herolevel;
    private int exp;
    private int att;
    private int def;
    private int hp;
    private int heroX;
    private int heroY;
    private int min_board_pos;
    private int max_board_pos;
    String[][] board;
    private SwingyUtils utils = new SwingyUtils();
    private Scanner Input = new Scanner(System.in);
    String playerName = "";

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
        heroMove();
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

    private void populateBoard(int boardSize){
        setCoordinates(boardSize/2,boardSize/2);
        board = new String[boardSize][boardSize];
        for(int row = 0;row  < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                board[row][column] = null;
            }
        }
    }
    private void setBoard_pos(int min, int max){
        setMin_board_pos(min);
        setMax_board_pos(max);
    }

    public void setMax_board_pos(int max_board_pos) {
        this.max_board_pos = max_board_pos;
    }

    private void setMin_board_pos(int min_board_pos) {
        this.min_board_pos = min_board_pos;
    }

    private void printMap(int level, String Player){
        int boardSize = (int) ((level -1) * 5 + 10 - (level*0.02));
        populateBoard(boardSize);
        setBoard_pos(0,boardSize);

        board[heroX][heroY] ="\033[0;33mH\033[0m";
            board[3][3] = "\033[31mV\033[0m";

//        Prints Map
        for(int row = 0;row  < boardSize; row++){
            int column;
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
        utils.printAsterix(75);
    }

    private void printmove(int level, int previous_x, int previous_y){
        setMax_board_pos((int) ((level -1) * 5 + 10 - (level*0.02)));

        board[previous_x][previous_y] = null;
        board[heroX][heroY] ="\033[0;33mH" +
                "\033[0m";
        board[3][3] = "\033[31mV\033[0m";

//        Prints Map
        for(int row = 0;row  < max_board_pos; row++){
            int column;
            for (column = 0; column < max_board_pos ; column++) {
                if (board[row][column] == null)
                {
                    System.out.print("| . ");
                }
                else {
                    System.out.print("| "+ board[row][column]  + " ");
                }
            }
            if (column == max_board_pos) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        utils.printAsterix(75);
    }

    private void heroMove(){
        Input.nextLine();
        System.out.println("Please Make a Move\n" +
                "1. Move North\n" +
                "2. Move East\n" +
                "3. Move South\n"+
                "4. Move West");
        int _heroMove = Input.nextInt();
        utils.printAsterix(75);
        switch (_heroMove) {
            case 1:
                moveNorth();
                break;
            case 2:
                moveEast();
                break;
            case 3:
                moveSouth();
                break;
            case 4:

                moveWest();
                break;
            default:
                System.err.println("Invalid Entry....");
                heroMove();
        }
        heroMove();
    }

    private void beforeMove(String direction){
        System.err.println(direction);
        utils.printAsterix(50);
        System.out.println("Level : "+utils.textBlueInt(this.herolevel )+ "\t\t XP : "+utils.textBlueInt(this.exp + 10) + "\t\t HP: "+utils.textBlueInt(this.hp));
        utils.printAsterix(50);
    }

    private void moveNorth(){
        if (heroX == min_board_pos){
            winGame();
        }
//        System.out.println("HERO X == "+heroX +" \t\t Min ==" +min_board_pos);
        beforeMove("Moving North (up)");
        if ((heroX -1) > min_board_pos || (heroX -1)< max_board_pos){
            setHeroX(heroX - 1);
            updateExp(10);
            printmove(herolevel,heroX + 1,heroY);
        }
    }
    private void moveEast(){
        if (heroY+1  == max_board_pos){
            winGame();
        }
//        System.out.println("HERO Y == "+heroY +" \t\t Max ==" +max_board_pos);;
        beforeMove("Moving East (right)");
        if ((heroY + 1) > min_board_pos || (heroY +1) < max_board_pos){
            setHeroY(heroY + 1);
            updateExp(10);
            printmove(herolevel,heroX ,heroY-1);
        }
    }
    private void moveSouth(){
        if ((heroX +1) == max_board_pos){
            winGame();
        }
        System.out.println("HERO X == "+heroX +" \t\t Min ==" +max_board_pos);
        beforeMove("Moving South (down)");
        if ((heroX + 1) > min_board_pos || (heroX + 1 )< max_board_pos){
            setHeroX(heroX + 1);
            updateExp(10);
            printmove(herolevel,heroX - 1,heroY);
        }
    }
    private void moveWest(){
        if ((heroY ) == min_board_pos){
            winGame();
        }
        beforeMove("Moving West (left)");
        if ((heroY -1) > min_board_pos || (heroY -1)< max_board_pos){
            setHeroY(heroY - 1);
            updateExp(10);
            printmove(herolevel,heroX ,heroY+1);
        }
    }

    private void updateHp(int hp){

    }

    private void updateExp(int exp){
        this.exp += exp;
    }

    private void printWinHeader(){
        utils.printAsterix(75);
        System.out.println("\t\t\t\t\t\033[1;34mCongratulation\033[0m \033[0;33m"+playerName+"\033[0m    \n\t\t\t\t\t\t\033[1;34mYou Have Won\033[0m");
        utils.printAsterix(75);
    }
    private void winGame(){
        printWinHeader();
        Input.nextLine();
        System.exit(1);
    }
}
