
package tabela_nba;

import java.util.Scanner;
/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);  
    private Time time1;
    
    private int quantidadeJogos;
    //conferência: 1 para Leste / 0 para Oeste
    
    private String[] nomesTimes = new String[15];
    
        
    enum Conferencia{
        LESTE, OESTE;
    }
    
    private Conferencia conferencia;
    
    public Tabela_NBA(){
        time1 = new Time();
        this.quantidadeJogos = 0;
        this.conferencia = conferencia.LESTE;
        for (int i = 0; i < 15; i++) {
            this.nomesTimes[i] = "";
        }
    }
    
    public void mudarConferencia(Conferencia novaConferencia){
        this.conferencia = novaConferencia;
    }
    
    public int defineQuantidadeJogos(){
        this.quantidadeJogos = time1.numeroJogos();
        
        return quantidadeJogos;
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

    public void setQuantidadeJogos(int quantidadeJogos) {
        this.quantidadeJogos = quantidadeJogos;
    }

    public void setNomesTimes(String[] nomesTimes) {
        this.nomesTimes = nomesTimes;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    

}
