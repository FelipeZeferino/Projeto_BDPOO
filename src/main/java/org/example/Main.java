package org.example;

import DAO.*;
import Model.Equipe;
import Model.Treinador;
import org.example.Classes.Habilidade;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Equipe equipe1 = new Equipe(1,'Equipe1');
        Equipe equipeA = new Equipe(1,"equipeA");
        Equipe equipeTeste = new Equipe(51, "EquipeTeste");
        EquipeDAO equipeDAO = new EquipeDAO();
        PokedexDAO pokedexDAO = new PokedexDAO();
        TreinadorDAO treinadorDAO = new TreinadorDAO();
        PokemanoDAO pokemanoDAO = new PokemanoDAO();
        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();

        Scanner scanner = new Scanner(System.in);
        int entrada;

//        do {
//            System.out.println("-----Menu-----");
//            System.out.println("Digite 1 para listar pokemons.");
//            System.out.println("Digite 2 para inserir novo pokemon.");
//            System.out.println("Digite 3 para deletar pokemon");
//            System.out.println("Digite 4 para listar treinadores");
//            entrada = scanner.nextInt();

//            switch(entrada){
//                case 1:
//                    pokemanoDAO.
//
//            }
//
//
//        }while(entrada != 0);


            //EquipeDAO - TESTADO
            //equipeDAO.insertEquipe(equipeTeste);

            //HabilidadeDAO - TESTADO
        Habilidade habilidade = new Habilidade(1, 50, "Fireball", "Fogo");
        habilidadeDAO.selectHabilidade();
        habilidadeDAO.insertHabilidade(habilidade);
        habilidadeDAO.selectHabilidade();
        habilidadeDAO.deleteHabilidade(1);
        habilidadeDAO.selectHabilidade();


            //PokemonDAO - TESTADO
//            Pokemon pokemonteste = new Pokemon(1, "Teste" ,"Fogo", 12);
//            pokemanoDAO.selectPokemon();
//            pokemanoDAO.insertPokemano(pokemonteste);
//            pokemanoDAO.selectPokemon();
//            pokemanoDAO.deletePokemon(1);
//            pokemanoDAO.selectPokemon();


            //TreinadorDAO - TESTADO
//        Treinador treinador = new Treinador(1, "Felipe", 2);
//        treinadorDAO.selectTreinador();
//        treinadorDAO.insertTreinador(treinador);
//        treinadorDAO.selectTreinador();
//        treinadorDAO.deleteTreinador(1);
//        treinadorDAO.selectTreinador();

//
//        System.out.println("-----Menu-----");
//        System.out.println();

//        System.out.println("Mostrando Equipes Pré-Preenchidas:");
//        System.out.println();
//        equipeDAO.selectEquipe();
//        System.out.println();
//
//        System.out.println("Inserindo uma equipe nova:");
//        equipeDAO.insertEquipe(equipeA);
//        System.out.println();
//        System.out.println("Mostrando tabela após inserir nova equipe:");
//        equipeDAO.selectEquipe();
//        System.out.println();
//
//        System.out.println("Deletando uma equipe:");
//        equipeDAO.deleteEquipe(1);
//        System.out.println();
//        System.out.println("Mostrando tabela após deletar uma equipe");
//        equipeDAO.selectEquipe();
//        System.out.println();
//
//        System.out.println("Atualizando nome de uma equipe:");
//        equipeDAO.updateEquipeNome(3, "EquipeAtualizada");
//        System.out.println();
//        System.out.println("Mostrando tabela após atualizar nome de uma equipe");
//        equipeDAO.selectEquipe();
//        System.out.println();
//    }

}}