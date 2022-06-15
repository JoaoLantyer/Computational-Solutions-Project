package com.company;

import java.util.*;

//Criando a classe Filme, que herda os atributos e métodos da classe Midia
public class Filme extends Midia{

    //Declarando os atributos
    private int duracao;
    private String diretor;

    //Criando um ArrayList idFilmeLista, que irá receber o id de cada Filme em Integer
    static ArrayList<Integer> idFilmeLista = new ArrayList<>();

    //Criando um Arraylist que receberá única e exclusivamente os títulos dos filmes, para que sejam ordenados alfabeticamente futuramente
    static ArrayList<String> tituloFilmeLista = new ArrayList<>();

    //Gerando o construtor
    public Filme(int id, int quantidade, String titulo, String classificacao, String tipo, float valor, int duracao, String diretor, String genero) {
        super(id, quantidade, titulo, classificacao, tipo, valor, genero);
        this.duracao = duracao;
        this.diretor = diretor;
    }

    //Gerando os Getters e Setters
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    //Criando um método para cadastrar o Filme e que irá retornar um objeto Filme
    public static Filme cadastrarFilme(){

        System.out.println("\nVOCE SELECIONOU: [4] CADASTRAR FILME\n");

        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis (o id recebe seu valor do último valor do ArrayList idFilmeLista)
        int id = idFilmeLista.get(idFilmeLista.size() - 1), duracao, quantidade;
        String titulo, diretor, classificacao, genero, tipo = "Filme";
        float valor;

        //Criando uma variável de referência do objeto Filme
        Filme filme;

        //Incrementando o id do Filme, toda vez que o método cadastrarFilme é chamado (Incrementamos o valor de id, o adicionamos ao ArrayList idFilmeLista e atribuímos este último valor a variável id)
        id++;
        idFilmeLista.add(id);
        id = idFilmeLista.get(idFilmeLista.size() - 1);

        try {
            System.out.print("INFORME O TITULO (SEM CARACTERES ESPECIAIS): ");
            titulo = scan.nextLine().toUpperCase(Locale.ROOT);

            System.out.print("INFORME O DIRETOR (SEM CARACTERES ESPECIAIS): ");
            diretor = scan.nextLine();

            genero = selecionarGeneroFilme();

            classificacao = selecionarClassificacao();

            System.out.print("INFORME A DURACAO (EM MINUTOS): ");
            duracao = scan.nextInt();

            System.out.print("INFORME A QUANTIDADE DE COPIAS DISPONIVEIS: ");
            quantidade = scan.nextInt();

            System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
            valor = scan.nextFloat();
        }catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            System.out.println("O PROGRAMA RETORNARA PARA O INICIO DO CADASTRO!");
            return cadastrarFilme();
        }

        //Instanciando um Objeto Filme na variável filme, com os atributos escolhidos acima
        filme = new Filme(id, quantidade, titulo, classificacao, tipo, valor, duracao, diretor, genero);

        if(!tituloFilmeLista.contains(titulo)) {
            tituloFilmeLista.add(titulo);
        }

        //Retornando a variável filme que o objeto Filme foi instanciado
        return filme;

    }

    //Criando um método que abrirá o sub-menu consultarFilme, este método recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void consultarFilme(ArrayList<Filme> listaFilme){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarFilme;
        String escolhaSelecionarGenero, escolhaSelecionarClassificacao, escolhaTitulo;

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 8(sair)
        do{

        System.out.println("-----------------------------------------------------------");
        System.out.println("|                 SUB-MENU CONSULTAR FILME                |");
        System.out.println("|                                                         |");
        System.out.println("|   [1] LISTAR TODOS OS FILMES                            |");
        System.out.println("|   [2] LISTAR TODOS OS FILMES ALFABETICAMENTE            |");
        System.out.println("|   [3] LISTAR FILMES POR GENERO                          |");
        System.out.println("|   [4] LISTAR FILMES POR CLASSIFICACAO INDICATIVA        |");
        System.out.println("|   [5] BUSCAR UM FILME ESPECIFICO                        |");
        System.out.println("|   [6] ATUALIZAR UM FILME                                |");
        System.out.println("|   [7] REMOVER UM FILME DO SISTEMA                       |");
        System.out.println("|   [8] RETORNAR AO MENU PRINCIPAL                        |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------");

        System.out.print("DIGITE UM NUMERO ENTRE 1 E 8 PARA UTILIZAR O MENU: ");

            try{
        escolhaConsultarFilme = scan.nextInt();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                consultarFilme(listaFilme);
                return;
            }

        scan.nextLine();

        //Criando uma estrutura de decisão "switch case" que terá a variável "escolhaConsultarFilme" como a variável de controle e selecionará uma das 6 opções dependendo do que o usuário digitou
        switch(escolhaConsultarFilme) {

            //Caso o usuário tenha digitado 1, será executado o método listarFilme no ArrayList listaFilme
            case 1: System.out.println("\nVOCE SELECIONOU: [1] LISTAR TODOS OS FILMES\n");
                listarFilme(listaFilme);
            break;

            //Caso o usuário tenha digitado 2, será executado o método listarFilmeAlfabeticamente no ArrayList listaFilme
            case 2: System.out.println("\nVOCE SELECIONOU: [2] LISTAR TODOS OS FILMES ALFABETICAMENTE\n");
                listarFilmeAlfabeticamente(listaFilme);
            break;

            //Caso o usuário tenha digitado 3, será executado o método selecionarGeneroFilme(), e o valor retornado deste será atribuído a variável escolhaSelecionarGenero
            case 3: System.out.println("\nVOCE SELECIONOU: [3] LISTAR FILMES POR GENERO\n");
                escolhaSelecionarGenero = selecionarGeneroFilme();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |           GENERO           |                          TITULO                           |               DIRETOR               | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo genero seja o mesmo atribuído a variável escolhaSelecionarGenero
                for (Filme umFilme : listaFilme) {
                    if (escolhaSelecionarGenero.equalsIgnoreCase(umFilme.getGenero())) {
                        System.out.printf("|%-5d%-29s%-60s%-38s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getGenero(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 4, será executado o método selecionarClassificacao(), e o valor retornado deste será atribuído a variável escolhaSelecionarClassificacao
            case 4: System.out.println("\nVOCE SELECIONOU: [4] LISTAR FILMES POR CLASSIFICACAO INDICATIVA\n");
                escolhaSelecionarClassificacao = selecionarClassificacao();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID | C. INDICATIVA |                          TITULO                           |               DIRETOR               |           GENERO           | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo classificacao seja o mesmo atribuído a variável escolhaSelecionarClassificacao
                for (Filme umFilme : listaFilme) {
                    if (escolhaSelecionarClassificacao.equalsIgnoreCase(umFilme.getClassificacao())) {
                        System.out.printf("|%-5d%-16s%-60s%-38s%-29s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getClassificacao(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 5, será solicitado que ele digite o título do Filme que deseja buscar, e então este valor será atribuído a variável escolhaTitulo
            case 5: System.out.println("\nVOCE SELECIONOU: [5] BUSCAR UM FILME ESPECIFICO\n");
                System.out.print("DIGITE O TITULO DO FILME QUE DESEJA BUSCAR: ");
                try{
                escolhaTitulo = scan.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("ERRO! VALOR INVALIDO!");
                    consultarFilme(listaFilme);
                    return;
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |                          TITULO                           |               DIRETOR               |           GENERO           | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                for (Filme umFilme : listaFilme) {
                    if (escolhaTitulo.equalsIgnoreCase(umFilme.getTitulo())) {
                        System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 6, será solicitado que ele digite o título do Filme que deseja atualizar, e então este valor será atribuído a variável escolhaTitulo
            case 6: System.out.println("\nVOCE SELECIONOU: [6] ATUALIZAR UM FILME\n");
                System.out.print("DIGITE O TITULO DO FILME QUE DESEJA ATUALIZAR: ");

                try{
                escolhaTitulo = scan.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("ERRO! VALOR INVALIDO!");
                    consultarFilme(listaFilme);
                    return;
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |                          TITULO                           |               DIRETOR               |           GENERO           | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                for(Filme umFilme : listaFilme) {
                    if (escolhaTitulo.equalsIgnoreCase(umFilme.getTitulo())){
                        System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        //Após isto, fazemos a atualização do cadastro, atribuindo o que o usuário digita em uma variável, que depois será atríbuida em cada atributo do objeto Filme, pelo método set
                        System.out.println("\nATUALIZACAO DOS DADOS: ");

                        try{
                        System.out.print("INFORME O TITULO (SEM CARACTERES ESPECIAIS): ");
                        String novoTitulo = scan.nextLine();

                        /*Para ser alterado no ArrayList tituloFilmeLista também, fizemos um "for loop" que, para cada elemento (umTitulo) em tituloFilmeLista,
                        será feita a condição de se o título do Filme for o mesmo que algum elemento, e se o novoTitulo não estiver no ArrayList tituloFilmeLista, será aplicado o método set com o novoTitulo */
                        for(String umTitulo: tituloFilmeLista) {
                            if (umFilme.getTitulo().equalsIgnoreCase(umTitulo) && !tituloFilmeLista.contains(novoTitulo)){
                                tituloFilmeLista.set(tituloFilmeLista.indexOf(umTitulo), novoTitulo);
                            }
                        }
                        umFilme.setTitulo(novoTitulo);
                        System.out.print("INFORME O DIRETOR (SEM CARACTERES ESPECIAIS): ");
                        String novoDiretor = scan.nextLine();
                        umFilme.setDiretor(novoDiretor);
                        String novoGenero = selecionarGeneroFilme();
                        umFilme.setGenero(novoGenero);
                        String novoClassificacao = selecionarClassificacao();
                        umFilme.setClassificacao(novoClassificacao);
                        System.out.print("INFORME A DURACAO (EM MINUTOS): ");
                        int novoDuracao = scan.nextInt();
                        umFilme.setDuracao(novoDuracao);
                        System.out.print("INFORME A QUANTIDADE DE COPIAS DISPONIVEIS: ");
                        int novoQuantidade = scan.nextInt();
                        umFilme.setQuantidade(novoQuantidade);
                        System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
                        float novoValor = scan.nextFloat();
                        umFilme.setValor(novoValor);

                        } catch (InputMismatchException e){
                            System.out.println("ERRO! VALOR INVALIDO!");
                            System.out.println("ATUALIZACAO INTERROMPIDA, TENTE NOVAMENTE");
                            consultarFilme(listaFilme);
                            return;
                        }
                        System.out.println("\nREGISTRO ATUALIZADO: ");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| ID |                          TITULO                           |               DIRETOR               |           GENERO           | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");
                        System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 7, será solicitado que ele digite o titulo do Filme que deseja remover, e então este valor será atribuído a variável escolhaTitulo
            case 7: System.out.println("\nVOCE SELECIONOU: [7] REMOVER UM FILME DO SISTEMA\n");
                System.out.print("DIGITE O TITULO DO FILME QUE DESEJA REMOVER DO SISTEMA: ");
                try{
                escolhaTitulo = scan.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("ERRO! VALOR INVALIDO!");
                    consultarFilme(listaFilme);
                    return;
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |                          TITULO                           |               DIRETOR               |           GENERO           | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                for(Filme umFilme : listaFilme) {
                    if(escolhaTitulo.equalsIgnoreCase(umFilme.getTitulo())){
                        System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("GOSTARIA DE REMOVER ESTE FILME? DIGITE 'SIM' OU 'NAO':");
                        String opcao = scan.nextLine();

                        //Depois foi feita uma opção, de se o usuário digitar "SIM", o umFilme será removido
                        if(opcao.equalsIgnoreCase("SIM")){

                            listaFilme.remove(umFilme);

                            System.out.println("\nFILME REMOVIDO COM SUCESSO!");
                        } else if (opcao.equalsIgnoreCase("NAO")) {
                            System.out.println("O FILME NAO FOI REMOVIDO DO SISTEMA...");
                            System.out.println("VOLTANDO PARA O SUB-MENU...");
                        }else{
                            System.out.println("OPCAO INVALIDA! ");
                            System.out.println("VOLTANDO PARA O SUB-MENU...");
                        }
                        break;
                    }
                }



            //Caso o usuário digite 8, será impressa uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
            case 8: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
            break;

                //Caso o usuário digite qualquer outro valor, será impressa uma mensagem de alerta
            default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 8 PARA UTILIZAR O SUB-MENU CONSULTAR FILME!\n");
        }
        }while(escolhaConsultarFilme != 8);

    }

    //Criando um método que imprime os atributos titulo, diretor e genero do Filme, e separando-os respectivamente para enquadrar na tabela
    public void imprimirFilme(){

        System.out.printf("|%-60s%-40s%-28s|\n", titulo, diretor, genero);
    }

    //Criando um método que recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void listarFilme(ArrayList<Filme> listaFilme){

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaFilme, e imprima o seu resultado por meio do método imprimirFilme(), para cada umFilme.
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                          TITULO                           |                DIRETOR                |           GENERO           |");
        for (Filme umFilme : listaFilme) {
            umFilme.imprimirFilme();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                         FIM DA CONSULTA                                                        |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
    }

    //Criando um método que ordene os valores do ArrayList tituloFilmeLista de forma alfabetica e depois, compare este mesmo String com o Titulo de algum filme, se for achado, será impresso todos os seus dados
    public static void listarFilmeAlfabeticamente(ArrayList<Filme> listaFilme){

        Collections.sort(tituloFilmeLista);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |                          TITULO                           |               DIRETOR               |           GENERO           | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");
        for(String umTitulo: tituloFilmeLista){

            for(Filme umFilme : listaFilme){
                if(umTitulo.equalsIgnoreCase(umFilme.getTitulo())){
                    System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                }
            }

        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    /*Criando um método que imprimirá um menu de escolha de gênero, e depois,a partir de uma estrutura de decisão "switch case",
    o usuário será convidado a escolher um dos gêneros que foram impressos na tela, este gênero será o retorno, em String, do método.*/
    public static String selecionarGeneroFilme(){

        int escolhaGenero;
        String generoEscolhido;

        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                         SELECIONE O GENERO:                         |");
        System.out.println("|                                                                     |");
        System.out.println("|   [ 1 ] Acao                  [ 2 ] Animacao      [ 3 ] Aventura    |");
        System.out.println("|   [ 4 ] Biografia             [ 5 ] Comedia       [ 6 ] Crime       |");
        System.out.println("|   [ 7 ] Documentario          [ 8 ] Drama         [ 9 ] Fantasia    |");
        System.out.println("|   [10 ] Ficcao Cientifica     [11 ] Faroeste      [12 ] Guerra      |");
        System.out.println("|   [13 ] Musical               [14 ] Romance       [15 ] Suspense    |");
        System.out.println("|   [16 ] Terror                [17 ] Outro                           |");
        System.out.println("|                                                                     |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.print("SUA ESCOLHA: ");

        try{
        escolhaGenero = scan.nextInt();
        } catch (InputMismatchException e){
        System.out.println("ERRO! VALOR INVALIDO!");
        return selecionarGeneroFilme();
        }

        switch (escolhaGenero){
            case 1: generoEscolhido = "Acao";
            break;

            case 2: generoEscolhido = "Animacao";
            break;

            case 3: generoEscolhido = "Aventura";
            break;

            case 4: generoEscolhido = "Biografia";
            break;

            case 5: generoEscolhido = "Comedia";
            break;

            case 6: generoEscolhido = "Crime";
            break;

            case 7: generoEscolhido = "Documentario";
            break;

            case 8: generoEscolhido = "Drama";
            break;

            case 9: generoEscolhido = "Fantasia";
            break;

            case 10: generoEscolhido = "Ficcao Cientifica";
            break;

            case 11: generoEscolhido = "Faroeste";
            break;

            case 12: generoEscolhido = "Guerra";
            break;

            case 13: generoEscolhido = "Musical";
            break;

            case 14: generoEscolhido = "Romance";
            break;

            case 15: generoEscolhido = "Suspense";
            break;

            case 16: generoEscolhido = "Terror";
            break;

            case 17: generoEscolhido = "Outro";
            break;

            default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 17 PARA SELECIONAR O GENERO!\n");
            return selecionarGeneroFilme();

        }
        return generoEscolhido;
    }

}