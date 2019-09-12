package swingy.view.console;

import swingy.utils_swingy.SwingyUtils;
import swingy.view.IDisplay;
import java.util.Scanner;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
    }

    public void initGame(){
        utils.printAsterix(50);
        System.out.println("\t\t\t\tWelcome To Swingy");
        utils.printAsterix(50);
    }
}
