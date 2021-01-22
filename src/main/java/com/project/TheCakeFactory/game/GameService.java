package com.project.TheCakeFactory.game;

import com.project.TheCakeFactory.helperClasses.GamePlayerModell;
import com.project.TheCakeFactory.player.Player;
import com.project.TheCakeFactory.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;

    GamePlayerModell gamePlayerModell;

    //Lägger till ett Game
    public ResponseEntity<Game> addGame(){
        Game game = new Game();
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }

    //Lägger till en Player till ett Game genom att man anger gameID och playerId.
    public ResponseEntity<Game> addPlayerToAGame(GamePlayerModell gamePlayerModell){
        Game game = gameRepository.findById(gamePlayerModell.getGameId());
        //if(game==null){
          //  throw new GameNotFoundException(gamePlayerModell.getGameId());
        //}
        Player player = playerRepository.findById((gamePlayerModell.getPlayerId()));
        game.addPlayerToGame(player);
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }

    //Visar en lista på alla Games samt spelare kopplat till den/dom.
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<List<Game>>(gameRepository.findAll(), HttpStatus.ACCEPTED);
    }

    /*
    public Score saveScore(Score score){
        Score foundedScore = gameRepository.findById(score.getId()).get();

        if (foundedScore == null){
            foundedScore.setScore(foundedScore.getScore() + score.getScore());
            gameRepository.save(foundedScore);
            return foundedScore;
        }
        gameRepository.save(score);
        return score;
    }
    */


}
