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
import static tabela_nba.controle.TabelaNBA.conferencia;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.local.TabelaDAO;

/**
 *
 * @author vinicius
 */
public class TelaTabela {

    TabelaDAO tabela = new TabelaDAO(conferencia.GERAL);
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
            LOGGER.info("Inserindo times.");
            while (rsTabela.next()) {
                if ("LESTE".equals(rsTabela.getString("conf"))) {
                    if ("ATLANTICO".equals(rsTabela.getString("divi"))) {
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

                    }
                    if ("CENTRAL".equals(rsTabela.getString("divi"))) {
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
                    }
                    if ("SUDESTE".equals(rsTabela.getString("divi"))) {
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
                    }

                } else if ("OESTE".equals(rsTabela.getString("conf"))) {
                    if ("NOROESTE".equals(rsTabela.getString("divi"))) {
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
                    }
                    if ("PACIFICO".equals(rsTabela.getString("divi"))) {
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
                    }
                    if ("SUDOESTE".equals(rsTabela.getString("divi"))) {
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
                    }
                }
                LOGGER.info("Times adicionados.");
            }
            ResultSet rsTabela1 = conexao.createStatement().executeQuery("SELECT periodo FROM times");
            while (rsTabela1.next()) {
                anoTabela = rsTabela1.getString("periodo");
            }
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
            System.out.println("Insira o nome do time: ");
            nomeTime = in.nextLine();
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

            System.out.println("Insira a divisao do time: ");
            divisaoTime = in.nextLine();

            if ("LESTE".equals(conferenciaTime)) {
                if (null != divisaoTime) {
                    if ("ATLANTICO".equals(divisaoTime)) {
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
                    }
                    else if ("CENTRAL".equals(divisaoTime)) {
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
                    }
                    else if ("SUDESTE".equals(divisaoTime)) {
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
                    } else {
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
                            }
                        } while (continua);
                    }
                }
            } else if ("OESTE".equals(conferenciaTime)) {
                if (null != divisaoTime) {
                    if ("NOROESTE".equals(divisaoTime)) {
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
                    }
                    else if ("PACIFICO".equals(divisaoTime)) {
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
                    }
                    else if ("SUDOESTE".equals(divisaoTime)) {
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
                            }
                        } while (continua);
                    }

                }
            }
            LocalDate current_date = LocalDate.now();
            anoTabela = String.valueOf(current_date.getYear());
            listarClassificacao();

        }
    }

    public void menuInicial() {
        System.out.println("");
        System.out.println("-------------------------- MENU --------------------------");
        System.out.println("1 - Visualizar tabelas reais");
        System.out.println("2 - Criar sua própria tabela");
        System.out.println("3 - Sair");
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
