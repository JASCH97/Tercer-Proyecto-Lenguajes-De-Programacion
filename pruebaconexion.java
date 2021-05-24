/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaprolog;
import java.util.Map;
import org.jpl7.*;

/**
 *
 * @author marco
 */
public class Testjavaprolog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        
        Query q = new Query("consult('outfoxed.pl')");
        q.hasSolution();
        
        q = new Query("tiene_accesorio(emily, reloj)");
        System.out.println(q.hasSolution());
        
        Map<String, Term>[] res = q.allSolutions();
        
        for(int i = 0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
    
}