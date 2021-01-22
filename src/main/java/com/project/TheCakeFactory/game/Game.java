package com.project.TheCakeFactory.game;

import com.project.TheCakeFactory.helperClasses.DataBaseEntityModel;
import com.project.TheCakeFactory.player.Player;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Game extends DataBaseEntityModel {


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Player> playerList;

    public Game(){
        super();
        this.playerList=new ArrayList<>();
    }

    // Då vi anänvder lombok så behövs inga getters/setters. Men IntelliJ tillåter inte, kräver plugin.:)


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayerToGame(Player player){
        boolean exist = false;
        for(Player p : this.playerList){
            if(p.equals(player)) exist=true; break;
        }
        if(!exist)
            this.playerList.add(player);
    }

    public void removePlayerFromGame(Player player){
        for(Player p : this.playerList) {
            if (p.equals(player)) {
                this.playerList.remove(player); break;
            }
        }
    }
}
