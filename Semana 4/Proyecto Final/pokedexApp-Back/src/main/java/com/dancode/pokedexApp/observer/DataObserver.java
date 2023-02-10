package com.dancode.pokedexApp.observer;

import com.dancode.pokedexApp.entity.Pokemon;

public interface DataObserver {
    void update(Pokemon pokemon);
}
