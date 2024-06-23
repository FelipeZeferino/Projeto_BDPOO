package Model;

import DAO.*;

import java.util.Scanner;
import Model.*;

import static java.lang.Integer.parseInt;

public class Main {

    // Instanciando as classes
//    private static Equipe equipe;
//    private static Treinador treinador;
//    private static Pokedex pokedex;
//    private static Pokemano pokemano;
//    private static Habilidade habilidade;
//    private static Treinador nomeNovoTreinador;
//    private static Treinador idEquipeSelecionada;

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


//        Pokemano squirtle = new Pokemano(1,"Squirtle", "Água", 1);
//        Pokemano charmander = new Pokemano(2,"Charmander", "Fogo", 1);
//        Pokemano bulbasaur = new Pokemano(3,"Bulbasaur", "Planta", 1);
        treinadorDAO.deleteTreinador(1);
        treinadorDAO.selectTreinador();
        pokedexDAO.selectPokedex();
        pokemano_has_pokedexDAO.selectPokemano_has_Pokedex();
        pokemanoDAO.selectPokemano();
//        Treinador.id++;
        // Menu inicial
        System.out.println("---------- Bem-vindo ao menu! ----------");

        //Cadastro Treinador e Pokedex
        System.out.println("-> Primeiro, vamos começar te cadastrando!");
        System.out.print("-> Qual o seu nome?\n");
        String nomeNovoTreinador = scanner.nextLine();
        System.out.println("-> Segue abaixo, algumas equipes disponíveis para escolha: ");
        equipeDAO.selectEquipe();
        System.out.println("-> Informe o ID da equipe que vc quer ingressar: ");
        int idEquipeSelecionada = scanner.nextInt();
        Treinador treinador = new Treinador(Treinador.id, nomeNovoTreinador, idEquipeSelecionada);

        treinadorDAO.insertTreinador(treinador);
        Pokedex pokedex1 = new Pokedex(treinador.getId(), treinador.getId()); //pokedex do treinador cadastrado tem o mesmo id dele
        pokedexDAO.insertPokedex(pokedex1);
        Treinador.id++; //Ao cadastrar o primeiro treinador ele acrescenta ao contador Treinador que é static e não depende de instancias do objeto
        System.out.println("O id da sua Pokedex é: " + pokedex1.getId());

        //Selecao primeiro pokemon
        System.out.println("-> Segue abaixo lista de pokemons disponíveis para seleção:");
        pokemanoDAO.selectPokemano();
        System.out.println("-> Informe o ID do pokemon que você quer adicionar na sua pokedex: ");
        int idPokemanoSelecionado = scanner.nextInt();
        Pokemano_has_Pokedex pk1 = new Pokemano_has_Pokedex(pokedex1.getId(), idPokemanoSelecionado);
        pokemano_has_pokedexDAO.insertPokemano_has_Pokedex(pk1);
        System.out.println("-> Seu pokemano foi adicionado a sua pokedex!");
        System.out.println("--------------------------\n");
        pokedexDAO.selectPokedex();
        pokemano_has_pokedexDAO.selectPokemano_has_Pokedex(1);

        System.out.println("Muito bem! Você passou da etapa inicial! Agora você pode escolher uma das opções abaixo!");
        System.out.println("\n");

        while (running) {


            // Menu 3
            System.out.println("--------------------------\n");
            System.out.println(" 1. Adicionar um novo Pokemano");
            System.out.println(" 2. Atualizar o nivel de algum Pokemon");
            System.out.println(" 3. Mostrar todos os seus Pokemanos");
            System.out.println(" 4. Remover Pokemano");
            System.out.println(" 5. Sair");
            System.out.println("--------------------------\n");


            int userInput;
            userInput = scanner.nextInt();
            //scanner.nextLine();

            switch (userInput) {
                case 1:
                    System.out.println("Entre com o id do Pokemon:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entre com o nome do Pokemon:");
                    String nome = scanner.nextLine();
                    System.out.println("Entre com o tipo do Pokemon:");
                    String tipo = scanner.nextLine();
                    System.out.println("Entre com o nível do Pokemon:");
                    int nivel = scanner.nextInt();

                    Pokemano NewPokemon = new Pokemano(id,nome,tipo,nivel);
                    pokemano_has_pokedexDAO.insertPokemano(id);
                    break;
                case 2:
                    System.out.println("-> Segue abaixo, lista de pokemons disponíveis para selecao: \n");
                    pokemanoDAO.selectPokemano();
                    System.out.print("-> Digite o ID do pokemano que quer atualizar o nível: ");
                    int idPokemano = scanner.nextInt();
                    System.out.print("-> Novo nivel do pokemano: ");
                    int nivelNovo = scanner.nextInt();
                    pokemanoDAO.updateNivelPokemano(idPokemano,nivelNovo);
                    break;
                case 3:
                    pokemano_has_pokedexDAO.selectPokemano_has_Pokedex();
                    break;
                case 4:
                    System.out.println("-> Segue abaixo, lista de pokemons disponíveis para selecao: \n");
                    pokemanoDAO.selectPokemano();
                    System.out.println("-> Informe o ID do pokemano que vc quer remover: ");
                    int idPokemanoRemovido = scanner.nextInt();
                    pokemanoDAO.deletePokemon(idPokemanoRemovido);
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }

        }
        scanner.close();
    }



//    private static boolean sair() {
//        while (true) {
//            System.out.print("-> Ja vai? (sim/nao): ");
//            String resposta = scanner.nextLine().toLowerCase();
//
//            if (resposta.equals("sim") || resposta.equals("s")) {
//                return false;
//            } else if (resposta.equals("nao") || resposta.equals("n")) {
//                System.out.println("Cancelado!\n");
//                return true;
//            }
//        }
//    }

}