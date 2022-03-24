
package tabela_nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        tela.telaInserir();
        
        tela.listarClassificacao();
        
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Drive");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/enderecobanco", "usuario", "password");
            //Consulta SQL feita aqui
            ResultSet rsTabela = conexao.createStatement().executeQuery("SELECT * FROM tabela");
            while(rsTabela.next()){
                System.out.println("Time: " + rsTabela.getString("time"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco não localizado!!!");
        } catch (SQLException ex) {
            System.out.println("Erro de conexão com o banco: " +ex.getMessage());
        }finally{
            if (conexao != null){
                conexao.close();
            }
        }
    }
}