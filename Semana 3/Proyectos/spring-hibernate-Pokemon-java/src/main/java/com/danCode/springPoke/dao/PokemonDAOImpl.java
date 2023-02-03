package com.danCode.springPoke.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danCode.springPoke.entity.Pokemon;

@Repository
public class PokemonDAOImpl implements PokemonDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Pokemon> getPokemons(){
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Pokemon> theQuery = currentSession.createQuery("from Pokemon order by name_Pokemon", Pokemon.class);
		
		List<Pokemon> pokemons = theQuery.getResultList();
		
		return pokemons;
	}
	
	@Override
	public void savePokemon(Pokemon thepokemon) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thepokemon);
	}
	
	@Override
	public Pokemon getPokemon(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Pokemon thePokemon = session.get(Pokemon.class, theId);
		return thePokemon;
	}
	
	@Override
	public void deletePokemon(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Pokemon where id=:pokemonId");
		theQuery.setParameter("pokemonId", theId);
		theQuery.executeUpdate();
	}

}
