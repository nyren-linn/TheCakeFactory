package com.project.TheCakeFactory.player;

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
public class Player {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(targetEntity=Player.class, fetch = FetchType.LAZY)
    private List<Integer> scoreList;

    public Player(String name){
        this.name=name;
        this.scoreList= new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public boolean equals(Player p) {
        return p.getId() == this.id && p.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
