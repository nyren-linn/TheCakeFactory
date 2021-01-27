package com.project.TheCakeFactory_Spring.player;

import com.project.TheCakeFactory_Spring.game.Game;
import com.project.TheCakeFactory_Spring.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    //Lägger till Player till PlayerRepository
    public ResponseEntity<Player> addPlayer(Player player){
        playerRepository.save(player);
        return new ResponseEntity<Player>(player, HttpStatus.CREATED);
    }

    //Metoden tar bort Player från PlayerRepository. Kan inte ta bort Player som är kopplat till Game,
    // då måste Player först tas bort från Game.
    //TODO: Lösa problemet att felmeddelande kastas trotts att spelare tas bort.
    public ResponseEntity<Player> deletePlayer(long playerId){
        //try{
            Player p = playerRepository.findById(playerId);
            playerRepository.delete(p);
            return new ResponseEntity<Player>(p, HttpStatus.OK);
        /*}catch(Exception e){
            //TODO: fix correct message to be returned properly to consumer of the API
            String message = "Something went wrong \nHave you removed the player from associated games?";
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }*/
    }

    //Visar en lista på att tillagda Players
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<List<Player>>(playerRepository.findAll(), HttpStatus.OK);
    }
}
