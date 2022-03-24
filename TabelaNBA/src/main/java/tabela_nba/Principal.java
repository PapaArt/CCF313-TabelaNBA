
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
        
        //tela.listarClassificacao();
        
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
            //Consulta SQL feita aqui
            ResultSet rsTabela = conexao.createStatement().executeQuery("SELECT * FROM times");
            while(rsTabela.next()){
                System.out.println("Time: " + rsTabela.getString("nomeTime"));
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