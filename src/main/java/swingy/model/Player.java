package swingy.model;

import org.jetbrains.annotations.NotNull;

public class Player {
    private String PlayerName;

    public void setPlayerName(@NotNull String playerName) {
        PlayerName = playerName;
    }

    public String getPlayerName() {
        return PlayerName;
    }
}
