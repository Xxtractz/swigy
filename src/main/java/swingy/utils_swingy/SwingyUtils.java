package swingy.utils_swingy;

import org.jetbrains.annotations.NotNull;

public class SwingyUtils {
    
    public void printAsterix(int size){
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
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

    public String textBlueInt(int uncolored){
        return "\033[0;34m"+uncolored+"\033[0m";
    }
}
