package com.curso;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    
   private String name;
   private int level;
   private int attackPoints;
   private int defensePoints;
   private int specialAttackPoints;
   
   private List<Observer> observers = new ArrayList<>();

   public Pokemon(String name, int level, int attackPoints, int defensePoints, int specialAttackPoints) {
       this.name = name;
       this.level = level;
       this.attackPoints = attackPoints;
       this.defensePoints = defensePoints;
       this.specialAttackPoints = specialAttackPoints;
   }

   public void addObserver(Observer observer) {
       observers.add(observer);
   }

   public void removeObserver(Observer observer) {
       observers.remove(observer);
   }

   public void notifyObservers() {
       for (Observer observer : observers) {
           observer.update(this);
       }
   }

   public void levelUp() {
       level++;
       notifyObservers();
   }

   public String getName() {
       return name;
   }

   public int getLevel() {
       return level;
   }

   public int getAttackPoints() {
       return attackPoints;
   }

   public int getDefensePoints() {
       return defensePoints;
   }

   public int getSpecialAttackPoints() {
       return specialAttackPoints;
   }
}
