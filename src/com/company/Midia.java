package com.company;

import java.util.Scanner;

public class Midia {
    protected int id, quantidade;
    protected String titulo, genero, classificacao, tipo;
    protected float valor;

    public Midia(int id, int quantidade, String titulo, String classificacao, String tipo, float valor, String genero) {
        this.id = id;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.tipo = tipo;
        this.valor = valor;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
