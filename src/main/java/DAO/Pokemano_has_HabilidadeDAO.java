package DAO;

import Model.Pokemano_has_Habilidade;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pokemano_has_HabilidadeDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertPokemano_has_Habilidade(Pokemano_has_Habilidade pokemano_has_habilidade) {

        connectToDB();

        String sql = "INSERT INTO Pokemano_has_Pokedex (pokemano_ID, habilidade_ID) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,pokemano_has_habilidade.getPokemano_ID());
            pst.setInt(2, pokemano_has_habilidade.getHabilidade_ID());
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
    public ArrayList<Pokemano_has_Habilidade> selectPokemano_has_Pokedex() {
        ArrayList<Pokemano_has_Habilidade> pokemanoHasHabilidade = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pokemano_has_Habilidade";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("--------------------------------");
            System.out.println("Lista de Habilidades do Pokemon: ");

            while (rs.next()) {

                Pokemano_has_Habilidade habilidadeAux = new Pokemano_has_Habilidade(rs.getInt("id"), rs.getInt("treinador_ID"));

                System.out.println("ID dos Pokemons da Pokedex:  " + habilidadeAux.getPokemano_ID());
                System.out.println("ID da pokedex: " + habilidadeAux.getHabilidade_ID());
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
        return pokemanoHasHabilidade;
    }

}
