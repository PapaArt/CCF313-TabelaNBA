package tabela_nba.visao;

import java.text.DecimalFormat;
import org.apache.log4j.Logger;
import tabela_nba.controle.tabela_NBA;
import static tabela_nba.controle.tabela_NBA.conferencia;
import tabela_nba.modelo.Time;

/**
 *
 * @author vinicius
 */
public class telaTabela {

    tabela_NBA tabela = new tabela_NBA(conferencia.LESTE);
    private static final Logger LOGGER = Logger.getLogger("NBALogger");

    //PASSAR COMO PARAMENTRO O tabela
    public void listarClassificacao() {

        tabela.ordenaPosicao();

        DecimalFormat formatador = new DecimalFormat("0.00");

        LOGGER.info("Mostrando classificação.");

        System.out.println("CLASSIFICACAO ");
        System.out.println("Times    V  D  %VIT  PPJ");
        LOGGER.info("Mostrando tabela.");
        for (Time nomeTime : tabela.listaTimes) {
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
        LOGGER.info("Inserindo times.");
        tabela.addTime(new Time("Nets", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 0));
        tabela.addTime(new Time("Celtics", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 1));
        tabela.addTime(new Time("76ers", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 2));
        tabela.addTime(new Time("Raptors", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 3));
        tabela.addTime(new Time("Knicks", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO, 4));

        tabela.addTime(new Time("Cavaliers", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 5));
        tabela.addTime(new Time("Pacers", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 6));
        tabela.addTime(new Time("Pistons", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 7));
        tabela.addTime(new Time("Bulls", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 8));
        tabela.addTime(new Time("Bucks", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL, 9));

        tabela.addTime(new Time("Hornets", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 10));
        tabela.addTime(new Time("Heat", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 11));
        tabela.addTime(new Time("Hawks", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 12));
        tabela.addTime(new Time("Wizards", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 13));
        tabela.addTime(new Time("Magic", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE, 14));

        tabela.addTime(new Time("Jazz", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 15));
        tabela.addTime(new Time("Nuggets", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 16));
        tabela.addTime(new Time("Timberwolves", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 17));
        tabela.addTime(new Time("Blazers", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 18));
        tabela.addTime(new Time("Thunder", Time.conferenciaTime.OESTE, Time.divisao.NOROESTE, 19));

        tabela.addTime(new Time("Suns", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 20));
        tabela.addTime(new Time("Warriors", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 21));
        tabela.addTime(new Time("Clippers", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 22));
        tabela.addTime(new Time("Lakers", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 23));
        tabela.addTime(new Time("Kings", Time.conferenciaTime.OESTE, Time.divisao.PACIFICO, 24));

        tabela.addTime(new Time("Grizzlies", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 25));
        tabela.addTime(new Time("Mavericks", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 26));
        tabela.addTime(new Time("Pelicans", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 27));
        tabela.addTime(new Time("Spurs", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 28));
        tabela.addTime(new Time("Rockets", Time.conferenciaTime.OESTE, Time.divisao.SUDOESTE, 29));

        LOGGER.info("Times adicionados.");

        tabela.confrontos();
    }
}
