package swingy.controller;
import org.jetbrains.annotations.NotNull;
import swingy.model.GameData;
import swingy.view.*;

public class GameController {
    private IDisplay display;
    private GameData gameData = new GameData();

    public GameController(@NotNull String view){
        if(view.equals("console".toUpperCase())){
            display  = new Console();
            display.initGame();
//            while (true){
//                prompt();
//            }
        }
        if(view.equals("gui".toUpperCase())){
             display = new GUI();
            display.initGame();
//            while (true){
//                prompt();
//            }
        }
    }

//    private void prompt(){
//        Scanner input = new Scanner(System.in);
//        String command = input.nextLine();
//
//        System.out.println("Here is my command \t"+command);
//        executeCommand(command);
//    }
//
//    private void executeCommand(String x){
//
//    }
}
