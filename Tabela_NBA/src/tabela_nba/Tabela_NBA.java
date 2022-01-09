
package tabela_nba;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);  
    
    public static final int QUANTIDADE_TIMES = (int) 2;
    public static final int QTD_JOGOS = (int) 82;
    
    //Time time1,time2;
    //Time[] times = new Time[QUANTIDADE_TIMES];
    private ArrayList<Time> listaTimes;
    private int quantidadeJogos;
    //conferência: 1 para Leste / 0 para Oeste
    
    private String nomesTimes; //implementar depois
    
    
        
    enum Conferencia{
        LESTE, OESTE;
    }
    
    private Conferencia conferencia;
    
    public Tabela_NBA(Conferencia nome){
        listaTimes = new ArrayList();
        this.conferencia = nome;
//        for (int i = 0; i < 15; i++) {
//            this.nomesTimes[i] = "";
//        }
    }
    
    public void addTime(Time time){
        listaTimes.add(time);
    }
    
    public void mudarConferencia(Conferencia novaConferencia){
        this.conferencia = novaConferencia;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setQuantidadeJogosTotal() {
        this.quantidadeJogos = QTD_JOGOS;
    }

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
    
    void classificacao(){
        
        
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        System.out.println("CLASSIFICACAO ");
        System.out.println("Times    V D %VIT  PPJ");
        
        for (Time nomeTime : listaTimes){
            System.out.print(+(nomeTime.getPosicao() + 1) + " ");
            System.out.print(nomeTime.getNomeTime() + " ");
            System.out.print(nomeTime.getVitorias() + " ");
            System.out.print(nomeTime.getDerrotas() + " ");
            System.out.print((nomeTime.getPorcentagemVitoria())* 100 + "% ");
            System.out.print(formatador.format(nomeTime.getPontosPorJogo()) + " ");
            System.out.println();
        }
    }
}
