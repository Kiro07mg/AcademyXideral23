package com.dancode.pokedexApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dancode.pokedexApp.entity.Pokemon;

public interface PokemonJPA extends JpaRepository<Pokemon,Integer>{
    
}
