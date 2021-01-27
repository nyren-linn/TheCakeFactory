package com.project.TheCakeFactory_Spring.game;

import com.project.TheCakeFactory_Spring.helperClasses.DataBaseEntityModel;
import com.project.TheCakeFactory_Spring.player.Player;
import com.project.TheCakeFactory_Spring.playerInGame.PlayerInGame;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Game extends DataBaseEntityModel {

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<PlayerInGame> playerList;

    public Game(){
        super();
        this.playerList=new ArrayList<>();
    }

    public List<PlayerInGame> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PlayerInGame> playerList) {
        this.playerList = playerList;
    }

    //Lägger till en spelare i playerList
    public void addPlayerToGame(PlayerInGame player){
        this.playerList.add(player);
    }

    //Tar bort spelare från playerList i Game.
    public boolean removePlayerFromGame(Player player){
        for(PlayerInGame p : this.playerList) {
            if (p.getPlayerId() == player.getId()) {
                this.playerList.remove(p);
                return true;
            }
        }
        return false;
    }

    public PlayerInGame getPlayerInGameById(long id){
        for(PlayerInGame p : playerList){
            if(p.getPlayerId() == id)
                return p;
        }
        return null;
    }
}
