package swingy.view.console;

import swingy.utils_swingy.SwingyUtils;

import java.util.Scanner;

public class Console {
    public Scanner stdInput;

    public Console(){
        new SwingyUtils().printAsterix(50);
        System.out.println("*                           Welcome To Swingy                             *");
    }
}
