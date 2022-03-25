
package tabela_nba.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tabela_nba.modelo.jogadorModelo;

/**
 *
 * @author artur
 */
public class jogadorDAOmysql{

    private final ArrayList<jogadorModelo> listaPlayers;
    
    public jogadorDAOmysql() {
        listaPlayers = new ArrayList();
    }

    public void addPlayer(jogadorModelo p){
        listaPlayers.add(p);
    }
    
    public void inserirJogadores() throws SQLException{
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado!!!");
        }
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
        ResultSet rsJogador = conexao.createStatement().executeQuery("SELECT * FROM jogadores");
        while (rsJogador.next()) {
            listaPlayers.add(new jogadorModelo(Integer.parseInt(rsJogador.getString("idPlayer")), rsJogador.getString("nomeJogador"), Double.parseDouble(rsJogador.getString("altura")), Double.parseDouble(rsJogador.getString("peso")), Double.parseDouble(rsJogador.getString("PPG")), Double.parseDouble(rsJogador.getString("RPG")), Double.parseDouble(rsJogador.getString("APG")), Double.parseDouble(rsJogador.getString("trueShooting"))));
        }
    }
    
    
    public String nomePlayer(int id) {
        return listaPlayers.get(id).getName();
    }

    public double altura(int id) {
        return listaPlayers.get(id).getAltura();
    }

    public double peso(int id) {
        return listaPlayers.get(id).peso();
    }

    public double PPG(int id) {
        return listaPlayers.get(id).getPPG();
    }

    public double RPG(int id) {
        return listaPlayers.get(id).getRPG();
    }

    public double APG(int id) {
        return listaPlayers.get(id).getAPG();
    }

    public double TS(int id) {
        return listaPlayers.get(id).getTS();
    }
    
    
}
