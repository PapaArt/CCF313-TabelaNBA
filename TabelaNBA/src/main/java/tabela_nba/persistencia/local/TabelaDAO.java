
package tabela_nba.persistencia.local;

import java.util.ArrayList;
import tabela_nba.controle.tabela_NBA;
import tabela_nba.modelo.Time;
import tabela_nba.persistencia.interfac.ITabelaDAO;
import tabela_nba.visao.telaTabela;

/**
 *
 * @author artur
 * @author vinicius
 */
public class TabelaDAO implements ITabelaDAO{
    private final tabela_NBA listaTabelas;
    public ArrayList<Time> listaTimes;
    private tabela_NBA.conferencia conferencia;
    telaTabela tela;
    public TabelaDAO(tabela_NBA.conferencia nome){
        listaTabelas = new tabela_NBA(nome);
    }
    
    @Override
    public void getTabela(tabela_NBA.conferencia nome) {
        if(listaTabelas.getConferencia() == nome){
            tela.listarClassificacao();
        }
    }
    
}
