package com.project.TheCakeFactory_Spring.helperClasses;

import com.project.TheCakeFactory_Spring.gameRound.GameRound;

public class UpdatePlayerGameRoundModel {

    private long gameId;
    private long playerId;
    private GameRound gameRound;

    public UpdatePlayerGameRoundModel(long gameId, long playerId, GameRound gameRound){
        this.gameId = gameId;
        this.playerId = playerId;
        this.gameRound = gameRound;
    }

    public long getGameId() {
        return gameId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public GameRound getGameRound() {
        return gameRound;
    }
}
