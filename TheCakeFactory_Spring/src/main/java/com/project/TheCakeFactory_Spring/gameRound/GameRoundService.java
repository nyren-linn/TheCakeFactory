package com.project.TheCakeFactory_Spring.gameRound;

import com.project.TheCakeFactory_Spring.game.Game;
import com.project.TheCakeFactory_Spring.game.GameService;
import com.project.TheCakeFactory_Spring.helperClasses.UpdatePlayerGameRoundModel;
import com.project.TheCakeFactory_Spring.playerInGame.PlayerInGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRoundService {
    
    @Autowired
    GameRoundRepository gameRoundRepository;
    @Autowired
    GameService gameService;

    //Hämtar gameId och playerId för att sedan lägga till GameRounds till Player.
    // Därefter uppdateras Game.
    public ResponseEntity<Game> addGameRound(UpdatePlayerGameRoundModel updatePlayerGameRoundModel){
        Game game = gameService.getGameById(updatePlayerGameRoundModel.getGameId());
        PlayerInGame playerInGame = game.getPlayerInGameById(updatePlayerGameRoundModel.getPlayerId());

        playerInGame.addGameRound(updatePlayerGameRoundModel.getGameRound());
        gameService.updateGame(game);
        return new ResponseEntity<>(game, HttpStatus.ACCEPTED);
    }

    //Visar en lista på alla GameRounds
    public ResponseEntity<List<GameRound>> getAllScoresForGameRound(){
        return new ResponseEntity<List<GameRound>>(gameRoundRepository.findAll(), HttpStatus.OK);
    }
}
