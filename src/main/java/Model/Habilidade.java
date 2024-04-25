package Model;
public class Habilidade {

    private int id;
    private int dano;
    private String nome;
    private String tipo_de_dano;


    // Construtor
    public Habilidade(int id, int dano, String nome, String tipo_de_dano) {
        this.id = id;
        this.dano = dano;
        this.nome = nome;
        this.tipo_de_dano = tipo_de_dano;
    }

    // Getters

    public int getId() {
        return id;
    }
    public int getDano() {
        return dano;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo_de_dano() {
        return tipo_de_dano;
    }
}
