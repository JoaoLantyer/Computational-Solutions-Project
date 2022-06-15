package com.company;

import java.util.*;

//Criando a classe Jogo, que herda os atributos e métodos da classe Midia
public class Jogo extends Midia{

    //Declarando os atributos
    private String plataforma, desenvolvedor;

    //Criando um ArrayList idFilmeLista, que irá receber o id de cada Jogo em Integer
    static ArrayList<Integer> idJogoLista = new ArrayList<>();

    //Criando um Arraylist que receberá única e exclusivamente os títulos dos jogos, para que sejam ordenados alfabeticamente futuramente
    static ArrayList<String> tituloJogoLista = new ArrayList<>();

    //Gerando o construtor
    public Jogo(int id, int quantidade, String titulo, String classificacao, String tipo, float valor, String genero, String desenvolvedor, String plataforma) {
        super(id, quantidade, titulo, classificacao, tipo, valor, genero);
        this.desenvolvedor = desenvolvedor;
        this.plataforma = plataforma;
    }

    //Gerando os Getters e Setters
    public String getPlataforma() { return plataforma; }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    //Criando um método para cadastrar o Jogo e que irá retornar um objeto Jogo
    public static Jogo cadastrarJogo(){

        System.out.println("\nVOCE SELECIONOU: [6] CADASTRAR JOGO\n");

        Scanner scan = new Scanner(System.in);

        //Declarando as variáveis (o id recebe seu valor do último valor do ArrayList idJogoLista)
        int id = idJogoLista.get(idJogoLista.size() - 1), quantidade;
        String titulo, desenvolvedor,plataforma , classificacao, genero, tipo = "Jogo";
        float valor;

        //Criando uma variável de referência do objeto Jogo
        Jogo jogo;

        //Incrementando o id do Jogo, toda vez que o método cadastrarJogo é chamado (Incrementamos o valor de id, o adicionamos ao ArrayList idJogoLista e atribuímos este último valor a variável id)
        id++;
        idJogoLista.add(id);
        id = idJogoLista.get(idJogoLista.size() - 1);

        try {

        System.out.print("INFORME O TITULO (SEM CARACTERES ESPECIAIS): ");
        titulo = scan.nextLine().toUpperCase(Locale.ROOT);

        System.out.print("INFORME O DESENVOLVEDOR (SEM CARACTERES ESPECIAIS): ");
        desenvolvedor = scan.nextLine();

        plataforma = selecionarPlataformaJogo();

        genero = selecionarGeneroJogo();

        classificacao = selecionarClassificacao();

        System.out.print("INFORME A QUANTIDADE DE COPIAS DISPONIVEIS: ");
        quantidade = scan.nextInt();

        System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
        valor = scan.nextFloat();

        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            System.out.println("O PROGRAMA RETORNARA PARA O INICIO DO CADASTRO!");
            return cadastrarJogo();
        }

        //Instanciando um Objeto Jogo na variável jogo, com os atributos escolhidos acima
        jogo = new Jogo(id, quantidade, titulo, classificacao, tipo, valor, genero, desenvolvedor, plataforma);

        if(!tituloJogoLista.contains(titulo)) {
            tituloJogoLista.add(titulo);
        }

        //Retornando a variável jogo que o objeto Jogo foi instanciado
        return jogo;

    }

    //Criando um método que abrirá o sub-menu consultarJogo, este método recebe um ArrayList de um objeto Jogo, neste caso listaJogo
    public static void consultarJogo(ArrayList<Jogo> listaJogo){

        Scanner scan = new Scanner(System.in);

        int escolhaConsultarJogo;
        String escolhaSelecionarGenero, escolhaSelecionarClassificacao, escolhaSelecionarPlataforma, escolhaTitulo;

        //Criando uma estrutura de repetição "do while" para que o Sub-Menu seja exibido e o usuário possa escolher uma das opções sempre que o número digitado for diferente de 8(sair)
        do{

            System.out.println("-----------------------------------------------------------");
            System.out.println("|                 SUB-MENU CONSULTAR JOGO                 |");
            System.out.println("|                                                         |");
            System.out.println("|   [1] LISTAR TODOS OS JOGOS                             |");
            System.out.println("|   [2] LISTAR TODOS OS JOGOS ALFABETICAMENTE             |");
            System.out.println("|   [3] LISTAR JOGOS POR GENERO                           |");
            System.out.println("|   [4] LISTAR JOGOS POR CLASSIFICACAO INDICATIVA         |");
            System.out.println("|   [5] LISTAR JOGOS POR PLATAFORMA                       |");
            System.out.println("|   [6] BUSCAR UM JOGO ESPECIFICO                         |");
            System.out.println("|   [7] ATUALIZAR UM JOGO                                 |");
            System.out.println("|   [8] REMOVER UM JOGO  DO SISTEMA                       |");
            System.out.println("|   [9] RETORNAR AO MENU PRINCIPAL                        |");
            System.out.println("|                                                         |");
            System.out.println("-----------------------------------------------------------");

            System.out.print("DIGITE UM NUMERO ENTRE 1 E 9 PARA UTILIZAR O MENU: ");

            try{
            escolhaConsultarJogo = scan.nextInt();
            } catch (InputMismatchException e){
                System.out.println("ERRO! VALOR INVALIDO!");
                consultarJogo(listaJogo);
                return;
            }
            scan.nextLine();

            //Criando uma estrutura de decisão "switch case" que terá a variável "escolhaConsultarJogo" como a variável de controle e selecionará uma das 6 opções dependendo do que o usuário digitou
            switch(escolhaConsultarJogo) {

                //Caso o usuário tenha digitado 1, será executado o método listarJogo no ArrayList listaJogo
                case 1: System.out.println("\nVOCE SELECIONOU: [1] LISTAR TODOS OS JOGOS\n");
                    listarJogo(listaJogo);
                    break;

                //Caso o usuário tenha digitado 2, será executado o método listarJogoAlfabeticamente no ArrayList listaJogo
                case 2: System.out.println("\nVOCE SELECIONOU: [2] LISTAR TODOS OS JOGOS ALFABETICAMENTE\n");
                    listarJogoAlfabeticamente(listaJogo);
                break;

                //Caso o usuário tenha digitado 3, será executado o método selecionarGeneroJogo(), e o valor retornado deste será atribuído a variável escolhaSelecionarGenero
                case 3: System.out.println("\nVOCE SELECIONOU: [3] LISTAR JOGOS POR GENERO\n");
                    escolhaSelecionarGenero = selecionarGeneroJogo();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID |           GENERO           |                          TITULO                           |            DESENVOLVEDOR            |  C. INDICATIVA  |       PLATAFORMA       | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaJogo e imprime, para cada umJogo, todos os seus atributos CASO seu atributo genero seja o mesmo atribuído a variável escolhaSelecionarGenero
                    for (Jogo umJogo : listaJogo) {
                        if (escolhaSelecionarGenero.equalsIgnoreCase(umJogo.getGenero())) {
                            System.out.printf("|%-5d%-29s%-60s%-38s%-18s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getGenero(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());                    }
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                //Caso o usuário tenha digitado 3, será executado o método selecionarClassificacao(), e o valor retornado deste será atribuído a variável escolhaSelecionarClassificacao
                case 4: System.out.println("\nVOCE SELECIONOU: [4] LISTAR JOGOS POR CLASSIFICACAO INDICATIVA\n");
                    escolhaSelecionarClassificacao = selecionarClassificacao();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID | C. INDICATIVA |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           |       PLATAFORMA       | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaJogo e imprime, para cada umJogo, todos os seus atributos CASO seu atributo classificacao seja o mesmo atribuído a variável escolhaSelecionarClassificacao
                    for (Jogo umJogo : listaJogo) {
                        if (escolhaSelecionarClassificacao.equalsIgnoreCase(umJogo.getClassificacao())) {
                            System.out.printf("|%-5d%-16s%-60s%-38s%-29s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getClassificacao(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                //Caso o usuário tenha digitado 5, será executado o método selecionarPlataforma(), e o valor retornado deste será atribuído a variável escolhaSelecionarPlataforma
                case 5: System.out.println("\nVOCE SELECIONOU: [5] LISTAR JOGOS POR PLATAFORMA\n");
                    escolhaSelecionarPlataforma = selecionarPlataformaJogo();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID |       PLATAFORMA       |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaJogo e imprime, para cada umJogo, todos os seus atributos CASO seu atributo plataforma seja o mesmo atribuído a variável escolhaSelecionarPlataforma
                    for (Jogo umJogo : listaJogo) {
                        if (escolhaSelecionarPlataforma.equalsIgnoreCase(umJogo.getPlataforma())) {
                            System.out.printf("|%-5d%-25s%-60s%-38s%-29s%-16s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getPlataforma(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getQuantidade(), umJogo.getValor());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                //Caso o usuário tenha digitado 6, será solicitado que ele digite o título do Jogo que deseja buscar, e então este valor será atribuído a variável escolhaTitulo
                case 6: System.out.println("\nVOCE SELECIONOU: [6] BUSCAR UM JOGO ESPECIFICO\n");
                    System.out.print("DIGITE O TITULO DO JOGO QUE DESEJA BUSCAR: ");
                    try{
                    escolhaTitulo = scan.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("ERRO! VALOR INVALIDO!");
                        consultarJogo(listaJogo);
                        return;
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA |       PLATAFORMA       | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaJogo e imprime, para cada umJogo, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                    for (Jogo umJogo : listaJogo) {
                        if (escolhaTitulo.equalsIgnoreCase(umJogo.getTitulo())) {
                            System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                    
                //Caso o usuário tenha digitado 7, será solicitado que ele digite o título do Jogo que deseja atualizar, e então este valor será atribuído a variável escolhaTitulo
                case 7: System.out.println("\nVOCE SELECIONOU: [7] ATUALIZAR UM JOGO\n");
                    System.out.print("DIGITE O TITULO DO JOGO QUE DESEJA ATUALIZAR: ");

                    try{
                    escolhaTitulo = scan.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("ERRO! VALOR INVALIDO!");
                        consultarJogo(listaJogo);
                        return;
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA |       PLATAFORMA       | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaFilme e imprime, para cada umFilme, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                    for(Jogo umJogo : listaJogo) {
                        if (escolhaTitulo.equalsIgnoreCase(umJogo.getTitulo())){
                            System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                            //Após isto, fazemos a atualização do cadastro, atribuindo o que o usuário digita em uma variável, que depois será atríbuida em cada atributo do objeto Jogo, pelo método set
                            System.out.println("\nATUALIZACAO DOS DADOS: ");

                            try{
                            System.out.print("INFORME O TITULO (SEM CARACTERES ESPECIAIS): ");
                            String novoTitulo = scan.nextLine().toUpperCase(Locale.ROOT);
                            
                            /*Para ser alterado no ArrayList tituloJogoLista também, fizemos um "for loop" que, para cada elemento (umTitulo) em tituloJogoLista,
                            será feita a condição de se o nome do Jogo for o mesmo que algum elemento, o elemento nesta posição (index), será aplicado o método set com o novoTitulo */
                            for(String umTitulo: tituloJogoLista) {
                                if (umJogo.getTitulo().equalsIgnoreCase(umTitulo)){
                                    tituloJogoLista.set(tituloJogoLista.indexOf(umTitulo), novoTitulo);
                                }
                            }
                            umJogo.setTitulo(novoTitulo);

                            System.out.print("INFORME O DESENVOLVEDOR (SEM CARACTERES ESPECIAIS): ");
                            String novoDesenvolvedor = scan.nextLine();
                            umJogo.setDesenvolvedor(novoDesenvolvedor);

                            String novoGenero = selecionarGeneroJogo();
                            umJogo.setGenero(novoGenero);

                            String novoPlataforma = selecionarPlataformaJogo();
                            umJogo.setPlataforma(novoPlataforma);

                            String novoClassificacao = selecionarClassificacao();
                            umJogo.setClassificacao(novoClassificacao);

                            System.out.print("INFORME A QUANTIDADE DE COPIAS DISPONIVEIS: ");
                            int novoQuantidade = scan.nextInt();
                            umJogo.setQuantidade(novoQuantidade);
                            System.out.print("INFORME O VALOR DO ALUGUEL POR UNIDADE: ");
                            float novoValor = scan.nextFloat();
                            umJogo.setValor(novoValor);

                            } catch (InputMismatchException e){
                                System.out.println("ERRO! VALOR INVALIDO!");
                                System.out.println("ATUALIZACAO INTERROMPIDA, TENTE NOVAMENTE");
                                consultarJogo(listaJogo);
                                return;
                            }

                            System.out.println("\nREGISTRO ATUALIZADO: ");
                            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("| ID |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA |       PLATAFORMA       | QUANTIDADE |  VALOR |");
                            System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                //Caso o usuário tenha digitado 8, será solicitado que ele digite o titulo do Jogo que deseja remover, e então este valor será atribuído a variável escolhaTitulo
                case 8: System.out.println("\nVOCE SELECIONOU: [8] REMOVER UM JOGO DO SISTEMA\n");
                    System.out.print("DIGITE O TITULO DO JOGO QUE DESEJA REMOVER DO SISTEMA: ");
                    try{
                    escolhaTitulo = scan.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("ERRO! VALOR INVALIDO!");
                        consultarJogo(listaJogo);
                        return;
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| ID |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA |       PLATAFORMA       | QUANTIDADE |  VALOR |");

                    //Então, foi criado um laço de repetição "for each", que percorre o ArrayList listaJogo e imprime, para cada umJogo, todos os seus atributos CASO seu atributo titulo seja o mesmo atribuído a variável escolhaTitulo
                    for(Jogo umJogo : listaJogo) {
                        if(escolhaTitulo.equalsIgnoreCase(umJogo.getTitulo())){
                            System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("GOSTARIA DE REMOVER ESTE JOGO? DIGITE 'SIM' OU 'NAO':");
                            String opcao = scan.nextLine();

                            //Depois foi feita uma opção, de se o usuário digitar "SIM", o umJogo será removido, juntamente com o seu nome no ArrayList tituloJogoLista
                            if(opcao.equalsIgnoreCase("SIM")){
                                listaJogo.remove(umJogo);
                                tituloJogoLista.remove(escolhaTitulo);

                                System.out.println("\nJOGO REMOVIDO COM SUCESSO!");
                            } else if (opcao.equalsIgnoreCase("NAO")) {
                                System.out.println("O JOGO NAO FOI REMOVIDO DO SISTEMA...");
                                System.out.println("VOLTANDO PARA O SUB-MENU...");
                            }else{
                                System.out.println("OPCAO INVALIDA! ");
                                System.out.println("VOLTANDO PARA O SUB-MENU...");
                            }
                            break;
                        }
                    }



                //Caso o usuário digite 9, será imprimida uma mensagem de saída, e a estrutura de repetição "do while" será quebrada, retornando-o ao menu principal
                case 9: System.out.println("\nRETORNANDO AO MENU PRINCIPAL...\n");
                    break;

                //Caso o usuário digite qualquer outro valor, será impressa uma mensagem de alerta
                default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 9 PARA UTILIZAR O SUB-MENU CONSULTAR JOGO!\n");
            }
        }while(escolhaConsultarJogo != 9);

    }

    //Criando um método que imprime os atributos titulo, desenvolvedor e genero do Jogo, e separando-os respectivamente para enquadrar na tabela
    public void imprimirJogo(){

        System.out.printf("|%-60s%-40s%-28s|\n", titulo, desenvolvedor, genero);
    }

    //Criando um método que recebe um ArrayList de um objeto Jogo, neste caso listaJogo
    public static void listarJogo(ArrayList<Jogo> listaJogo){

        //Criando uma estrutura de repetição "for each", que percorre todo o ArrayList listaJogo, e imprima o seu resultado por meio do método imprimirJogo(), para cada umJogo.
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                          TITULO                           |             DESENVOLVEDOR             |           GENERO           |");
        for (Jogo umJogo : listaJogo) {
            umJogo.imprimirJogo();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                         FIM DA CONSULTA                                                        |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
    }

    //Criando um método que ordene os valores do ArrayList tituloJogoLista de forma alfabetica e depois, compare este mesmo String com o Titulo de algum jogo, se for achado, será impresso todos os seus dados
    public static void listarJogoAlfabeticamente(ArrayList<Jogo> listaJogo){

        Collections.sort(tituloJogoLista);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID |                          TITULO                           |            DESENVOLVEDOR            |           GENERO           | C. INDICATIVA |       PLATAFORMA       | QUANTIDADE |  VALOR |");

        for(String umTitulo: tituloJogoLista){

            for(Jogo umJogo : listaJogo){
                if(umTitulo.equalsIgnoreCase(umJogo.getTitulo())){
                    System.out.printf("|%-5d%-60s%-38s%-29s%-16s%-25s%-13d%-8.2f|\n", umJogo.getId(), umJogo.getTitulo(), umJogo.getDesenvolvedor(), umJogo.getGenero(), umJogo.getClassificacao(), umJogo.getPlataforma(), umJogo.getQuantidade(), umJogo.getValor());
                }
            }

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    /*Criando um método que imprimirá um menu de escolha de gênero, e depois,a partir de uma estrutura de decisão "switch case",
    o usuário será convidado a escolher um dos gêneros que foram impressos na tela, este gênero será o retorno, em String, do método.*/
    public static String selecionarGeneroJogo(){

        int escolhaGenero;
        String generoEscolhido;

        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                         SELECIONE O GENERO:                         |");
        System.out.println("|                                                                     |");
        System.out.println("|   [ 1 ] Acao              [ 2 ] Aventura      [ 3 ] Corrida         |");
        System.out.println("|   [ 4 ] Esporte           [ 5 ] Estrategia    [ 6 ] Jogo on-line    |");
        System.out.println("|   [ 7 ] Party Games       [ 8 ] Plataforma    [ 9 ] Quebra-Cabeca   |");
        System.out.println("|   [10 ] Outro                                                       |");
        System.out.println("|                                                                     |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.print("SUA ESCOLHA: ");
        try{
        escolhaGenero = scan.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            return selecionarGeneroJogo();
        }
        switch (escolhaGenero){
            case 1: generoEscolhido = "Acao";
                break;

            case 2: generoEscolhido = "Aventura";
                break;

            case 3: generoEscolhido = "Corrida";
                break;

            case 4: generoEscolhido = "Esporte";
                break;

            case 5: generoEscolhido = "Estrategia";
                break;

            case 6: generoEscolhido = "Jogo on-line";
                break;

            case 7: generoEscolhido = "Party Games";
                break;

            case 8: generoEscolhido = "Plataforma";
                break;

            case 9: generoEscolhido = "Quebra-Cabeca";
                break;

            case 10: generoEscolhido = "Outro";
                break;

            default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 10 PARA SELECIONAR O GENERO!\n");
            return selecionarGeneroJogo();

        }
        return generoEscolhido;
    }

    /*Criando um método que imprimirá um menu de escolha de plataforma, e depois, a partir de uma estrutura de decisão "switch case",
    o usuário será convidado a escolher uma das plataformas que foram imprimidas na tela, esta plataforma será o retorno, em String, do método.*/
    public static String selecionarPlataformaJogo(){

        int escolhaPlataforma;
        String plataformaEscolhida;

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                           SELECIONE A PLATAFORMA:                          |");
        System.out.println("|                                                                            |");
        System.out.println("|   [ 1 ] Nintendo Switch    [ 2 ] Playstation 5     [ 3 ] Xbox Series X/S   |");
        System.out.println("|   [ 4 ] Nintendo Wii U     [ 5 ] Playstation 4     [ 6 ] Xbox One          |");
        System.out.println("|   [ 7 ] Nintendo 3DS       [ 8 ] Playstation Vita  [ 9 ] Xbox 360          |");
        System.out.println("|   [10 ] Nintendo Wii       [11 ] Playstation 3     [12 ] Xbox              |");
        System.out.println("|   [13 ] Nintendo DS        [14 ] PSP               [15 ] Dreamcast         |");
        System.out.println("|   [16 ] Nintendo GameCube  [17 ] Playstation 2     [18 ] Sega Saturn       |");
        System.out.println("|   [19 ] Game Boy Advance   [20 ] Playstation       [21 ] Mega Drive        |");
        System.out.println("|   [22 ] Game Boy Color     [23 ] TurboGrafx-16     [24 ] Sega CD           |");
        System.out.println("|   [25 ] Nintendo 64        [26 ] Intellivision     [27 ] Game Gear         |");
        System.out.println("|   [28 ] Super Nintendo     [29 ] Atari 2600        [30 ] Master System     |");
        System.out.println("|   [31 ] Game Boy           [32 ] PC                [33 ] Outro             |");
        System.out.println("|   [34 ] NES                                                                |");
        System.out.println("|                                                                            |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("SUA ESCOLHA: ");
        try{
        escolhaPlataforma = scan.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERRO! VALOR INVALIDO!");
            return selecionarPlataformaJogo();
        }
        switch (escolhaPlataforma){
            case 1: plataformaEscolhida = "Nintendo Switch";
                break;

            case 2: plataformaEscolhida = "Playstation 5";
                break;

            case 3: plataformaEscolhida = "Xbox Series X/S";
                break;

            case 4: plataformaEscolhida = "Nintendo Wii U";
                break;

            case 5: plataformaEscolhida = "Playstation 4";
                break;

            case 6: plataformaEscolhida = "Xbox One";
                break;

            case 7: plataformaEscolhida = "Nintendo 3DS";
                break;

            case 8: plataformaEscolhida = "Playstation Vita";
                break;

            case 9: plataformaEscolhida = "Xbox 360";
                break;

            case 10: plataformaEscolhida = "Nintendo Wii";
                break;

            case 11: plataformaEscolhida = "Playstation 3";
                break;

            case 12: plataformaEscolhida = "Xbox";
                break;

            case 13: plataformaEscolhida = "Nintendo DS";
                break;

            case 14: plataformaEscolhida = "PSP";
                break;

            case 15: plataformaEscolhida = "Dreamcast";
                break;

            case 16: plataformaEscolhida = "Nintendo GameCube";
                break;

            case 17: plataformaEscolhida = "Playstation 2";
                break;

            case 18: plataformaEscolhida = "Sega Saturn";
                break;

            case 19: plataformaEscolhida = "Game Boy Advance";
                break;

            case 20: plataformaEscolhida = "Playstation";
                break;

            case 21: plataformaEscolhida = "Mega Drive";
                break;

            case 22: plataformaEscolhida = "Game Boy Color";
                break;

            case 23: plataformaEscolhida = "TurboGrafx-16";
                break;

            case 24: plataformaEscolhida = "Sega CD";
                break;

            case 25: plataformaEscolhida = "Nintendo 64";
                break;

            case 26: plataformaEscolhida = "Intellivision";
                break;

            case 27: plataformaEscolhida = "Game Gear";
                break;

            case 28: plataformaEscolhida = "Super Nintendo";
                break;

            case 29: plataformaEscolhida = "Atari 2600";
                break;

            case 30: plataformaEscolhida = "Master System";
                break;

            case 31: plataformaEscolhida = "Game Boy";
                break;

            case 32: plataformaEscolhida = "PC";
                break;

            case 33: plataformaEscolhida = "Outro";
                break;

            case 34: plataformaEscolhida = "NES";
                break;

            default: System.out.println("\n[ALERTA] VOCE DEVE SELECIONAR UM NUMERO ENTRE 1 E 34 PARA SELECIONAR A PLATAFORMA!\n");
            return selecionarPlataformaJogo();


        }
        return plataformaEscolhida;
    }


}
