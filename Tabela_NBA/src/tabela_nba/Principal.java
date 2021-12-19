
package tabela_nba;

import java.text.DecimalFormat;
import tabela_nba.Tabela_NBA.Conferencia;

/**
 *
 * @author vinicius
 */
public class Principal {
    public static final int PONTOSTOTAIS_TIME1 = (int) 1060;
    public static final int PONTOSTOTAIS_TIME2 = (int) 1204;
    public static void main(String[] args) {
        Tabela_NBA tabela = new Tabela_NBA(Conferencia.LESTE);
        
        //int defineQuantidadeJogos = tabela.defineQuantidadeJogos();
//        tabela.time1.ganhou();
//        tabela.time1.aproveitamento();
        tabela.times[0].setVitorias(6);
        tabela.times[0].setDerrotas(4);
        tabela.times[0].setPontosPorJogo(PONTOSTOTAIS_TIME1);
        tabela.times[1].setVitorias(7);
        tabela.times[1].setDerrotas(3);
        tabela.times[1].setPontosPorJogo(PONTOSTOTAIS_TIME2);
        
        DecimalFormat formatador = new DecimalFormat("000.00");
        
        System.out.println("Nome time 1: "+tabela.times[0].getNomeTime());
        System.out.println();
        System.out.println("get vitorias time 1: " +tabela.times[0].getVitorias());
        System.out.println("get derrotas time 1: " +tabela.times[0].getDerrotas());
        System.out.println("get jogos time 1: "+tabela.times[0].getJogos());
        System.out.println("Porcentagem de vitoria time 1: " + (tabela.times[0].getPorcentagemVitoria())* 100 + "%");
        System.out.println("Pontos totais time 1: "+ PONTOSTOTAIS_TIME1);
        System.out.println("Media pontos por jogo time 1: "+ formatador.format(tabela.times[0].getPontosPorJogo()));
        System.out.println();
        System.out.println("Nome time 2: "+tabela.times[1].getNomeTime());
        System.out.println("get vitorias time 2: " +tabela.times[1].getVitorias());
        System.out.println("get vitorias time 2: " +tabela.times[1].getDerrotas());
        System.out.println("get jogos time 2: "+tabela.times[1].getJogos());
        System.out.println("Porcentagem de vitoria time 2: " + (tabela.times[1].getPorcentagemVitoria())* 100 + "%");
        System.out.println("Pontos totais time 2: "+ PONTOSTOTAIS_TIME2);
        System.out.println("Media pontos por jogo time 2: "+ tabela.times[1].getPontosPorJogo());
        System.out.println();
        tabela.insertionSort(tabela.times);
        tabela.printArray(tabela.times);
        
    }
}