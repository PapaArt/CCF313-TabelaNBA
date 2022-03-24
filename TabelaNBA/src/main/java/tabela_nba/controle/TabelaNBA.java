package tabela_nba.controle;

import java.util.ArrayList;
import java.util.Random;
import org.apache.log4j.Logger;
import tabela_nba.modelo.Time;

/**
 *
 * @author artur
 * @author vinicius
 */
public class TabelaNBA {

    private static final Logger LOGGER = Logger.getLogger("NBALogger");

    Random rand = new Random();

    public ArrayList<Time> listaTimes;
    private int quantidadeJogos;

    public enum conferencia {
        LESTE, OESTE, GERAL;
    }

    private conferencia conferencia;

    public TabelaNBA(conferencia nome) {
        listaTimes = new ArrayList();
        this.conferencia = nome;
    }

    public void addTime(Time time) {
        listaTimes.add(time);
    }

    public void mudarConferencia(conferencia novaConferencia) {
        this.conferencia = novaConferencia;
    }

    public conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(conferencia conferencia) {
        this.conferencia = conferencia;
    }

}
