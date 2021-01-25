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

    @PostMapping("/addScoreToGameRound")
    public ResponseEntity<GameRound> addScoreToGameRound (@RequestBody GameRound gameRound){
        return gameRoundService.addScoreToGameRound(gameRound);
    }

    @GetMapping("/getAllScores")
    public ResponseEntity<List<GameRound>> getAllScores(){
        return gameRoundService.getAllScores();
    }
}
