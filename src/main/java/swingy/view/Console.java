package swingy.view;

import swingy.model.*;
import swingy.model.hero.*;
import swingy.model.villian.Erik;
import swingy.model.villian.Loki;
import swingy.model.villian.Thanos;
import swingy.model.villian.Villian;
import swingy.utils_swingy.SwingyUtils;

import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;
    private GameData game_data ;
    private Player player;
    private Hero hero;
    private Map map;
    private Villian thanos;
    private Villian loki;
    private Villian erik;

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
        game_data = new GameData();
        player = new Player();
        map = new Map();
        erik = new Erik();
        thanos = new Thanos();
        loki = new Loki();
    }

    @Override
    public void initGame(){
        System.out.println(utils.textBlue(game_data.getGameBeginHeader()));
        System.out.println(utils.textYellow(game_data.gameInstructions()));
        System.out.println(utils.textBlue(utils.Asterisk(119)));
        getUser();
        getHero();
        beforePlay();
    }

    @Override
    public void getUser() {
        System.out.print("Hi, Welcome to Swingy, Please enter your Name: ");
        String name = stdInput.nextLine().toUpperCase();
        player.setPlayerName(name);
    }

    @Override
    public void getHero() {
        System.out.println(utils.textYellow(player.getPlayerName())+
                        "!, Please Select Below, to Proceed\n" +
                        "1. Create a New Hero\n" +
                        "2. Select previous Hero");
        if (stdInput.hasNextInt()){
            int Att = stdInput.nextInt();
            if (Att == 1) {
                createHero();
            }else if (Att == 2) {
                selectHero();
            } else {
                System.err.println("Invalid Entry... Please try Again");
                getHero();
            }
        }else {
            System.err.println("Invalid Entry... Please try Again");
            stdInput.nextLine();
            getHero();
        }

    }

    @Override
    public void selectHero() {
        gameOver();
        System.exit(0);
    }

    @Override
    public void createHero() {
        System.out.print("Lets Create your Hero.!!\n");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        promptHeroName();
        utils.successMessage("You Have Successfully Created a Hero");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        System.out.println("Current Stats");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        printStat();
        System.out.println(utils.textBlue(utils.Asterisk(75)));
    }

    private void promptHeroName(){
                System.out.print("Please Choose Hero Type\n" +
                "1. Thor\n" +
                "2. Iron Man\n" +
                "3. Black Panther\n");
        if (stdInput.hasNextInt()){
            int _heroType = stdInput.nextInt();
            if (_heroType == 1){
                hero = new Thor();
            }
            else if (_heroType == 2){
                hero = new IronMan();
            }
            else if (_heroType == 3){
                hero = new BlackPanther();
            }
            else{
                System.err.println("Invalid Entry....");
                promptHeroName();
            }
        }
        else{
            System.err.println("Invalid Entry....");
            stdInput.nextLine();
            promptHeroName();
        }
    }

    @Override
    public void printStat(){
        System.out.println(utils.textRed("Player     : ")+utils.textBlue(player.getPlayerName())
            +utils.textRed("\nHeroName   : ")+utils.textBlue(hero.heroName())
            +utils.textRed("\nXP         : ")+utils.textBlueInt(hero.XP())
            +utils.textRed("\nLevel      : ")+utils.textBlueInt(hero.heroLevel())
            +utils.textRed("\nAttack     : ")+utils.textBlueInt(hero.Attack())
            +utils.textRed("\nDefence    : ")+utils.textBlueInt(hero.Defence())
            +utils.textRed("\nHit Points : ")+utils.textBlueInt(hero.HP()));
    }
    
    private void beforePlay(){
        map.setSize(hero.heroLevel());
        hero.setCo_x(map.getSize()/2);
        hero.setCo_y(map.getSize()/2);

        setThanosLocation();
        setLokiLocation();
        setErikLocation();
    }

    private void setThanosLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == map.getSize()/2 && y == map.getSize()/2){
            setThanosLocation();
        }else {
            thanos.setVillian_X_Cor(x);
            thanos.setVillian_Y_Cor(y);
        }
    }

    private void setLokiLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        loki.setVillian_X_Cor(x);
        loki.setVillian_Y_Cor(y);
    }

    private void setErikLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        erik.setVillian_X_Cor(x);
        erik.setVillian_Y_Cor(y);
    }

    @Override
    public void playGame() {
        map.setSize(hero.heroLevel());
        map.setBoard();
        populateBoard();
        map.printBoard();
        movement();
    }

    private void gameOver(){
        System.out.println(utils.textYellow(utils.Asterisk(125)));
        System.out.println(utils.textRed(game_data.getGameOverHeader()));
        System.out.println(utils.textYellow(utils.Asterisk(125)));
    }

    private void populateBoard(){
        map.updatePosition(hero.co_x(),hero.co_y(),utils.textBlue(hero.heroFlag()));
        map.updatePosition(thanos.villian_X_Cor(),thanos.villian_Y_Cor(),utils.textRed(thanos.VllianFlag()));
        map.updatePosition(loki.villian_X_Cor(),loki.villian_Y_Cor(),utils.textRed(loki.VllianFlag()));
        map.updatePosition(erik.villian_X_Cor(),erik.villian_Y_Cor(),utils.textRed(erik.VllianFlag()));
    }

    private void movement(){
        stdInput.nextLine();
        System.out.println("Please Make a Move\n" +
                "1. Move North\n" +
                "2. Move East\n" +
                "3. Move South\n"+
                "4. Move West\n" +
                utils.textRed("********Enter 0 to Exit*********"));
        if (stdInput.hasNextInt()){
        int _heroMove = stdInput.nextInt();
        switch (_heroMove) {
            case 0:
                endGame();
                break;
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
        }}else {
            System.err.println("Invalid Entry....");
            movement();
        }
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        map.printBoard();
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        movement();
    }

    private void endGame(){
        gameOver();
        System.exit(0);
    }

    private void moveNorth(){
        if(hero.co_x() == 0){
            endGame();
        }
        hero.setCo_x(hero.co_x() - 1);
        isFight();
        map.updatePosition(hero.co_x()+1,hero.co_y(),null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );

    }

    private void moveSouth(){
        if(hero.co_x() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_x(hero.co_x() + 1);
        fight();
        map.updatePosition(hero.co_x() - 1,hero.co_y(),null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private void moveEast(){
        if(hero.co_y() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_y(hero.co_y() + 1);
        fight();
        map.updatePosition(hero.co_x(),hero.co_y() - 1,null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private void moveWest(){
        if(hero.co_y() == 0){
            endGame();
        }
        hero.setCo_y(hero.co_y() - 1);
        fight();
        map.updatePosition(hero.co_x(),hero.co_y() + 1,null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private String isFight(){
        if ((hero.co_x() == thanos.villian_X_Cor()) &&
                (hero.co_y() == thanos.villian_Y_Cor())){
            return thanos.villianName();
        }
        if ((hero.co_x() == erik.villian_X_Cor()) &&
                (hero.co_y() == erik.villian_Y_Cor())){
            return erik.villianName();
        }
        if ((hero.co_x() == loki.villian_X_Cor()) &&
                (hero.co_y() == loki.villian_Y_Cor())){
            return loki.villianName();
        }
        return "";
    }
    private void fight(){
        if ((hero.co_x() == thanos.villian_X_Cor()) &&
                (hero.co_y() == thanos.villian_Y_Cor())){
            heroVSvillianStats();
            fightThanos();
            gameOver();
        }
        if ((hero.co_x() == erik.villian_X_Cor()) &&
                (hero.co_y() == erik.villian_Y_Cor())){
            heroVSvillianStats();
            fightErik();
            gameOver();
        }
        if ((hero.co_x() == loki.villian_X_Cor()) &&
                (hero.co_y() == loki.villian_Y_Cor())){
            heroVSvillianStats();
           fightLoki();
            gameOver();
        }
    }

    private void heroVSvillianStats(){
        System.out.println("Get Ready to Fight\n" +
                "You are about to Fight -> "+utils.textBlue(thanos.villianName())+
                "\n Attack              -> "+utils.textBlueInt(thanos.villian_Attack())+ "\t\tYour Attack ->"+utils.textBlueInt(hero.Attack())+
                "\n Defence             -> "+utils.textBlueInt(thanos.villian_Defence())+ "\t\tYour Defence  ->"+utils.textBlueInt(hero.Defence())+
                "\n Hit Points          -> "+utils.textBlueInt(thanos.villian_HP()) +"\t\tYour Hit Points ->"+utils.textBlueInt(hero.HP()));
    }

    private void fightThanos(){
        int thanosPower = thanos.villian_Attack() + thanos.villian_Defence() + thanos.villian_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (thanosPower > heroPower*luck){
            System.out.println(thanos.villianName()+" Wins");
            gameOver();
        }
        else {
            System.out.println("You defeated "+thanos.villianName());
        }
    }
    private void fightErik(){
        int erikPower = erik.villian_Attack() + erik.villian_Defence() + erik.villian_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (erikPower > heroPower*luck){
            System.out.println(erik.villianName()+" Wins");
            gameOver();
        }
        else {
            System.out.println("You defeated "+erik.villianName());
        }
    }
    private void fightLoki(){
        int lokiPower = loki.villian_Attack() + loki.villian_Defence() + loki.villian_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (lokiPower > heroPower*luck){
            System.out.println(loki.villianName()+" Wins");
            gameOver();
        }
        else {
            System.out.println("You defeated "+loki.villianName());
        }
    }
}
