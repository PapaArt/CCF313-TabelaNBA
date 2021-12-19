
package tabela_nba;

import java.util.Scanner;
/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);  
    Time time1,time2;
    
    private int quantidadeJogos;
    //conferência: 1 para Leste / 0 para Oeste
    
    private String[] nomesTimes = new String[15]; //implementar depois
    
        
    enum Conferencia{
        LESTE, OESTE;
    }
    
    private Conferencia conferencia;
    
    public Tabela_NBA(Conferencia nome){
        nomesTimes[0] = "Bulls";
        nomesTimes[1] = "Lakers";
        time1 = new Time(nomesTimes[0]);
        time2 = new Time(nomesTimes[1]);
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

    public String[] getNomesTimes() {
        return nomesTimes;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setQuantidadeJogos() {
        this.quantidadeJogos = time1.getJogos();
    }

//    public void setNomesTimes(String[] nomesTimes) {
//        this.nomesTimes = nomesTimes;
//    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    
    public void setPosicao(int posicao) {
        if(time1.getPorcentagemVitoria() > time2.getPorcentagemVitoria()){
            time1.setPosicao(1);
        }
  
    }
    

}
