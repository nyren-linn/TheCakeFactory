package com.project.TheCakeFactory.game;

import com.project.TheCakeFactory.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @OneToMany(fetch = FetchType.LAZY)
    private List<Player> playerList;

    //Vad ska jag ha i konstruktorn??
    public Game(){
        this.playerList=new ArrayList<>();
    }

    // Då vi anänvder lombok så behövs inga getters :)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
