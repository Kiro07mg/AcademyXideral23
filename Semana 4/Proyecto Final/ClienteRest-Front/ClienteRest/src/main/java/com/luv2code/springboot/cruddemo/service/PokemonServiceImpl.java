package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {
    
    private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PokemonServiceImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}

    @Override
    public List<Pokemon> findAll() {
        logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Pokemon>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Pokemon>>() {});

		// get the list of customers from response
		List<Pokemon> pokemons = responseEntity.getBody();

		logger.info("in findAll(): pokemons" + pokemons);
		
		return pokemons;
    }

    @Override
    public Pokemon findById(int theId) {
        
		logger.info("in getPokemon(): Calling REST API " + crmRestUrl);

		// make REST call
		Pokemon thePokemon = 
        restTemplate.getForObject(crmRestUrl + "/" + theId, 
                Pokemon.class);

        logger.info("in findById(): thePokemon=" + thePokemon);

        return thePokemon;
    }

    @Override
    public void save(Pokemon thePokemon) {
        //logger.info("in savePokemon(): Calling REST API " + crmRestUrl);
		
		int pokemonId = thePokemon.getId();

		// make REST call
		if (pokemonId == 0) {
			// add pokemon
			restTemplate.postForEntity(crmRestUrl, thePokemon, String.class);			
		
		} else {
			// update pokemon
			restTemplate.put(crmRestUrl, thePokemon);
		}

		logger.info("in pokemon save(): success");	
		
    }

    @Override
    public void deleteById(int theId) {
        
		logger.info("in deleteById(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteById(): deleted pokemon theId=" + theId);
		
    }
    
}
