package DAO;

import Model.Equipe;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipeDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

//    //INSERT
//    public boolean insertAluno(Equipe equipe) {
//
//        connectToDB();
//
//        String sql = "INSERT INTO Alunos (matricula, nome, idade, cidade) values(?,?,?,?)";
//        try {
//            pst = con.prepareStatement(sql);
//            pst.setInt(1,aluno.getMatricula());
//            pst.setString(2, aluno.getNome());
//            pst.setInt(3, aluno.getIdade());
//            pst.setString(4, aluno.getCidade());
//            pst.execute();
//            sucesso = true;
//        } catch (SQLException exc) {
//            System.out.println("Erro: " + exc.getMessage());
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
//
//    //UPDATE
//    public boolean updateAlunoNome(int matricula, String nome) {
//        connectToDB();
//        String sql = "UPDATE Alunos SET nome=? where matricula=?";
//        try {
//            pst = con.prepareStatement(sql);
//            pst.setString(1, nome);
//            pst.setInt(2, matricula);
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
//
//    //DELETE
//    public boolean deleteAluno(int matricula) {
//        connectToDB();
//        String sql = "DELETE FROM Alunos where matricula=?";
//        try {
//            pst = con.prepareStatement(sql);
//            pst.setInt(1, matricula);
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

    //SELECT
    public ArrayList<Equipe> selectEquipe() {
        ArrayList<Equipe> equipes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Equipe";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de equipes: ");

            while (rs.next()) {

                Equipe equipeAux = new Equipe(rs.getInt("id"), rs.getString("nome"));

                System.out.println("id = " + equipeAux.getId());
                System.out.println("nome = " + equipeAux.getNome());
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

