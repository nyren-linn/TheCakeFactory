package com.project.TheCakeFactory_Spring.gameRound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoundRepository extends JpaRepository<GameRound, Long> {
    GameRound findById(long id);
}
