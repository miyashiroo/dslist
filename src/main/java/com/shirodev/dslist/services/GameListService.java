package com.shirodev.dslist.services;


import com.shirodev.dslist.dto.GameDTO;
import com.shirodev.dslist.dto.GameListDTO;
import com.shirodev.dslist.dto.GameMinDTO;
import com.shirodev.dslist.entities.Game;
import com.shirodev.dslist.entities.GameList;
import com.shirodev.dslist.repositories.GameListRepository;
import com.shirodev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }


}
