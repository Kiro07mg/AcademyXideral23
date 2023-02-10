package com.dancode.pokedexApp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dancode.pokedexApp.dao.PokemonJPA;
import com.dancode.pokedexApp.entity.Pokemon;
import com.dancode.pokedexApp.observer.DataObserved;

@Service
public class PokemonServiceImpl extends DataObserved implements PokemonService {

    private PokemonJPA pokemonJpa;
    
    @Autowired
    public PokemonServiceImpl(PokemonJPA pokemonDao){
        pokemonJpa = pokemonDao;
    }

    @Override
    @Transactional
    public List<Pokemon> findAll() {
        return pokemonJpa.findAll();
    }

    @Override
    @Transactional
    public Pokemon findById(int theId) {
        Optional<Pokemon> result = pokemonJpa.findById(theId);
		
		Pokemon thePokemon = null;
		
		if (result.isPresent()) {
			thePokemon = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return thePokemon;
    }

    @Override
    @Transactional
    public void save(Pokemon thepokemon) throws IOException{
        Pokemon savePokemon = pokemonJpa.save(thepokemon);
        notifyObservers(savePokemon);
        
    }

    @Override
    @Transactional
    public void deleteById(int theId) throws IOException {
        Pokemon deletePokemon = pokemonJpa.getById(theId);
        pokemonJpa.deleteById(theId);
        notifyObservers(deletePokemon);
    }
    
}
