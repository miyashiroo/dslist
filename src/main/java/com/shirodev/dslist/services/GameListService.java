package com.shirodev.dslist.services;


import com.shirodev.dslist.dto.GameDTO;
import com.shirodev.dslist.dto.GameListDTO;
import com.shirodev.dslist.dto.GameMinDTO;
import com.shirodev.dslist.entities.Game;
import com.shirodev.dslist.entities.GameList;
import com.shirodev.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepositoryo;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
    @Transactional
    public void move(Long listId,int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepositoryo.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameRepository.updateBelongingPosition(listId,list.get(i).getId(),i);

        }




    }


}
