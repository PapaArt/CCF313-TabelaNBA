
package tabela_nba.persistencia.interfac;

import tabela_nba.controle.tabela_NBA.conferencia;
import tabela_nba.modelo.Time;
import tabela_nba.modelo.Time.conferenciaTime;
import tabela_nba.modelo.Time.divisao;

/**
 *
 * @author artur
 */
public interface ITimeDAO {
    
    String getTime(int id);
    divisao getTimeDivisao(String nomeTime);
    conferenciaTime getTimeConferencia(String nomeTime);

}
