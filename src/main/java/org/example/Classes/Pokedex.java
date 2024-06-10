package org.example.Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pokedex {
    private int id;
    private ArrayList<Pokemon> pokemons;

    public Pokedex(int id) {
        this.id = id;
        this.pokemons = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
}