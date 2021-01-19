package com.project.TheCakeFactory.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findById(long id);
}
