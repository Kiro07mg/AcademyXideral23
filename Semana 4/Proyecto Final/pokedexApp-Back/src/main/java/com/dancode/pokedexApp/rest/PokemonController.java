package com.dancode.pokedexApp.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancode.pokedexApp.dao.PokemonJPA;
import com.dancode.pokedexApp.entity.Pokemon;
import com.dancode.pokedexApp.observer.DataObserved;
import com.dancode.pokedexApp.observer.DataObserver;
import com.dancode.pokedexApp.service.PokemonServiceImpl;

@RestController
@RequestMapping("/api")
public class PokemonController extends DataObserved{
    
    @Autowired
    private PokemonServiceImpl pokemonService;

    @Autowired
    private PokemonJPA pokemonJPA;

    @Override
    public void addObserver(DataObserver dataObserver) {
        super.addObserver(dataObserver);
    }

    @Override
    public void removeObserver(DataObserver dataObserver) {
        super.removeObserver(dataObserver);
    }

    @Override
    public void notifyObservers(Pokemon pokemon) {
        super.notifyObservers(pokemon);
    }

    @GetMapping("/pokemons")
    public List<Pokemon> findAll(){
        
        if (pokemonService.findAll().isEmpty()) {
            throw new PokemonNotFoundException("No pokemon data found");
        }
        return pokemonService.findAll();
    }

    @GetMapping("/pokemons/{pokemonId}")
    public Pokemon getPokemon(@PathVariable int pokemonId){
        Pokemon pokemon = pokemonService.findById(pokemonId);
        if(pokemon == null){
            throw new PokemonNotFoundException("Pokemon id not found: " + pokemonId);
        }
        return pokemon;
    }

    @PostMapping("/pokemons")
    public Pokemon addPokemon(@RequestBody Pokemon myPokemon) throws IOException{
        myPokemon.setId(0);
        pokemonService.save(myPokemon);

        pokemonJPA.saveAndFlush(myPokemon);

        for(DataObserver dataObserver : DataObservers){
            dataObserver.update(myPokemon);
        }
        return myPokemon;
    }

    @PutMapping("/pokemons")
    public Pokemon updatPokemon(@RequestBody Pokemon myPokemon) throws IOException{
        pokemonService.save(myPokemon);
        return myPokemon;
    }

    @DeleteMapping("/pokemons/{pokemonId}")
    public String deletePokemon(@PathVariable int pokemonId) throws IOException{
        Pokemon poke = pokemonService.findById(pokemonId);
        if(poke == null){
            throw new PokemonNotFoundException("Pokemon id not found: " + pokemonId);
        }
        pokemonService.deleteById(pokemonId);
        return "Deleted pokemon id: " + pokemonId;
    }
}
