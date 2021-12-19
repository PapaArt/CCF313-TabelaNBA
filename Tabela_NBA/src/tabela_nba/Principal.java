
package tabela_nba;

import tabela_nba.Tabela_NBA.Conferencia;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static void main(String[] args) {
        Tabela_NBA tabela = new Tabela_NBA(Conferencia.LESTE);
        
        //int defineQuantidadeJogos = tabela.defineQuantidadeJogos();
//        tabela.time1.ganhou();
//        tabela.time1.aproveitamento();
        tabela.time1.setVitorias(6);
        tabela.time1.setDerrotas(6);
        tabela.time2.setVitorias(7);
        tabela.time2.setDerrotas(3);
        
        System.out.println("Nome time 1: "+tabela.time1.getNomeTime());
        System.out.println();
        System.out.println("get vitorias time 1: " +tabela.time1.getVitorias());
        System.out.println("get derrotas time 1: " +tabela.time1.getDerrotas());
        System.out.println("get jogos time 1: "+tabela.time1.getJogos());
        System.out.println("Porcentagem de vitoria time 1: " + (tabela.time1.getPorcentagemVitoria())* 100 + "%");
        System.out.println();
         System.out.println("Nome time 2: "+tabela.time2.getNomeTime());
        System.out.println("get vitorias time 2: " +tabela.time2.getVitorias());
        System.out.println("get derrotas time 2: " +tabela.time2.getDerrotas());
        System.out.println("get jogos time 2: "+tabela.time2.getJogos());
        System.out.println("Porcentagem de vitoria time 2: " + (tabela.time2.getPorcentagemVitoria())* 100 + "%");
        
    }
}