package com.company;


//Criando a classe Cliente
public class Cliente {

    //Declarando os atributos em protected, para serem acessados pelo ClienteControle
    protected String nome, cpf, telefone, email, cep;

    //Gerando o construtor
    public Cliente(String nome, String cpf, String telefone, String email, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
    }

    //Gerando os Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}