package swingy.controller;
import swingy.view.IDisplay;
import swingy.view.console.Console;

public class GameController {
    private IDisplay display;

    public GameController(String view){
        if(view.equals("console")){
            display = new Console();
            display.initGame();
        }
    }

}
