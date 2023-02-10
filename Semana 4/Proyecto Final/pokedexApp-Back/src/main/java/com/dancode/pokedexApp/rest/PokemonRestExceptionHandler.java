package com.dancode.pokedexApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PokemonRestExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<PokemonErrorResponse> handleException(PokemonNotFoundException exception){
        PokemonErrorResponse error = new PokemonErrorResponse(
                                HttpStatus.NOT_FOUND.value(), 
                                exception.getMessage(),
                                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PokemonErrorResponse> handleException(Exception exception){
        PokemonErrorResponse error = new PokemonErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                exception.getMessage(),
                                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
