package org.example.Classes;

public class Treinador {
    private int ID;
    private String nome;
    private int IdEquipe;

    public Treinador(int ID, String nome, int idEquipe) {
        this.ID = ID;
        this.nome = nome;
        IdEquipe = idEquipe;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getIdEquipe() {
        return IdEquipe;
    }
}
