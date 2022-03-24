
package tabela_nba.modelo;

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
    private int jogosDiv[];
    private int jogosConf[];
    //private int jogosAtras; // 0 = sem jogos atrás
        
    private double porcentagemVitoria;
    private double pontosPorJogo;
    
    private int posicao;
    private int id;

    public enum divisao{
        ATLANTICO, CENTRAL, SUDESTE, NOROESTE, PACIFICO, SUDOESTE;
    }
    
    
    public enum conferenciaTime{
        LESTE, OESTE;
    }
    
    private conferenciaTime conferencia;
    private divisao divisao;
    
    public Time(String nomeTime, conferenciaTime conferencia, divisao divisao, int idTime){
        this.nomeTime = nomeTime;
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogos = 0; 
        this.pontosPorJogo = 0;
        this.posicao = 0;
        this.id = idTime;
        this.conferencia = conferencia;
        this.divisao = divisao;
        this.jogosDiv = new int[4];
        this.jogosConf = new int[10];
        
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
    
    public divisao getDivisao(){
        return divisao;
    }
    
    public double getMediaPontosPorJogo() {
        return (double)this.pontosPorJogo/this.jogos;
    }

    public int getPosicao() {
        return posicao;
    }

    public conferenciaTime getConferencia() {
        return conferencia;
    }
    
    public int getId() {
        return id;
    }
    
    public void incrementaVitorias(){
        this.vitorias += 1;
    }
    
    public void incrementaDerrotas(){
        this.derrotas += 1;
    }

    public void incrementaJogos() {
        this.jogos += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void somaPontosPorJogo(double pontosPorPartida) {
        
        this.pontosPorJogo += pontosPorPartida;
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

    public double getPontosPorJogo() {
        return pontosPorJogo;
    }

    public void setPontosPorJogo(double pontosPorJogo) {
        this.pontosPorJogo = pontosPorJogo;
    }
    
}
