package swingy.controller;
import org.jetbrains.annotations.NotNull;
import swingy.view.*;

public class GameController {
    private IDisplay display;

    public GameController(@NotNull String view){
        if(view.equals("console".toUpperCase())){
            display  = new Console();
            display.initGame();

        }
        if(view.equals("gui".toUpperCase())) {
            display = new GUI();
            display.initGame();
        }

        try {
            while (true) {
                run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void run(){
        display.playGame();
    }

}
