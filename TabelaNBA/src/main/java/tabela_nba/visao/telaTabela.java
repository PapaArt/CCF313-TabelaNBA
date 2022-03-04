    
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
    public void listarClassificacao(){
        
        tabela.ordenaPosicao();
        
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        LOGGER.info("Mostrando classificação.");
        
        System.out.println("CLASSIFICACAO ");
        System.out.println("Times    V  D  %VIT  PPJ");
        LOGGER.info("Mostrando tabela.");
        for (Time nomeTime : tabela.listaTimes){
            System.out.print((nomeTime.getPosicao() + 1) + " ");
            System.out.print(nomeTime.getNomeTime() + "   ");
            System.out.print(nomeTime.getVitorias() + " ");
            System.out.print(nomeTime.getDerrotas() + "  ");
            System.out.print(formatador.format((nomeTime.getPorcentagemVitoria())* 100) + "% ");
            System.out.print(formatador.format(nomeTime.getMediaPontosPorJogo()) + " ");
            System.out.println("");
        }
        LOGGER.info("Tabela apresentada.");
    }
    
    //PASSAR COMO PARAMENTRO O tabela
    public void telaInserir(){
        LOGGER.info("Inserindo times.");
        LOGGER.info("Time 1 adicionado.");
        tabela.addTime(new Time("Bulls", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL,0));
        LOGGER.info("Time 2 adicionado.");
        tabela.addTime(new Time("Nets", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO,1));
        LOGGER.info("Time 3 adicionado.");
        tabela.addTime(new Time("Heat", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE,2));
        LOGGER.info("Time 4 adicionado.");
        tabela.addTime(new Time("Bucks", Time.conferenciaTime.LESTE, Time.divisao.CENTRAL,3));
        LOGGER.info("Time 5 adicionado.");
        tabela.addTime(new Time("Celtics", Time.conferenciaTime.LESTE, Time.divisao.ATLANTICO,4));
        LOGGER.info("Time 6 adicionado.");
        tabela.addTime(new Time("Hornets", Time.conferenciaTime.LESTE, Time.divisao.SUDESTE,5));
        LOGGER.info("Times adicionados.");
        
        tabela.confrontos();
    }
}
