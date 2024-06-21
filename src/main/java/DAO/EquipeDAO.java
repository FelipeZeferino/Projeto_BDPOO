package DAO;

import Model.Equipe;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipeDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertEquipe(Equipe equipe) {

        connectToDB();

        String sql = "INSERT INTO Equipe (id, nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,equipe.getId());
            pst.setString(2, equipe.getNome());
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
    public boolean updateEquipeNome(int id, String nome) {
        connectToDB();
        String sql = "UPDATE Equipe SET nome=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2,id);
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
    public boolean deleteEquipe(int id) {
        connectToDB();
        String sql = "DELETE FROM Equipe where id=?";
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
    public ArrayList<Equipe> selectEquipe() {
        ArrayList<Equipe> equipes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Equipe";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Equipes: ");

            while (rs.next()) {

                Equipe equipeAux = new Equipe(rs.getInt("id"), rs.getString("nome"));

                System.out.println("--------------------------------");
                System.out.println("ID Equipe: " + equipeAux.getId());
                System.out.println("Nome Equipe: " + equipeAux.getNome());
                System.out.println("--------------------------------");

                equipes.add(equipeAux);
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
        return equipes;
    }
}

