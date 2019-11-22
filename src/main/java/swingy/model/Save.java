package swingy.model;

import swingy.model.hero.Hero;

import javax.validation.constraints.NotNull;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    public void saveStage(@NotNull Hero hero,@NotNull String playerName){
        try {
            String filename = playerName + ".txt";
            FileWriter writer = new FileWriter(filename, true);
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
}
