package com.luv2code.springboot.cruddemo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Pokemon;
import com.luv2code.springboot.cruddemo.service.PokemonService;

@Controller
@RequestMapping("/mvc")
public class PokemonMvcController {

    @Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/Pokemons")
	public String listPokemons(Model theModel) {
		
		// get customers from the service
		List<Pokemon> thePokemons = pokemonService.findAll();
				
		// add the customers to the model
		theModel.addAttribute("pokemons", thePokemons);
		
		return "list-pokemons";
	}

    @GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Pokemon thePokemon = new Pokemon();
		
		theModel.addAttribute("pokemon", thePokemon);
		
		return "pokemon-form";
	}
	
	@PostMapping("/savePokemon")
	public String savePokemon(@ModelAttribute("pokemon") Pokemon thePokemon) {
		
		// save the customer using our service
		pokemonService.save(thePokemon);	
		
		return "redirect:/mvc/Pokemons";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pokemonId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Pokemon thePokemon = pokemonService.findById(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("pokemon", thePokemon);
		
		// send over to our form		
		return "pokemon-form";
	}
	
	@GetMapping("/delete")
	public String deletePokemon(@RequestParam("pokemonId") int theId) {
		
		// delete the customer
		pokemonService.deleteById(theId);
		
		return "redirect:/mvc/Pokemons";
	}
}
