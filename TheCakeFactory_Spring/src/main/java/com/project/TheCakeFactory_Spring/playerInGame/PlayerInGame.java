package com.project.TheCakeFactory_Spring.playerInGame;

import com.project.TheCakeFactory_Spring.gameRound.GameRound;
import com.project.TheCakeFactory_Spring.helperClasses.DataBaseEntityModel;
import com.project.TheCakeFactory_Spring.player.Player;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlayerInGame extends DataBaseEntityModel {

    private long playerId;
    private String playerName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GameRound> roundList;

    public PlayerInGame(){}
    
    //Tar emot en player och hämtar id och namn från Player-klassen
    public PlayerInGame(Player player){
        this.playerId=player.getId();
        this.playerName=player.getName();
        this.roundList=new ArrayList<>();
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<GameRound> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<GameRound> roundList) {
        this.roundList = roundList;
    }

    public void addGameRound(GameRound gameRound){
        this.roundList.add(gameRound);
    }

    //Lägger till score genom klassen GameRound.
    public void addScore(GameRound score){
        if(score.getScore()>0){
            this.roundList.add(score);
        }
    }
    //Tar bort score genom klassen GameRound.
    public void withdrawScore(GameRound score){
        if(score.getScore()<0){
            roundList.add(score);
        }
    }

    //Ger den totala Score för flera GameRounds för en spelare.
    public int getTotalScore(){
        int totalScore = 0;
        for(GameRound gr : roundList){
            totalScore += gr.getScore();
        }
        return totalScore;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        PlayerInGame p = (PlayerInGame) obj;

        if(playerId != p.playerId) return false;
        return playerName.equals(p.playerName);
    }
}
