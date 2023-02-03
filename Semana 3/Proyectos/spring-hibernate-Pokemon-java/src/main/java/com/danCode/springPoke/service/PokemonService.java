package com.danCode.springPoke.service;

import java.util.List;

import com.danCode.springPoke.entity.Pokemon;

public interface PokemonService {

	public List<Pokemon> getPokemons();
	
	public void savePokemon(Pokemon thePokemon);
	
	public Pokemon getPokemon(int theId);
	
	public void deletePokemon(int theId);
	
}
