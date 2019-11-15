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
        System.exit(0);
    }

    @Override
    public void createHero() {
        System.out.print("Lets Create your Hero.!!\n");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        promptHeroName();
//        promptHeroType();
//        utils.Asterisk(75);
//        setHerolevel(1);
//        setExperience(0);
    }

    private void promptHeroName(){
                System.out.print("Please Choose Hero Type\n" +
                "1. Thor\n" +
                "2. Iron Man\n" +
                "3. Black Panther\n");
        int _heroType = Input.nextInt();
        switch (_heroType){
            case 1:
                hero.
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



}
