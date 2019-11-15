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

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
        game_data = new GameData();
        player = new Player();
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
            utils.Asterisk(75);
            createHero(Att);
        }else if (Att == 2) {
            utils.Asterisk(75);
            selectHero(Att);
        } else {
            System.err.println("Invalid Entry... Please try Again");
            getHero();
        }
    }

    @Override
    public void selectHero(int att) {
        System.exit(0);
    }

    @Override
    public void createHero(int att) {
        System.out.print("Lets Create your Hero.!!\n");
        utils.Asterisk(75);
//        promptHeroName();
//        promptHeroType();
//        utils.Asterisk(75);
//        setHerolevel(1);
//        setExperience(0);
    }


}
