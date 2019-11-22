package swingy.model;

import swingy.model.hero.Hero;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {

    public void saveStage(@NotNull Hero hero,@NotNull String playerName){
        try {
            String filename = "./src/main/resources/history/"+playerName.toLowerCase() + ".txt";
            FileWriter writer = new FileWriter(filename, false);
            writer.write("HeroName :"+hero.heroName()); // hero Name
            writer.write("\r\n");   // write new line
            writer.write("HeroFlag :"+hero.heroFlag());
            writer.write("\r\n");
            writer.write("HeroLevel :"+hero.heroLevel()); // Hero Level
            writer.write("\r\n");
            writer.write("HeroXP :"+hero.XP()); // Hero XP
            writer.write("\r\n");
            writer.write("HeroHP :"+hero.HP()); // Hero HP
            writer.write("\r\n");
            writer.write("HeroAttack :"+hero.Attack()); // Hero Attack
            writer.write("\r\n");
            writer.write("HeroDefence :"+hero.Defence()); // Hero Defence
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHero(@NotNull String playerName){
        ArrayList<String> hero = new ArrayList<String>();
        try {
            String filename = "./src/main/resources/history/"+playerName.toLowerCase() + ".txt";
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrOfStr = line.split(":");
                hero.add(arrOfStr[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hero;
    }
}
