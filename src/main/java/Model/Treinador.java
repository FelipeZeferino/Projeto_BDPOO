package Model;
public class Treinador {

    public static int id = 1;
    private String nome;
    private int equipe_ID;


    // Construtor
    public Treinador(int id, String nome, int equipe_ID) {
        this.id = id;
        this.nome = nome;
        this.equipe_ID = equipe_ID;
    }





    //Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getEquipe_ID() {
        return equipe_ID;
    }
    public void setNome(String nome){ this.nome = nome;}
}
