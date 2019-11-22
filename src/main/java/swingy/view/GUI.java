package swingy.view;
import swingy.model.GameData;
import swingy.model.Map;
import swingy.model.Player;
import swingy.model.Save;
import swingy.model.hero.BlackPanther;
import swingy.model.hero.Hero;
import swingy.model.hero.IronMan;
import swingy.model.hero.Thor;
import swingy.model.villain.Erik;
import swingy.model.villain.Loki;
import swingy.model.villain.Thanos;
import swingy.model.villain.Villain;
import swingy.utils_swingy.SwingyUtils;

import javax.swing.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.Random;

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
    private JFrame frame;

    public GUI(){
        gameData = new GameData();
        utils = new SwingyUtils();
        player = new Player();
        map = new Map();
        erik = new Erik();
        thanos = new Thanos();
        loki = new Loki();
        save = new Save();
        frame = new JFrame();
    }
    @Override
    public void initGame() {

        JOptionPane.showMessageDialog(null,"$$$$$$$$$ Swingy $$$$$$$$$$$".toUpperCase()+"\n"+gameData.gameInstructions());
        getUser();
        getHero();
        beforePlay();
    }

    @Override
    public void getUser() {
        @NotNull
        @NotEmpty
        String _player = JOptionPane.showInputDialog("Hi, Welcome to Swingy, Please enter your Name");
        if (!_player.isEmpty()){
            player.setPlayerName(_player);
        }
        else {
            getUser();
        }
    }

    @Override
    public void getHero() {
        @NotNull
        @NotEmpty
        String selectHeroOpt = JOptionPane.showInputDialog(player.getPlayerName()+" !, Please Select Below, to Proceed\n" +
                "1. Create a New Hero\n" +
                "2. Select previous Hero");
        if (selectHeroOpt.equals("1")){
            createHero();
        }
        else if (selectHeroOpt.equals("2")) {
            selectHero();
        }
        else getHero();
    }

    @Override
    public void selectHero() {

    }

    private void beforePlay(){
        map.setSize(hero.heroLevel());
        hero.setCo_x(map.getSize()/2);
        hero.setCo_y(map.getSize()/2);

        setThanosLocation();
        setLokiLocation();
        setErikLocation();
    }

    private void setThanosLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == map.getSize()/2 && y == map.getSize()/2){
            setThanosLocation();
        }else {
            thanos.setVillain_X_Cor(x);
            thanos.setVillain_Y_Cor(y);
        }
    }

    private void setLokiLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == map.getSize()/2 && y == map.getSize()/2){
            setLokiLocation();
        }else {
            loki.setVillain_X_Cor(x);
            loki.setVillain_Y_Cor(y);
        }
    }

    private void setErikLocation(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == map.getSize()/2 && y == map.getSize()/2){
            setErikLocation();
        }else {
            erik.setVillain_X_Cor(x);
            erik.setVillain_Y_Cor(y);
        }
    }

    @Override
    public void createHero() {
        String _heroType = JOptionPane.showInputDialog("Lets Create your Hero.!!\n" +
                "Please Choose Hero Type\\n\" +\n" +
                "   1. Thor\n" +
                "   2. Iron Man\n" +
                "   3. Black Panther");
        if (_heroType.equals("1")){
            hero = new Thor();
        }
        else if (_heroType.equals("2")){
            hero = new IronMan();
        }
        else if (_heroType.equals("3")){
            hero = new BlackPanther();
        }else {
            createHero();
        }
    }

    @Override
    public void printStat() {

    }

    @Override
    public void playGame() {

        frame.setLayout(new GridLayout());
        frame.setSize(1080,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
