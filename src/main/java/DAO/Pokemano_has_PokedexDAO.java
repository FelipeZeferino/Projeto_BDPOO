package DAO;

import Model.Pokemano;
import Model.Pokemano_has_Pokedex;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pokemano_has_PokedexDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokemano_has_Pokedex(Pokemano_has_Pokedex pokemano_has_pokedex) {

        connectToDB();

        String sql = "INSERT INTO Pokemano_has_Pokedex (pokemano_ID, pokedex_ID) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,pokemano_has_pokedex.getPokemano_ID());
            pst.setInt(2, pokemano_has_pokedex.getPokedex_ID());
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

    public boolean deletePokemon(int id) {
        connectToDB();
        String sql = "DELETE FROM pokemano_has_pokedex WHERE Pokemano_ID = ? AND Pokedex_ID = 1";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
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

    public boolean insertPokemano (int ID) {
        connectToDB();

        String sql = "INSERT INTO Pokemano_has_Pokedex (pokemano_ID) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, ID);
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

    //SELECT
    public ArrayList<Pokemano_has_Pokedex> selectPokemano_has_Pokedex() {
        ArrayList<Pokemano_has_Pokedex> pokemanoHasPokedexes = new ArrayList<>();
        ArrayList<Pokemano> lista = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemano_has_Pokedex";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Pokemanos na Pokedex: ");

            while (rs.next()) {

                Pokemano_has_Pokedex pokedexAux = new Pokemano_has_Pokedex(rs.getInt("Pokemano_ID"), rs.getInt("Pokedex_ID"));

                System.out.println("ID dos Pokemons da Pokedex:  " + pokedexAux.getPokemano_ID());
                System.out.println("--------------------------------");
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
        return pokemanoHasPokedexes;
    }
    public ArrayList<Pokemano_has_Pokedex> selectPokemano_has_Pokedex(int TreinadorId) {
        ArrayList<Pokemano_has_Pokedex> pokemanoHasPokedexes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemano_has_Pokedex WHERE pokedex_ID = ?";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, TreinadorId);
            rs = pst.executeQuery();


            System.out.println("Lista de Pokemanos na Pokedex: ");

            while (rs.next()) {

                Pokemano_has_Pokedex pokedexAux = new Pokemano_has_Pokedex(rs.getInt("pokedex_ID"), rs.getInt("pokemano_ID"));

                System.out.println("ID dos Pokemons da Pokedex:  " + pokedexAux.getPokemano_ID());
                System.out.println("--------------------------------");
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return pokemanoHasPokedexes;
    }

}
