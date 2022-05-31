package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//Criando uma classe ClienteControle que herda os atributos da classe Cliente
public class ClienteControle extends Cliente {

    public ClienteControle(String nome, String cpf, String telefone, String email, String cep) {
        super(nome, cpf, telefone, email, cep);
    }

    //Criando um método para cadastrar o Cliente e que irá retornar um objeto Cliente
    public static ClienteControle cadastrarCliente(){

        System.out.println("\nVOCÊ SELECIONOU: [2] CADASTRAR CLIENTE\n");

        Scanner scan = new Scanner(System.in);

        String nome, cpf, telefone, email, cep;

        //Criando uma variável de referência do objeto Cliente
        ClienteControle clienteControl;

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

        //Instanciando um Objeto ClienteControle na variável clienteControl, com os atributos escolhidos acima
        clienteControl = new ClienteControle(nome, cpf, telefone, email, cep);

        System.out.println("\nCADASTRO CONCLUIDO!");

        //Retornando a variável clienteControl que o objeto ClienteControle foi instanciado
        return clienteControl;

    }

    //Criando um método que abrirá o sub-menu consultarCliente, este método recebe um ArrayList de um objeto Cliente, neste caso listaCliente
    public static void consultarCliente(ArrayList<ClienteControle> listaCliente){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarCliente;
        String escolhaCpf;

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 3(sair)
        do {

            System.out.println("-----------------------------------------------------------");
            System.out.println("|                 SUB-MENU CONSULTAR CLIENTE              |");
            System.out.println("|                                                         |");
            System.out.println("|   [1] LISTAR TODOS OS CLIENTES                          |");
            System.out.println("|   [2] BUSCAR UM CLIENTE ESPECIFICO                      |");
            System.out.println("|   [3] RETORNAR AO MENU PRINCIPAL                        |");
            System.out.println("|                                                         |");
            System.out.println("-----------------------------------------------------------");

            System.out.print("DIGITE UM NUMERO ENTRE 1 E 3 PARA UTILIZAR O MENU: ");
            escolhaConsultarCliente = scan.nextInt();

            scan.nextLine();

            //Criando uma estrutura de decisão "switch case" que terá a variável "escolhaConsultarCliente" como a variável de controle e selecionará uma das 4 opções dependendo do que o usuário digitou
            switch(escolhaConsultarCliente){

                //Caso o usuário tenha digitado 1, será executado o método listarCliente no ArrayList listaCliente
                case 1: listarCliente(listaCliente);
                    break;

                //Caso o usuário tenha digitado 4, será solicitado que ele digite o cpf do Cliente que deseja buscar, e então este valor será atribuído a variável escolhaCpf
                case 2:
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA BUSCAR: ");
                    escolhaCpf = scan.nextLine();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaCliente e imprime, para cada umCliente, todos os seus atributos CASO seu atributo cpf seja o mesmo atribuído a variável escolhaCpf
                    for (ClienteControle umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                        }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    break;

                //Caso o usuário digite 3, será imprimida uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
                case 3: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
                    break;

                //Caso o usuário digite qualquer outro valor, será imprimido uma mensagem de alerta
                default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 3 PARA UTILIZAR O SUB-MENU CONSULTAR CLIENTE!\n");

            }

        }while(escolhaConsultarCliente != 3);

    }

    //Criando um método que imprime todos os atributos do Cliente
    public void imprimirCliente(){

        System.out.printf("|%-40s%-14s%-40s|\n", this.nome, this.cpf, this.email);
    }

    //Criando um método que recebe um ArrayList de um objeto ClienteControle, neste caso listaCliente
    public static void listarCliente(ArrayList<ClienteControle> listaCliente){

        System.out.println("\nVOCÊ SELECIONOU: [3] CONSULTAR CLIENTE\n");

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaCliente, e imprima o seu resultado por meio do método imprimirCliente(), para cada umCliente.
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|                   NOME                |     CPF     |                  EMAIL                 |");
        for (ClienteControle umCliente : listaCliente) {
            umCliente.imprimirCliente();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|                                       FIM DA CONSULTA                                        |");
        System.out.println("------------------------------------------------------------------------------------------------\n");
    }
}
