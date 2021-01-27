package com.project.TheCakeFactory_Spring.game;

import com.project.TheCakeFactory_Spring.helperClasses.GamePlayerModel;
import com.project.TheCakeFactory_Spring.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    GameService gameService;
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping ("/addGame")
    public ResponseEntity<Game> addGame(){
        return gameService.addGame();
    }

    @PostMapping("/addPlayerToAGame")
    public ResponseEntity<Game> addPlayerToAGame(@RequestBody GamePlayerModel gamePlayerModel){
        return gameService.addPlayerToAGame(gamePlayerModel);
    }

    @DeleteMapping("/removePlayerFromGame")
    public ResponseEntity removePlayerFromGame(@RequestBody GamePlayerModel gamePlayerModel){
        return gameService.removePlayerFromGame(gamePlayerModel);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<Game>> getAllGames(){
        return gameService.getAllGames();
    }
}
