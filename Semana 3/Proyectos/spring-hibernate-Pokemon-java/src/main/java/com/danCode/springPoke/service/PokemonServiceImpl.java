package com.danCode.springPoke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danCode.springPoke.dao.PokemonDAO;
import com.danCode.springPoke.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService{

	@Autowired
	@Qualifier("pokemonDAOImplJdbc")
	private PokemonDAO pokemonDAO;
	
	@Override
	@Transactional
	public List<Pokemon> getPokemons(){
		return pokemonDAO.getPokemons();
	}
	
	@Override
	@Transactional
	public void savePokemon(Pokemon thePokemon) {
		pokemonDAO.savePokemon(thePokemon);
	}
	
	@Override
	@Transactional
	public Pokemon getPokemon(int theId) {
		return pokemonDAO.getPokemon(theId);
	}
	
	@Override
	@Transactional
	public void deletePokemon(int theId) {
		pokemonDAO.deletePokemon(theId);
	}
}
