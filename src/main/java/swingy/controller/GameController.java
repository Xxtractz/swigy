package swingy.controller;
import org.jetbrains.annotations.NotNull;
import swingy.view.IDisplay;
import swingy.view.console.Console;

import java.util.Scanner;

public class GameController {
    private IDisplay display;

    public GameController(@NotNull String view){
        if(view.equals("console")){
            display = new Console();
            display.initGame();
        }
    }

    public void prompt(){
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        executeCommand(command);
    }

    public void executeCommand(String x){

    }
}
