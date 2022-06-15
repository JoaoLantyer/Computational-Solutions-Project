package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    //Declarando os ArrayLists que irão receber os Objetos da classe Cliente, Filme e Jogo respectivamente
    ArrayList<Cliente> clienteLista = new ArrayList<>();
    static ArrayList<Filme> filmeLista = new ArrayList<>();
    ArrayList<Jogo> jogoLista = new ArrayList<>();

    //Declarando os ArrayLists que irão receber o ID de cada aluguel em Integer, o cpf do Cliente que fez o aluguel em String e o título do filme alugado em String
    ArrayList<Integer> idAluguelLista = new ArrayList<>();
    ArrayList<String> AluguelClienteLista = new ArrayList<>();
    ArrayList<String> AluguelLista = new ArrayList<>();

    public void cadastroInicial(){
        //Adicionando um valor inicial a idAluguelLista, a idFilmeLista e idJogoLista
        idAluguelLista.add(0);
        Filme.idFilmeLista.add(0);
        Jogo.idJogoLista.add(0);

        //Cadastro automático de 7 ou mais objetos, como foi instruído no edital
        clienteLista.add(new Cliente("JOAO LANTYER", "00000000000", "000000000", "joaolantyer@email.com", "00000-000"));
        clienteLista.add(new Cliente("RENAN ABREU", "11111111111", "111111111", "renanabreu@email.com", "11111-111"));
        clienteLista.add(new Cliente("JOAO ALFREDO", "22222222222", "222222222", "joaoalfredo@email.com", "22222-222"));
        clienteLista.add(new Cliente("ALDAIR LIMA", "33333333333", "333333333", "aldairlima@email.com", "33333-333"));
        clienteLista.add(new Cliente("LEONI MASCARENHAS", "44444444444", "444444444", "leonimascarenhasu@email.com", "44444-444"));
        filmeLista.add(new Filme(1, 5, "BATMAN: O CAVALEIRO DAS TREVAS", "12 anos", "Filme", 7.90f, 152, "Christopher Nolan", "Acao"));
        filmeLista.add(new Filme(2, 5, "UM SONHO DE LIBERDADE", "16 anos", "Filme", 5.90f, 142, "Frank Darabont", "Drama"));
        filmeLista.add(new Filme(3, 5, "O PODEROSO CHEFAO", "14 anos", "Filme", 6.50f, 175, "Francis Ford Coppola", "Crime"));
        jogoLista.add(new Jogo(1, 5, "THE LEGEND OF ZELDA: OCARINA OF TIME", "12 anos", "Jogo", 5.50f, "Aventura", "Nintendo", "Nintendo 64"));
        jogoLista.add(new Jogo(2, 5, "HALF-LIFE 2", "16 anos", "Jogo", 5.80f, "Acao", "Valve", "PC"));
        jogoLista.add(new Jogo(3, 5, "METAL GEAR SOLID", "18 anos", "Jogo", 5.70f, "Acao", "Konami", "Playstation"));

        //Adicionando 3 elementos no ArrayList idFilmeLista e no idJogoLista baseado no que foi feito acima, para que, ao ser cadastrado um novo filme ou jogo, o id ja comece do 4, já que ele incrementa em 1 e ele é atribuído do tamanho de idFilmeLista/idJogoLista
        Filme.idFilmeLista.add(1);
        Filme.idFilmeLista.add(2);
        Filme.idFilmeLista.add(3);
        Jogo.idJogoLista.add(1);
        Jogo.idJogoLista.add(2);
        Jogo.idJogoLista.add(3);

        //Adicionando os nomes e títulos cadastrados acima no ArrayList que os recebe como String, para serem ordenados alfabeticamente futuramente
        Cliente.nomeClienteLista.add("JOAO LANTYER");
        Cliente.nomeClienteLista.add("RENAN ABREU");
        Cliente.nomeClienteLista.add("JOAO ALFREDO");
        Cliente.nomeClienteLista.add("ALDAIR LIMA");
        Cliente.nomeClienteLista.add("LEONI MASCARENHAS");
        Filme.tituloFilmeLista.add("BATMAN: O CAVALEIRO DAS TREVAS");
        Filme.tituloFilmeLista.add("UM SONHO DE LIBERDADE");
        Filme.tituloFilmeLista.add("O PODEROSO CHEFAO");
        Jogo.tituloJogoLista.add("THE LEGEND OF ZELDA: OCARINA OF TIME");
        Jogo.tituloJogoLista.add("HALF-LIFE 2");
        Jogo.tituloJogoLista.add("METAL GEAR SOLID");
    }

    public void executar(){

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando a variável para registrar a escolha do Menu
        int escolha;

        System.out.println("\n---------------------INICIO DO PROGRAMA--------------------\n");

        //Criando uma estrutura de repetição "do while" para que o Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 10(sair)
        do{
            //Executando o método que irá imprimir o Menu
            exibirMenu();

            System.out.println("==================== ESCOLHA SUA OPCAO ====================");
            System.out.print("\nDIGITE UM NUMERO ENTRE 1 E 10 PARA UTILIZAR O MENU: ");

            //Tratando os erros com um "try catch" para que, sempre que um erro de InputMismatchException aconteça, retorne ao método atual. Isto se repete por todo o código.
            try{
            //Atribuindo o valor da variável "escolha" ao que for digitado no teclado do usuário
            escolha = scan.nextInt();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                executar();
                return;
            }

            //Criando uma estrutura de decisão "switch case" que terá a variável "escolha" como a variável de controle e selecionará uma das 11 opções dependendo do que o usuário digitou
            switch (escolha) {
                //Caso o usuário tenha digitado 1, será executado o método realizarAluguel()
                case 1: realizarAluguel();
                break;

                //Caso o usuário tenha digitado 2, será executado o método da classe cliente cadastrarCliente() e o retorno deste será adicionado ao ArrayList clienteLista
                case 2: clienteLista.add(Cliente.cadastrarCliente());
                break;

                //Caso o usuário tenha digitado 3, será executado o método da classe cliente consultarCliente() no ArrayList clienteLista
                case 3: Cliente.consultarCliente(clienteLista);
                break;

                //Caso o usuário tenha digitado 4, será executado o método da classe Filme cadastrarFilme() e o retorno deste será adicionado ao ArrayList filmeLista
                case 4: filmeLista.add(Filme.cadastrarFilme());
                break;

                //Caso o usuário tenha digitado 5, será executado o método da classe Filme consultarFilme() no ArrayList filmeLista
                case 5: Filme.consultarFilme(filmeLista);
                break;

                //Caso o usuário tenha digitado 6, será executado o método da classe Jogo cadastrarJogo() e o retorno deste será adicionado ao ArrayList jogoLista
                case 6: jogoLista.add(Jogo.cadastrarJogo());

                //Caso o usuário tenha digitado 7, será executado o método da classe Jogo consultarJogo() no ArrayList jogoLista
                case 7: Jogo.consultarJogo(jogoLista);

                //Caso o usuário tenha digitado 8, será executado o método pendencias()
                case 8: pendencias();
                break;

                //Caso o usuário tenha digitado 9,, será executado o método realizarDevolucao()
                case 9: realizarDevolucao();
                break;

                //Caso o usuário tenha digitado 10, será executado o método sair()
                case 10: sair();
                break;

                //Caso o usuário tenha digitado qualquer outra coisa, será executado o método mensagemDefault()
                default: mensagemDefault();
            }

        }while(escolha != 10);

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
        System.out.println("|                   [6] CADASTRAR JOGO                    |");
        System.out.println("|                   [7] CONSULTAR JOGO                    |");
        System.out.println("|                   [8] PENDENCIAS                        |");
        System.out.println("|                   [9] REALIZAR DEVOLUCAO                |");
        System.out.println("|                   [10] SAIR                             |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------\n");

    }


    //Criando um método para exibir a escolha entre duas opções (Aluguel de Filme ou Jogo), e um "switch case" que irá executar uma das duas dependendo da escolha do usuário
    public void realizarAluguel() {

        Scanner scan = new Scanner(System.in);

        int escolhaAluguel;

        System.out.println("-----------------------------------------------------------");
        System.out.println("|    VOCE DESEJA FAZER ALUGUEL DE UM FILME OU UM JOGO?    |");
        System.out.println("|                                                         |");
        System.out.println("|           [1] FILME                 [2] JOGO            |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------");

        System.out.print("SUA ESCOLHA: ");

        try{
        escolhaAluguel = scan.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarAluguel();
            return;
        }

        switch(escolhaAluguel){
            case 1: realizarAluguelFilme();
            break;

            case 2: realizarAluguelJogo();
            break;

            default:System.out.println("[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 2 PARA UTILIZAR O MENU!");
        }

    }

    //Criando um método para exibir os detalhes do Cliente que realizará o Aluguel e o Filme que será alugado,e guarde estes em suas respectivas ArrayLists
    public void realizarAluguelFilme() {

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis (o id recebe seu valor do último valor do ArrayList idAluguelLista)
        int id = idAluguelLista.get(idAluguelLista.size() - 1);
        String respCliente, respFilme, opcao;
        float valorTotal = 0;
        int menos = -1;

        System.out.println("\nVOCE SELECIONOU: [1] REALIZAR ALUGUEL DE UM FILME\n");

        //Incrementando o id do aluguel, toda vez que o método realizarAluguelFilme for chamado (Incrementamos o valor de id, o adicionamos ao ArrayList idAluguelLista e atribuímos este último valor a variável id)
        id++;
        idAluguelLista.add(id);
        id = idAluguelLista.get(idAluguelLista.size() - 1);
        System.out.println("ID DO ALUGUEL: " + id);

        //Atribuíndo o cpf do Cliente que irá fazer aluguel numa variável, para que se busque na lista clienteLista um Cliente com o mesmo cpf, e se achar, irá imprimir o resto dos seus dados
        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER O ALUGUEL: ");

        try{
        respCliente = scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarAluguelFilme();
            return;
        }

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

            try{
            respFilme = scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                realizarAluguelFilme();
                return;
            }
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
                        ArrayList AluguelLista, assim como o nome do Cliente será adicionado no ArrayList AluguelClienteLista */
                        AluguelLista.add(umFilme.getTitulo());

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
            try{
            opcao = scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                realizarAluguelFilme();
                return;
            }

        }while (opcao.equalsIgnoreCase("SIM"));

        if (opcao.equalsIgnoreCase("NAO")) {
            System.out.println("SAINDO...");
        } else {
            System.out.println("OPCAO INVALIDA, SAINDO... ");
        }

        System.out.printf("VALOR TOTAL: R$%.2f\n", valorTotal);
        System.out.println("----------------------MUITO OBRIGADO!----------------------");

    }

    //Criando um método para exibir os detalhes do Cliente que realizará o Aluguel e o Jogo que será alugado,e guarde estes em suas respectivas ArrayLists
    public void realizarAluguelJogo() {

        //Criando o objeto Scanner que irá receber a entrada do teclado do usuário
        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis (o id recebe seu valor do último valor do ArrayList idAluguelLista)
        int id = idAluguelLista.get(idAluguelLista.size() - 1);
        String respCliente, respJogo, opcao;
        float valorTotal = 0;
        int menos = -1;

        System.out.println("\nVOCE SELECIONOU: [2] REALIZAR ALUGUEL DE UM JOGO\n");

        //Incrementando o id do aluguel, toda vez que o método realizarAluguelJogo for chamado (Incrementamos o valor de id, o adicionamos ao ArrayList idAluguelLista e atribuímos este último valor a variável id)
        id++;
        idAluguelLista.add(id);
        id = idAluguelLista.get(idAluguelLista.size() - 1);
        System.out.println("ID DO ALUGUEL: " + id);

        //Atribuíndo o cpf do Cliente que irá fazer aluguel numa variável, para que se busque na lista clienteLista um Cliente com o mesmo cpf, e se achar, irá imprimir o resto dos seus dados
        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER O ALUGUEL: ");

        try{
        respCliente = scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarAluguelJogo();
            return;
        }

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

        //Criando uma estrutura de repetição "do while" para repetir esta porção do código, toda vez que o usuário escolher que quer fazer o aluguel de um jogo adicional
        do {

            /*Atribuindo o título do Jogo que será alugado numa variável, para que busque na lista jogoLista um Jogo com o mesmo título,
            e se achar, juntamente com o fato de ter mais de 0 unidades, irá imprimir o resto dos dados do mesmo */
            System.out.print("INFORME A SEGUIR O TITULO DO JOGO QUE DESEJA FAZER O ALUGUEL: ");

            try{
            respJogo = scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                realizarAluguelJogo();
                return;
            }

            for (Jogo umJogo : jogoLista) {
                if (respJogo.equalsIgnoreCase(umJogo.getTitulo())) {
                    if(umJogo.getQuantidade() > 0) {
                        System.out.println("-----------------------------------------------------------");
                        System.out.printf("| ID DO JOGO: %-44s|\n", umJogo.getId());
                        System.out.printf("| DESENVOLVEDOR: %-41s|\n", umJogo.getDesenvolvedor());
                        System.out.printf("| GENERO: %-48s|\n", umJogo.getGenero());
                        System.out.printf("| CLASSIFICACAO INDICATIVA: %-30s|\n", umJogo.getClassificacao());
                        System.out.printf("| PLATAFORMA: %-44s|\n", umJogo.getPlataforma());
                        System.out.printf("| UNIDADES DISPONIVEIS APOS O ALUGUEL: %-19s|\n", (umJogo.getQuantidade() + menos));
                        umJogo.setQuantidade(umJogo.getQuantidade() + menos);
                        System.out.printf("| VALOR POR UNIDADE: R$%-35.2f|\n", umJogo.getValor());
                        System.out.println("-----------------------------------------------------------\n");

                        /*Adicionalmente, ao achar o Jogo e o mesmo possui mais que 0 unidades disponíveis, o mesmo é adicionado ao
                        ArrayList AluguelLista, assim como o nome do Cliente será adicionado no ArrayList AluguelClienteLista */
                        AluguelLista.add(umJogo.getTitulo());

                        for (Cliente umCliente : clienteLista) {
                            if (respCliente.equals(umCliente.getCpf())) {
                                AluguelClienteLista.add(umCliente.getNome());
                            }
                        }
                        //Atribuindo e somando o valor do Filme alugado ao valorTotal, toda vez que essa operação é repetida, para recebermos o valor total da transação
                        valorTotal += umJogo.getValor();
                    }
                }
            }

            System.out.print("DESEJA ALUGAR OUTRO JOGO? DIGITE 'SIM' OU 'NAO': ");
            try{
            opcao = scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                realizarAluguelJogo();
                return;
            }

        }while (opcao.equalsIgnoreCase("SIM"));

        if (opcao.equalsIgnoreCase("NAO")) {
            System.out.println("SAINDO...");
        } else {
            System.out.println("OPCAO INVALIDA, SAINDO... ");
        }

        System.out.printf("VALOR TOTAL: R$%.2f\n", valorTotal);
        System.out.println("----------------------MUITO OBRIGADO!----------------------");

    }

    //Criando um método para exibir a escolha entre duas opções (Devolução de Filme ou Jogo), e um "switch case" que irá executar uma das duas dependendo da escolha do usuário
    public void realizarDevolucao() {

        Scanner scan = new Scanner(System.in);

        int escolhaDevolucao;

        System.out.println("-----------------------------------------------------------");
        System.out.println("|   VOCE DESEJA FAZER DEVOLUCAO DE UM FILME OU UM JOGO?   |");
        System.out.println("|                                                         |");
        System.out.println("|           [1] FILME                 [2] JOGO            |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------");

        System.out.print("SUA ESCOLHA: ");
        try{
            escolhaDevolucao = scan.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarDevolucao();
            return;
        }

        switch(escolhaDevolucao){
            case 1: realizarDevolucaoFilme();
                break;

            case 2: realizarDevolucaoJogo();
            break;

            default: System.out.println("[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 2 PARA UTILIZAR O MENU!");
        }

    }

    //Criando um método para realizar a devolução de um filme, exibindo os detalhes do Cliente e do Filme, e assim removendo dos ArrayLists AluguelClienteLista e AluguelLista
    public void realizarDevolucaoFilme(){

        Scanner scan = new Scanner(System.in);

        String respCliente, respFilme;
        int mais = 1;

        System.out.println("\nVOCE SELECIONOU: [1] REALIZAR DEVOLUCAO DE UM FILME\n");

        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER A DEVOLUCAO: ");
        try{
        respCliente = scan.nextLine();
    } catch (InputMismatchException e){
        System.out.println("ERRO! VALOR INVALIDO!");
        realizarDevolucaoFilme();
        return;
    }

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

        System.out.print("INFORME A SEGUIR O TITULO DO FILME QUE DESEJA FAZER A DEVOLUCAO: ");
        try{
        respFilme = scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarDevolucaoFilme();
            return;
        }
        for (Filme umFilme : filmeLista) {
            if (respFilme.equalsIgnoreCase(umFilme.getTitulo())) {
                System.out.println("-----------------------------------------------------------");
                System.out.printf("| ID DO FILME: %-43s|\n", umFilme.getId());
                System.out.printf("| DIRETOR: %-47s|\n", umFilme.getDiretor());
                System.out.printf("| GENERO: %-48s|\n", umFilme.getGenero());
                System.out.printf("| CLASSIFICACAO INDICATIVA: %-30s|\n", umFilme.getClassificacao());
                System.out.printf("| DURACAO (EM MINUTOS): %-34s|\n", umFilme.getDuracao());
                System.out.printf("| UNIDADES DISPONIVEIS APOS A DEVOLUCAO: %-17s|\n", (umFilme.getQuantidade() + mais));
                umFilme.setQuantidade(umFilme.getQuantidade() + mais);
                System.out.printf("| VALOR POR UNIDADE: R$%-35.2f|\n", umFilme.getValor());
                System.out.println("-----------------------------------------------------------\n");

                /*Criando um "for loop" que, para cada umCliente em clienteLista será feita a condição de se o CPF digitado for igual ao de algum Cliente no sistema,
                e se o nome deste mesmo cliente em AluguelClienteLista estiver na mesma posição (index) do título do filme no ArrayList AluguelLista, ambos serão removidos*/
                for (Cliente umCliente : clienteLista) {
                    if (respCliente.equals(umCliente.getCpf()) && AluguelClienteLista.indexOf(umCliente.getNome()) == AluguelLista.indexOf(umFilme.getTitulo())) {
                        AluguelLista.remove(umFilme.getTitulo());
                        AluguelClienteLista.remove(umCliente.getNome());

                        System.out.println("DEVOLUCAO REALIZADA COM SUCESSO!\n");
                        System.out.println("----------------------MUITO OBRIGADO!----------------------");
                    }
                }
            }
        }
    }

    //Criando um método para realizar a devolução de um filme, exibindo os detalhes do Cliente e do Filme, e assim removendo dos ArrayLists AluguelClienteLista e AluguelLista
    public void realizarDevolucaoJogo(){

        Scanner scan = new Scanner(System.in);

        String respCliente, respJogo;
        int mais = 1;

        System.out.println("\nVOCE SELECIONOU: [1] REALIZAR DEVOLUCAO DE UM JOGO\n");

        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE QUE DESEJA FAZER A DEVOLUCAO: ");
        try{
        respCliente = scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarDevolucaoJogo();
            return;
        }
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

        System.out.print("INFORME A SEGUIR O TITULO DO JOGO QUE DESEJA FAZER A DEVOLUCAO: ");
        try{
        respJogo = scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            realizarDevolucaoJogo();
            return;
        }
        for (Jogo umJogo : jogoLista) {
            if (respJogo.equalsIgnoreCase(umJogo.getTitulo())) {
                System.out.println("-----------------------------------------------------------");
                System.out.printf("| ID DO JOGO: %-44s|\n", umJogo.getId());
                System.out.printf("| DESENVOLVEDOR: %-41s|\n", umJogo.getDesenvolvedor());
                System.out.printf("| GENERO: %-48s|\n", umJogo.getGenero());
                System.out.printf("| CLASSIFICACAO INDICATIVA: %-30s|\n", umJogo.getClassificacao());
                System.out.printf("| PLATAFORMA: %-44s|\n", umJogo.getPlataforma());
                System.out.printf("| UNIDADES DISPONIVEIS APOS A DEVOLUCAO: %-17s|\n", (umJogo.getQuantidade() + mais));
                umJogo.setQuantidade(umJogo.getQuantidade() + mais);
                System.out.printf("| VALOR POR UNIDADE: R$%-35.2f|\n", umJogo.getValor());
                System.out.println("-----------------------------------------------------------\n");

                /*Criando um "for loop" que, para cada umCliente em clienteLista será feita a condição de se o CPF digitado for igual ao de algum Cliente no sistema,
                e se o nome deste mesmo cliente em AluguelClienteLista estiver na mesma posição (index) do título do jogo no ArrayList AluguelLista, ambos serão removidos*/
                for (Cliente umCliente : clienteLista) {
                    if (respCliente.equals(umCliente.getCpf()) && AluguelClienteLista.indexOf(umCliente.getNome()) == AluguelLista.indexOf(umJogo.getTitulo())) {
                        AluguelLista.remove(umJogo.getTitulo());
                        AluguelClienteLista.remove(umCliente.getNome());

                        System.out.println("DEVOLUCAO REALIZADA COM SUCESSO!\n");
                        System.out.println("----------------------MUITO OBRIGADO!----------------------\n");
                    }
                }
            }
        }
    }



    //Criando um método para checar quais objetos foram alugados, imprimindo o nome do cliente que fez o aluguel e o título do filme alugado
    public void pendencias() {
        System.out.println("\nVOCE SELECIONOU: [8] ALUGUEIS PENDENTES\n");
        for (int i = 0; i < AluguelClienteLista.size(); i++) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|CLIENTE:                                                 |");
            System.out.printf("|%-57s|\n", AluguelClienteLista.get(i));
            System.out.println("|MIDIA(S) PENDENTE(S):                                    |");
            System.out.printf("|%-57s|\n", AluguelLista.get(i));
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    //Criando um método para imprimir uma mensagem de saída, quando o usuário escolher 10
    public void sair(){
        System.out.println("\nVOCE SELECIONOU: [10] SAIR\n");
    }

    //Criando um método que imprima uma mensagem "default", ou seja, irá aparecer quando o usuário digitar qualquer coisa que não seja de 1 a 10
    public void mensagemDefault(){
        System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 10 PARA UTILIZAR O MENU!\n");
    }
}
