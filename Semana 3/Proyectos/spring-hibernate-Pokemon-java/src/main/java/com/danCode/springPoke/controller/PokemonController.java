package com.danCode.springPoke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danCode.springPoke.entity.Pokemon;
import com.danCode.springPoke.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/list")
	public String listPokemons(Model theModel) {
		List<Pokemon> thePokemons = pokemonService.getPokemons();
		theModel.addAttribute("pokemons", thePokemons);
		return "list-pokemons";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Pokemon thePokemon = new Pokemon();
		theModel.addAttribute("pokemon",thePokemon);
		return "pokemon-form";
	}
	@PostMapping("/savePokemon")
	public String savePokemon(@ModelAttribute("pokemon") Pokemon thePokemon) {
		pokemonService.savePokemon(thePokemon);
		return "redirect:/pokemon/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pokemonId") int theId, Model theModel) {
		Pokemon thePokemon = pokemonService.getPokemon(theId);
		theModel.addAttribute("pokemon", thePokemon);
		return "pokemon-form";
	}
	
	@GetMapping("/delete")
	public String deletePokemon(@RequestParam("pokemonId") int theId) {
		pokemonService.deletePokemon(theId);
		return "redirect:/pokemon/list";
	}
}
