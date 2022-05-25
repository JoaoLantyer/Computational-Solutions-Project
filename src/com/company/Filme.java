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

        System.out.print("INFORME A CLASSIFICACAO INDICATIVA: ");
        classificacao = scan.nextLine();

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

    //Criando um método que imprime todos os atributos do Filme
    public void imprimirFilme(){
        				
				System.out.printf("|%-60s%-40s%-10s|\n", titulo, diretor, genero);
    }

    //Criando um método que recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void consultarFilme(ArrayList<Filme> listaFilme){

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

    public static String selecionarGenero(){

        int escolhaGenero;
        String generoEscolhido;

        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                         SELECIONE O GENERO:                         |");
        System.out.println("|                                                                     |");
        System.out.println("[ 1 ] Acao                  [ 2 ] Animacao      [ 3 ] Aventura        |");
        System.out.println("[ 4 ] Biografia             [ 5 ] Comedia       [ 6 ] Crime           |");
        System.out.println("[ 7 ] Documentario          [ 7 ] Drama         [ 8 ] Fantasia        |");
        System.out.println("[ 9 ] Ficcao Cientifica     [10 ] Faroeste      [11 ] Guerra          |");
        System.out.println("[12 ] Musical               [13 ] Romance       [14 ] Suspense        |");
        System.out.println("[15 ] Terror                [16 ] Outro                               |");
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
}