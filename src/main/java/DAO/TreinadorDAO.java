package DAO;

import Model.Treinador;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreinadorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertTreinador(Treinador treinador) {

        connectToDB();

        String sql = "INSERT INTO Treinador (id, nome, equipe_ID) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,treinador.getId());
            pst.setString(2, treinador.getNome());
            pst.setInt(3, treinador.getEquipe_ID());
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

    //UPDATE
    public boolean updateTreinadorNome(int id, String nome) {
        connectToDB();
        String sql = "UPDATE Treinador SET nome=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
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

    //DELETE
    public boolean deleteTreinador(int id) {
        connectToDB();
        String sql = "DELETE FROM Treinador where id=?";
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
    public ArrayList<Treinador> selectTreinador() {
        ArrayList<Treinador> treinadores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Treinador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de treinadores: ");

            while (rs.next()) {

                Treinador treinadorAux = new Treinador(rs.getInt("id"), rs.getString("nome"),rs.getInt("Equipe_ID"));

                System.out.println("id = " + treinadorAux.getId());
                System.out.println("nome = " + treinadorAux.getNome());
                System.out.println("treinador ID = " + treinadorAux.getEquipe_ID());
                System.out.println("--------------------------------");

                treinadores.add(treinadorAux);
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
        return treinadores;
    }
}

