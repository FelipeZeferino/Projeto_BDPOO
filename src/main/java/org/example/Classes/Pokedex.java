package org.example.Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pokedex {
    private int id;
    private int id_treinador;
    private ArrayList<Pokemon> pokemons;

    public Pokedex(int id, int id_treinador) {
        this.id = id;
        this.id_treinador = id_treinador;
        this.pokemons = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
}