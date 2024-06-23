package DAO;


import Model.Pokemano;
import java.sql.SQLException;
import java.util.ArrayList;


public class PokemanoDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokemano(Pokemano pokemano) {

        connectToDB();

        String sql = "INSERT INTO Pokemano (id, nome, tipo, nivel) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,pokemano.getId());
            pst.setString(2, pokemano.getNome());
            pst.setString(3, pokemano.getTipo());
            pst.setInt(4, pokemano.getNivel());
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

    public boolean updateNivelPokemano(int idPokemano, int nivelNovo) {
        connectToDB();
        String sql = "UPDATE Pokemano SET nivel=? where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idPokemano);
            pst.setInt(2, nivelNovo);
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
    public ArrayList<Pokemano> selectPokemano() {
        ArrayList<Pokemano> pokemanos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemano";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("--------------------------------");
            System.out.println("Lista de Pokemanos: ");
            System.out.println("--------------------------\n");

            while (rs.next()) {

                Pokemano pokemanoAux = new Pokemano(rs.getInt("id"), rs.getString("nome"),  rs.getString("tipo"),rs.getInt("nivel"));

                System.out.println("ID do Pokemano: " + pokemanoAux.getId());
                System.out.println("Nome do Pokemano: " + pokemanoAux.getNome());
                System.out.println("Tipo do Pokemano: " + pokemanoAux.getTipo());
                System.out.println("Nivel do Pokemano: " + pokemanoAux.getNivel());
                System.out.println("--------------------------------");

                pokemanos.add(pokemanoAux);
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
        return pokemanos;
    }
}
