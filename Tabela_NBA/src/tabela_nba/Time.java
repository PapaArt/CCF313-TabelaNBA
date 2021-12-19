
package tabela_nba;

import java.text.DecimalFormat;

/**
 *
 * @author vinicius
 */
public class Time {
    private String nomeTime;
    
    DecimalFormat formatador = new DecimalFormat("0.000");
    
    private int vitorias;
    private int derrotas;
    
    private int jogos;
    //private int jogosAtras; // 0 = sem jogos atrás
        
    private double porcentagemVitoria;
    private double pontosPorJogo;
    
    private int posicao;

    
    public Time(String nomeTime){
        this.nomeTime = nomeTime;
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogos = 0; 
        this.pontosPorJogo = 0;
        this.posicao = 0;
    }
    
    public void defineNomeTime(String time){
        this.nomeTime = time;
    }

    public int posicaoTabela(){
        return this.posicao;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getJogos() {
        return jogos;
    }

    public double getPorcentagemVitoria() {
        this.porcentagemVitoria = (double)this.vitorias/this.jogos;
        return porcentagemVitoria;
    }

    public double getPontosPorJogo() {
        return this.pontosPorJogo/this.jogos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
        this.jogos += vitorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
        this.jogos += derrotas;
    }

//    public void setPorcentagemVitoria(double porcentagemVitoria) {
//        this.porcentagemVitoria = porcentagemVitoria;
//    }
//
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
   
}
