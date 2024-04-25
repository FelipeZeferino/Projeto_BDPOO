package org.example;

import DAO.EquipeDAO;
import Model.Equipe;

public class Main {
    public static void main(String[] args) {

        //Equipe equipe1 = new Equipe(1,'Equipe1');
        EquipeDAO equipeDAO = new EquipeDAO();

        equipeDAO.selectEquipe();
    }
}