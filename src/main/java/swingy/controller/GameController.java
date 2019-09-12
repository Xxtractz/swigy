package swingy.controller;
import org.jetbrains.annotations.NotNull;
import swingy.view.IDisplay;
import swingy.view.console.Console;

public class GameController {
    private IDisplay display;

    public GameController(@NotNull String view){
        if(view.equals("console")){
            display = new Console();
            display.initGame();
        }
    }

}
