package com.project.TheCakeFactory_Spring.playerInGame;

import com.project.TheCakeFactory_Spring.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerInGameRepository extends JpaRepository<PlayerInGame, Long> {
    PlayerInGame findById(long id);
}
