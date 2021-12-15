
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
    private int conferencia;
    
    private String[] nomesTimes = new String[15];
        
    public Tabela_NBA(){
        time1 = new Time();
        this.quantidadeJogos = 0;
        this.conferencia = 0;
        for (int i = 0; i < 15; i++) {
            this.nomesTimes[i] = "";
        }
    }
    
    public int defineConferencia(int conferenciaTabela){
        switch (conferenciaTabela) {
            case 0:
                this.conferencia = conferenciaTabela;
                System.out.println("Conferencia Oeste");
                return this.conferencia;
            case 1:
                this.conferencia = conferenciaTabela;
                System.out.println("Conferencia Leste");
                return this.conferencia;
            default:
                System.err.println("Conferência invalida!!!");
                return 0;
        }
    }
    
    public int defineQuantidadeJogos(){
        this.quantidadeJogos = time1.numeroJogos();
        
        return quantidadeJogos;
    }

}
