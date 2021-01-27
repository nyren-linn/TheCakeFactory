package com.project.TheCakeFactory_Spring.gameRound;

import com.project.TheCakeFactory_Spring.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRoundService {
    
    @Autowired
    GameRoundRepository gameRoundRepository;

    //Lägger till ett GameRound
    public ResponseEntity<GameRound> addGameRound(GameRound gameRound){
        gameRoundRepository.save(gameRound);
        return new ResponseEntity<GameRound>(gameRound, HttpStatus.ACCEPTED);
    }
    
    //Visar en lista på alla GameRounds
    public ResponseEntity<List<GameRound>> getAllScoresForGameRound(){
        return new ResponseEntity<List<GameRound>>(gameRoundRepository.findAll(), HttpStatus.OK);
    }
}
