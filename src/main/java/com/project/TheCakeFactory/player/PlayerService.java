package com.project.TheCakeFactory.player;

import com.project.TheCakeFactory.game.Game;
import com.project.TheCakeFactory.game.GameRepository;
import com.project.TheCakeFactory.helperClasses.GamePlayerModell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    //Lägger till Player till PlayerRepository
    public ResponseEntity<Player> addPlayer(Player player){
        playerRepository.save(player);
        return new ResponseEntity<Player>(player, HttpStatus.ACCEPTED);
    }

    //Metoden tar bort Player från PlayerRepository. Kan inte ta bort spelare som är kopplat till Game,
    // då måste Player först tas bort från Game.
    public ResponseEntity<Player> deletePlayer(Player player){
        playerRepository.findById(player.getId());
        playerRepository.delete(player);
        return new ResponseEntity<Player>(HttpStatus.ACCEPTED);
    }

    //Visar en lista på att tillagda Players
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<List<Player>>(playerRepository.findAll(), HttpStatus.ACCEPTED);
    }

}
