package swingy.model.hero;

public interface Hero {
    String heroName();
    String heroFlag();
    int heroLevel();
    int co_x();
    int co_y();
    int Attack();
    int Defence();
    int HP();
    int XP();
    void setCo_x(int co_x);
    void setCo_y(int co_y);
}
