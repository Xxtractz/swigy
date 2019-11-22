package swingy.view;
import swingy.model.GameData;
import swingy.model.Map;
import swingy.model.Player;
import swingy.model.Save;
import swingy.model.hero.Hero;
import swingy.model.villain.Erik;
import swingy.model.villain.Loki;
import swingy.model.villain.Thanos;
import swingy.model.villain.Villain;
import swingy.utils_swingy.SwingyUtils;

import javax.swing.*;

public class GUI implements IDisplay {
    private GameData gameData;
    private SwingyUtils utils;
    private Player player;
    private Hero hero;
    private Map map;
    private Villain thanos;
    private Villain loki;
    private Villain erik;
    private Save save;

    public GUI(){
        gameData = new GameData();
        utils = new SwingyUtils();
        player = new Player();
        map = new Map();
        erik = new Erik();
        thanos = new Thanos();
        loki = new Loki();
        save = new Save();
    }
    @Override
    public void initGame() {

        JOptionPane.showMessageDialog(null,"WElCOME TO Swingy".toUpperCase()+"\n"+gameData.gameInstructions());
        getUser();
//        JFrame header =  new JFrame();
//
//        header.add(gameData.gameBeginHeader());
//
//        header.setSize(800,800);
//        header.setLayout(null);
//        header.setVisible(true);
    }

    @Override
    public void getUser() {

    }

    @Override
    public void getHero() {

    }

    @Override
    public void selectHero() {

    }

    @Override
    public void createHero() {

    }

    @Override
    public void printStat() {

    }

    @Override
    public void playGame() {

    }

}
