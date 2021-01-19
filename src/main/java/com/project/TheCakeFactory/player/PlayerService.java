package com.project.TheCakeFactory.player;

import com.project.TheCakeFactory.game.Game;
import com.project.TheCakeFactory.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;

    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        playerRepository.save(player);

        return new ResponseEntity<Player>(player, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<List<Player>>(playerRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
