
package tabela_nba;

/**
 *
 * @author vinicius
 */
public class Time {
    private String nomeTime;
    
    //conferência: 0 para Leste 1 para Oeste
    private int conferencia = 0;
        
    private int vitorias = 0;
    private int derrotas = 0;
    private int jogosAtras = 0; // 0 = sem jogos atrás
        
    private double porcentagemVitoria = 0;
}
