package swingy.controller;

import swingy.view.IDisplay;
import swingy.view.console.Console;

public class GameController {
    public IDisplay display;

    public GameController(String view){
        if(view == "console"){
            new Console();
        }
    }

}
