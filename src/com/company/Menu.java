package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    //Declarando os ArrayLists que irão receber os Objetos da classe Cliente e Filme respectivamente
    ArrayList<ClienteControle> clienteLista = new ArrayList<>();
    ArrayList<FilmeControle> filmeLista = new ArrayList<>();

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

        //Adicionando um valor inicial a idAluguelLista e a idFilmeLista
        idAluguelLista.add(0);
        FilmeControle.idFilmeLista.add(0);

        //Cadastro automático de 7 ou mais objetos, como foi instruído no edital
        clienteLista.add(new ClienteControle("Joao Lantyer", "00000000000", "000000000", "joaolantyer@email.com", "00000-000"));
        clienteLista.add(new ClienteControle("Renan Abreu", "11111111111", "111111111", "renanabreu@email.com", "11111-111"));
        clienteLista.add(new ClienteControle("Joao Alfredo", "22222222222", "222222222", "joaoalfredo@email.com", "22222-222"));
        clienteLista.add(new ClienteControle("Aldair Lima", "33333333333", "333333333", "aldairlima@email.com", "33333-333"));
        clienteLista.add(new ClienteControle("Leoni Mascarenhas", "44444444444", "444444444", "leonimascarenhasu@email.com", "44444-444"));
        filmeLista.add(new FilmeControle(1, "Batman: O Cavaleiro das Trevas", "Christopher Nolan", "Acao", "12 anos", 152, 5, 7.90f));
        filmeLista.add(new FilmeControle(2, "Um Sonho de Liberdade", "Frank Darabont", "Drama", "16 anos", 142, 5, 5.90f));
        filmeLista.add(new FilmeControle(3, "O Poderoso Chefao", "Francis Ford Coppola", "Crime", "14 anos", 175, 5, 6.50f));

        //Adicionando 3 elementos no ArrayList idFilmeLista baseado no que foi feito acima, para que, ao ser cadastrado um novo filme, o id ja comece do 4, já que ele incrementa em 1 e ele é atribuído do tamanho de idFilmeLista
        FilmeControle.idFilmeLista.add(1);
        FilmeControle.idFilmeLista.add(2);
        FilmeControle.idFilmeLista.add(3);

        //Criando uma estrutura de repetição "do while" para que o Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 7(sair)
        do{
            //Executando o método que irá imprimir o Menu
            exibirMenu();

            System.out.println("==================== ESCOLHA SUA OPCAO ====================");
            System.out.print("\nDIGITE UM NUMERO ENTRE 1 E 7 PARA UTILIZAR O MENU: ");

            //Atribuindo o valor da variável "escolha" ao que for digitado no teclado do usuário
            escolha = scan.nextInt();

            //Criando uma estrutura de decisão "switch case" que terá a variável "escolha" como a variável de controle e selecionará uma das 8 opções dependendo do que o usuário digitou
            switch (escolha) {
                //Caso o usuário tenha digitado 1, será executado o método realizarAluguel()
                case 1: realizarAluguel();
                break;

                //Caso o usuário tenha digitado 2, será executado o método da classe cliente cadastrarCliente() e o retorno deste será adicionado ao ArrayList clienteLista
                case 2: clienteLista.add(ClienteControle.cadastrarCliente());
                break;

                //Caso o usuário tenha digitado 3, será executado o método da classe cliente consultarCliente() no ArrayList clienteLista
                case 3: ClienteControle.consultarCliente(clienteLista);
                break;

                //Caso o usuário tenha digitado 4, será executado o método da classe Filme cadastrarFilme() e o retorno deste será adicionado ao ArrayList filmeLista
                case 4: filmeLista.add(FilmeControle.cadastrarFilme());
                break;

                //Caso o usuário tenha digitado 5, será executado o método da classe Filme consultarFilme() no ArrayList filmeLista
                case 5: FilmeControle.consultarFilme(filmeLista);
                break;

                //Caso o usuário tenha digitado 6, será executado o método pendencias()
                case 6: pendencias();
                break;

                //Caso o usuário tenha digitado 7, será executado o método sair()
                case 7: sair();
                break;

                //Caso o usuário tenha digitado qualquer outra coisa, será executado o método mensagemDefault()
                default: mensagemDefault();
            }

        }while(escolha != 7);

        System.out.println("--------------------PROGRAMA FINALIZADO--------------------");
    }

    //Criando um método para imprimir o Menu
    public void exibirMenu(){

        System.out.println("-----------------------------------------------------------");
        System.out.println("|                     MENU PRINCIPAL                      |");
        System.out.println("|                                                         |");
        System.out.println("|                   [1] REALIZAR ALUGUEL                  |");
        System.out.println("|                   [2] CADASTRAR CLIENTE                 |");
        System.out.println("|                   [3] CONSULTAR CLIENTE                 |");
        System.out.println("|                   [4] CADASTRAR FILME                   |");
        System.out.println("|                   [5] CONSULTAR FILME                   |");
        System.out.println("|                   [6] ALUGUEIS PENDENTES                |");
        System.out.println("|                   [7] SAIR                              |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------\n");

    }

    //Criando um método para exibir os detalhes do Cliente que realizará o Aluguel e o Filme que será alugado,e guarde estes em suas respectivas ArrayLists
    public void realizarAluguel() {

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis (o id recebe seu valor do último valor do ArrayList idAluguelLista)
        int id = idAluguelLista.get(idAluguelLista.size() - 1);
        String respCliente, respFilme, opcao;
        float valorTotal = 0;
        int menos = -1;

        System.out.println("\nVOCE SELECIONOU: [1] REALIZAR ALUGUEL\n");

        //Incrementando o id do aluguel, toda vez que o método realizarAluguel for chamado (Incrementamos o valor de id, o adicionamos ao ArrayList idAluguelLista e atribuímos este último valor a variável id)
        id++;
        idAluguelLista.add(id);
        id = idAluguelLista.get(idAluguelLista.size() - 1);
        System.out.println("ID DO ALUGUEL: " + id);

        //Atribuíndo o cpf do Cliente que irá fazer aluguel numa variável, para que se busque na lista clienteLista um Cliente com o mesmo cpf, e se achar, irá imprimir o resto dos seus dados
        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER O ALUGUEL: ");
        respCliente = scan.nextLine();
        for (Cliente umCliente : clienteLista) {
            if (respCliente.equals(umCliente.getCpf())) {
                System.out.println("-----------------------------------------------------------");
                System.out.printf("| NOME: %-50s|\n", umCliente.getNome());
                System.out.printf("| TELEFONE: %-46s|\n", umCliente.getTelefone());
                System.out.printf("| E-MAIL: %-48s|\n", umCliente.getEmail());
                System.out.printf("| CEP: %-51s|\n", umCliente.getCep());
                System.out.println("-----------------------------------------------------------\n");
            }


        }

        //Criando uma estrutura de repetição "do while" para repetir esta porção do código, toda vez que o usuário escolher que quer fazer o aluguel de um filme adicional
        do {

            /*Atribuindo o título do Filme que será alugado numa variável, para que busque na lista filmeLista um Filme com o mesmo título,
            e se achar, juntamente com o fato de ter mais de 0 unidades, irá imprimir o resto dos dados do mesmo */
            System.out.print("INFORME A SEGUIR O TITULO DO FILME QUE DESEJA FAZER O ALUGUEL: ");
            respFilme = scan.nextLine();
            for (Filme umFilme : filmeLista) {
                if (respFilme.equalsIgnoreCase(umFilme.getTitulo())) {
                    if(umFilme.getQuantidade() > 0) {
                        System.out.println("-----------------------------------------------------------");
                        System.out.printf("| ID DO FILME: %-43s|\n", umFilme.getId());
                        System.out.printf("| DIRETOR: %-47s|\n", umFilme.getDiretor());
                        System.out.printf("| GENERO: %-48s|\n", umFilme.getGenero());
                        System.out.printf("| CLASSIFICACAO INDICATIVA: %-30s|\n", umFilme.getClassificacao());
                        System.out.printf("| DURACAO (EM MINUTOS): %-34s|\n", umFilme.getDuracao());
                        System.out.printf("| UNIDADES DISPONIVEIS APOS O ALUGUEL: %-19s|\n", (umFilme.getQuantidade() + menos));
                        umFilme.setQuantidade(umFilme.getQuantidade() + menos);
                        System.out.printf("| VALOR POR UNIDADE: R$%-35.2f|\n", umFilme.getValor());
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
            System.out.println("OPCAO INVALIDA, SAINDO... ");
        }

        System.out.printf("VALOR TOTAL: R$%.2f\n", valorTotal);
        System.out.println("----------------------MUITO OBRIGADO!----------------------");

    }

    //Criando um método para checar quais objetos foram alugados, imprimindo o nome do cliente que fez o aluguel e o título do filme alugado
    public void pendencias() {
        System.out.println("\nVOCE SELECIONOU: [6] ALUGUEIS PENDENTES\n");
        for (int i = 0; i < AluguelClienteLista.size(); i++) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|CLIENTE:                                                 |");
            System.out.printf("|%-57s|\n", AluguelClienteLista.get(i));
            System.out.println("|FILME(S) PENDENTE(S):                                    |");
            System.out.printf("|%-57s|\n", AluguelFilmeLista.get(i));
            System.out.println("-----------------------------------------------------------\n");
        }
    }
    //Criando um método para imprimir uma mensagem de saída, quando o usuário escolher 7
    public void sair(){
        System.out.println("\nVOCE SELECIONOU: [7] SAIR\n");
    }

    //Criando um método que imprima uma mensagem "default", ou seja, irá aparecer quando o usuário digitar qualquer coisa que não seja de 1 a 7
    public void mensagemDefault(){
        System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 7 PARA UTILIZAR O MENU!\n");
    }
}
