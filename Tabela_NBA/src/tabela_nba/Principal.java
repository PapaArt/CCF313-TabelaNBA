
package tabela_nba;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static void main(String[] args) {
        Tabela_NBA tabela = new Tabela_NBA();
        Time team = new Time();
        
        int defineQuantidadeJogos = tabela.defineQuantidadeJogos();
//        tabela.time1.ganhou();
//        tabela.time1.aproveitamento();
        int vitorias = team.ganhou();
        System.out.println("Vitorias: "+vitorias);
        System.out.println("Jogos: "+defineQuantidadeJogos);
    }
}