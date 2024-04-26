package org.example.Classes;

public class Equipe {
    private int ID;
    private String Nome;


    public Equipe(String nome, int ID) {
        Nome = nome;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }
}
