package com.danCode.springPoke.dao;

import java.util.List;

import com.danCode.springPoke.entity.Pokemon;

public interface PokemonDAO {
	
	public List<Pokemon> getPokemons();
	
	public void savePokemon(Pokemon thePokemon);
	
	public Pokemon getPokemon(int theId);
	
	public void deletePokemon(int theId);

}
