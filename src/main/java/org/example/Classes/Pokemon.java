package org.example.Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pokemon {
    private int id;
    private String nome;
    private String tipo;
    private int nivel;
    private ArrayList<Pokedex> pokedex;

    public Pokemon(int id, String nome, String tipo, int nivel) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.pokedex = new ArrayList<>();
    }



    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }
}
