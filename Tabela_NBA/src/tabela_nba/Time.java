
package tabela_nba;

import java.text.DecimalFormat;

/**
 *
 * @author vinicius
 */
public class Time {
    private String nomeTime;
    
    DecimalFormat formatador = new DecimalFormat("0.000");
    //conferência: 0 para Leste 1 para Oeste
    private int conferencia;
    private int vitorias;
    private int derrotas;
    
    private int jogos;
    //private int jogosAtras; // 0 = sem jogos atrás
        
    private double porcentagemVitoria;
    private double pontosPorJogo;
    
    private int posicao;
    
    public void iniciarTime(){
        this.nomeTime = "";
        this.conferencia = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogos = 0; 
        this.pontosPorJogo = 0;
        this.posicao = 0;
    }
    
    public void defineNomeTime(String time){
        this.nomeTime = time;
    }
    
    public void defineConferencia(int conferenciaTime){
        switch (conferenciaTime) {
            case 0:
                this.conferencia = conferenciaTime;
                System.out.println("Conferencia Oeste");
                break;
            case 1:
                this.conferencia = conferenciaTime;
                System.out.println("Conferencia Leste");
                break;
            default:
                System.err.println("Conferência invalida!!!");
                break;
        }
    }
    
    public int ganhou(){
        this.vitorias += 1;
        return this.vitorias;
    }
    
    public int perdeu(){
        this.derrotas += 1;
        return this.vitorias;
    }
    
    public double aproveitamento(){
        this.jogos = this.vitorias + this.derrotas;
        this.porcentagemVitoria = this.vitorias/this.jogos;
        return this.porcentagemVitoria;
    }
    
    public int numeroJogos(){
        this.jogos = this.vitorias + this.derrotas;
        return this.jogos;
    }
    
    public double mediaDePontos(){
        return this.pontosPorJogo/this.jogos;
    } 
    
    public int posicaoTabela(){
        return this.posicao;
    }
}
