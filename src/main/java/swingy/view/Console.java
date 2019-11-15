package swingy.view;

import swingy.model.*;
import swingy.utils_swingy.SwingyUtils;

import java.util.Scanner;
import javax.annotation.*;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;
    private GameData game_data ;
    private Player player;
    private Hero hero;

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
        game_data = new GameData();
        player = new Player();
        hero = new Hero();
    }

    @Override
    public void initGame(){
        System.out.println(utils.textBlue(game_data.getGameBeginHeader()));
        System.out.println(utils.textYellow(game_data.gameInstructions()));
        System.out.println(utils.textBlue(utils.Asterisk(119)));
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
        int Att = stdInput.nextInt();
        if (Att == 1) {
            createHero();
        }else if (Att == 2) {
            selectHero();
        } else {
            System.err.println("Invalid Entry... Please try Again");
            getHero();
        }
    }

    @Override
    public void selectHero() {
        gameover();
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
        System.exit(1);
    }

    private void promptHeroName(){
                System.out.print("Please Choose Hero Type\n" +
                "1. Thor\n" +
                "2. Iron Man\n" +
                "3. Black Panther\n");
        int _heroType = stdInput.nextInt();
        if (_heroType == 1){
            hero.setThor();
        }
        else if (_heroType == 2){
            hero.setIronMan();
        }
        else if (_heroType == 3){
            hero.setBlackPanther();
        }
        else{
            System.err.println("Invalid Entry....");
            promptHeroName();
        }
    }

    @Override
    public void printStat(){
        System.out.println(utils.textRed("Player     : ")+utils.textBlue(player.getPlayerName())
            +utils.textRed("\nHeroName   : ")+utils.textBlue(hero.getHeroName())
            +utils.textRed("\nXP         : ")+utils.textBlueInt(hero.getXP())
            +utils.textRed("\nLevel      : ")+utils.textBlueInt(hero.getHeroLevel())
            +utils.textRed("\nAttack     : ")+utils.textBlueInt(hero.getAttack())
            +utils.textRed("\nDefence    : ")+utils.textBlueInt(hero.getDefence())
            +utils.textRed("\nHit Points : ")+utils.textBlueInt(hero.getHP()));
    }

    @Override
    public void playGame() {

    }

    private void gameover(){
        System.out.println(utils.textYellow(utils.Asterisk(200)));
        System.out.println(utils.textRed(game_data.getGameOverHeader()));
        System.out.println(utils.textYellow(utils.Asterisk(200)));
    }

}
