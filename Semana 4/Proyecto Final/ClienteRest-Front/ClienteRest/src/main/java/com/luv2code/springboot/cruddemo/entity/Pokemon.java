package com.luv2code.springboot.cruddemo.entity;

import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Pokemon {
    
    private int id;
	
	private String namePokemon;
	
	private String type;
	
	private String ability;
}
