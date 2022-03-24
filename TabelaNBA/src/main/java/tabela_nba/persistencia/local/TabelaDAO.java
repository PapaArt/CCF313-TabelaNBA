package tabela_nba.persistencia.local;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import tabela_nba.controle.TabelaNBA;
import tabela_nba.modelo.Time;
import tabela_nba.visao.TelaTabela;
import tabela_nba.persistencia.interfac.ITabelaDAO;

/**
 *
 * @author artur
 * @author vinicius
 */
public class TabelaDAO implements ITabelaDAO {

    public TabelaNBA listaTabelas;
    private TelaTabela tela;
    private static final Logger LOGGER = Logger.getLogger("NBALogger");

    Random rand = new Random();

    public TabelaDAO(TabelaNBA.conferencia nome) {
        listaTabelas = new TabelaNBA(nome);
    }

    @Override
    public void getTabela() {
        try {
            tela.listarClassificacao();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TabelaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Time pesquisa(int idTime) {
        for (Time t : listaTabelas.listaTimes) {
            if (t.getId() == idTime) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void embates(int idTime1, int idTime2, int vencedor) {
        if (vencedor < 0 || vencedor > 1) {
            LOGGER.error("Insira um time vencedor válido!");
            return;
        }
        if ((pesquisa(idTime1) != null) && (pesquisa(idTime2) != null)) {
            for (Time nomeTime : listaTabelas.listaTimes) {
                if (idTime1 == nomeTime.getId()) {
                    if (vencedor == 0) {
                        nomeTime.incrementaVitorias();
                        nomeTime.incrementaJogos();
                        nomeTime.somaPontosPorJogo(rand.nextInt(20) + 100);
                    } else {
                        nomeTime.incrementaDerrotas();
                        nomeTime.incrementaJogos();
                        nomeTime.somaPontosPorJogo(rand.nextInt(10) + 80);
                    }
                } else if (idTime2 == nomeTime.getId()) {
                    if (vencedor == 1) {
                        nomeTime.incrementaVitorias();
                        nomeTime.incrementaJogos();
                        nomeTime.somaPontosPorJogo(rand.nextInt(10) + 100);
                    } else {
                        nomeTime.incrementaDerrotas();
                        nomeTime.incrementaJogos();
                        nomeTime.somaPontosPorJogo(rand.nextInt(10) + 85);
                    }
                }
            }
        }
    }

    @Override
    public void ordenaPosicao() {
        for (int i = 1; i < listaTabelas.listaTimes.size(); i++) {
            Time novoTime = listaTabelas.listaTimes.get(i);

            for (int j = i; i > 0 && listaTabelas.listaTimes.get(i - 1).getPorcentagemVitoria() < novoTime.getPorcentagemVitoria(); i--) {
                listaTabelas.listaTimes.set(i, listaTabelas.listaTimes.get(i - 1));
            }
            listaTabelas.listaTimes.set(i, novoTime);
            listaTabelas.listaTimes.get(i).setPosicao(i);
        }
    }

}
