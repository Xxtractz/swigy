package swingy.utils_swingy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SwingyUtils {
    
    public String printAsterisk(int size){
        StringBuilder ast = new StringBuilder();
        for (int i = 0; i < size; i++) ast.append("*");
        return ast.toString();
    }

    public String textRed(String uncolored){
        return "\033[0;31m"+uncolored+"\033[0m";
    }

    public String textRedInt(int uncolored){
        return "\033[0;31m"+uncolored+"\033[0m";
    }

    public String textBlue(String uncolored){
        return "\033[0;34m"+uncolored+"\033[0m";
    }

    public String textYellow(String uncolored){
        return "\033[0;33m"+uncolored+"\033[0m";
    }

    public String textBlueInt(int uncolored){
        return "\033[0;34m"+uncolored+"\033[0m";
    }
}
