package com.company;

import java.util.*;

//Criando a classe Cliente
public class Cliente {

    //Declarando os atributos
    private String nome, cpf, telefone, email, cep;

    //Criando um Arraylist que receberá única e exclusivamente os nomes dos clientes, para que sejam ordenados alfabeticamente futuramente
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

        try{

        System.out.print("INFORME A SEGUIR O PRIMEIRO E ULTIMO NOME DO CLIENTE (SEM CARACTERES ESPECIAIS): ");
        nome = scan.nextLine().toUpperCase(Locale.ROOT);

        System.out.print("INFORME A SEGUIR O CPF DO CLIENTE: ");
        cpf = scan.nextLine();

        System.out.print("INFORME A SEGUIR O TELEFONE DO CLIENTE: ");
        telefone = scan.nextLine();

        System.out.print("INFORME A SEGUIR O E-MAIL DO CLIENTE: ");
        email = scan.nextLine();

        System.out.print("INFORME A SEGUIR O CEP DO CLIENTE: ");
        cep = scan.nextLine();

        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            System.out.println("O PROGRAMA RETORNARA PARA O INICIO DO CADASTRO!");
            return cadastrarCliente();
        }

        //Instanciando um Objeto Cliente na variável cliente, com os atributos escolhidos acima
        cliente = new Cliente(nome, cpf, telefone, email, cep);

        if(!nomeClienteLista.contains(nome)) {
            nomeClienteLista.add(nome);
        }

        System.out.println("\nCADASTRO CONCLUIDO!");

        //Retornando a variável cliente que o objeto Cliente foi instanciado
        return cliente;

    }

    //Criando um método que abrirá o sub-menu consultarCliente, este método recebe um ArrayList de um objeto Cliente, neste caso listaCliente
    public static void consultarCliente(ArrayList<Cliente> listaCliente){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarCliente;
        String escolhaCpf, nomeCliente = "null";

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 6(sair)
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

                //Caso o usuário tenha digitado 2, será executado o método listarClienteAlfabeticamente no ArrayList listaCliente
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

                //Caso o usuário tenha digitado 4, será solicitado que ele digite o cpf do Cliente que deseja atualizar, e então este valor será atribuído a variável escolhaCpf
                case 4: System.out.println("\nVOCE SELECIONOU: [4] ATUALIZAR UM CLIENTE\n");
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA ATUALIZAR O CADASTRO: ");
                    escolhaCpf = scan.nextLine();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaCliente e imprime, para cada umCliente, todos os seus atributos CASO seu atributo cpf seja o mesmo atribuído a variável escolhaCpf
                    for (Cliente umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                            //Após isto, fazemos a atualização do cadastro, atribuindo o que o usuário digita em uma variável, que depois será atríbuida em cada atributo do objeto cliente, pelo método set
                            System.out.println("\nATUALIZACAO DOS DADOS: ");
                            System.out.print("INFORME A SEGUIR O PRIMEIRO E ULTIMO NOME DO CLIENTE (SEM CARACTERES ESPECIAIS): ");
                            String novoNome = scan.nextLine().toUpperCase(Locale.ROOT);

                            /*Para ser alterado no ArrayList nomeClienteLista também, fizemos um "for loop" que, para cada elemento (umNome) em nomeClienteLista,
                            será feita a condição de se o nome do Cliente for o mesmo que algum elemento, e se o novoNome não estiver no ArrayList nomeClienteLista, será aplicado o método set com o novoNome */
                            for(String umNome: nomeClienteLista) {
                                if (umCliente.getNome().equalsIgnoreCase(umNome) && !nomeClienteLista.contains(novoNome)){
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

                //Caso o usuário tenha digitado 5, será solicitado que ele digite o cpf do Cliente que deseja remover, e então este valor será atribuído a variável escolhaCpf
                case 5: System.out.println("\nVOCE SELECIONOU: [5] REMOVER UM CLIENTE DO SISTEMA\n");
                    System.out.print("DIGITE O CPF DO CLIENTE QUE DESEJA REMOVER DO SISTEMA: ");
                    escolhaCpf = scan.nextLine();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|     CPF     |                   NOME                |   TELEFONE    |                E-MAIL                 |     CEP      |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaCliente e imprime, para cada umCliente, todos os seus atributos CASO seu atributo cpf seja o mesmo atribuído a variável escolhaCpf
                    for (Cliente umCliente : listaCliente) {
                        if (escolhaCpf.equalsIgnoreCase(umCliente.getCpf())) {
                            System.out.printf("|%-14s%-40s%-16s%-40s%-14s|\n", umCliente.getCpf(), umCliente.getNome(), umCliente.getTelefone(), umCliente.getEmail(), umCliente.getCep());
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                            nomeCliente = umCliente.getNome();

                            //Depois foi feita uma opção, de se o usuário digitar "SIM", o Cliente que foi passado anteriormente, será removido
                            System.out.println("GOSTARIA DE REMOVER ESTE CLIENTE? DIGITE 'SIM' OU 'NAO':");
                            String opcao = scan.nextLine();
                            if(opcao.equalsIgnoreCase("SIM")){

                                listaCliente.remove(umCliente);

                                System.out.println("\nCLIENTE REMOVIDO COM SUCESSO!");
                            }else if (opcao.equalsIgnoreCase("NAO")){
                                System.out.println("O CLIENTE NAO FOI REMOVIDO DO SISTEMA...");
                                System.out.println("VOLTANDO PARA O SUB-MENU...");
                            }else{
                                System.out.println("OPCAO INVALIDA! ");
                                System.out.println("VOLTANDO PARA O SUB-MENU...");
                            }
                            break;
                        }
                    }


                //Caso o usuário digite 6, será impressa uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
                case 6: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
                break;

                //Caso o usuário digite qualquer outro valor, será impressa uma mensagem de alerta
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


    //Criando um método que ordene os valores do ArrayList nomeClienteLista de forma alfabetica e depois, compare este mesmo String com o Nome de algum cliente, se for achado, será impresso todos os seus dados
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