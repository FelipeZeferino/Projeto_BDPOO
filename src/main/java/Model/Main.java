package Model;

import DAO.*;

import java.util.Scanner;
import Model.*;

import static java.lang.Integer.parseInt;

public class Main {


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


        treinadorDAO.deleteTreinador(1);

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
        Treinador treinador = new Treinador(1,nomeNovoTreinador, idEquipeSelecionada);

        treinadorDAO.insertTreinador(treinador);
        Pokedex pokedex1 = new Pokedex(treinador.getId());
        pokedexDAO.insertPokedex(pokedex1);

        //Selecao primeiro pokemon
        System.out.println("-> Segue abaixo lista de pokemons disponíveis para seleção:");
        pokemanoDAO.selectPokemano();
        System.out.println("-> Informe o ID do pokemon que você quer adicionar na sua pokedex: ");
        int idPokemanoSelecionado = scanner.nextInt();
        pokemano_has_pokedexDAO.insertPokemano(idPokemanoSelecionado);
        System.out.println("-> Seu pokemano foi adicionado a sua pokedex!");
        System.out.println("--------------------------\n");
        pokedexDAO.selectPokedex();
        pokemano_has_pokedexDAO.selectPokemano_has_Pokedex(1);

        System.out.println("Muito bem! Você passou da etapa inicial! Agora você pode escolher uma das opções abaixo!");
        System.out.println("\n");

        while (running) {


            // Menu 3
            System.out.println("--------------------------\n");
            System.out.println(" 1. Adicionar um novo Pokemon ao banco de Pokemons");
            System.out.println(" 2. Adicionar um novo Pokemon a sua Pokedex");
            System.out.println(" 3. Remover Pokemon da Pokedex");
            System.out.println(" 4. Mostrar todos os Pokemons da sua Pokedex");
            System.out.println(" 5. Atualizar o nivel de algum Pokemon");
            System.out.println(" 6. Criar uma nova habilidade");
            System.out.println(" 7. Adicionar uma habilidade a algum Pokemon");
            System.out.println(" 8. Para alterar seu nome de treinador");
            System.out.println(" 9. Sair");
            System.out.println("--------------------------\n");


            int userInput = scanner.nextInt();
            scanner.nextLine();

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
                    pokemanoDAO.insertPokemano(NewPokemon);

                    break;
                case 2:
                    System.out.println("-> Segue abaixo, lista de pokemons disponíveis para selecao: \n");
                    pokemanoDAO.selectPokemano();
                    System.out.print("-> Digite o ID do pokemano que deseja adicionar a Pokedex: ");
                    int idPokemano = scanner.nextInt();
                    pokemano_has_pokedexDAO.insertPokemano(idPokemano);

                    break;
                case 3:
                    System.out.println("-> Informe o ID do pokemano que vc quer remover: ");
                    pokemano_has_pokedexDAO.selectPokemano_has_Pokedex();
                    int idPokemanoRemovido = scanner.nextInt();
                    pokemano_has_pokedexDAO.deletePokemon(idPokemanoRemovido);
                    break;
                case 4:
                    System.out.println("listar todos os pokemons da pokedex");
                    pokedexDAO.selectAllPokemons();
                    break;
                case 5:
                    System.out.println("-> Segue abaixo, lista de pokemons disponíveis para selecao: \n");
                    pokemanoDAO.selectPokemano();
                    System.out.print("-> Digite o ID do pokemano que deseja alterar o nivel: ");
                    int ChosenId = scanner.nextInt();
                    System.out.print("-> Novo nivel do pokemano: ");
                    int nivelNovo = scanner.nextInt();
                    pokemanoDAO.updateNivelPokemano(nivelNovo,ChosenId);
                    break;
                case 6:
                    System.out.println("Criar habilidade");
                    System.out.println("Entre com o nome da habilidade:");
                    String SkillName = scanner.nextLine();
                    System.out.println("Entre com o tipo da habilidade:");
                    String SkillType = scanner.nextLine();
                    System.out.println("Entre com o dano da habilidade:");
                    int SkillDmg = scanner.nextInt();
                    System.out.println("Entre com o id da habilidade:");
                    int NewSkillID = scanner.nextInt();
                    Habilidade habilidade = new Habilidade(NewSkillID,SkillDmg,SkillName,SkillType);
                    habilidadeDAO.insertHabilidade(habilidade);
                    System.out.println("Habilidade Criada!");
                    break;
                case 7:
                    System.out.println("Adicionar habilidade a algum pokemon");
                    System.out.println("Lista de Habilidades disponiveis");
                    habilidadeDAO.selectHabilidade();
                    System.out.println("-> Digite o ID da habilidade que deseja adicionar");
                    int SkillID = scanner.nextInt();
                    System.out.println("Lista de Pokemons disponiveis");
                    pokemanoDAO.selectPokemano();
                    System.out.println("A qual pokemon deseja adicionar?");
                    int choice = scanner.nextInt();
                    Pokemano_has_Habilidade PokemonSkill = new Pokemano_has_Habilidade(choice, SkillID);
                    pokemano_has_habilidadeDAO.insertPokemano_has_Habilidade(PokemonSkill);
                    break;
                case 8:
                    System.out.println("Alterar Nome de treinador:");
                    System.out.println("Digite seu novo nome de treinador!");
                    String newName = scanner.nextLine();
                    treinador.setNome(newName);
                    treinadorDAO.updateTreinadorNome(treinador.getId(), newName);
                    break;
                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }

        }
        scanner.close();
    }
}
