package com.favorites.web.repository;

import com.favorites.web.entity.Favorites;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface FavoritesRepository extends MongoRepository<Favorites, Serializable> {

    List<Favorites> findAllByClientId(String clientId);
    Favorites findFirstById(String favoriteId);

}
