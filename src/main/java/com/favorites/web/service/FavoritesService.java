package com.favorites.web.service;

import com.favorites.web.entity.Favorites;
import com.favorites.web.repository.FavoritesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;

    public List<Favorites> getAllFavorites(String clientId){ return favoritesRepository.findAllByClientId(clientId); }

    public Favorites getFavorite(String favoriteId){ return favoritesRepository.findFirstById(favoriteId); }

    public Favorites createFavorite(Favorites newFavorites){
        return favoritesRepository.save(newFavorites);
    }

    public void deleteFavorite(Favorites dlFavorites){
        favoritesRepository.delete(dlFavorites);
    }


}
