package swingy.view;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import swingy.model.*;
import swingy.model.hero.*;
import swingy.model.villain.Erik;
import swingy.model.villain.Loki;
import swingy.model.villain.Thanos;
import swingy.model.villain.Villain;
import swingy.utils_swingy.SwingyUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class Console implements IDisplay {
    private Scanner stdInput;
    private SwingyUtils utils;
    private GameData game_data ;
    private Player player;
    private Hero hero;
    private Map map;
    private Villain thanos;
    private Villain loki;
    private Villain erik;

    public Console(){
        stdInput    = new Scanner(System.in);
        utils = new SwingyUtils();
        game_data = new GameData();
        player = new Player();
        map = new Map();
        erik = new Erik();
        thanos = new Thanos();
        loki = new Loki();
    }

    //START Initiation Stage Game

    @Override
    public void initGame(){
        System.out.println(utils.textBlue(game_data.getGameBeginHeader()));
        System.out.println(utils.textYellow(game_data.gameInstructions()));
        System.out.println(utils.textBlue(utils.Asterisk(119)));
        getUser();
        getHero();
        beforePlay();
    }

    @Override
    public void getUser() {
        System.out.print("Hi, Welcome to Swingy, Please enter your Name: ");
        String name = stdInput.nextLine().toUpperCase();
        player.setPlayerName(name);
    }

    @Override
    public void getHero() {
        System.out.println(utils.textYellow(player.getPlayerName())+
                        "!, Please Select Below, to Proceed\n" +
                        "1. Create a New Hero\n" +
                        "2. Select previous Hero");
        if (stdInput.hasNextInt()){
            int Att = stdInput.nextInt();
            if (Att == 1) {
                createHero();
            }else if (Att == 2) {
                selectHero();
            } else {
                System.err.println("Invalid Entry... Please try Again");
                getHero();
            }
        }else {
            System.err.println("Invalid Entry... Please try Again");
            stdInput.nextLine();
            getHero();
        }

    }

    @Override
    public void selectHero() {
        gameOver();
        System.exit(0);
    }

    @Override
    public void createHero() {
        System.out.print("Lets Create your Hero.!!\n");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        promptHeroName();
        utils.successMessage("You Have Successfully Created a Hero");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        System.out.println("Current Stats");
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        printStat();
        System.out.println(utils.textBlue(utils.Asterisk(75)));
    }

    private void promptHeroName(){
                System.out.print("Please Choose Hero Type\n" +
                "1. Thor\n" +
                "2. Iron Man\n" +
                "3. Black Panther\n");
        if (stdInput.hasNextInt()){
            int _heroType = stdInput.nextInt();
            if (_heroType == 1){
                hero = new Thor();
            }
            else if (_heroType == 2){
                hero = new IronMan();
            }
            else if (_heroType == 3){
                hero = new BlackPanther();
            }
            else{
                System.err.println("Invalid Entry....");
                promptHeroName();
            }
        }
        else{
            System.err.println("Invalid Entry....");
            stdInput.nextLine();
            promptHeroName();
        }
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

     //GAME Utils Start

    @Override
    public void printStat(){
        System.out.println(utils.textRed("Player     : ")+utils.textBlue(player.getPlayerName())
                +utils.textRed("\nHeroName   : ")+utils.textBlue(hero.heroName())
                +utils.textRed("\nXP         : ")+utils.textBlueInt(hero.XP())
                +utils.textRed("\nLevel      : ")+utils.textBlueInt(hero.heroLevel())
                +utils.textRed("\nAttack     : ")+utils.textBlueInt(hero.Attack())
                +utils.textRed("\nDefence    : ")+utils.textBlueInt(hero.Defence())
                +utils.textRed("\nHit Points : ")+utils.textBlueInt(hero.HP()));
    }

    private void populateBoard(){
        map.updatePosition(hero.co_x(),hero.co_y(),utils.textBlue(hero.heroFlag()));
        map.updatePosition(thanos.villain_X_Cor(),thanos.villain_Y_Cor(),utils.textRed(thanos.villainFlag()));
        map.updatePosition(loki.villain_X_Cor(),loki.villain_Y_Cor(),utils.textRed(loki.villainFlag()));
        map.updatePosition(erik.villain_X_Cor(),erik.villain_Y_Cor(),utils.textRed(erik.villainFlag()));
    }

    private void heroVsVillainStats(@NotNull Villain villain){
        System.out.println("Get Ready to Fight\n" +
                "You are about to Fight -> "+utils.textBlue(villain.villainName())+
                "\n Attack              -> "+utils.textBlueInt(villain.villain_Attack())+ "\t\tYour Attack ->"+utils.textBlueInt(hero.Attack())+
                "\n Defence             -> "+utils.textBlueInt(villain.villain_Defence())+ "\t\tYour Defence  ->"+utils.textBlueInt(hero.Defence())+
                "\n Hit Points          -> "+utils.textBlueInt(villain.villain_HP()) +"\t\tYour Hit Points ->"+utils.textBlueInt(hero.HP()));
    }

    @AssertTrue
    private void letsFight(@NotNull Boolean fight, int x,int y){
        if(fight){
            stdInput.nextLine();
            System.out.println("Oops looks like you have stumbled onto a villain \nDo you wish to fight \n1. Yes \n2. No");

            @NotBlank
            int fighting = stdInput.nextInt();
            if(fighting == 1){
                fight();
                map.updatePosition(hero.co_x()+1,hero.co_y(),null);
            }else {
                hero.setCo_x(x);
                hero.setCo_y(y);
            }
        }
    }

    private void gameOver(){
        System.out.println(utils.textYellow(utils.Asterisk(125)));
        System.out.println(utils.textRed(game_data.getGameOverHeader()));
        System.out.println(utils.textYellow(utils.Asterisk(125)));
        System.out.println(utils.textBlue("Thank You For playing...".toUpperCase()));
        System.out.println(utils.textYellow(utils.Asterisk(75)));
        printStat();
        System.out.println(utils.textYellow(utils.Asterisk(75)));
        endGame();
    }

    @Contract(" -> fail")
    private void endGame(){
        System.exit(1);
    }

    private void unsetVillain(@NotNull Villain villian){
        villian.setVillain_X_Cor(-1);
        villian.setVillain_Y_Cor(-1);
    }

    private void canlevelup(){

    }

    //GAME Utils End


    //Game Play Start

    @Override
    public void playGame() {
        map.setSize(hero.heroLevel());
        map.setBoard();
        populateBoard();
        map.printBoard();
        movement();
    }

    private void movement(){
        canlevelup();
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        System.out.println("Level : "+utils.textBlueInt(hero.heroLevel())+ "\t\t XP : "+utils.textBlueInt(hero.XP()) + "\t\t HP: "+utils.textBlueInt(hero.HP()));
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        stdInput.nextLine();
        System.out.println("Please Make a Move\n" +
                "1. Move North\n" +
                "2. Move East\n" +
                "3. Move South\n"+
                "4. Move West\n" +
                utils.textRed("********Enter 0 to Exit*********"));
        if (stdInput.hasNextInt()){
            int _heroMove = stdInput.nextInt();
            switch (_heroMove) {
                case 0:
                    endGame();
                    break;
                case 1:
                    moveNorth();
                    break;
                case 2:
                    moveEast();
                    break;
                case 3:
                    moveSouth();
                    break;
                case 4:
                    moveWest();
                    break;
                default:
                    System.err.println("Invalid Entry....");
            }
            hero.setHeroXP(hero.XP() + 10);
        }else {
            System.err.println("Invalid Entry....");
            movement();
        }
        System.out.println(utils.textBlue(utils.Asterisk(75)));
        map.printBoard();
        movement();
    }

    private void moveNorth(){
        if(hero.co_x() == 0){
            endGame();
        }
        hero.setCo_x(hero.co_x() - 1);
        letsFight(isFight(), hero.co_x() + 1,hero.co_y());
        map.updatePosition(hero.co_x()+1,hero.co_y(),null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag()));
    }

    private void moveSouth(){
        if(hero.co_x() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_x(hero.co_x() + 1);
        letsFight(isFight(), hero.co_x() - 1,hero.co_y());
        map.updatePosition(hero.co_x() - 1,hero.co_y(),null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private void moveEast(){
        if(hero.co_y() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_y(hero.co_y() + 1);
        letsFight(isFight(), hero.co_x(),hero.co_y() - 1);
        map.updatePosition(hero.co_x(),hero.co_y() - 1,null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private void moveWest(){
        if(hero.co_y() == 0){
            endGame();
        }
        hero.setCo_y(hero.co_y() - 1);
        letsFight(isFight(), hero.co_x() ,hero.co_y() + 1);
        map.updatePosition(hero.co_x(),hero.co_y() + 1,null);
        map.updatePosition(
                hero.co_x(),
                hero.co_y(),
                utils.textBlue(hero.heroFlag())
        );
    }

    private boolean isFight(){
        if ((hero.co_x() == thanos.villain_X_Cor()) &&
                (hero.co_y() == thanos.villain_Y_Cor())){
            return true;
        }
        else if ((hero.co_x() == erik.villain_X_Cor()) &&
                (hero.co_y() == erik.villain_Y_Cor())){
            return true;
        }
        else return (hero.co_x() == loki.villain_X_Cor()) &&
                    (hero.co_y() == loki.villain_Y_Cor());
    }

    private void fight(){
        if ((hero.co_x() == thanos.villain_X_Cor()) &&
                (hero.co_y() == thanos.villain_Y_Cor())){
            heroVsVillainStats(thanos);
            System.out.println(utils.textBlue(utils.Asterisk(75)));
            fightThanos();
            System.out.println(utils.textBlue(utils.Asterisk(75)));
        }
        if ((hero.co_x() == erik.villain_X_Cor()) &&
                (hero.co_y() == erik.villain_Y_Cor())){
            heroVsVillainStats(erik);
            System.out.println(utils.textBlue(utils.Asterisk(75)));
            fightErik();
            System.out.println(utils.textBlue(utils.Asterisk(75)));
        }
        if ((hero.co_x() == loki.villain_X_Cor()) &&
                (hero.co_y() == loki.villain_Y_Cor())){
            heroVsVillainStats(loki);
            System.out.println(utils.textBlue(utils.Asterisk(75)));
            fightLoki();
            System.out.println(utils.textBlue(utils.Asterisk(75)));
        }
    }

    private void fightThanos(){
        int thanosPower = thanos.villain_Attack() + thanos.villain_Defence() + thanos.villain_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (thanosPower > heroPower*luck){
            System.out.println(utils.textRed(thanos.villainName()+" Wins"));
            gameOver();
        }
        else {
            unsetVillain(thanos);
            hero.setHeroAttack(hero.Attack() + 80);
            hero.setHeroDefence(hero.Defence() + 80);
            hero.setHeroHP(hero.HP() + 80);
            hero.setHeroXP(hero.XP() + 1800);
            utils.successMessage("You defeated "+thanos.villainName()+"\n You have been upgraded");
        }
    }
    private void fightErik(){
        int erikPower = erik.villain_Attack() + erik.villain_Defence() + erik.villain_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (erikPower > heroPower*luck){
            System.out.println(utils.textRed(erik.villainName()+" Wins"));
            gameOver();
        }
        else {
            unsetVillain(erik);
            hero.setHeroAttack(hero.Attack() + 40);
            hero.setHeroDefence(hero.Defence() + 40);
            hero.setHeroHP(hero.HP() + 40);
            hero.setHeroXP(hero.XP() + 980);
            utils.successMessage("You defeated "+erik.villainName()+"\n You have been upgraded");
        }
    }
    private void fightLoki(){
        int lokiPower = loki.villain_Attack() + loki.villain_Defence() + loki.villain_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (lokiPower > heroPower*luck){
            System.out.println(utils.textRed(loki.villainName()+" Wins"));
            gameOver();
        }
        else {
            unsetVillain(loki);
            hero.setHeroAttack(hero.Attack() + 40);
            hero.setHeroDefence(hero.Defence() + 40);
            hero.setHeroHP(hero.HP() + 40);
            hero.setHeroXP(hero.XP() + 960);
            utils.successMessage("You defeated "+loki.villainName()+"\n You have been upgraded");
        }
    }

    //  Game Play End
}
