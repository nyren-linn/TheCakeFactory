package com.project.TheCakeFactory.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/addPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/deletePlayer/{playerId}")
    public ResponseEntity deletePlayer(@PathVariable long playerId){
        return playerService.deletePlayer(playerId);
    }


    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return playerService.getAllPlayers();
    }

}
