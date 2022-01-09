
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
        
        
        tabela.addTime(new Time("Bulls"));
        

//        tabela.time1.ganhou();
//        tabela.time1.aproveitamento();
 
//        tabela.times[0].setJogos(10);
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaVitorias();
//        tabela.times[0].incrementaDerrotas();
//        tabela.times[0].incrementaDerrotas();
//        tabela.times[0].incrementaDerrotas();
//        tabela.times[0].incrementaDerrotas();
//        tabela.times[0].incrementaDerrotas();
//        tabela.times[0].setPontosPorJogo(PONTOSTOTAIS_TIME1);
//        
//        tabela.times[1].setJogos(10);
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaVitorias();
//        tabela.times[1].incrementaDerrotas();
//        tabela.times[1].incrementaDerrotas();
//        tabela.times[1].incrementaDerrotas();
//        tabela.times[1].setPontosPorJogo(PONTOSTOTAIS_TIME2);
        
        
        System.out.println(" "+tabela.getNomesTimes());
        
//        tabela.ordenaPosicao(tabela.times);
//        tabela.classificacao(tabela.times);
//        
    }
}