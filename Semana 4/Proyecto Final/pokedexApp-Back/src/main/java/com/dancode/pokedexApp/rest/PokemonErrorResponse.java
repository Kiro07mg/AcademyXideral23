package com.dancode.pokedexApp.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PokemonErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
