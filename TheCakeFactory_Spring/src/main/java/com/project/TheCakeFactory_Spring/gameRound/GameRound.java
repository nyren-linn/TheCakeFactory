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

    @OneToMany(targetEntity= GameRound.class, fetch = FetchType.LAZY)
    private List<Integer> scoreList;
    
    public GameRound(int score){
        super();
        this.scoreList= new ArrayList<>();
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }
}
