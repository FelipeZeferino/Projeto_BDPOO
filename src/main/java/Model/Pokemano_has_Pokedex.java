package Model;
public class Pokemano_has_Pokedex {

    private int pokemano_ID;
    private int pokedex_ID;

    // Construtor
    public Pokemano_has_Pokedex(int pokemano_ID, int pokedex_ID) {
        this.pokemano_ID = pokemano_ID;
        this.pokedex_ID = pokedex_ID;
    }

    // Getters
    public int getPokemano_ID() {
        return pokemano_ID;
    }
    public int getPokedex_ID() {
        return pokedex_ID;
    }
}
