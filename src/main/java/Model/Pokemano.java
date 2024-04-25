package Model;

public class Pokemano {
    private int id;
    private String nome;
    private String tipo;
    private int nivel;

    // Construtor
    public Pokemano(int id, String nome, String tipo, int nivel) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    // Geters

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

    // Setter
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
