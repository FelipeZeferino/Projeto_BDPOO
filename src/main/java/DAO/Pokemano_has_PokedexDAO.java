package DAO;

import Model.Pokemano_has_Pokedex;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pokemano_has_PokedexDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokemano_has_Pokedex(Pokemano_has_Pokedex pokemano_has_pokedex) {

        connectToDB();

        String sql = "INSERT INTO Pokedex (pokemano_ID, pokedex_ID) values(?,?)";
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



//    //DELETE
//    public boolean deletePokedex_has_Pokemano(int id) {
//        connectToDB();
//        String sql = "DELETE FROM Pokedex_has_Pokemano where id=?";
//        try {
//            pst = con.prepareStatement(sql);
//            pst.setInt(1, id);
//            pst.execute();
//            sucesso = true;
//        } catch (SQLException ex) {
//            System.out.println("Erro = " + ex.getMessage());
//            sucesso = false;
//        } finally {
//            try {
//                con.close();
//                pst.close();
//            } catch (SQLException exc) {
//                System.out.println("Erro: " + exc.getMessage());
//            }
//        }
//        return sucesso;
//    }

//    //SELECT
//    public ArrayList<Pokemano_has_Pokedex> selectPokemano_has_Pokedex() {
//        ArrayList<Pokemano_has_Pokedex> pokemanoHasPokedexes = new ArrayList<>();
//        connectToDB();
//        String sql = "SELECT * FROM Pokemano_has_Pokedex";
//
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(sql);
//
//            System.out.println("Lista de Pokemanos na Pokedex: ");
//
//            while (rs.next()) {
//
//                Pokemano_has_Pokedex pokemano_has_Pokedex = new Pokedex(rs.getInt("id"), rs.getInt("treinador_ID"));
//
//                System.out.println("id = " + pokedexAux.getId());
//                System.out.println("treinador_ID = " + pokedexAux.getTreinador_ID());
//                System.out.println("--------------------------------");
//
//                pokedexs.add(pokedexAux);
//            }
//            sucesso = true;
//        } catch (SQLException e) {
//            System.out.println("Erro: " + e.getMessage());
//            sucesso = false;
//        } finally {
//            try {
//                con.close();
//                st.close();
//            } catch (SQLException e) {
//                System.out.println("Erro: " + e.getMessage());
//            }
//        }
//        return pokedexs;
    }
}

