package com.project.TheCakeFactory.helperClasses;

import com.project.TheCakeFactory.game.Game;
import com.project.TheCakeFactory.game.GameRepository;
import com.project.TheCakeFactory.player.Player;
import com.project.TheCakeFactory.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;


public class GamePlayerModel {

    private long playerId;
    private long gameId;

    public GamePlayerModel(long playerId, long gameId){
        this.playerId=playerId;
        this.gameId=gameId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

}
