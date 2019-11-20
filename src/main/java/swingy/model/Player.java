package swingy.model;


import javax.validation.constraints.NotNull;

public class Player {
    private String PlayerName;

    @NotNull
    public void setPlayerName( String playerName) {
        PlayerName = playerName;
    }

    public String getPlayerName() {
        return PlayerName;
    }
}
