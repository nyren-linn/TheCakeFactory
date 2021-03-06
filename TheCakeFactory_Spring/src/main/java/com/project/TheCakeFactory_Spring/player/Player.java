package com.project.TheCakeFactory_Spring.player;

import com.project.TheCakeFactory_Spring.gameRound.GameRound;
import com.project.TheCakeFactory_Spring.helperClasses.DataBaseEntityModel;
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
    
    public Player(String name){
        super();
        this.name=name;
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
