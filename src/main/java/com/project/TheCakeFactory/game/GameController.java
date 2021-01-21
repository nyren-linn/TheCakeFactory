package com.project.TheCakeFactory.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping ("/addGame")
    public ResponseEntity<Game> addGame(){
        System.out.println("Tjohej!");
        return gameService.addGame();
    }

    @PostMapping("/addPlayerToGame")
    public ResponseEntity<Game> addPlayerToGame(@RequestBody Game game){
        return gameService.addPlayerToGame(game);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<Game>> getAllGames(){
        System.out.println("Hej hå!");
        return gameService.getAllGames();
    }






}
