package swingy.view;

import swingy.model.GameData;
import swingy.utils_swingy.SwingyUtils;

import java.util.Scanner;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;
    private GameData game_data ;

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
        game_data = new GameData();
    }

    public void initGame(){
        System.out.println(utils.textBlue(game_data.getGameBeginHeader()));
        System.out.println(utils.textYellow(game_data.gameInstructions()));
        System.out.println(utils.textBlue(utils.printAsterisk(119)));

//        utils.printAsterix(50);
//        System.out.println("\t\t\t\tWelcome To Swingy");
//        utils.printAsterix(50);
    }
}
