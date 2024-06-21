package DAO;

import Model.Habilidade;
import java.sql.SQLException;
import java.util.ArrayList;


public class HabilidadeDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertHabilidade(Habilidade habilidade) {

        connectToDB();

        String sql = "INSERT INTO Habilidade (id, dano, nome, tipo_de_dano) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,habilidade.getId());
            pst.setInt(2, habilidade.getDano());
            pst.setString(3, habilidade.getNome());
            pst.setString(4, habilidade.getTipo_de_dano());
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
    public boolean deleteHabilidade(int id) {
        connectToDB();
        String sql = "DELETE FROM Habilidade where id=?";
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
    public ArrayList<Habilidade> selectHabilidade() {
        ArrayList<Habilidade> habilidades = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Habilidade";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Habilidades: ");

            while (rs.next()) {

                Habilidade habilidadeAux = new Habilidade(rs.getInt("id"), rs.getInt("dano"),  rs.getString("nome"),rs.getString("tipo_de_dano"));

                System.out.println("id = " + habilidadeAux.getId());
                System.out.println("nome = " + habilidadeAux.getDano());
                System.out.println("Tipo = " + habilidadeAux.getNome());
                System.out.println("Nivel = " + habilidadeAux.getTipo_de_dano());
                System.out.println("--------------------------------");

                habilidades.add(habilidadeAux);
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
        return habilidades;
    }
}
