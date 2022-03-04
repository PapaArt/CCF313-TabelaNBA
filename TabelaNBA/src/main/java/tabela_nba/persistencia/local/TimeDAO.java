
package tabela_nba.persistencia.local;

import java.util.ArrayList;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.interfac.ITimeDAO;

/**
 *
 * @author artur
 * @author vinicius
 */
public class TimeDAO implements ITimeDAO {
    private String nomeTime;
    private int vitorias;
    private int derrotas;
    private int jogos;
    private double porcentagemVitoria;
    private double pontosPorJogo;
    private int posicao;
    private int id;
    private Time.conferenciaTime conferencia;
    private Time.divisao divisao;
    
    private final Time time;
    private ArrayList<Time> listaTimes;
    
    public TimeDAO(String nomeTime, Time.conferenciaTime conferencia, Time.divisao divisao, int idTime){
        time = new Time(nomeTime,conferencia,divisao,idTime);
    }
    

    @Override
    public Time.divisao getTimeDivisao(String nomeTime) {
        for (Time t : listaTimes) {
            if(t.getNomeTime() == null ? nomeTime == null : t.getNomeTime().equals(nomeTime)){
                return t.getDivisao();
            }
        }
        return null;
    }

    @Override
    public Time.conferenciaTime getTimeConferencia(String nomeTime) {
        for (Time t : listaTimes) {
            if(t.getNomeTime() == null ? nomeTime == null : t.getNomeTime().equals(nomeTime)){
                return t.getConferencia() ;
            }
        }
        return null;
    }

    @Override
    public String getTime(int id) {
        for (Time t : listaTimes) {
            if(t.getId() == id){
                return t.getNomeTime();
            }
        }
        return null;
    }
    
}
