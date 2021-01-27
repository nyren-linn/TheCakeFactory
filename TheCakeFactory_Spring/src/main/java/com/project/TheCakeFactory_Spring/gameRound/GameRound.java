package com.project.TheCakeFactory_Spring.gameRound;

import com.project.TheCakeFactory_Spring.helperClasses.DataBaseEntityModel;
import com.project.TheCakeFactory_Spring.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class GameRound extends DataBaseEntityModel {
    
    private int score;
    private String type;
    
    public GameRound(int score, String type){
        super();
        this.score= score;
        this.type= type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }
}
