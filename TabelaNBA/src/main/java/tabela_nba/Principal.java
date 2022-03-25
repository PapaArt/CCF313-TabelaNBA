package tabela_nba;

import java.sql.SQLException;
import tabela_nba.visao.TelaTabela;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static void main(String[] args) throws SQLException {
        TelaTabela tela = new TelaTabela();
        

//        tela.telaInserirBanco();
//        tela.listarClassificacao();
        tela.menuDois();

    }
}
