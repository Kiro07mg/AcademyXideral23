package com.curso;

public class main {

    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", 10, 50, 40, 60);
        Trainer ash = new Trainer("Ash");
        pikachu.addObserver(ash);

        pikachu.levelUp();
        pikachu.levelUp();
        pikachu.levelUp();
    }
}
