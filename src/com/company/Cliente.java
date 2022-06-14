package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Criando a classe Cliente
public class Cliente {

    //Declarando os atributos
    private String nome, cpf, telefone, email, cep;

    static ArrayList<String> nomeClienteLista = new ArrayList<>();

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

        System.out.println("\nVOCE SELECIONOU: [2] CADASTRAR CLIENTE\n");

        Scanner scan = new Scanner(System.in);

        String nome, cpf, telefone, email, cep;

        //Criando uma variável de referência do objeto Cliente
        Cliente cliente;

        System.out.print("INFORME A SEGUIR O PRIMEIRO E ULTIMO NOME DO CLIENTE (SEM CARACTERES ESPECIAIS): ");
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

        nomeClienteLista.add(nome);

        System.out.println("\nCADASTRO CONCLUIDO!");

        //Retornando a variável cliente que o objeto Cliente foi instanciado
        return cliente;

    }

    //Criando um método que abrirá o sub-menu consultarCliente, este método recebe um ArrayList de um objeto Cliente, neste caso listaCliente
    public static void consultarCliente(ArrayList<Cliente> listaCliente){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarCliente;
        String escolhaCpf, nomeCliente = "null";

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 3(sair)
        do {

            System.out.println("-----------------------------------------------------------");
            System.out.println("|                 SUB-MENU CONSULTAR CLIENTE              |");
            System.out.println("|                                                         |");
            System.out.println("|   [1] LISTAR TODOS OS CLIENTES                          |");
            System.out.println("|   [2] LISTAR TODOS OS CLIENTES ALFABETICAMENTE          |");
            System.out.println("|   [3] BUSCAR UM CLIENTE ESPECIFICO                      |");
            System.out.println("|   [4] ATUALIZAR O CADASTRO DE UM CLIENTE                |");
            System.out.println("|   [5] REMOVER O CADASTRO DE UM CLIENTE                  |");
            System.out.println("|   [6] RETORNAR AO MENU PRINCIPAL                        |");
            System.out.println("|                                                         |");
            System.out.println("-----------------------------------------------------------");

            System.out.print("DIGITE UM NUMERO ENTRE 1 E 6 PARA UTILIZAR O MENU: ");
            escolhaConsultarCliente = scan.nextInt();

            scan.nextLine();

            //Criando uma estrutura de decisão "switch case" que terá a variável "escolhaConsultarCliente" como a variável de controle e selecionará uma das 4 opções dependendo do que o usuário digitou
            switch(escolhaConsultarCliente){

                //Caso o usuário tenha digitado 1, será executado o método listarCliente no ArrayList listaCliente
                case 1: System.out.println("\nVOCE SELECIONOU: [1] LISTAR TODOS OS CLIENTES\n");
                    listarCliente(listaCliente);
                break;

                case 2: System.out.println("\nVOCE SELECIONOU: [2] LISTAR TODOS OS CLIENTES ALFABETICAMENTE\n");
                    listarClienteAlfabeticamente(listaCliente);
                break;

                //Caso o usuário tenha digitado 3, será solicitado que ele digite o cpf do Cliente que deseja buscar, e então este valor será atribuído a variável escolhaCpf
                case 3: System.out.println("\nVOCE SELECIONOU: [3] BUSCAR UM CLIENTE ESPECIFICO\n");
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA BUSCAR: ");
                    escolhaCpf = scan.nextLine();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaCliente e imprime, para cada umCliente, todos os seus atributos CASO seu atributo cpf seja o mesmo atribuído a variável escolhaCpf
                    for (Cliente umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 4: System.out.println("\nVOCE SELECIONOU: [4] ATUALIZAR UM CLIENTE\n");
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA ATUALIZAR O CADASTRO: ");
                    escolhaCpf = scan.nextLine();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");
                    for (Cliente umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("\nATUALIZACAO DOS DADOS: ");
                            System.out.print("INFORME A SEGUIR O PRIMEIRO E ULTIMO NOME DO CLIENTE (SEM CARACTERES ESPECIAIS): ");
                            String novoNome = scan.nextLine();
                            for(String umNome: nomeClienteLista) {
                                if (umCliente.getNome().equalsIgnoreCase(umNome)){
                                    nomeClienteLista.set(nomeClienteLista.indexOf(umNome), novoNome);
                                }
                            }
                            umCliente.setNome(novoNome);
                            System.out.print("INFORME A SEGUIR O TELEFONE DO CLIENTE: ");
                            String novoTelefone = scan.nextLine();
                            umCliente.setTelefone(novoTelefone);
                            System.out.print("INFORME A SEGUIR O E-MAIL DO CLIENTE: ");
                            String novoEmail = scan.nextLine();
                            umCliente.setEmail(novoEmail);
                            System.out.print("INFORME A SEGUIR O CEP DO CLIENTE: ");
                            String novoCep = scan.nextLine();
                            umCliente.setCep(novoCep);
                            System.out.println("\nREGISTRO ATUALIZADO: ");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("|     CPF      |                    NOME               |   TELEFONE    |                E-MAIL                 |     CEP     |");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), "| " + umCliente.getNome(), "| " + umCliente.getTelefone(), "| " + umCliente.getEmail(), "| " + umCliente.getCep());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                        }
                    }
                    break;

                case 5: System.out.println("\nVOCE SELECIONOU: [5] REMOVER UM CLIENTE DO SISTEMA\n");
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA REMOVER DO SISTEMA: ");
                    escolhaCpf = scan.nextLine();
                    int posicao = 0;
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");
                    for (Cliente umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                            posicao = listaCliente.indexOf(umCliente);
                            nomeCliente = umCliente.getNome();
                        }
                    }

                    System.out.println("GOSTARIA DE REMOVER ESTE CLIENTE? DIGITE 'SIM' OU 'NAO':");
                    String opcao = scan.nextLine();
                    if(opcao.equalsIgnoreCase("SIM")){

                        listaCliente.remove(posicao);
                        nomeClienteLista.remove(nomeCliente);

                        System.out.println("\nCLIENTE REMOVIDO COM SUCESSO!");
                    }else if (opcao.equalsIgnoreCase("NAO")){
                        System.out.println("O CLIENTE NAO FOI REMOVIDO DO SISTEMA...");
                        System.out.println("VOLTANDO PARA O SUB-MENU...");
                    }else{
                        System.out.println("OPCAO INVALIDA! ");
                        System.out.println("VOLTANDO PARA O SUB-MENU...");
                    }
                    break;

                //Caso o usuário digite 6, será imprimida uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
                case 6: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
                break;

                //Caso o usuário digite qualquer outro valor, será imprimido uma mensagem de alerta
                default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 6 PARA UTILIZAR O SUB-MENU CONSULTAR CLIENTE!\n");

            }

        }while(escolhaConsultarCliente != 6);

    }

    //Criando um método que imprime todos os atributos do Cliente
    public void imprimirCliente(){
       
				System.out.printf("|%-40s%-14s%-40s|\n", nome, cpf, email);
    }

    //Criando um método que recebe um ArrayList de um objeto Cliente, neste caso listaCliente
    public static void listarCliente(ArrayList<Cliente> listaCliente){

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaCliente, e imprima o seu resultado por meio do método imprimirCliente(), para cada umCliente.
			 	System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println("|                   NOME                |     CPF     |                  EMAIL                 |");
        for (Cliente umCliente : listaCliente) {
            umCliente.imprimirCliente();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|                                       FIM DA CONSULTA                                        |");
        System.out.println("------------------------------------------------------------------------------------------------\n");
    }


    public static void listarClienteAlfabeticamente(ArrayList<Cliente> listaCliente){

        Collections.sort(nomeClienteLista);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");

        for(String umNome: nomeClienteLista){

            for(Cliente umCliente : listaCliente){
                if(umNome.equalsIgnoreCase(umCliente.getNome())){
                    System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }
}