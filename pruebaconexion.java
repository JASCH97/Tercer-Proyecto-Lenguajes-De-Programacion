
package testjavaprolog;
import java.util.Map;
import org.jpl7.*;

public class Testjavaprolog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Al parecer hay que ejecutar siempre estas 2 líneas antes de realizar consultas
        // Si no, da un error
        Query q = new Query("consult('outfoxed.pl')"); 
        q.hasSolution();
        
        obtenerPersonajes();
        
        // Esto permite hacer una consulta a cierta relación, retorna si tiene solución
        q = new Query("tiene_accesorio(emily, reloj)");
        System.out.println(q.hasSolution());

        
        /*
        // Esta part itera sobre un conjunto de datos
        Map<String, Term>[] res = q.allSolutions();
        
        for(int i = 0; i<res.length; i++){
            System.out.println(res[i]);
        }*/
    }
    
    // Este método retorna los personajes como un HashMap
    public static int obtenerPersonajes(){
        
        Query personajes = new Query("personaje(Persona, X, Y, Z)");
        
        Map<String, Term>[] listaPersonajes = personajes.allSolutions();
        
        for(int i = 0; i<listaPersonajes.length; i++){
            System.out.println(listaPersonajes[i]);
            
        }
        /*
        Variable X = new Variable("X");
        Variable Y = new Variable("Y");
        Variable Z = new Variable("Z");
        Variable nombre = new Variable("Persona");
        Query personajes = new Query("personaje", new Term[] {nombre, X, Y, Z});
        
        Map<String, Term>[] solutions;
        solutions = personajes.allSolutions();
        
        
        
        for(int i = 0; i< solutions.length; i++){
            System.out.println(solutions[i].get("X"));
        }
     */
        return 0;
    }
    
}
