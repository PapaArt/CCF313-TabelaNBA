
package tabela_nba.persistencia.interfac;

import tabela_nba.controle.TabelaNBA.conferencia;
import tabela_nba.modelo.Time;

/**
 *
 * @author artur
 * @author vinicius
 */
public interface ITabelaDAO {
    Time pesquisa(int idTime);
    void embates(int idTime1, int idTime2, int vencedor);
    void ordenaPosicao();
    void getTabela();
    
}
