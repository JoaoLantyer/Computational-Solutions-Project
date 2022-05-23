package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Filme {

    private int id, duracao, quantidade;
    private String titulo, diretor, classificacao, genero;
    private float valor;

    Scanner scan = new Scanner(System.in);
    static ArrayList<Integer> idFilmeLista = new ArrayList<>();

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

    public static Filme cadastrarFilme(){

        System.out.println("\nVOCÊ SELECIONOU: [4] CADASTRAR FILME\n");

        Scanner scan = new Scanner(System.in);

        int id = 0, duracao, quantidade;
        String titulo, diretor, classificacao, genero;
        float valor;

        Filme filme;

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

        filme = new Filme(id, titulo, diretor, genero, classificacao, duracao, quantidade, valor);

        return filme;

    }

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

    public static void consultarFilme(ArrayList<Filme> listaFilme){

        System.out.println("\nVOCÊ SELECIONOU: [5] CONSULTAR FILME\n");

        for(int i = 0 ; i < listaFilme.size(); i++){
            listaFilme.get(i).imprimirFilme();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("|                    FIM DA CONSULTA                      |");
        System.out.println("-----------------------------------------------------------\n");
    }

}

    /*private int idFilme = 0;

    Scanner scan = new Scanner(System.in);

    //DECLARANDO OS ARRAYLISTS
    static ArrayList<Integer> idFilmeLista = new ArrayList<>();
    static ArrayList<String> tituloLista = new ArrayList<>();
    static ArrayList<String>  diretorLista = new ArrayList<>();
    static ArrayList<Integer>  duracaoLista = new ArrayList<>();
    static ArrayList<String>  classificacaoLista = new ArrayList<>();
    static ArrayList<String>  generoLista = new ArrayList<>();
    static ArrayList<Integer>  quantidadeLista = new ArrayList<>();
    static ArrayList<Float>  valorLista = new ArrayList<>();

    public void cadastrarFilme(){

        System.out.println("\nVOCÊ SELECIONOU: [4] CADASTRAR FILME\n");

        idFilme++;
        idFilmeLista.add(idFilme);

        System.out.print("INFORME O TÍTULO: ");
        String titulo = scan.nextLine();
        tituloLista.add(titulo);

        System.out.print("INFORME O DIRETOR: ");
        String diretor = scan.nextLine();
        diretorLista.add(diretor);

        System.out.print("INFORME O GÊNERO: ");
        String genero = scan.nextLine();
        generoLista.add(genero);

        System.out.print("INFORME A CLASSIFICAÇÃO INDICATIVA: ");
        String classificacao = scan.nextLine();
        classificacaoLista.add(classificacao);

        System.out.print("INFORME A DURAÇÃO (EM MINUTOS): ");
        int duracao = scan.nextInt();
        duracaoLista.add(duracao);

        System.out.print("INFORME A QUANTIDADE DE CÓPIAS DISPONÍVEIS: ");
        int quantidade = scan.nextInt();
        quantidadeLista.add(quantidade);

        System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
        float valor = scan.nextFloat();
        valorLista.add(valor);

        scan.nextLine();



        System.out.println("\nCADASTRO CONCLUIDO!");

    }

    public void consultarFilmes(){

        System.out.println("\nVOCÊ SELECIONOU: [5] CONSULTAR FILME\n");

        System.out.println("==================== DADOS DOS FILMES ===================== \n");

        for (int i = 0 ; i < tituloLista.size(); i++ ){
            System.out.println("-----------------------------------------------------------");
            System.out.println("| ID DO FILME: " + idFilmeLista.get(i));
            System.out.println("| TÍTULO DO FILME: " + tituloLista.get(i));
            System.out.println("| DIRETOR: " + diretorLista.get(i));
            System.out.println("| GÊNERO: " + generoLista.get(i));
            System.out.println("| CLASSIFICAÇÃO INDICATIVA: " + classificacaoLista.get(i));
            System.out.println("| DURAÇÃO: " + duracaoLista.get(i) + " MINUTOS");
            System.out.println("| UNIDADES DISPONÍVEIS: " + quantidadeLista.get(i));
            System.out.println("| VALOR POR UNIDADE: R$ " + valorLista.get(i));
            System.out.println("-----------------------------------------------------------\n");
        }
            System.out.println("-----------------------------------------------------------");
            System.out.println("|                    FIM DA CONSULTA                      |");
            System.out.println("-----------------------------------------------------------\n");

    }
}*/