
package tabela_nba;

import java.text.DecimalFormat;
import tabela_nba.Tabela_NBA.Conferencia;
import tabela_nba.Time.ConferenciaTime;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static final int PONTOSTOTAIS_TIME1 = (int) 1060;
    public static final int PONTOSTOTAIS_TIME2 = (int) 1204;
    public static void main(String[] args) {
        Tabela_NBA tabela = new Tabela_NBA(Conferencia.LESTE);
        
        
        tabela.addTime(new Time("Bulls", ConferenciaTime.LESTE, 0));
        tabela.addTime(new Time("Nets", ConferenciaTime.LESTE, 1));
        tabela.addTime(new Time("Heat", ConferenciaTime.LESTE, 2));
        tabela.addTime(new Time("Bucks", ConferenciaTime.LESTE, 3));
        tabela.addTime(new Time("Celtics", ConferenciaTime.LESTE, 4));
        tabela.addTime(new Time("Hornets", ConferenciaTime.LESTE, 5));
        
        
        tabela.confrontos();
        tabela.classificacao();

    }
}