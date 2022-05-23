package com.company;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    //Declarando ArrayLists
    ArrayList<Cliente> clienteLista = new ArrayList<>();
    ArrayList<Filme> filmeLista = new ArrayList<>();
    ArrayList<Integer> idAluguelLista = new ArrayList<>();
    ArrayList<String> AluguelClienteLista = new ArrayList<>();
    ArrayList<String> AluguelFilmeLista = new ArrayList<>();

    public void executar(){

        Scanner scan = new Scanner(System.in);

        //Variáveis
        int num;

        System.out.println("\n---------------------INICIO DO PROGRAMA--------------------\n");

        exibirMenu();

        do{

            System.out.println("==================== ESCOLHA SUA OPÇÃO ====================");
            System.out.print("\nDIGITE UM NÚMERO ENTRE 1 E 7 PARA UTILIZAR O MENU: ");
            num = scan.nextInt();

            switch (num) {
                case 1 -> realizarAluguel();
                case 2 -> clienteLista.add(Cliente.cadastrarCliente());
                case 3 -> Cliente.consultarCliente(clienteLista);
                case 4 -> filmeLista.add(Filme.cadastrarFilme());
                case 5 -> Filme.consultarFilme(filmeLista);
                case 6 -> pendencias();
                case 7 -> sair();
                default -> mensagemDefault();
            }

        }while(num != 7);

        System.out.println("--------------------PROGRAMA FINALIZADO--------------------");
    }

    public void exibirMenu(){

        System.out.println("-----------------------------------------------------------");
        System.out.println("| \t\t   [1] REALIZAR ALUGUEL                            |");
        System.out.println("| \t\t   [2] CADASTRAR CLIENTE                           |");
        System.out.println("| \t\t   [3] CONSULTAR CLIENTE                           |");
        System.out.println("| \t\t   [4] CADASTRAR FILME                             |");
        System.out.println("| \t\t   [5] CONSULTAR FILME                             |");
        System.out.println("| \t\t   [6] ALUGUEIS PENDENTES                          |");
        System.out.println("| \t\t   [7] SAIR                                        |");
        System.out.println("-----------------------------------------------------------\n");

    }

    public void realizarAluguel() {

        Scanner scan = new Scanner(System.in);

        int id = 0;
        String respCliente, respFilme, opcao;
        float valorTotal = 0;

        System.out.println("\nVOCÊ SELECIONOU: [1] REALIZAR ALUGUEL\n");



            id++;
            idAluguelLista.add(id);
            id = idAluguelLista.size();
            System.out.println("ID DO ALUGUEL: " + id);

            System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER O ALUGUEL: ");
            respCliente = scan.nextLine();
            for (Cliente umCliente : clienteLista) {
                if (respCliente.equals(umCliente.getCpf())) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("| NOME: " + umCliente.getNome());
                    System.out.println("| TELEFONE: " + umCliente.getTelefone());
                    System.out.println("| E-MAIL: " + umCliente.getEmail());
                    System.out.println("| CEP: " + umCliente.getCep());
                    System.out.println("-----------------------------------------------------------\n");
                    AluguelClienteLista.add(umCliente.getNome());
                }
            }

            do {

            System.out.print("INFORME A SEGUIR O TÍTULO DO FILME QUE DESEJA FAZER O ALUGUEL: ");
            respFilme = scan.nextLine();
            for (Filme umFilme : filmeLista) {
                if (respFilme.equals(umFilme.getTitulo())) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("| ID DO FILME: " + umFilme.getId());
                    System.out.println("| DIRETOR: " + umFilme.getDiretor());
                    System.out.println("| GÊNERO: " + umFilme.getGenero());
                    System.out.println("| CLASSIFICAÇÃO INDICATIVA: " + umFilme.getClassificacao());
                    System.out.println("| DURAÇÃO: " + umFilme.getDuracao() + " MINUTOS");
                    System.out.println("| UNIDADES DISPONÍVEIS: " + umFilme.getQuantidade());
                    System.out.println("| VALOR POR UNIDADE: R$ " + umFilme.getValor());
                    System.out.println("-----------------------------------------------------------\n");
                    AluguelFilmeLista.add(umFilme.getTitulo());
                    valorTotal += umFilme.getValor();
                }
            }

            System.out.print("DESEJA ALUGAR OUTRO FILME? DIGITE 'SIM' ou 'NAO': ");
            opcao = scan.nextLine();

            switch(opcao.toUpperCase(Locale.ROOT)) {
                case "SIM":
                case "NAO":
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA, SAINDO... ");
            }

        } while (opcao.equalsIgnoreCase("SIM"));

        System.out.println("VALOR TOTAL: " + valorTotal);
        System.out.println("--------------------MUITO OBRIGADO!--------------------");

    }

    public void pendencias() {
        System.out.println("\nVOCÊ SELECIONOU: [6] ALUGUEIS PENDENTES\n");
        for (int i = 0; i < AluguelClienteLista.size(); i++) {
            System.out.println("CLIENTE: " + AluguelClienteLista.get(i) + "\n FILME PENDENTE: " + AluguelFilmeLista.get(i));
        }
    }

    public void sair(){
        System.out.println("\nVOCÊ SELECIONOU: [7] SAIR\n");
    }

    public void mensagemDefault(){
        System.out.println("\n[ALERTA] VOCÊ DEVE SELECIONAR UM NÚMERO ENTRE 1 E 7 PARA UTILIZAR O MENU!\n");
    }
}
