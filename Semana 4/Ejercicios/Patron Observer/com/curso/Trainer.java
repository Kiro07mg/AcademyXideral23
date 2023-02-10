package com.curso;

public class Trainer implements Observer{
    
    private String name;

    public Trainer(String name) {
        this.name = name;
    }

    @Override
    public void update(Pokemon pokemon) {
        System.out.println(name + ": ¡" + pokemon.getName() + " ha subido al nivel " + pokemon.getLevel() + "!");
    }
}
