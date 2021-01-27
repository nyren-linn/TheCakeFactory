package com.project.TheCakeFactory_Spring.gameRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameRoundController {

    @Autowired
    GameRoundService gameRoundService;

    @GetMapping ("/addGameRound")
    public ResponseEntity<GameRound> addGameRound(GameRound gameRound){
        return gameRoundService.addGameRound(gameRound);
    }
    
    @GetMapping("/getAllScoresForGameRound")
    public ResponseEntity<List<GameRound>> getAllScores(){
        return gameRoundService.getAllScoresForGameRound();
    }
}
