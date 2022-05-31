package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Criando a classe Filme
public class Filme {

    //Declarando os atributos
    protected int id, duracao, quantidade;
    protected String titulo, diretor, classificacao, genero;
    protected float valor;

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

}