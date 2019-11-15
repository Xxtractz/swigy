package swingy.model;

public class Hero {
    private String heroName;
    private Character heroFlag;
    private int heroLevel;
    private int co_x;
    private int co_Y;
    private int Attack;
    private int Defence;
    private int HP;
    private int XP;

//    Hero Types
    public void setThor(){
        setHeroName("Thor");
        setHeroFlag('T');
        setXP(0);
        setHeroLevel(1);
        setAttack(100);
        setDefence(55);
        setHP(100);
    }
    public void setBlackPanther(){
        setHeroName("Black Panther");
        setHeroFlag('B');
        setXP(0);
        setHeroLevel(1);
        setAttack(45);
        setDefence(100);
        setHP(120);
    }
    public void setIronMan(){
        setHeroName("Iron Man");
        setHeroFlag('I');
        setXP(0);
        setHeroLevel(1);
        setAttack(93);
        setDefence(80);
        setHP(100);
    }

//    Set Hero Attributes
    private void setHeroName(String heroName) {
    this.heroName = heroName;
}
    private void setHeroFlag(Character heroFlag) {
        this.heroFlag = heroFlag;
    }
    private void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }
    private void setAttack(int attack) {
        Attack = attack;
    }
    private void setDefence(int defence) {
        Defence = defence;
    }
    private void setHP(int HP) {
        this.HP = HP;
    }
    private void setXP(int XP) {
        this.XP = XP;
    }
    public void setCo_x(int co_x) {
        this.co_x = co_x;
    }
    public void setCo_Y(int co_Y) {
        this.co_Y = co_Y;
    }

//    Get Hero Attributes
    public String getHeroName() {
        return heroName;
    }
    public Character getHeroFlag() {
        return heroFlag;
    }
    public int getHeroLevel() {
        return heroLevel;
    }
    public int getCo_x() {
        return co_x;
    }
    public int getCo_Y() {
        return co_Y;
    }
    public int getAttack() {
        return Attack;
    }
    public int getDefence() {
        return Defence;
    }
    public int getHP() {
        return HP;
    }
    public int getXP() {
        return XP;
    }
}
