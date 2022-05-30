package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Criando a classe Filme
public class Filme {

    //Declarando os atributos
    private int id, duracao, quantidade;
    private String titulo, diretor, classificacao, genero;
    private float valor;

    //Criando um ArrayList idFilmeLista, que irá receber o id de cada Filme em Integer
    static ArrayList<Integer> idFilmeLista = new ArrayList<>();

    //Gerando o construtor
    public Filme(int id, String titulo, String diretor, String genero, String classificacao, int duracao, int quantidade, float valor) {
        this.id = id;
        this.duracao = duracao;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.diretor = diretor;
        this.classificacao = classificacao;
        this.genero = genero;
        this.valor = valor;
    }

    //Gerando os Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    //Criando um método para cadastrar o Filme e que irá retornar um objeto Filme
    public static Filme cadastrarFilme(){

        System.out.println("\nVOCE SELECIONOU: [4] CADASTRAR FILME\n");

        Scanner scan = new Scanner(System.in);

        int id = 3, duracao, quantidade;
        String titulo, diretor, classificacao, genero;
        float valor;

        //Criando uma variável de referência do objeto Filme
        Filme filme;

        //Incrementando o id do Filme, toda vez que o método cadastrarFilme é chamado (o id recebe seu valor por meio do tamanho do ArrayList idFilmeLista)
        id++;
        idFilmeLista.add(id);
        id = idFilmeLista.size();

        System.out.print("INFORME O TITULO (SEM CARACTERES ESPECIAIS): ");
        titulo = scan.nextLine();

        System.out.print("INFORME O DIRETOR (SEM CARACTERES ESPECIAIS): ");
        diretor = scan.nextLine();

        genero = selecionarGenero();

        classificacao = selecionarClassificacao();

        System.out.print("INFORME A DURACAO (EM MINUTOS): ");
        duracao = scan.nextInt();

        System.out.print("INFORME A QUANTIDADE DE COPIAS DISPONIVEIS: ");
        quantidade = scan.nextInt();

        System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
        valor = scan.nextFloat();

        //Instanciando um Objeto Filme na variável filme, com os atributos escolhidos acima
        filme = new Filme(id, titulo, diretor, genero, classificacao, duracao, quantidade, valor);

        //Retornando a variável filme que o objeto Filme foi instanciado
        return filme;

    }

    //Criando um método que abrirá o sub-menu consultarFilme, este método recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void consultarFilme(ArrayList<Filme> listaFilme){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarFilme;
        String escolhaSelecionarGenero, escolhaSelecionarClassificacao, escolhaTitulo;

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 5(sair)
        do{

        System.out.println("-----------------------------------------------------------");
        System.out.println("|                 SUB-MENU CONSULTAR FILME                |");
        System.out.println("|                                                         |");
        System.out.println("|   [1] LISTAR TODOS OS FILMES                            |");
        System.out.println("|   [2] LISTAR FILMES POR GENERO                          |");
        System.out.println("|   [3] LISTAR FILMES POR CLASSIFICACAO INDICATIVA        |");
        System.out.println("|   [4] BUSCAR UM FILME ESPECIFICO                        |");
        System.out.println("|   [5] RETORNAR AO MENU PRINCIPAL                        |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------");

        System.out.print("DIGITE UM NUMERO ENTRE 1 E 5 PARA UTILIZAR O MENU: ");
        escolhaConsultarFilme = scan.nextInt();

        scan.nextLine();

        //Criando uma estrutura de decisão "switch case" que terá a variável "escolhaConsultarFilme" como a variável de controle e selecionará uma das 6 opções dependendo do que o usuário digitou
        switch(escolhaConsultarFilme) {

            //Caso o usuário tenha digitado 1, será executado o método listarFilme no ArrayList listaFilme
            case 1: listarFilme(listaFilme);
                break;

            //Caso o usuário tenha digitado 2, será executado o método selecionarGenero(), e o valor retornado deste será atribuído a variável escolhaSelecionarGenero
            case 2: escolhaSelecionarGenero = selecionarGenero();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |  GENERO  |                          TITULO                           |               DIRETOR               | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo genero seja o mesmo atribuído a variável escolhaSelecionarGenero
                for (Filme umFilme : listaFilme) {
                    if (escolhaSelecionarGenero.equalsIgnoreCase(umFilme.getGenero())) {
                        System.out.printf("|%-5d%-11s%-60s%-38s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getGenero(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 3, será executado o método selecionarClassificacao(), e o valor retornado deste será atribuído a variável escolhaSelecionarClassificacao
            case 3: escolhaSelecionarClassificacao = selecionarClassificacao();
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID | C. INDICATIVA |                          TITULO                           |               DIRETOR               |  GENERO  | DURACAO | QUANTIDADE |  VALOR  |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo classificacao seja o mesmo atribuído a variável escolhaSelecionarClassificacao
                for (Filme umFilme : listaFilme) {
                    if (escolhaSelecionarClassificacao.equalsIgnoreCase(umFilme.getClassificacao())) {
                        System.out.printf("|%-5d%-16s%-60s%-38s%-11s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getClassificacao(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            //Caso o usuário tenha digitado 4, será solicitado que ele digite o título do Filme que deseja buscar, e então este valor será atribuído a variável escolhaTitulo
            case 4: System.out.print("DIGITE O TITULO DO FILME QUE DESEJA BUSCAR: ");
                escolhaTitulo = scan.nextLine();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |                          TITULO                           |               DIRETOR               |  GENERO  | C. INDICATIVA | DURACAO | QUANTIDADE |  VALOR |");

                //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                for (Filme umFilme : listaFilme) {
                    if (escolhaTitulo.equalsIgnoreCase(umFilme.getTitulo())) {
                        System.out.printf("|%-5d%-60s%-38s%-11s%-16s%-10s%-13d%-8.2f|\n", umFilme.getId(), umFilme.getTitulo(), umFilme.getDiretor(), umFilme.getGenero(), umFilme.getClassificacao(), umFilme.getDuracao(), umFilme.getQuantidade(), umFilme.getValor());
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

                //Caso o usuário digite 5, será imprimida uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
            case 5: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
                break;

                //Caso o usuário digite qualquer outro valor, será imprimido uma mensagem de alerta
            default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 5 PARA UTILIZAR O SUB-MENU CONSULTAR FILME!\n");
        }
        }while(escolhaConsultarFilme != 5);

    }

    //Criando um método que imprime os atributos titulo, diretor e genero do Filme, e separando-os respectivamente para enquadrar na tabela
    public void imprimirFilme(){
        				
				System.out.printf("|%-60s%-40s%-10s|\n", titulo, diretor, genero);
    }

    //Criando um método que recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void listarFilme(ArrayList<Filme> listaFilme){

        System.out.println("\nVOCE SELECIONOU: [5] CONSULTAR FILME\n");

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaFilme, e imprima o seu resultado por meio do método imprimirFilme(), para cada umFilme.
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.println("|                          TITULO                           |                DIRETOR                |  GENERO  |");
        for (Filme umFilme : listaFilme) {
            umFilme.imprimirFilme();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                     FIM DA CONSULTA                                          |");
        System.out.println("----------------------------------------------------------------------------------------------------------------\n");
    }

    /*Criando um método que imprimirá um menu de escolha de gênero, e depois,a partir de uma estrutura de decisão "switch case",
    o usuário será convidado a escolher um dos gêneros que foram imprimidos na tela, este gênero será o retorno, em String, do método.*/
    public static String selecionarGenero(){

        int escolhaGenero;
        String generoEscolhido;

        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                         SELECIONE O GENERO:                         |");
        System.out.println("|                                                                     |");
        System.out.println("|   [ 1 ] Acao                  [ 2 ] Animacao      [ 3 ] Aventura    |");
        System.out.println("|   [ 4 ] Biografia             [ 5 ] Comedia       [ 6 ] Crime       |");
        System.out.println("|   [ 7 ] Documentario          [ 7 ] Drama         [ 8 ] Fantasia    |");
        System.out.println("|   [ 9 ] Ficcao Cientifica     [10 ] Faroeste      [11 ] Guerra      |");
        System.out.println("|   [12 ] Musical               [13 ] Romance       [14 ] Suspense    |");
        System.out.println("|   [15 ] Terror                [16 ] Outro                           |");
        System.out.println("|                                                                     |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.print("SUA ESCOLHA: ");
        escolhaGenero = scan.nextInt();

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

            case 7: generoEscolhido = "Drama";
            break;

            case 8: generoEscolhido = "Fantasia";
            break;

            case 9: generoEscolhido = "Ficcao Cientifica";
            break;

            case 10: generoEscolhido = "Faroeste";
            break;

            case 11: generoEscolhido = "Guerra";
            break;

            case 12: generoEscolhido = "Musical";
            break;

            case 13: generoEscolhido = "Romance";
            break;

            case 14: generoEscolhido = "Suspense";
            break;

            case 15: generoEscolhido = "Terror";
            break;

            case 16: generoEscolhido = "Outro";
            break;

            default: generoEscolhido = "Nao Escolhido";
            System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 16 PARA SELECIONAR O GENERO!\n");

        }
        return generoEscolhido;
    }

    /*Criando um método que imprimirá um menu de escolha de classificação indicativa, e depois,a partir de uma estrutura de decisão "switch case",
    o usuário será convidado a escolher uma das classificações que foram imprimidas na tela, esta classificação será o retorno, em String, do método.*/
    public static String selecionarClassificacao(){

        int escolhaClassificacao;
        String classificacaoEscolhida;

        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                SELECIONE A CLASSIFICACAO INDICATIVA:                |");
        System.out.println("|                                                                     |");
        System.out.println("[ 1 ] Livre                 [ 2 ] 10 anos         [ 3 ] 12 anos       |");
        System.out.println("[ 4 ] 14 anos               [ 5 ] 16 anos         [ 6 ] 18 anos       |");
        System.out.println("|                                                                     |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.print("SUA ESCOLHA: ");
        escolhaClassificacao = scan.nextInt();

        switch (escolhaClassificacao){
            case 1: classificacaoEscolhida = "Livre";
                break;

            case 2: classificacaoEscolhida = "10 anos";
                break;

            case 3: classificacaoEscolhida = "12 anos";
                break;

            case 4: classificacaoEscolhida = "14 anos";
                break;

            case 5: classificacaoEscolhida = "16 anos";
                break;

            case 6: classificacaoEscolhida = "18 anos";
                break;

            default: classificacaoEscolhida = "Nao Escolhido";
                System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 6 PARA SELECIONAR A CLASSIFICACAO INDICATIVA!\n");

        }
        return classificacaoEscolhida;
    }

}