package org.example;

import DAO.EquipeDAO;
import Model.Equipe;

public class Main {
    public static void main(String[] args) {

        //Equipe equipe1 = new Equipe(1,'Equipe1');
        Equipe equipeA = new Equipe("equipeA");
        EquipeDAO equipeDAO = new EquipeDAO();


        System.out.println("-----Menu-----");
        System.out.println();

        System.out.println("Mostrando Equipes Pré-Preenchidas:");
        System.out.println();
        equipeDAO.selectEquipe();
        System.out.println();

        System.out.println("Inserindo uma equipe nova:");
        equipeDAO.insertEquipe(equipeA);
        System.out.println();
        System.out.println("Mostrando tabela após inserir nova equipe:");
        equipeDAO.selectEquipe();
        System.out.println();

        System.out.println("Deletando uma equipe:");
        equipeDAO.deleteEquipe(1);
        System.out.println();
        System.out.println("Mostrando tabela após deletar uma equipe");
        equipeDAO.selectEquipe();
        System.out.println();

        System.out.println("Atualizando nome de uma equipe:");
        equipeDAO.updateEquipeNome(3, "EquipeAtualizada");
        System.out.println();
        System.out.println("Mostrando tabela após atualizar nome de uma equipe");
        equipeDAO.selectEquipe();
        System.out.println();
    }

}