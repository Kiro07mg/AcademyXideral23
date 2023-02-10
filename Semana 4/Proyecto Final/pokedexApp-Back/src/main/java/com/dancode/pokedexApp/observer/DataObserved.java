package com.dancode.pokedexApp.observer;

import java.util.ArrayList;

import com.dancode.pokedexApp.entity.Pokemon;
//observable
public class DataObserved {
    
    protected ArrayList<DataObserver> DataObservers;

    public DataObserved(){
        this.DataObservers = new ArrayList<>();
    }

    public void addObserver(DataObserver dataObserver){
        this.DataObservers.add(dataObserver);
    }

    public void removeObserver(DataObserver dataObserver){
        this.DataObservers.remove(dataObserver);
    }

    public void notifyObservers(Pokemon pokemon){
        for (DataObserver dataObserver : DataObservers) {
            dataObserver.update(pokemon);
        }
    }
}
