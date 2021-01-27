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

    // Då vi anänvder lombok så behövs inga getters/setters. Men IntelliJ tillåter inte, kräver plugin.:)

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

    //Tar bort spelare från playerList.
    //TODO: Funkar just nu inte! FIXA!
    public void removePlayerFromGame(Player player){
        PlayerInGame oldPlayer = new PlayerInGame(player);
        for(PlayerInGame p : this.playerList) {
            if (p.equals(oldPlayer)) {
                this.playerList.remove(oldPlayer); break;
            }
        }
    }
}
