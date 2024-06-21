package Model;

import DAO.*;

import java.util.Scanner;
import Model.*;

import static java.lang.Integer.parseInt;

public class Main {

    // Instanciando as classes
    private static Equipe equipe;
    private static Treinador treinador;
    private static Pokedex pokedex;
    private static Pokemano pokemano;
    private static Habilidade habilidade;
    private static Treinador nomeNovoTreinador;
    private static Treinador idEquipeSelecionada;

    private static EquipeDAO equipeDAO = new EquipeDAO();
    private static TreinadorDAO treinadorDAO = new TreinadorDAO();
    private static PokedexDAO pokedexDAO = new PokedexDAO();
    private static PokemanoDAO pokemanoDAO = new PokemanoDAO();
    private static HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
    private static Pokemano_has_PokedexDAO pokemano_has_pokedexDAO = new Pokemano_has_PokedexDAO();
    private static Pokemano_has_HabilidadeDAO pokemano_has_habilidadeDAO = new Pokemano_has_HabilidadeDAO();


    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        boolean running = true;

        while (running) {

            // Menu inicial
            System.out.println("---------- Bem vindo, ao menu! ----------");

            menu1();
            menu2();
            equipeSelecionada();


            // Menu 3
            System.out.println("Muito bem! Vc passou da etapa inicial! Agora vc pode escolher uma das opções abaixo!");
            System.out.println("\n");
            System.out.println("--------------------------\n");
            System.out.println(" 1. Adicionar um novo Pokemano");
            System.out.println(" 2. Atualizar o nivel de algum Pokemon");
            System.out.println(" 3. Mostrar todos os seus Pokemanos");
            System.out.println(" 4. Remover Pokemano");
            System.out.println(" 5. Sair");
            System.out.println("--------------------------\n");

            int userInput;
            if(scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine();
            } else {
                continue;
            }

            switch (userInput) {
                case 1:

                    break;a
                case 2:
                    atualizarNivelPokemano();
                    break;
                case 3:

                    break;
                case 4:
                    removerPokemano();
                    break;
                case 5:
                    running = sair();
                    break;

                default:
                    System.out.println("Opcao invalida.\n");
            }

        }
        scanner.close();
    }


    // MENUS
    private static void menu1() {
        System.out.println("-> Primeiro, vamos começar te cadastrando!");
        cadastroTreinador();
    }
    private static void menu2() {
        System.out.println("-> Segue abaixo, algumas equipes disponíveis para escolha: ");
        mostrarEquipes();
    }


    private static void cadastroTreinador() {
        System.out.print("-> Qual o seu nome?\n");
        String nomeNovoTreinador = scanner.nextLine();
        Treinador treinador = new Treinador(nomeNovoTreinador);
        treinadorDAO.insertTreinadorNovo(nomeNovoTreinador);
    }

    private static void mostrarEquipes (){
        equipeDAO.selectEquipe();
    }

    private static void equipeSelecionada (){
        System.out.println("-> Informe o ID da equipe que vc quer ingressar: ");
        int idEquipeSelecionada = scanner.nextInt();
        treinadorDAO.insertTreinadorEquipe(idEquipeSelecionada);
        adicionarPokemanoInicial();
    }

    private static void removerPokemano (){
        System.out.println("-> Segue abaixo, lista de pokemos disponíveis para selecao: \n");
        pokemanoDAO.selectPokemano();
        System.out.println("-> Informe o ID do pokemano que vc quer remover: ");
        int idPokemanoRemovido = scanner.nextInt();
        pokemanoDAO.deletePokemon(idPokemanoRemovido);
    }

    private static void adicionarPokemanoInicial(){
        System.out.println("-> Segue abaixo, lista de pokemos disponíveis para selecao:");
        pokemanoDAO.selectPokemano();
        System.out.println("-> Informe o ID do pokemano que vc quer adicionar na sua pokedex: ");
        int idPokemanoSelecionado = scanner.nextInt();
        pokemano_has_pokedexDAO.insertPokemano(idPokemanoSelecionado);
        System.out.println("-> Seu pokemano foi adicionado a sua pokedex!");
        System.out.println("--------------------------\n");
    }

    private static void atualizarNivelPokemano () {
        System.out.println("-> Segue abaixo, lista de pokemos disponíveis para selecao: \n");
        pokemanoDAO.selectPokemano();
        System.out.print("-> Digite o ID do pokemano que quer atualizar o nível: ");
        int idPokemano = scanner.nextInt();
        System.out.print("-> Novo nivel do pokemano: ");
        int nivelNovo = scanner.nextInt();
        pokemanoDAO.updateNivelPokemano(idPokemano,nivelNovo);
    }


    private static boolean sair() {
        while (true) {
            System.out.print("-> Ja vai? (sim/nao): ");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("sim") || resposta.equals("s")) {
                return false;
            } else if (resposta.equals("nao") || resposta.equals("n")) {
                System.out.println("Cancelado!\n");
                return true;
            }
        }
    }

}