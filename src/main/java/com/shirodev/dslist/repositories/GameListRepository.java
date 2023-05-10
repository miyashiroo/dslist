package com.shirodev.dslist.repositories;

import com.shirodev.dslist.entities.Game;
import com.shirodev.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
