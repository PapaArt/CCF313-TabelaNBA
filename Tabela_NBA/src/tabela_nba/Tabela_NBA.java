
package tabela_nba;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);  
    
    public static final int QUANTIDADE_TIMES = (int) 2;
    
    //Time time1,time2;
    Time[] times = new Time[QUANTIDADE_TIMES];
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
    
    public void ordenaPosicao(Time times[]){
        int n = times.length;
        Time[] copiaTimes = times.clone();
        
        for (int i = 1; i < n; i++){
            double key = times[i].getPorcentagemVitoria();
            copiaTimes[i] = times[i];
            int j = i - 1;
            
            while (j >= 0 && times[j].getPorcentagemVitoria() < key){
                times[j+1] = times[j];
                j = j - 1;
            }
            times[j+1] = copiaTimes[i];
        }
    }
    
    public void classificacao(Time times[]){
        int n = times.length;
        
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        for (int i = 0; i < n; i++){
            times[i].setPosicao(i);
        }
        
        System.out.println("CLASSIFICACAO ");
        System.out.println("Times   V   D   %VIT    PPJ");
        
        for (int i = 0; i < n; i++){
            System.out.print(+(times[i].getPosicao() + 1) + " ");
            System.out.print(times[i].getNomeTime() + " ");
            System.out.print(times[i].getVitorias() + " ");
            System.out.print(times[i].getDerrotas() + " ");
            System.out.print((times[i].getPorcentagemVitoria())* 100 + "% ");
            System.out.print(formatador.format(times[i].getPontosPorJogo()) + " ");
            System.out.println();
        }
    }
}
