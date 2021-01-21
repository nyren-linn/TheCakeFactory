package com.project.TheCakeFactory.game;

import com.project.TheCakeFactory.player.Player;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime created;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Player> playerList;

    public Game(){
        this.playerList=new ArrayList<>();
        this.created= LocalDateTime.now();
    }

    // Då vi anänvder lombok så behövs inga getters/setters. Men IntelliJ tillåter inte, kräver plugin.:)

    public long getId() {
        return id;
    }

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
}
