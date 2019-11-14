package swingy.controller;
import swingy.view.IDisplay;
import swingy.view.Console;

public class GameController {
    private IDisplay display = new Console();

    public GameController(String view){
        if(view.equals("console")){
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
