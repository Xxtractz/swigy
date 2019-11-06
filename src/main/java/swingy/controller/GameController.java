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
            while (true){
                prompt();
            }
        }
    }

    private void prompt(){
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        System.out.println("Here is my command \t"+command);
        executeCommand(command);
    }

    private void executeCommand(String x){

    }
}
