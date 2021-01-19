package com.project.TheCakeFactory.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/addGame")
    public ResponseEntity<Game> addGame(@RequestBody Game game){
        return gameService.addGame(game);
    }

    @PostMapping("/addPlayerToGame")
    public ResponseEntity<Game> addPlayerToGame(@RequestBody Game game){
        return gameService.addPlayerToGame(game);
    }

    public ResponseEntity<List<Game>> getAllGames(){
        return gameService.getAllGames();
    }






}
