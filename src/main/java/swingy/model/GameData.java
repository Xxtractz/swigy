package swingy.model;

public class GameData {
    public String gameOverHeader;
    public String gameBeginHeader ;

    public void setGameOverHeader() {
        this.gameOverHeader =
                "\n    ::::::::::           :::::        ::::::      ::::::  ::::::::           ::::::::    ::            :: :::::::  :::::     " +
                "\n  :::        :::        ::   ::       :::  ::    ::  :::  :::               ::      ::    ::          ::  :::      ::   ::   " +
                "\n :::                   ::     ::      :::   ::  ::   :::  ::               ::        ::    ::        ::   ::       ::    ::  " +
                "\n :::         :::::    :::::::::::     :::     :::    :::  ::::::::        ::          ::    ::      ::    :::::::  ::   ::   " +
                "\n :::          :::    ::         ::    :::            :::  ::               ::        ::      ::    ::     ::       :: :::    " +
                "\n  :::        :::    ::           ::   :::            :::  :::               ::      ::        ::  ::      :::      ::   ::   " +
                "\n    ::::::::::     ::             ::  :::            :::  ::::::::            :::::::          ::::       :::::::  ::    ::  ";
    }

    public void setGameBeginHeader() {
        this.gameBeginHeader =
                        "/*********************************************************************************************************************/\n"+
                        "                         ######                                                                                      \n"+
                        "                       ###        ##                 ##    @@    ####   ##      ########     ##    ##                \n"+
                        "                         ###       ##               ##     ##    ## ##  ##    ###     ###     ##  ##                 \n"+
                        "                           ###      ##             ##      ##    ##  ## ##   ###               ####                  \n"+
                        "                             ###     ##    ##     ##       ##    ##    ###    ###    ######     ##                   \n"+
                        "                           ###        ##  ## ##  ##        ##    ##     ##     ###    ###       ##                   \n"+
                        "                       #####           ###    ###          ##    ##     ##       #######        ##                   \n"+
                        "/*********************************************************************************************************************/";
    }

    public String gameInstructions(){
        return "Hi, Welcome to Swingy at Text Base RPG....\n" +
                "Here are Instructions on how to play\n" +
                "Move North -> Hero goes upwards\n" +
                "Move East -> Hero goes Right\n" +
                "Move South -> Hero goes downwards\n" +
                "Move West -> Hero goes Left\n" +
                "Here are rules:\n" +
                "-> To win you need to pass the End of the MAP\n" +
                "-> To Advance to next Level You need to accumulate above 1000xp\n" +
                "-> The Map's are based on your level... \n" +
                "-> Fighting a Viilian can boost your XP \n" +
                "-> When Fighting a Villian, if you Lose you will die and start over." +
                "     >>>  If you defeat a villian, You will get more powerful, Your XP,ATT,DEF,HP will Increase";


    }

    public String getGameOver() {
        return gameOverHeader;
    }

    public String getGameBeginHeader() {
        return gameBeginHeader ;
    }
}
