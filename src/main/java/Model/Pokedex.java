package Model;
public class Pokedex {
    private int id;
    private int treinador_ID;


    // Construtor
    public Pokedex(int treinador_ID) {
        this.id = 1;
        this.treinador_ID = treinador_ID;
    }

    // Getters
    public int getId() {
        return id;
    }
    public int getTreinador_ID() {
        return treinador_ID;
    }
}