package org.example.Classes;

public class Habilidade {

    private int IdHabilidade;
    private int Dano;
    private String Nome;
    private String  TipoDeDano;

    public Habilidade(int idHabilidade, int dano, String nome, String tipoDeDano) {
        IdHabilidade = idHabilidade;
        Dano = dano;
        Nome = nome;
        TipoDeDano = tipoDeDano;
    }

    public int getIdHabilidade() {
        return IdHabilidade;
    }

    public int getDano() {
        return Dano;
    }

    public String getNome() {
        return Nome;
    }

    public String getTipoDeDano() {
        return TipoDeDano;
    }
}
