
package tabela_nba.persistencia.interfac;

import tabela_nba.modelo.Time.conferenciaTime;
import tabela_nba.modelo.Time.divisao;

/**
 * 
 * @author artur
 * @author vinicius
 */
public interface ITimeDAO {
    
    String getTime(int id);
    divisao getTimeDivisao(String nomeTime);
    conferenciaTime getTimeConferencia(String nomeTime);

}
