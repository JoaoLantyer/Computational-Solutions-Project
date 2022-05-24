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

        System.out.println("\nVOCÊ SELECIONOU: [4] CADASTRAR FILME\n");

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

        System.out.print("INFORME O TÍTULO: ");
        titulo = scan.nextLine();

        System.out.print("INFORME O DIRETOR: ");
        diretor = scan.nextLine();

        System.out.print("INFORME O GÊNERO: ");
        genero = scan.nextLine();

        System.out.print("INFORME A CLASSIFICAÇÃO INDICATIVA: ");
        classificacao = scan.nextLine();

        System.out.print("INFORME A DURAÇÃO (EM MINUTOS): ");
        duracao = scan.nextInt();

        System.out.print("INFORME A QUANTIDADE DE CÓPIAS DISPONÍVEIS: ");
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
        System.out.println("-----------------------------------------------------------");
        System.out.println("| ID DO FILME: " + id);
        System.out.println("| TÍTULO DO FILME: " + titulo);
        System.out.println("| DIRETOR: " + diretor);
        System.out.println("| GÊNERO: " + genero);
        System.out.println("| CLASSIFICAÇÃO INDICATIVA: " + classificacao);
        System.out.println("| DURAÇÃO: " + duracao + " MINUTOS");
        System.out.println("| UNIDADES DISPONÍVEIS: " + quantidade);
        System.out.println("| VALOR POR UNIDADE: R$ " + valor);
        System.out.println("-----------------------------------------------------------\n");
    }

    //Criando um método que recebe um ArrayList de um objeto Filme, neste caso listaFilme
    public static void consultarFilme(ArrayList<Filme> listaFilme){

        System.out.println("\nVOCÊ SELECIONOU: [5] CONSULTAR FILME\n");

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaFilme, e imprima o seu resultado por meio do método imprimirFilme(), para cada umFilme.
        for (Filme umFilme : listaFilme) {
            umFilme.imprimirFilme();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("|                    FIM DA CONSULTA                      |");
        System.out.println("-----------------------------------------------------------\n");
    }
}