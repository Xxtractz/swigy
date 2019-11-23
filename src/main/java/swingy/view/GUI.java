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
    private Container con;

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    private JLabel _playerName;
    private JLabel _playerNameHolder;
    private JLabel _heroName;
    private JLabel _heroNameHolder;
    private JLabel _heroFlag;
    private JLabel _heroFlagHolder;
    private JLabel _heroLevel;
    private JLabel _heroLevelHolder;
    private JLabel _heroXP;
    private JLabel _heroXPHolder;
    private JLabel _heroHP;
    private JLabel _heroHPHolder;
    private JLabel _heroAttack;
    private JLabel _heroAttackHolder;
    private JLabel _heroDefence;
    private JLabel _heroDefenceHolder;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

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
        con = frame.getContentPane();

//        PANES
        jPanel1 = new JPanel();
        jPanel2 = new  JPanel();
        jPanel3 = new JPanel();

//        Buttons
        jButton1 = new JButton();
        jButton4 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

//        LABELS
        _playerName         = new JLabel();
        _playerNameHolder   = new JLabel();
        _heroLevel          = new JLabel();
        _heroLevelHolder    = new JLabel();
        _heroName           = new JLabel();
        _heroNameHolder     = new JLabel();
        _heroFlag           = new JLabel();
        _heroFlagHolder     = new JLabel();
        _heroLevel          = new JLabel();
        _heroLevelHolder    = new JLabel();
        _heroXP             = new JLabel();
        _heroXPHolder       = new JLabel();
        _heroHP             = new JLabel();
        _heroHPHolder       = new JLabel();
        _heroAttack         = new JLabel();
        _heroAttackHolder   = new JLabel();
        _heroDefence        = new JLabel();
    }
    @Override
    public void initGame() {

//        JOptionPane.showMessageDialog(null,"$$$$$$$$$ Swingy $$$$$$$$$$$".toUpperCase()+"\n"+gameData.gameInstructions());
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
//        Activating Window Basics
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//      Container
        con.setLayout(new BorderLayout(10,8));
        con.setBackground(Color.WHITE);

        /*
        * Adding Panel
        * */
        jPanel1.setBackground(Color.gray);
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        con.add(jPanel1, BorderLayout.NORTH);

        /*
        * LABELS On Panel
        * */
        _playerName.setText("Player Name : ");
        _playerNameHolder.setText(player.getPlayerName());
        _playerNameHolder.setForeground(Color.BLUE);
        _heroLevel.setText("\t\tLevel : ");
        _heroLevelHolder.setText(""+hero.heroLevel());
        _heroLevelHolder.setForeground(Color.BLUE);
        _heroXP.setText("\t\tXP : ");
        _heroXPHolder.setText(""+hero.XP());
        _heroXPHolder.setForeground(Color.BLUE);

        jPanel1.add(_playerName);
        jPanel1.add(_playerNameHolder);
        jPanel1.add(_heroLevel);
        jPanel1.add(_heroLevelHolder);
        jPanel1.add(_heroXP);
        jPanel1.add(_heroXPHolder);

    }

}
