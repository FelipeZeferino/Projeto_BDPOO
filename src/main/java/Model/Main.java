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

            // Menu 1
            System.out.println("\n");
            System.out.println("---------- Bem vindo, ao menu! ----------\n");

            System.out.println("-> Iniciando Cadastro do Primeiro Treinador:\n");

            cadastroTreinador();



            // Menu 2
            System.out.println("--------------------------------");
            System.out.println("Muito bem! Você passou da etapa inicial! Agora você pode escolher uma das opções abaixo!");
            System.out.println("--------------------------------");
            System.out.println(" 1. Adicionar um novo Treinador");
            System.out.println(" 2. Atualizar o nivel de algum Pokemon");
            System.out.println(" 3. Mostrar todos os seus Pokemanos");
            System.out.println(" 4. Remover Pokemano");
            System.out.println(" 5. Sair");
            System.out.println("--------------------------------");

            int userInput;
            if(scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine();
            } else {
                continue;
            }

            switch (userInput) {
                case 1:
                    cadastroTreinador();
                    break;
                case 2:
                    atualizarNivelPokemano();
                    break;
                case 3:
                    pokemano_has_pokedexDAO.selectPokemano_has_Pokedex();
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





    private static void cadastroTreinador() {
        System.out.print("-> Qual o nome do Treinador?\n");
        String nomeNovoTreinador = scanner.nextLine();


        System.out.println("\n-> Segue abaixo, algumas equipes disponíveis para escolha: ");
        equipeDAO.selectEquipe();
        System.out.println("\n--------------------------------");

        System.out.println("-> Informe o ID da equipe que vc quer ingressar:\n");
        int idEquipeSelecionada = scanner.nextInt();

        Treinador treinador = new Treinador(nomeNovoTreinador, idEquipeSelecionada);
        treinadorDAO.insertTreinador(treinador);

//        System.out.println("--------------------------------");
//        System.out.println("-> Segue abaixo, informações Treinador:");
//        treinadorDAO.selectTreinador();
//        System.out.println("\n--------------------------------");

        Pokedex pokedex1 = new Pokedex(treinador.getId());
        pokedexDAO.insertPokedex(pokedex1);
       // System.out.println("O id da sua Pokedex é: " + pokedex1.getId());

//        pokedexDAO.selectPokedex();
//        System.out.println("\n--------------------------------");
        pokemanoDAO.selectPokemano();
        System.out.println("\n--------------------------------");

        System.out.println("-> Informe o ID do pokemano que vc quer adicionar na sua pokedex: \n");
        int idPokemanoSelecionado = scanner.nextInt();


        pokedexDAO.selectPokedex();
        System.out.println("\n--------------------------------");

        System.out.println("Informe o ID da pokedex que vc quer inserir o pokemon novo:");
        int idPokedex = scanner.nextInt();


        Pokemano_has_Pokedex pokemano_has_pokedex = new Pokemano_has_Pokedex(idPokemanoSelecionado,idPokedex);
        pokemano_has_pokedexDAO.insertPokemano_has_Pokedex(pokemano_has_pokedex);


        System.out.println("--------------------------------");
        System.out.println("-> Seu pokemano foi adicionado a sua pokedex!");
        System.out.println("--------------------------------");

        pokedexDAO.selectPokedex();
        System.out.println("\n--------------------------------");
        pokemano_has_pokedexDAO.selectPokemano_has_Pokedex();
        System.out.println("\n--------------------------------");


    }

    private static void removerPokemano (){
        System.out.println("-> Segue abaixo, lista de pokemos disponíveis para selecao: \n");
        pokemanoDAO.selectPokemano();
        System.out.println("-> Informe o ID do pokemano que vc quer remover: ");
        int idPokemanoRemovido = scanner.nextInt();
        pokemanoDAO.deletePokemon(idPokemanoRemovido);
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