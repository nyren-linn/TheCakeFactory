package com.project.TheCakeFactory_Spring.gameRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRoundService {
    
    @Autowired
    GameRoundRepository gameRoundRepository;
    
    public ResponseEntity<GameRound> addScoreToGameRound (GameRound gameRound){
        gameRoundRepository.save(gameRound);
        return new ResponseEntity<GameRound>(gameRound, HttpStatus.CREATED);
    }
    
    public ResponseEntity<List<GameRound>> getAllScores(){
        return new ResponseEntity<List<GameRound>>(gameRoundRepository.findAll(), HttpStatus.OK);
    }
}
