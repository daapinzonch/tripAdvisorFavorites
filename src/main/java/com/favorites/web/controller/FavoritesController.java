package com.favorites.web.controller;

import com.favorites.web.entity.Favorites;
import com.favorites.web.service.FavoritesService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
@CrossOrigin(origins = "*")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @GetMapping
    public String msg(){
        return "CLIENTS AVAILABLE";
    }

    @ApiOperation(value = "Gets all the favorites from a client by id." , response = List.class)
    @GetMapping("/{id}")
    public ResponseEntity<List<Favorites>> getAllFavorites(@PathVariable(value = "id") String clientId){
        return ResponseEntity.ok(favoritesService.getAllFavorites(clientId));
    }

    @ApiOperation(value = "Creates a new favorite.")
    @PostMapping(path ="/", consumes = "application/json")
    public ResponseEntity<String> createClient(@RequestBody Favorites favorites) {
            Favorites cli = favoritesService.getFavorite(favorites.getId());
            if (cli==null){
                Favorites created = favoritesService.createFavorite(favorites);
                return new ResponseEntity<>(created.getId(),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @ApiOperation(value = "Deletes a favorite is a change of state by Id.")
    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> deleteFavorite(@PathVariable(value = "id") String FavoriteId) {
        Favorites cli = favoritesService.getFavorite(FavoriteId);
        if (cli!=null){
            favoritesService.deleteFavorite(cli);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
