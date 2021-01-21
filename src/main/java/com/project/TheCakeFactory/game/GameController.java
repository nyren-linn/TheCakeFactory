package com.project.TheCakeFactory.game;

import com.project.TheCakeFactory.helperClasses.GamePlayerModell;
import com.project.TheCakeFactory.player.PlayerRepository;
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
        System.out.println("Tjohej!");
        return gameService.addGame();
    }

    @PostMapping("/addPlayerToAGame")
    public ResponseEntity<Game> addPlayerToAGame(@RequestBody GamePlayerModell game){
        System.out.println("Goddagens kära du!");
        return gameService.addPlayerToAGame(game);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<Game>> getAllGames(){
        System.out.println("Hej hå!");
        return gameService.getAllGames();
    }
}
