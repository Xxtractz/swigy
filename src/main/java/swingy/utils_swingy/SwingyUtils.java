package swingy.utils_swingy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SwingyUtils {
    
    public String Asterisk(int size){
        StringBuilder ast = new StringBuilder();
        for (int i = 0; i < size; i++) ast.append("*");
        return ast.toString();
    }

    public void successMessage(String string){
        System.out.println("\033[1;32m"+string+"\033[0m");
    }

    public String textRed(String uncolored){
        return "\033[1;31m"+uncolored+"\033[0m";
    }

    public String textRedInt(int uncolored){
        return "\033[0;31m"+uncolored+"\033[0m";
    }

    public String textBlue(String uncolored){
        return "\033[1;34m"+uncolored+"\033[0m";
    }

    public String textYellow(String uncolored){
        return "\033[0;33m"+uncolored+"\033[0m";
    }

    public String textBlueInt(int uncolored){
        return "\033[0;34m"+uncolored+"\033[0m";
    }
}
