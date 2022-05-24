package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    //Declarando os ArrayLists que irão receber os Objetos da classe Cliente e Filme respectivamente
    ArrayList<Cliente> clienteLista = new ArrayList<>();
    ArrayList<Filme> filmeLista = new ArrayList<>();

    //Declarando os ArrayLists que irão receber o ID de cada aluguel em Integer, o cpf do Cliente que fez o aluguel em String e o título do filme alugado em String
    ArrayList<Integer> idAluguelLista = new ArrayList<>();
    ArrayList<String> AluguelClienteLista = new ArrayList<>();
    ArrayList<String> AluguelFilmeLista = new ArrayList<>();

    public void executar(){

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando a variável para registrar a escolha do Menu
        int escolha;

        System.out.println("\n---------------------INICIO DO PROGRAMA--------------------\n");

        //Cadastro automático de 7 ou mais objetos, como foi instruído no edital
        clienteLista.add(new Cliente("João Lantyer", "00000000000", "000000000", "joaolantyer@email.com", "00000-000"));
        clienteLista.add(new Cliente("Renan Abreu", "11111111111", "111111111", "renanabreu@email.com", "11111-111"));
        clienteLista.add(new Cliente("João Alfredo", "22222222222", "222222222", "joaoalfredo@email.com", "22222-222"));
        clienteLista.add(new Cliente("Aldair Lima", "33333333333", "333333333", "aldairlima@email.com", "33333-333"));
        clienteLista.add(new Cliente("Leoni Mascarenhas", "444444444444", "444444444", "leonimascarenhasu@email.com", "44444-444"));
        filmeLista.add(new Filme(1, "Batman: O Cavaleiro das Trevas", "Christopher Nolan", "Ação", "12 anos", 152, 5, 7.90f));
        filmeLista.add(new Filme(2, "Um Sonho de Liberdade", "Frank Darabont", "Drama", "16 anos", 142, 5, 5.90f));
        filmeLista.add(new Filme(3, "O Poderoso Chefão", "Francis Ford Coppola", "Crime", "14 anos", 175, 5, 6.50f));

        //Adicionando 3 elementos no ArrayList idFilmeLista baseado no que foi feito acima, para que, ao ser cadastrado um novo filme, o id ja comece do 4, já que ele incrementa em 1 e ele é atribuído do tamanho de idFilmeLista
        Filme.idFilmeLista.add(1);
        Filme.idFilmeLista.add(2);
        Filme.idFilmeLista.add(3);

        //Criando uma estrutura de repetição "do while" para que o Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 7(sair)
        do{
            //Executando o método que irá imprimir o Menu
            exibirMenu();

            System.out.println("==================== ESCOLHA SUA OPÇÃO ====================");
            System.out.print("\nDIGITE UM NÚMERO ENTRE 1 E 7 PARA UTILIZAR O MENU: ");

            //Atribuindo o valor da variável "escolha" ao que for digitado no teclado do usuário
            escolha = scan.nextInt();

            //Criando uma estrutura de decisão "switch case" que terá a variável "num" como a variável de controle e selecionará uma das 8 opções dependendo do que o usuário digitou
            switch (escolha) {
                //Caso o usuário tenha digitado 1, será executado o método realizarAluguel()
                case 1 -> realizarAluguel();

                //Caso o usuário tenha digitado 2, será executado o método da classe cliente cadastrarCliente() e o retorno deste será adicionado ao ArrayList clienteLista
                case 2 -> clienteLista.add(Cliente.cadastrarCliente());

                //Caso o usuário tenha digitado 3, será executado o método da classe cliente consultarCliente() no ArrayList clienteLista
                case 3 -> Cliente.consultarCliente(clienteLista);

                //Caso o usuário tenha digitado 4, será executado o método da classe Filme cadastrarFilme() e o retorno deste será adicionado ao ArrayList filmeLista
                case 4 -> filmeLista.add(Filme.cadastrarFilme());

                //Caso o usuário tenha digitado 5, será executado o método da classe Filme consultarFilme() no ArrayList filmeLista
                case 5 -> Filme.consultarFilme(filmeLista);

                //Caso o usuário tenha digitado 6, será executado o método pendencias()
                case 6 -> pendencias();

                //Caso o usuário tenha digitado 7, será executado o método sair()
                case 7 -> sair();

                //Caso o usuário tenha digitado qualquer outra coisa, será executado o método mensagemDefault()
                default -> mensagemDefault();
            }

        }while(escolha != 7);

        System.out.println("--------------------PROGRAMA FINALIZADO--------------------");
    }

    //Criando um método para imprimir o Menu
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

    //Criando um método para exibir os detalhes do Cliente que realizará o Aluguel e o Filme que será alugado,e guarde estes em suas respectivas ArrayLists
    public void realizarAluguel() {

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis
        int id = 0;
        String respCliente, respFilme, opcao;
        float valorTotal = 0;
        int menos = -1;

        System.out.println("\nVOCÊ SELECIONOU: [1] REALIZAR ALUGUEL\n");

        //Incrementando o id do aluguel, toda vez que o método realizarAluguel for chamado (o id recebe seu valor por meio do tamanho do ArrayList idAluguelLista)
        id++;
        idAluguelLista.add(id);
        id = idAluguelLista.size();
        System.out.println("ID DO ALUGUEL: " + id);

        //Atribuíndo o cpf do Cliente que irá fazer aluguel numa variável, para que se busque na lista clienteLista um Cliente com o mesmo cpf, e se achar, irá imprimir o resto dos seus dados
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
            }


        }

        //Criando uma estrutura de repetição "do while" para repetir esta porção do código, toda vez que o usuário escolher que quer fazer o aluguel de um filme adicional
        do {

            /*Atribuindo o título do Filme que será alugado numa variável, para que busque na lista filmeLista um Filme com o mesmo título,
            e se achar, juntamente com o fato de ter mais de 0 unidades, irá imprimir o resto dos dados do mesmo */
            System.out.print("INFORME A SEGUIR O TÍTULO DO FILME QUE DESEJA FAZER O ALUGUEL: ");
            respFilme = scan.nextLine();
            for (Filme umFilme : filmeLista) {
                if (respFilme.equalsIgnoreCase(umFilme.getTitulo())) {
                    if(umFilme.getQuantidade() > 0) {
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("| ID DO FILME: " + umFilme.getId());
                        System.out.println("| DIRETOR: " + umFilme.getDiretor());
                        System.out.println("| GÊNERO: " + umFilme.getGenero());
                        System.out.println("| CLASSIFICAÇÃO INDICATIVA: " + umFilme.getClassificacao());
                        System.out.println("| DURAÇÃO: " + umFilme.getDuracao() + " MINUTOS");
                        System.out.println("| UNIDADES DISPONÍVEIS APÓS O ALUGUEL: " + (umFilme.getQuantidade() + menos));
                        umFilme.setQuantidade(umFilme.getQuantidade() + menos);
                        System.out.println("| VALOR POR UNIDADE: R$ " + umFilme.getValor());
                        System.out.println("-----------------------------------------------------------\n");

                        /*Adicionalmente, ao achar o Filme e o mesmo possui mais que 0 unidades disponíveis, o mesmo é adicionado ao
                        ArrayList AluguelFilmeLista, assim como o nome do Cliente será adicionado no ArrayList AluguelClienteLista */
                        AluguelFilmeLista.add(umFilme.getTitulo());

                        for (Cliente umCliente : clienteLista) {
                            if (respCliente.equals(umCliente.getCpf())) {
                                AluguelClienteLista.add(umCliente.getNome());
                            }
                        }
                        //Atribuindo e somando o valor do Filme alugado ao valorTotal, toda vez que essa operação é repetida, para recebermos o valor total da transação
                        valorTotal += umFilme.getValor();
                    }
                }
            }

            System.out.print("DESEJA ALUGAR OUTRO FILME? DIGITE 'SIM' OU 'NAO': ");
            opcao = scan.nextLine();

        }while (opcao.equalsIgnoreCase("SIM"));

        if (opcao.equalsIgnoreCase("NAO")) {
            System.out.println("SAINDO...");
        } else {
            System.out.println("OPÇÃO INVÁLIDA, SAINDO... ");
        }

        System.out.println("VALOR TOTAL: " + valorTotal);
        System.out.println("--------------------MUITO OBRIGADO!--------------------");

    }

    //Criando um método para checar quais objetos foram alugados, imprimindo o nome do cliente que fez o aluguel e o título do filme alugado
    public void pendencias() {
        System.out.println("\nVOCÊ SELECIONOU: [6] ALUGUEIS PENDENTES\n");
        for (int i = 0; i < AluguelClienteLista.size(); i++) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|CLIENTE: " + AluguelClienteLista.get(i));
            System.out.println("|FILME(S) PENDENTE(S): " + AluguelFilmeLista.get(i));
            System.out.println("-----------------------------------------------------------\n");
        }
    }
    //Criando um método para imprimir uma mensagem de saída, quando o usuário escolher 7
    public void sair(){
        System.out.println("\nVOCÊ SELECIONOU: [7] SAIR\n");
    }

    //Criando um método que imprima uma mensagem "default", ou seja, irá aparecer quando o usuário digitar qualquer coisa que não seja de 1 a 7
    public void mensagemDefault(){
        System.out.println("\n[ALERTA] VOCÊ DEVE SELECIONAR UM NÚMERO ENTRE 1 E 7 PARA UTILIZAR O MENU!\n");
    }
}
