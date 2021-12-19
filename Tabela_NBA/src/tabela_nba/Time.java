
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

    
    public void iniciarTime(){
        this.nomeTime = "";
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogos = 0; 
        this.pontosPorJogo = 0;
        this.posicao = 0;
    }
    
    public void defineNomeTime(String time){
        this.nomeTime = time;
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
        return porcentagemVitoria;
    }

    public double getPontosPorJogo() {
        return pontosPorJogo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public void setPorcentagemVitoria(double porcentagemVitoria) {
        this.porcentagemVitoria = porcentagemVitoria;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
}
