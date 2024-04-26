package Model;
public class Equipe {

    private int id;
    private String nome;


    // Construtores
    public Equipe(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Equipe(String nome) {
        this.nome = nome;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
