package com.dancode.pokedexApp.service;

import java.io.IOException;
import java.util.List;

import com.dancode.pokedexApp.entity.Pokemon;

public interface PokemonService {
    
    public List<Pokemon> findAll();

    public Pokemon findById(int theId);

    public void save(Pokemon pokemon) throws IOException;

    public void deleteById(int theId) throws IOException;
}
