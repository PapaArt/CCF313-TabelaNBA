
package tabela_nba.persistencia.local;

import java.util.ArrayList;
import tabela_nba.controle.tabela_NBA;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.interfac.ITimeDAO;

/**
 *
 * @author artur
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
    
    private Time time;
    private ArrayList<Time> listaTimes;
    
    public TimeDAO(String nomeTime, Time.conferenciaTime conferencia, Time.divisao divisao, int idTime){
        time = new Time(nomeTime,conferencia,divisao,idTime);
    }
    

    @Override
    public Time.divisao getTimeDivisao(String nomeTime) {
        for (Time t : listaTimes) {
            if(t.getNomeTime() == nomeTime){
                return t.getDivisao();
            }
        }
        return null;
    }

    @Override
    public Time.conferenciaTime getTimeConferencia(String nomeTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTime(int id) {
        for (Time time : listaTimes) {
            if(time.getId() == id){
                return time.getNomeTime();
            }
        }
        return null;
    }
    
    
    
}
