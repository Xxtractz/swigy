package swingy.view;

import swingy.model.GameData;
import swingy.utils_swingy.SwingyUtils;
import swingy.view.IDisplay;
import java.util.Scanner;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;
    private GameData game_data = new GameData();

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
    }

    public void displayHeader(){
        System.out.println(utils.textBlue(game_data.getGameBeginHeader()));
    }

    public void initGame(){
//        game_data.setdata();
        displayHeader();
//        utils.printAsterix(50);
//        System.out.println("\t\t\t\tWelcome To Swingy");
//        utils.printAsterix(50);
    }
}
