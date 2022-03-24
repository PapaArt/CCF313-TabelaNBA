package tabela_nba.visao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.apache.log4j.Logger;
import static tabela_nba.controle.TabelaNBA.conferencia;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.local.TabelaDAO;

/**
 *
 * @author vinicius
 */
public class TelaTabela {

    TabelaDAO tabela = new TabelaDAO(conferencia.LESTE);
    private static final Logger LOGGER = Logger.getLogger("NBALogger");

    //PASSAR COMO PARAMENTRO O tabela
    public void listarClassificacao() {

        tabela.ordenaPosicao();

        DecimalFormat formatador = new DecimalFormat("0.00");

        LOGGER.info("Mostrando classificação.");

        System.out.println("CLASSIFICACAO ");
        System.out.println("Times    V  D  %VIT  PPJ");
        LOGGER.info("Mostrando tabela.");
        for (Time nomeTime : tabela.listaTabelas.listaTimes) {
            System.out.print((nomeTime.getPosicao() + 1) + " ");
            System.out.print(nomeTime.getNomeTime() + "   ");
            System.out.print(nomeTime.getVitorias() + " ");
            System.out.print(nomeTime.getDerrotas() + "  ");
            System.out.print(formatador.format((nomeTime.getPorcentagemVitoria()) * 100) + "% ");
            System.out.print(formatador.format(nomeTime.getMediaPontosPorJogo()) + " ");
            System.out.println("");
        }
        LOGGER.info("Tabela apresentada.");
    }

    //PASSAR COMO PARAMENTRO O tabela
    public void telaInserir() {
//        LOGGER.info("Inserindo times.");;
//        tabela.listaTabelas.addTime(new Time("Nets", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 0));
//        tabela.listaTabelas.addTime(new Time("Celtics", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 1));
//        tabela.listaTabelas.addTime(new Time("76ers", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 2));
//        tabela.listaTabelas.addTime(new Time("Raptors", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 3));
//        tabela.listaTabelas.addTime(new Time("Knicks", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 4));
//
//        tabela.listaTabelas.addTime(new Time("Cavaliers", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 5));
//        tabela.listaTabelas.addTime(new Time("Pacers", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 6));
//        tabela.listaTabelas.addTime(new Time("Pistons", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 7));
//        tabela.listaTabelas.addTime(new Time("Bulls", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 8));
//        tabela.listaTabelas.addTime(new Time("Bucks", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 9));
//
//        tabela.listaTabelas.addTime(new Time("Hornets", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 10));
//        tabela.listaTabelas.addTime(new Time("Heat", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 11));
//        tabela.listaTabelas.addTime(new Time("Hawks", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 12));
//        tabela.listaTabelas.addTime(new Time("Wizards", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 13));
//        tabela.listaTabelas.addTime(new Time("Magic", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 14));
//
//        tabela.listaTabelas.addTime(new Time("Jazz", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 15));
//        tabela.listaTabelas.addTime(new Time("Nuggets", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 16));
//        tabela.listaTabelas.addTime(new Time("Timberwolves", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 17));
//        tabela.listaTabelas.addTime(new Time("Blazers", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 18));
//        tabela.listaTabelas.addTime(new Time("Thunder", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 19));
//
//        tabela.listaTabelas.addTime(new Time("Suns", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 20));
//        tabela.listaTabelas.addTime(new Time("Warriors", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 21));
//        tabela.listaTabelas.addTime(new Time("Clippers", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 22));
//        tabela.listaTabelas.addTime(new Time("Lakers", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 23));
//        tabela.listaTabelas.addTime(new Time("Kings", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 24));
//
//        tabela.listaTabelas.addTime(new Time("Grizzlies", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 25));
//        tabela.listaTabelas.addTime(new Time("Mavericks", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 26));
//        tabela.listaTabelas.addTime(new Time("Pelicans", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 27));
//        tabela.listaTabelas.addTime(new Time("Spurs", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 28));
//        tabela.listaTabelas.addTime(new Time("Rockets", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 29));
//
//        LOGGER.info("Times adicionados.");
//
//        //tabela.confrontos();
    }
    
    public void telaInserirBanco() throws SQLException{
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
            //Consulta SQL feita aqui
            ResultSet rsTabela = conexao.createStatement().executeQuery("SELECT * FROM times");
            LOGGER.info("Inserindo times.");
            while(rsTabela.next()){
                if("LESTE".equals(rsTabela.getString("conf"))){
                    if("ATLANTICO".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                        int win, lose, games, ppj;
                        win = Integer.parseInt(rsTabela.getString("vitorias"));
                        lose = Integer.parseInt(rsTabela.getString("derrotas"));
                        games = Integer.parseInt(rsTabela.getString("jogos"));
                        ppj = Integer.parseInt(rsTabela.getString("pontosPorJogo"));
                        
                    }
                    if("CENTRAL".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("SUDESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("NOROESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.NOROESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("PACIFICO".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.PACIFICO, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("SUDOESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.LESTE, Time.divisao.SUDOESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                }else if("OESTE".equals(rsTabela.getString("conf"))){
                    if("ATLANTICO".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.ATLANTICO, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("CENTRAL".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.CENTRAL, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("SUDESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.SUDESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("NOROESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("PACIFICO".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                    if("SUDOESTE".equals(rsTabela.getString("divi"))){
                        tabela.listaTabelas.addTime(new Time(rsTabela.getString("nomeTime"), 
                                Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 
                                Integer.parseInt(rsTabela.getString("idTime"))));
                    }
                }
                LOGGER.info("Times adicionados.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado!!!");
        } catch (SQLException ex) {
            System.out.println("Erro de conexão com o banco: " +ex.getMessage());
        }finally{
            if (conexao != null){
                conexao.close();
            }
        }
    }
}
