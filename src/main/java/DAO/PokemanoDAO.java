package DAO;


import org.example.Classes.Pokemon;

import java.sql.SQLException;
import java.util.ArrayList;


public class PokemanoDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokemano(Pokemon pokemon) {

        connectToDB();

        String sql = "INSERT INTO Pokemano (id, nome, tipo, nivel) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,pokemon.getId());
            pst.setString(2, pokemon.getNome());
            pst.setString(3, pokemon.getTipo());
            pst.setInt(4, pokemon.getNivel());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }



    //DELETE
    public boolean deletePokemon(int id) {
        connectToDB();
        String sql = "DELETE FROM Pokemano where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Pokemon> selectPokemon() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemano";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Pokemons: ");

            while (rs.next()) {

                Pokemon pokemanoAux = new Pokemon(rs.getInt("id"), rs.getString("nome"),  rs.getString("tipo"),rs.getInt("nivel"));

                System.out.println("id = " + pokemanoAux.getId());
                System.out.println("nome = " + pokemanoAux.getNome());
                System.out.println("Tipo = " + pokemanoAux.getTipo());
                System.out.println("Nivel = " + pokemanoAux.getNivel());
                System.out.println("--------------------------------");

                pokemons.add(pokemanoAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return pokemons;
    }
}
