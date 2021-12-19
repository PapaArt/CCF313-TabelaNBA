
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
        tabela.times[0].setVitorias(6);
        tabela.times[0].setDerrotas(6);
        tabela.times[1].setVitorias(7);
        tabela.times[1].setDerrotas(3);
        
        System.out.println("Nome time 1: "+tabela.times[0].getNomeTime());
        System.out.println("Nome time 2: "+tabela.times[1].getNomeTime());
        System.out.println();
        System.out.println("get vitorias time 1: " +tabela.times[0].getVitorias());
        System.out.println("get jogos time 1: "+tabela.times[0].getJogos());
        System.out.println("Porcentagem de vitoria time 1: " + (tabela.times[0].getPorcentagemVitoria())* 100 + "%");
        System.out.println();
        System.out.println("get vitorias time 1: " +tabela.times[1].getVitorias());
        System.out.println("get jogos time 1: "+tabela.times[1].getJogos());
        System.out.println("Porcentagem de vitoria time 1: " + (tabela.times[1].getPorcentagemVitoria())* 100 + "%");
        
    }
}