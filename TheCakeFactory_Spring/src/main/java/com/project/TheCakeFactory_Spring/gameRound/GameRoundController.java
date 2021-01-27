package com.project.TheCakeFactory_Spring.gameRound;

import com.project.TheCakeFactory_Spring.game.Game;
import com.project.TheCakeFactory_Spring.helperClasses.UpdatePlayerGameRoundModel;
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
    public ResponseEntity<Game> addGameRound(@RequestBody UpdatePlayerGameRoundModel updatePlayerGameRoundModel){
        return gameRoundService.addGameRound(updatePlayerGameRoundModel);
    }
    
    @GetMapping("/getAllScoresForGameRound")
    public ResponseEntity<List<GameRound>> getAllScores(){
        return gameRoundService.getAllScoresForGameRound();
    }
}
