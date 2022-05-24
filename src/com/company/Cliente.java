package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Criando a classe Cliente
public class Cliente {

    //Declarando os atributos
    private String nome, cpf, telefone, email, cep;

    //Gerando o construtor
    public Cliente(String nome, String cpf, String telefone, String email, String cep){
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

    //Criando um método para cadastrar o Cliente e que irá retornar um objeto Cliente
    public static Cliente cadastrarCliente(){

        System.out.println("\nVOCÊ SELECIONOU: [2] CADASTRAR CLIENTE\n");

        Scanner scan = new Scanner(System.in);

        String nome, cpf, telefone, email, cep;

        //Criando uma variável de referência do objeto Cliente
        Cliente cliente;

        System.out.print("INFORME A SEGUIR O NOME DO CLIENTE: ");
        nome = scan.nextLine();

        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE: ");
        cpf = scan.nextLine();

        System.out.print("INFORME A SEGUIR O TELEFONE DO CLIENTE: ");
        telefone = scan.nextLine();

        System.out.print("INFORME A SEGUIR O E-MAIL DO CLIENTE: ");
        email = scan.nextLine();

        System.out.print("INFORME A SEGUIR O CEP DO CLIENTE: ");
        cep = scan.nextLine();

        //Instanciando um Objeto Cliente na variável cliente, com os atributos escolhidos acima
        cliente = new Cliente(nome, cpf, telefone, email, cep);

        System.out.println("\nCADASTRO CONCLUIDO!");

        //Retornando a variável cliente que o objeto Cliente foi instanciado
        return cliente;

    }

    //Criando um método que imprime todos os atributos do Cliente
    public void imprimirCliente(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("| NOME: " + nome);
        System.out.println("| CPF: " + cpf);
        System.out.println("| TELEFONE: " + telefone);
        System.out.println("| E-MAIL: " + email);
        System.out.println("| CEP: " + cep);
        System.out.println("-----------------------------------------------------------\n");
    }

    //Criando um método que recebe um ArrayList de um objeto Cliente, neste caso listaCliente
    public static void consultarCliente(ArrayList<Cliente> listaCliente){

        System.out.println("\nVOCÊ SELECIONOU: [3] CONSULTAR CLIENTE\n");

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaCliente, e imprima o seu resultado por meio do método imprimirCliente(), para cada umCliente.
        for (Cliente umCliente : listaCliente) {
            umCliente.imprimirCliente();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("|                    FIM DA CONSULTA                      |");
        System.out.println("-----------------------------------------------------------\n");
    }
}