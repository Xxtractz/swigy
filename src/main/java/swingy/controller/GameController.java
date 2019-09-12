package swingy.controller;
import org.jetbrains.annotations.NotNull;
import swingy.view.IDisplay;

public class GameController {
    private IDisplay display;

    public GameController(@NotNull String view){
        if(view.equals("console")){
            this.display.initGame();
        }
    }

}
