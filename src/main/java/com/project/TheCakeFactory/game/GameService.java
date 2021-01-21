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

    public ResponseEntity<Game> addGame(){
        System.out.println("Tjohejhej!");
        Game game = new Game();
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Game> addPlayerToAGame(GamePlayerModell gamePlayerModell){
        System.out.println("Goddagens!");
        Game game = gameRepository.findById(gamePlayerModell.getGameId());
        //if(game==null){
          //  throw new GameNotFoundException(gamePlayerModell.getGameId());
        //}
        Player player = playerRepository.findById((gamePlayerModell.getPlayerId()));
        game.addPlayerToGame(player);
        gameRepository.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Game>> getAllGames(){
        System.out.println("Hej hå HÅ!");
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
