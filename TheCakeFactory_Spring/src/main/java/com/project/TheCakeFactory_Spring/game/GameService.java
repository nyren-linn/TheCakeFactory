package com.project.TheCakeFactory_Spring.game;

import com.project.TheCakeFactory_Spring.helperClasses.GamePlayerModel;
import com.project.TheCakeFactory_Spring.player.Player;
import com.project.TheCakeFactory_Spring.player.PlayerRepository;
import com.project.TheCakeFactory_Spring.playerInGame.PlayerInGame;
import com.project.TheCakeFactory_Spring.playerInGame.PlayerInGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    PlayerInGameRepository playerInGameRepository;

    //Lägger till ett Game
    public ResponseEntity<Game> addGame(){
        Game game = new Game();
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.CREATED);
    }

    //Lägger till en Player till ett Game genom att man anger gameID och playerId.
    public ResponseEntity<Game> addPlayerToAGame(GamePlayerModel gamePlayerModel){
        Game game = gameRepository.findById(gamePlayerModel.getGameId());
        //if(game==null){
          //  throw new GameNotFoundException(gamePlayerModell.getGameId());
        //}
        Player player = playerRepository.findById(gamePlayerModel.getPlayerId());
        PlayerInGame playerInGame= new PlayerInGame(player);
        game.addPlayerToGame(playerInGame);
        playerInGameRepository.save(playerInGame);
        //System.out.println(game.getPlayerList().get(0).getPlayerId());
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }

    //Tar bort Player från Game genom att ange gameId och playerId.
    public ResponseEntity removePlayerFromGame(GamePlayerModel gamePlayerModel){
        try {
            Game game = gameRepository.findById(gamePlayerModel.getGameId());
            Player player = playerRepository.findById(gamePlayerModel.getPlayerId());
            game.removePlayerFromGame(player);
            gameRepository.save(game);
            return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<GamePlayerModel>(gamePlayerModel, HttpStatus.BAD_REQUEST);
        }
    }

    //Visar en lista på alla Games samt spelare kopplat till den/dom.
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<List<Game>>(gameRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
