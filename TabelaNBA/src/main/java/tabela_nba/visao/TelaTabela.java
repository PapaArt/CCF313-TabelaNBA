package tabela_nba.visao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import tabela_nba.controle.Jogador;
import static tabela_nba.controle.TabelaNBA.conferencia;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.local.TabelaDAO;

/**
 *
 * @author vinicius
 */
public class TelaTabela {

    TabelaDAO tabela = new TabelaDAO(conferencia.GERAL);
    Jogador player = new Jogador();
    private static final Logger LOGGER = Logger.getLogger("NBALogger");

    private String anoTabela;

    //PASSAR COMO PARAMENTRO O tabela
    public void listarClassificacao() {
        tabela.ordenaPosicao();

        DecimalFormat formatador = new DecimalFormat("0.00");

        LOGGER.info("Mostrando classificação.");
        System.out.println("");
        System.out.println("CLASSIFICACAO GERAL DO ANO " + anoTabela);
        System.out.println("Times    V  D  %VIT  PPJ");
        LOGGER.info("Mostrando tabela.");
        for (Time nomeTime : tabela.listaTabelas.listaTimes) {
            System.out.print((nomeTime.getPosicao() + 1) + " ");
            System.out.print(nomeTime.getNomeTime() + "   ");
            System.out.print(nomeTime.getVitorias() + " ");
            System.out.print(nomeTime.getDerrotas() + "  ");
            System.out.print(formatador.format((nomeTime.getPorcentagemVitoria()) * 100) + "% ");
            System.out.print(formatador.format(nomeTime.getPontosPorJogo()) + " ");
            System.out.println("");
        }
        LOGGER.info("Tabela apresentada.");
        tabela.listaTabelas.listaTimes.clear();
    }

    public void telaInserirBanco() throws SQLException {
        int win, lose, game;
        double ppj;

        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
            //Consulta SQL feita aqui
            ResultSet rsTabela = conexao.createStatement().executeQuery("SELECT * FROM times");
            LOGGER.info("Iniciando inserção de times");
            while (rsTabela.next()) {
                if ("LESTE".equals(rsTabela.getString("conf"))) {
                    if ("ATLANTICO".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia leste - atlantico");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia norte - atlantico finalizada");
                    }
                    if ("CENTRAL".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia leste - central");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.LESTE, Time.divisao.CENTRAL,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia leste - central finalizada");
                    }
                    if ("SUDESTE".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia leste - sudeste");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.LESTE, Time.divisao.SUDESTE,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia leste - sudeste finalizada");
                    }

                } else if ("OESTE".equals(rsTabela.getString("conf"))) {
                    if ("NOROESTE".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia oeste - noroeste");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.OESTE, Time.divisao.NOROESTE,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia oeste - noroeste finalizada");
                    }
                    if ("PACIFICO".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia oeste - pacifico");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.OESTE, Time.divisao.PACIFICO,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia oeste - pacifico finalizada");
                    }
                    if ("SUDOESTE".equals(rsTabela.getString("divi"))) {
                        LOGGER.info("Inserindo times da conferencia oeste - sudoeste");
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"),
                                Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE,
                                Integer.parseInt(rsTabela.getString("idTime"))));

                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setVitorias(win);
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setDerrotas(lose);
                        game = Integer.parseInt(rsTabela.getString("jogos"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setJogos(game);
                        ppj = Double.parseDouble(rsTabela.getString("pontosPorJogo"));
                        tabela.listaTabelas.listaTimes.get(Integer.parseInt(rsTabela.getString("idTime"))).setPontosPorJogo(ppj);
                        LOGGER.info("Inserindo times da conferencia oeste - pacifico finalizada");
                    }
                }
                LOGGER.info("Times adicionados.");
            }
            ResultSet rsTabela1 = conexao.createStatement().executeQuery("SELECT periodo FROM times");
            LOGGER.info("Busca pelo ano da tabela");
            while (rsTabela1.next()) {
                anoTabela = rsTabela1.getString("periodo");
            }
            LOGGER.info("Ano da tabela definido");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado!!!");
        } catch (SQLException ex) {
            System.out.println("Erro de conexão com o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
        listarClassificacao();
    }

    public void tabelaPessoal() {
        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("Bem vindo ao sistema de criação da sua própria tabela");
        System.out.println("-----------------------------------------------------");

        Scanner scan = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int qtd;
        int idTime = 0;
        String nomeTime;
        String conferenciaTime;
        String divisaoTime;

        String vitoria;
        String derrota;
        String pontosPorJogo;

        int win = 0;
        int lose = 0;
        int game;
        double ppj;

        boolean continua = true;

        System.out.print("Digite quantos times participarão do campeonato: ");
        qtd = scan.nextInt();

        for (int i = 0; i < qtd; i++) {
            continua = true;
            do {
                System.out.println("Insira o nome do time: ");
                nomeTime = in.nextLine();
                if(nomeTime != null){
                    continua = false;
                }else{
                    System.err.println("ERRO!!! Insira um nome válido");
                }
            } while (continua);
            do {
                System.out.println("Insira a conferencia do time: ");
                conferenciaTime = in.nextLine();
                if ("LESTE".equals(conferenciaTime) || "OESTE".equals(conferenciaTime)) {
                    continua = false;
                } else {
                    System.out.println("");
                    System.err.println("ERRO!!! Insira uma conferencia válida!!! Válidas -> LESTE e OESTE. Em maiúsculo");
                }
            } while (continua);

            if ("LESTE".equals(conferenciaTime)) {
                continua = true;
                do {
                    System.out.println("--------------------------------------------");
                    System.out.println("Insira a divisao do time: ");
                    divisaoTime = in.nextLine();
                    if ("ATLANTICO".equals(divisaoTime) || "CENTRAL".equals(divisaoTime) || "SUDESTE".equals(divisaoTime)) {
                        continua = false;

                    } else {
                        System.out.println("");
                        System.err.println("ERRO!!! Insira uma divisão válida!!! \n"
                                + "Validos-> ATLANTICO, CENTRAL e SUDESTE. Em maiúsculo");
                        System.out.println("");
                    }
                } while (continua);
            } else {
                continua = true;
                do {
                    System.out.println("--------------------------------------------");
                    System.out.println("Insira a divisao do time: ");
                    divisaoTime = in.nextLine();
                    if ("NOROESTE".equals(divisaoTime) || "PACIFICO".equals(divisaoTime) || "SUDOESTE".equals(divisaoTime)) {
                        continua = false;

                    } else {
                        System.out.println("");
                        System.err.println("ERRO!!! Insira uma divisão válida!!! \n"
                                + "Validos-> NOROESTE, PACIFICO e SUDOESTE. Em maiúsculo");
                        System.out.println("");
                    }
                } while (continua);
            }

            if ("LESTE".equals(conferenciaTime)) {

                if ("ATLANTICO".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia leste - atlantico / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia leste - atlantico / interação user concluida");
                }
                if ("CENTRAL".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia leste - central / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.LESTE, Time.divisao.CENTRAL,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia leste - central / interação user concluida");
                }
                if ("SUDESTE".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia leste - sudeste / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.LESTE, Time.divisao.SUDESTE,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia leste - sudeste / interação user concluido");
                }

            } else if ("OESTE".equals(conferenciaTime)) {

                if ("NOROESTE".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia oeste - noroeste / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.OESTE, Time.divisao.NOROESTE,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia oeste - noroeste / interação user concluido");
                }
                if ("PACIFICO".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia oeste - pacifico / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.OESTE, Time.divisao.PACIFICO,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia oeste - pacifico / interação user concludo");
                }
                if ("SUDOESTE".equals(divisaoTime)) {
                    LOGGER.info("Inserindo times da conferencia oeste - sudoeste / interação user");
                    tabela.listaTabelas.addTime(new Time(nomeTime,
                            Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE,
                            idTime));
                    System.out.println("Digite a quantidade de vitorias do seu time");
                    vitoria = in.nextLine();
                    win = Integer.valueOf(vitoria);
                    tabela.listaTabelas.listaTimes.get(idTime).setVitorias(win);
                    System.out.println("Digite a quantidade de derrotas do seu time");
                    derrota = in.nextLine();
                    lose = Integer.valueOf(derrota);
                    tabela.listaTabelas.listaTimes.get(idTime).setDerrotas(lose);
                    game = win + lose;
                    tabela.listaTabelas.listaTimes.get(idTime).setJogos(game);
                    System.out.println("Digite a quantidade de pontos por jogo do seu time");
                    pontosPorJogo = in.nextLine();
                    ppj = Double.valueOf(pontosPorJogo);
                    tabela.listaTabelas.listaTimes.get(idTime).setPontosPorJogo(ppj);
                    idTime += 1;
                    LOGGER.info("Inserindo times da conferencia oeste - sudoeste / interação user concluido");
                }

            }

        }
        LocalDate current_date = LocalDate.now();
        anoTabela = String.valueOf(current_date.getYear());
        listarClassificacao();
    }
    
    public void telaJogadores() throws SQLException{
        System.out.println("");
        System.out.println("-------------------------- JOGADORES --------------------------");
        for(int i = 0; i < 5; i++){
            System.out.println("");
            System.out.println("Id do jogador: "+i);
            System.out.println("Nome do jogador: "+player.nomePlayer(i));
            System.out.println("Altura do jogador: "+player.altura(i));
            System.out.println("Peso do jogador: "+player.peso(i));
            System.out.println("Pontuação por jogo: "+player.PPG(i));
            System.out.println("Rebotes por jogo: "+player.RPG(i));
            System.out.println("Assistências por jogo: "+player.APG(i));
            System.out.println("True Shooting: "+player.TS(i));
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
        }
    }
    
    public void menuJogadores() throws SQLException{
        player.preencherBanco();
        System.out.println("");
        System.out.println("-------------------------- MENU JOGADOR --------------------------");
        System.out.println("1 - Visualizar dados dos jogadores");
        System.out.println("2 - MVP's");
        System.out.println("3 - All-Star games");
        System.out.println("4 - MVP's da final");
        System.out.println("5 - Campeões da NBA");
        System.out.println("6 - Sair");
    }
    
    public void menuJogadores2() throws SQLException{
        boolean continuar = true;
        int opcao;
        Scanner scan = new Scanner(System.in);
        while (true) {
            menuJogadores();
            System.out.print("Opção desejada: ");
            do {
                try {
                    opcao = scan.nextInt();

                    switch (opcao) {
                        case 1:
                            telaJogadores();
                            break;
                        case 2:
                            player.jogadoresMVP();
                            break;
                        case 3:
                            player.gamesAllStar();
                            break;
                        case 4:
                            player.melhorDaFinal();
                            break;
                        case 5:
                            player.titulosNBA();
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.err.println("ERRO! Essa opção é inválida");
                    }
                    continuar = false;
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("ERRO! Insira um valor inteiro");
                    scan.nextLine();
                }
            } while (continuar);
        }
    }

    public void menuInicial() {
        System.out.println("");
        System.out.println("-------------------------- MENU --------------------------");
        System.out.println("1 - Visualizar tabelas reais");
        System.out.println("2 - Criar sua própria tabela");
        System.out.println("3 - Visualizar jogadores");
        System.out.println("4 - Sair");
    }

    public void menuDois() throws SQLException {
        boolean continuar = true;
        int opcao;
        Scanner scan = new Scanner(System.in);
        while (true) {
            menuInicial();
            System.out.print("Opção desejada: ");
            do {
                try {
                    opcao = scan.nextInt();

                    switch (opcao) {
                        case 1:
                            telaInserirBanco();
                            break;
                        case 2:
                            tabelaPessoal();
                            break;
                        case 3:
                            menuJogadores2();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.err.println("ERRO! Essa opção é inválida");
                    }
                    continuar = false;
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("ERRO! Insira um valor inteiro");
                    scan.nextLine();
                }
            } while (continuar);
        }
    }

}
