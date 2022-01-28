
package tabela_nba;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    
    Scanner scan = new Scanner(System.in);
    
    Random rand = new Random();
    
    public static final int QUANTIDADE_TIMES = (int) 6;
    public static final int QTD_JOGOS = (int) 82;
    

    private ArrayList<Time> listaTimes;
    private int quantidadeJogos;
    
    
    private String nomesTimes; //implementar depois
    
    
        
    enum Conferencia{
        LESTE, OESTE;
    }
    
    
    private Conferencia conferencia;
    
    public Tabela_NBA(Conferencia nome){
        listaTimes = new ArrayList();
        this.conferencia = nome;
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
    
    // vencedor == 0 para time1 && vencedor == 1 para time2
    public void embates(int idTime1, int idTime2, int vencedor){
        if(vencedor < 0 || vencedor > 1){
            System.err.println("Insira um time vencedor válido!");
            
            return;
        }
        
        for(Time nomeTime : listaTimes){
            if(idTime1 == nomeTime.getId()){
                if(vencedor == 0){
                    nomeTime.incrementaVitorias();
                    nomeTime.incrementaJogos();
                }
                else{
                    nomeTime.incrementaDerrotas();
                    nomeTime.incrementaJogos();
                }
            }
            else if(idTime2 == nomeTime.getId()){
                if(vencedor == 1){
                    nomeTime.incrementaVitorias();
                    nomeTime.incrementaJogos();
                }
                else{
                    nomeTime.incrementaDerrotas();
                    nomeTime.incrementaJogos();
                }
            }
        }
    }
    public void confrontos(){
        
        // Selecionar um time aleatorio 'i' e fazer todos os enfrentamentos
        // Os enfrentamentos serao baseados no valor aleatorio 'j' e de acordo
        // com as regras da NBA de sorteio, decidir metodo para vitoria/derrota
        // e decidir metodo de parada
        
        /**
         * 4 jogos contra os outros 4 adversários da divisão (4×4=16 jogos)
         * 4 jogos* contra 6 adversários da conferência (fora da divisão) (4×6=24 jogos)
         * 3 jogos contra as restantes 4 equipas da conferência (3×4=12 jogos)
         * 2 jogos contra equipas da conferência adversária (2×15=30 jogos)
         */
        
        int i = rand.nextInt(QUANTIDADE_TIMES);
        
        do{
            int j = rand.nextInt(QUANTIDADE_TIMES);
            int vencedor = rand.nextInt(2);
            
            if (i != j)
               embates(i, j, vencedor);
            
        }while(listaTimes.get(i).getJogos() != 82);
        
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    
    public void ordenaPosicao(){
        
        for (int i = 1; i < listaTimes.size(); i++){
            Time novoTime = listaTimes.get(i);
            int j;
            for (j = i; i > 0 && listaTimes.get(i-1).getPorcentagemVitoria() < novoTime.getPorcentagemVitoria(); i--){
                listaTimes.set(i, listaTimes.get(i-1));
            }
            listaTimes.set(i, novoTime);
            listaTimes.get(i).setPosicao(i);
        }
    }
    
    void classificacao(){
        
        ordenaPosicao();
        
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        System.out.println("CLASSIFICACAO ");
        System.out.println("Times    V  D  %VIT  PPJ");
        
        for (Time nomeTime : listaTimes){
            System.out.print(+(nomeTime.getPosicao() + 1) + " ");
            System.out.print(nomeTime.getNomeTime() + "   ");
            System.out.print(nomeTime.getVitorias() + " ");
            System.out.print(nomeTime.getDerrotas() + "  ");
            System.out.print(formatador.format((nomeTime.getPorcentagemVitoria())* 100) + "% ");
            System.out.print(formatador.format(nomeTime.getPontosPorJogo()) + " ");
            System.out.println();
        }
    }
}
