package DAO;

import Model.Pokedex;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokedexDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokedex(Pokedex pokedex) {

        connectToDB();

        String sql = "INSERT INTO Pokedex (id, treinador_ID) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,pokedex.getId());
            pst.setInt(2, pokedex.getTreinador_ID());
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
    public boolean deletePokedex(int id) {
        connectToDB();
        String sql = "DELETE FROM Pokedex where id=?";
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

    //SELECT
    public ArrayList<Pokedex> selectPokedex() {
        ArrayList<Pokedex> pokedexs = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokedex";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Pokedex: ");

            while (rs.next()) {

                Pokedex pokedexAux = new Pokedex(rs.getInt("id"), rs.getInt("treinador_ID"));

                System.out.println("ID = " + pokedexAux.getId());
                System.out.println("Treinador_ID = " + pokedexAux.getTreinador_ID());
                System.out.println("--------------------------------");

                pokedexs.add(pokedexAux);
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
        return pokedexs;
    }
}

