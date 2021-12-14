
package tabela_nba;

import java.util.Scanner;

/**
 *
 * @author artur
 * @author vinicius
 */
public class Tabela_NBA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nomesTimes[] = {"Golden State Warriors","Boston Celtics","Brooklyn Nets","Los Angeles Lakers"};
        
        //conferência: 0 para Leste 1 para Oeste
        int conferencia = 0;
        
        int vitorias = 0;
        int derrotas = 0;
        int jogosAtras = 0; // 0 = sem jogos atrás
        
        double porcentagemVitoria = 0;
        
        
        System.out.println("Indique o confronto:");
        System.out.println("1 para: "+nomesTimes[0]);
        System.out.println("2 para: "+nomesTimes[1]);
        System.out.println("3 para: "+nomesTimes[2]);
        System.out.println("4 para: "+nomesTimes[3]);
        
      
        System.out.print("Time 1: ");
        int time1 = scan.nextInt();
        System.out.print("Time 2: ");
        int time2 = scan.nextInt();
        
        System.out.println("O confronto eh: "+nomesTimes[time1-1]+" contra "+nomesTimes[time2-1]);
        
        
        
    }
}
