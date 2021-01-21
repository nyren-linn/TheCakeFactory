package com.project.TheCakeFactory.player;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return playerService.getAllPlayers();
    }

}
