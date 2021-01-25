package com.project.TheCakeFactory_Spring.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findById(long id);
}
