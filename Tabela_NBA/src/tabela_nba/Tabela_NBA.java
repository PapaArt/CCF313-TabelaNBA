
package tabela_nba;

import java.util.Scanner;
/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);  
    //Time time1,time2;
    Time[] times = new Time[30];
    
    private int quantidadeJogos;
    //conferência: 1 para Leste / 0 para Oeste
    
    private String nomesTimes; //implementar depois
    
        
    enum Conferencia{
        LESTE, OESTE;
    }
    
    private Conferencia conferencia;
    
    public Tabela_NBA(Conferencia nome){
        times[0] = new Time("Bulls");
        times[1] = new Time("Lakers");
        this.conferencia = nome;
//        for (int i = 0; i < 15; i++) {
//            this.nomesTimes[i] = "";
//        }
    }
    
    public void mudarConferencia(Conferencia novaConferencia){
        this.conferencia = novaConferencia;
    }

    public int getQuantidadeJogos() {
        return quantidadeJogos;
    }

    public String getNomesTimes() {
        return nomesTimes;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setQuantidadeJogos() {
        this.quantidadeJogos = times[0].getJogos();
    }

//    public void setNomesTimes(String[] nomesTimes) {
//        this.nomesTimes = nomesTimes;
//    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    
    public void setPosicao(int posicao) {
        if(times[0].getPorcentagemVitoria() > times[1].getPorcentagemVitoria()){
            times[0].setPosicao(1);
        }  
    }
}
