
package tabela_nba;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static void main(String[] args) {
        Tabela_NBA tabela = new Tabela_NBA();
        
        //int defineQuantidadeJogos = tabela.defineQuantidadeJogos();
//        tabela.time1.ganhou();
//        tabela.time1.aproveitamento();
        tabela.time1.defineNomeTime("Bulls");
        tabela.time1.ganhou();
        tabela.time1.ganhou();
        tabela.time1.ganhou();
        tabela.time1.ganhou();
        tabela.time1.mediaDePontos();
        System.out.println("Nome: "+tabela.time1.getNomeTime());
    }
}