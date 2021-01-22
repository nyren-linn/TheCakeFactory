package com.project.TheCakeFactory.player;

import com.project.TheCakeFactory.helperClasses.DataBaseEntityModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@NoArgsConstructor
public class Player extends DataBaseEntityModel {

    private String name;

    @OneToMany(targetEntity=Player.class, fetch = FetchType.LAZY)
    private List<Integer> scoreList;

    public Player(String name){
        super();
        this.scoreList= new ArrayList<>();
        this.name=name;
    }
    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Player p) {
        return p.getId() == this.getId() && p.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name);
    }
}
