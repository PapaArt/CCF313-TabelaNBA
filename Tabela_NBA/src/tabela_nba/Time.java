
package tabela_nba;

/**
 *
 * @author vinicius
 */
public class Time {
    private String nomeTime;
    
    //conferência: 0 para Leste 1 para Oeste
    private int conferencia;
    private int vitorias;
    private int derrotas;
    
    private int jogos;
    //private int jogosAtras; // 0 = sem jogos atrás
        
    private double porcentagemVitoria;
    private double pontosPorJogo;
    
    public void iniciarTime(){
        this.nomeTime = "";
        this.conferencia = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogos = 0; 
        this.pontosPorJogo = 0;
    }
    
    public void defineNomeTime(String time){
        this.nomeTime = time;
    }
    
    public void defineConferencia(int conferenciaTime){
        if(conferenciaTime != 0 || conferenciaTime != 1 ){
            System.err.println("");
        }
        this.conferencia = 1;
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
    
    
}
