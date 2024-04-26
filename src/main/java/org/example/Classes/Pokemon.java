package org.example.Classes;

public class Pokemon {
    private int id;
    private String nome;
    private String tipo;
    private int nivel;

    public Pokemon(int id, String nome, String tipo, int nivel) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
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
