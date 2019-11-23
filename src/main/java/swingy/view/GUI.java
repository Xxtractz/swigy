package swingy.view;
import swingy.controller.GameController;
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
import javax.swing.border.LineBorder;
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

    private JButton south;
    private JButton north;
    private JButton east;
    private JButton west;

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
    private JLabel _map;
    private JPanel topPanel;
    private JPanel SidePanel;
    private JPanel controls;
    private JPanel name_Stats;

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
        topPanel = new JPanel();
        SidePanel = new  JPanel();
        controls = new JPanel();
        name_Stats = new JPanel();

//        Buttons
        south = new JButton("South");
        north = new JButton("North");
        east = new JButton("East");
        west = new JButton("West");

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
        _map        = new JLabel("",SwingConstants.CENTER);

    }
    @Override
    public void initGame() {

//        JOptionPane.showMessageDialog(null,"$$$$$$$$$ Swingy $$$$$$$$$$$".toUpperCase()+"\n"+gameData.gameInstructions());
//        getUser();
//        getHero();
//        beforePlay();
        JOptionPane.showMessageDialog(null,"Please Use The console Version for Now");

        new GameController("console".toUpperCase());
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
    private void populateBoard(){
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
        map.updatePosition(thanos.villain_X_Cor(),thanos.villain_Y_Cor(),thanos.villainFlag());
        map.updatePosition(loki.villain_X_Cor(),loki.villain_Y_Cor(),loki.villainFlag());
        map.updatePosition(erik.villain_X_Cor(),erik.villain_Y_Cor(),erik.villainFlag());
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

    }

    private void runGame(){
        map.setBoard();
        populateBoard();
        //        Activating Window Basics
        frame.setVisible(true);
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//      Container
        con.setLayout(new BorderLayout(10,8));
        con.setBackground(Color.WHITE);

        /*
         * Adding top Panel
         * */
        topPanel.setBackground(Color.gray);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        con.add(topPanel, BorderLayout.NORTH);

        /*
         * LABELS for Panel
         * */
        _playerName.setText("Player Name : ");
        _playerNameHolder.setText(player.getPlayerName());
        _playerNameHolder.setForeground(Color.BLUE);
        _heroLevel.setText("Level : ");
        _heroLevelHolder.setText(""+hero.heroLevel());
        _heroLevelHolder.setForeground(Color.BLUE);
        _heroXP.setText("XP : ");
        _heroXPHolder.setText(""+hero.XP());
        _heroXPHolder.setForeground(Color.BLUE);

        /*
         * Add to Panel
         * */
        topPanel.add(_playerName);
        topPanel.add(_playerNameHolder);
        topPanel.add(_heroLevel);
        topPanel.add(_heroLevelHolder);
        topPanel.add(_heroXP);
        topPanel.add(_heroXPHolder);

        /*
         * Adding Middle Panel
         * */
        SidePanel.setLayout(new GridLayout(6,4,5,5));
        SidePanel.setBorder(new LineBorder(Color.black));
        SidePanel.setBackground(Color.gray);

        controls.setLayout(new GridLayout(4,1,5,5));
        controls.setBorder(new LineBorder(Color.BLACK));

        /*
         * Buttons
         * */
        controls.add(south);
        controls.add(north);
        controls.add(west);
        controls.add(east);

        /*
         * LABELS for MiddlePanel
         * */
        _heroName.setText(" Hero Name : ");
        _heroNameHolder.setText(" "+hero.heroName());
        _playerNameHolder.setForeground(Color.BLUE);
        _heroLevel.setText("Level : ");
        _heroLevelHolder.setText(""+hero.heroLevel());
        _heroLevelHolder.setForeground(Color.BLUE);
        _heroXP.setText("XP : ");
        _heroXPHolder.setText(""+hero.XP());
        _heroXPHolder.setForeground(Color.BLUE);

        _map.setText(map.getBoard());
        _map.setOpaque(true);
        _map.setBorder(new LineBorder(Color.BLACK,1));

        name_Stats.setLayout(new FlowLayout(FlowLayout.CENTER));
        name_Stats.setBorder(new LineBorder(Color.BLACK));
        name_Stats.add(_heroName);
        name_Stats.add(_heroNameHolder);

        SidePanel.add(name_Stats);
        SidePanel.add(controls);
        con.add(_map);
        con.add(SidePanel, BorderLayout.WEST);
    }
}
