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
        System.out.println("Banco preenchido com sucesso!!!");
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

        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("MVP")) != 0) {
                System.out.println("Jogadores que já foram MVP: " + rsJogador.getString("nomeJogador"));
                System.out.println("Número de premiações: " + rsJogador.getString("MVP"));
            } else {
                System.out.println("Jogador nunca foi MVP!");
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

        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("allStar")) != 0) {
                System.out.println("Jogadores que já jogaram o All-Star: " + rsJogador.getString("nomeJogador"));
                System.out.println("Número de partidas jogadas: " + rsJogador.getString("allStar"));
            } else {
                System.out.println("Jogador nunca foi escolhido para o All-Star game!");
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

        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("finalMVP")) != 0) {
                System.out.println("Jogadores que foram o melhor em uma final da NBA: " + rsJogador.getString("nomeJogador"));
                System.out.println("Número de premiações: " + rsJogador.getString("finalMVP"));
            } else {
                System.out.println("Jogador não foi o melhor da final ou nunca jogou uma!");
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

        while (rsJogador.next()) {
            if (Integer.parseInt(rsJogador.getString("titulosNBA")) != 0) {
                System.out.println("Jogadores que já ganharam a NBA: " + rsJogador.getString("nomeJogador"));
                System.out.println("Quantidade de títulos: " + rsJogador.getString("titulosNBA"));
            } else {
                System.out.println("Jogador nunca ganhou a NBA!");
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
