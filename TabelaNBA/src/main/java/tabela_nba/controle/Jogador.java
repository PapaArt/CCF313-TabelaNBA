package tabela_nba.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import tabela_nba.persistencia.mysql.jogadorDAOmysql;

/**
 *
 * @author artur
 */
public class Jogador {

    private final jogadorDAOmysql player;

    public Jogador() {
        player = new jogadorDAOmysql();
    }

    public void preencherBanco() throws SQLException{
        player.inserirJogadores();
    }
    
    public void jogadoresMVP() throws SQLException {
        player.inserirJogadores();

        Connection conexao;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado!!!");
        }
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
        ResultSet rsJogador = conexao.createStatement().executeQuery("SELECT * FROM jogadores");
        System.out.println("");
        System.out.println("MVP");
        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("MVP")) != 0) {
                System.out.println("" + rsJogador.getString("nomeJogador"));
                System.out.println("Número de premiações: " + rsJogador.getString("MVP"));
            }
        }

    }

    public void gamesAllStar() throws SQLException {
        player.inserirJogadores();

        Connection conexao;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado!!!");
        }
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
        ResultSet rsJogador = conexao.createStatement().executeQuery("SELECT * FROM jogadores");
        System.out.println("");
        System.out.println("All Star");
        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("allStar")) != 0) {
                System.out.println("" + rsJogador.getString("nomeJogador"));
                System.out.println("Número de partidas jogadas: " + rsJogador.getString("allStar"));
            } 
        }
    }

    public void melhorDaFinal() throws SQLException {
        player.inserirJogadores();

        Connection conexao;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado!!!");
        }
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
        ResultSet rsJogador = conexao.createStatement().executeQuery("SELECT * FROM jogadores");
        System.out.println("");
        System.out.println("Melhores da Final");
        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("finalMVP")) != 0) {
                System.out.println("" + rsJogador.getString("nomeJogador"));
                System.out.println("Número de premiações: " + rsJogador.getString("finalMVP"));
            }
        }
    }

    public void titulosNBA() throws SQLException {
        player.inserirJogadores();

        Connection conexao;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado!!!");
        }
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba", "root", "password");
        ResultSet rsJogador = conexao.createStatement().executeQuery("SELECT * FROM jogadores");
        System.out.println("");
        System.out.println("Ganhadores da NBA");
        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("titulosNBA")) != 0) {
                System.out.println("" + rsJogador.getString("nomeJogador"));
                System.out.println("Quantidade de títulos: " + rsJogador.getString("titulosNBA"));
            }
        }
    }

    public String nomePlayer(int id){
        return player.nomePlayer(id);
    }

    public double altura(int id) {
        return player.altura(id);
    }

    public double peso(int id) {
        return player.peso(id);
    }

    public double PPG(int id) {
        return player.PPG(id);
    }

    public double RPG(int id) {
        return player.RPG(id);
    }

    public double APG(int id) {
        return player.APG(id);
    }

    public double TS(int id) {
        return player.TS(id);
    }

}
