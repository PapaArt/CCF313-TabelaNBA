
package tabela_nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import tabela_nba.visao.TelaTabela;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static final int PONTOSTOTAIS_TIME1 = (int) 1060;
    public static final int PONTOSTOTAIS_TIME2 = (int) 1204;
    public static void main(String[] args) throws SQLException {
        TelaTabela tela = new TelaTabela();
        
        //tela.telaInserir();
        tela.telaInserirBanco();
        
        //tela.listarClassificacao();
        
    }
}