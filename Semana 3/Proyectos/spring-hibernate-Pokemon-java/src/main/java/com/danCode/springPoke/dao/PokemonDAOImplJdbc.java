package com.danCode.springPoke.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danCode.springPoke.entity.Pokemon;

@Repository
public class PokemonDAOImplJdbc implements PokemonDAO{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Pokemon> getPokemons() {
		
		List<Pokemon> pokemons = new ArrayList<>();
		
		String sql = "select * from pokedexkanto order by name_pokemon";
					
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement()) {

			ResultSet myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("id");
				String namePokemon = myRs.getString("name_pokemon");
				String type = myRs.getString("type");
				String ability = myRs.getString("ability");
				Pokemon tempPokemon = new Pokemon(id, namePokemon, type, ability);

				pokemons.add(tempPokemon);				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;
	}

	@Override
	public void savePokemon(Pokemon thePokemon) {
		if(thePokemon.getId() == 0) {
			String sql = "insert into pokedexkanto "
					   + "(name_pokemon, type, ability) "
					   + "values (?, ?, ?)";
			try (Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql)) {
				
				// set the param values for the student
				myStmt.setString(1, thePokemon.getNamePokemon());
				myStmt.setString(2, thePokemon.getType());
				myStmt.setString(3, thePokemon.getAbility());
				
				// execute sql insert
				myStmt.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			String sql = "update pokedexkanto "
					+ "set name_pokemon=?, type=?, ability=? "
					+ "where id=?";
		
			try (Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql)) {
				
				myStmt.setString(1, thePokemon.getNamePokemon());
				myStmt.setString(2, thePokemon.getType());
				myStmt.setString(3, thePokemon.getAbility());
				myStmt.setInt(4, thePokemon.getId());
				
				myStmt.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Pokemon getPokemon(int theId) {
		
		Pokemon thepokemon = null;
		
		String sql = "select * from pokedexkanto where id=?";

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql)){
			myStmt.setInt(1, theId);
			
			ResultSet myRs = myStmt.executeQuery();
			
			if (myRs.next()) {
				String namePokemon = myRs.getString("name_pokemon");
				String type = myRs.getString("type");
				String ability = myRs.getString("ability");
			
				thepokemon = new Pokemon(theId, namePokemon, type, ability);
			}
			else {
				throw new Exception("Could not find pokemon id: " + theId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thepokemon;
		
	}

	

	@Override
	public void deletePokemon(int theId) {

		String sql = "delete from pokedexkanto where id=?";
		
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql)) {
			myStmt.setInt(1, theId);
			
			myStmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
