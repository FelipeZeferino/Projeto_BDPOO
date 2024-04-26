package Model;
public class Pokemano_has_Habilidade {

    private int pokemano_ID;
    private int habilidade_ID;


    // Construtor
    public Pokemano_has_Habilidade(int pokemano_ID, int habilidade_ID) {
        this.pokemano_ID = pokemano_ID;
        this.habilidade_ID = habilidade_ID;
    }

    // Getters
    public int getPokemano_ID() {
        return pokemano_ID;
    }
    public int getHabilidade_ID() {
        return habilidade_ID;
    }
}
