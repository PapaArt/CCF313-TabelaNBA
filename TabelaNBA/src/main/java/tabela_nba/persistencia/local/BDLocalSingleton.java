
package tabela_nba.persistencia.local;

/**
 *
 * @author artur
 */
public class BDLocalSingleton {
    
    private static BDLocalSingleton BDLocal = new BDLocalSingleton(); 
    
    public static BDLocalSingleton getInstance(){
        return BDLocal;
    }
    
    private BDLocalSingleton(){
        
    }
    
}
