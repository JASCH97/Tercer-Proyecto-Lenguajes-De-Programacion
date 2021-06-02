
package proyecto3;


import java.util.ArrayList;
import org.jpl7.Query;

//En esta clase se realizan las diferentes consultas a prolog.
public class Consulta {
    boolean esPistaCulpable;  //El resultado de cada consulta se guarda en esta variable.
    Query consulta;         //Cada consulta se guarda en esta variable
    String culpable;        //En esta variable se guarda el culpable elegido aleatoriamente por prolog
    ArrayList<String> pistasEncontradas = new ArrayList<>();
    String pistaRandom;
    int largoLista;  //se toma el largo de las lista que tiene las pistas guardadas
    String caraDadoRandom;
    
    
    //metodo que realiza la conexion con prolog. Al parecer hay que hacerla antes de cada consulta.
    public void conexionProlog(){
        String archivo = "consult('proyecto3.pl')";
        Query conexion = new Query (archivo);
        conexion.hasSolution();
        //System.out.println(archivo + " " + (conexion.hasSolution() ? "conexion satisfactoria" : "conexion fallida"));
        
    }
    
    //metodo que realiza una consulta a prolog para eliminar un culpable 
    public void consultaQuitarCulpable(){
        conexionProlog();
        consulta = new Query("quitarCulpable()");
        consulta.hasSolution();
        //System.out.println("Se ha eliminado el culpable" + culpable);
    }
    
    
    //metodo que realiza la consulta correspondiente en prolog para crear un culpable random entre los personajes .
    //El resultado se guarda en 'cupable'
    public void consultaCulpable(){
        conexionProlog();
        consultaQuitarCulpable();  //se resetea el culpable para evitar problemas
        consulta = new Query("culpableRandom()");
        consulta.hasSolution();  //Sin esta linea la consulta se cae
        //System.out.println("culpable random creado" + consulta.hasSolution()); //Linea de debugg, al estar activa se imprime otro culpable
        
        consulta = new Query("culpable(_,aurelio,_,_,_)");
        
        if(consulta.hasSolution() == true){
            this.culpable = "aurelio";
            System.out.println("Aurelio es el culpable");
        }
        
        consulta = new Query("culpable(_,jimena,_,_,_)");
        
        if(consulta.hasSolution() == true){
            this.culpable = "jimena";
            System.out.println("Jimena es el culpable");
        }
        
        consulta = new Query("culpable(_,carlos,_,_,_)");
        
        if(consulta.hasSolution() == true){
            this.culpable = "carlos";
            System.out.println("Carlos es el culpable");
        }
        
        consulta = new Query("culpable(_,emily,_,_,_)");
        
        if(consulta.hasSolution() == true){
            this.culpable = "emily";
            System.out.println("Emily es el culpable");
        }
        
        consulta = new Query("culpable(_,eduardo,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "eduardo";
            System.out.println("Eduardo es el culpable");
        }
        
        consulta = new Query("culpable(_,samanta,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "samanta";
            System.out.println("Samanta es el culpable");
        }
        
        consulta = new Query("culpable(_,alex,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "alex";
            System.out.println("Alex es el culpable");
        }
        
        consulta = new Query("culpable(_,marco,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "marco";
            System.out.println("Marco es el culpable");
        }
        
        consulta = new Query("culpable(_,joan,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "joan";
            System.out.println("Joan es el culpable");
        }
        
        consulta = new Query("culpable(_,tomas,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "tomas";
            System.out.println("Tomas es el culpable");
        }
        
        consulta = new Query("culpable(_,esteban,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "esteban";
            System.out.println("Esteban es el culpable");
        }
        
        consulta = new Query("culpable(_,daniela,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "daniela";
            System.out.println("Daniela es el culpable");
        }
        
        consulta = new Query("culpable(_,alvaro,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "alvaro";
            System.out.println("Alvaro es el culpable");
        }
        
        consulta = new Query("culpable(_,leandro,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "leandro";
            System.out.println("Leandro es el culpable");
        }
        
        consulta = new Query("culpable(_,luis,_,_,_)");
        
        if(consulta.hasSolution() == true){                             
            this.culpable = "luis";
            System.out.println("Luis es el culpable");
        }
        
        consulta = new Query("culpable(_,jaime,_,_,_)");
        if(consulta.hasSolution() == true){
            this.culpable = "jaime";
            System.out.println("Jaime es el culpable");
        }
        
        
    }
    
    
    //metodo que consulta a prolog si una pista corresponde al culpable y guarda el resultado de la consulta en 'esPistaCulpable'
    public void consultaDecifradorPistas(int i){  //el i representa el # asociado a cada accesorio
        conexionProlog();
        
        switch (i) 
        {
            case 1:  i = 1;
                     consulta = new Query("decifradorPistas(azul)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 2:  i = 2;
                     consulta = new Query("decifradorPistas(rojo)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 3:  i = 3;
                     consulta = new Query("decifradorPistas(verde)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 4:  i = 4;
                     consulta = new Query("decifradorPistas(rosado)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 5:  i = 5;
                     consulta = new Query("decifradorPistas(cuernos)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 6:  i = 6;
                     consulta = new Query("decifradorPistas(queso)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 7:  i = 7;
                     consulta = new Query("decifradorPistas(huevo)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 8:  i = 8;
                     consulta = new Query("decifradorPistas(banano)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 9:  i = 9;
                     consulta = new Query("decifradorPistas(trajeDoctor)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 10:  i = 10;
                     consulta = new Query("decifradorPistas(trajePolicia)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 11:  i = 11;
                     consulta = new Query("decifradorPistas(trajeNegro)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break;
                     
            case 12:  i = 12;
                     consulta = new Query("decifradorPistas(trajeBlanco)");
                     this.esPistaCulpable = consulta.hasSolution();
                     break; 
                     
            
            default: System.out.println("Numero de accesorio incorrecto");
                     break;
        }
       
    }   
    
    
    //metodo para consultar a prolog por una pista aleatoria y guardarla en la variable global pistaRandom 
    public void consultaPistaRandom(){
        conexionProlog();
        
        consultaQuitarPistaRandom();                    //se setea la pista random para que no caiga en bucle
        consulta = new Query("generarPistaRandom()");
        consulta.hasSolution();
        
        int resultadoPista = consultaPistaRandomAux();
        int largoLista = pistasEncontradas.size();
        
        if(resultadoPista == 0){
            consultaPistaRandom();
        }
        
        if(largoLista == 12){
            System.out.println("Todas las pistas fueron encontradas");
        }
        
        else{
        
            switch(resultadoPista){
                case 1: resultadoPista = 1;
                        if(existePista("azul") == false){
                            this.pistasEncontradas.add("azul");
                            this.pistaRandom = "azul";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 2: resultadoPista = 2;
                        if(existePista("rojo") == false){
                            this.pistasEncontradas.add("rojo");
                            this.pistaRandom = "rojo";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 3: resultadoPista = 3;
                        if(existePista("verde") == false){
                            this.pistasEncontradas.add("verde");
                            this.pistaRandom = "verde";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 4: resultadoPista = 4;
                        if(existePista("rosado") == false){
                            this.pistasEncontradas.add("rosado");
                            this.pistaRandom = "rosado";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 5: resultadoPista = 5;
                        if(existePista("cuernos") == false){
                            this.pistasEncontradas.add("cuernos");
                            this.pistaRandom = "cuernos";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 6: resultadoPista = 6;
                        if(existePista("queso") == false){
                            this.pistasEncontradas.add("queso");
                            this.pistaRandom = "queso";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 7: resultadoPista = 7;
                        if(existePista("huevo") == false){
                            this.pistasEncontradas.add("huevo");
                            this.pistaRandom = "huevo";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 8: resultadoPista = 8;
                        if(existePista("banano") == false){
                            this.pistasEncontradas.add("banano");
                            this.pistaRandom = "banano";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 9: resultadoPista = 9;
                        if(existePista("trajeDoctor") == false){
                            this.pistasEncontradas.add("trajeDoctor");
                            this.pistaRandom = "trajeDoctor";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 10: resultadoPista = 10;
                        if(existePista("trajePolicia") == false){
                            this.pistasEncontradas.add("trajePolicia");
                            this.pistaRandom = "trajePolicia";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 11: resultadoPista = 11;
                        if(existePista("trajeNegro") == false){
                            this.pistasEncontradas.add("trajeNegro");
                            this.pistaRandom = "trajeNegro";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                case 12: resultadoPista = 12;
                        if(existePista("trajeBlanco") == false){
                            this.pistasEncontradas.add("trajeBlanco");
                            this.pistaRandom = "trajeBlanco";
                            this.largoLista++;
                        }
                        else{
                            consultaPistaRandom();
                        }
                        break;
                        
                default: System.out.println("Error inesperado?");
                         break;
                
            }
        
        
        }
        
        
            

    }
    
    //metodo auxiliar de consultarPistaRandom de retorna un numero del 1 al 12 asociado a una pista diferente
    public int consultaPistaRandomAux(){
        Query consulta1 = new Query("pistaRandom(_,azul)");
        if(consulta1.hasSolution() == true){
            return 1;
        }
        
        Query consulta2 = new Query("pistaRandom(_,rojo)");
        if(consulta2.hasSolution() == true){
            return 2;
        }
        
        Query consulta3 = new Query("pistaRandom(_,verde)");
        if(consulta3.hasSolution() == true){
            return 3;
        }
        
        Query consulta4 = new Query("pistaRandom(_,rosado)");
        if(consulta4.hasSolution() == true){
            return 4;
        }
        
        Query consulta5 = new Query("pistaRandom(_,cuernos)");
        if(consulta5.hasSolution() == true){
            return 5;
        }
        
        Query consulta6 = new Query("pistaRandom(_,queso)");
        if(consulta6.hasSolution() == true){
            return 6;
        }
        
        Query consulta7 = new Query("pistaRandom(_,huevo)");
        if(consulta7.hasSolution() == true){
            return 7;
        }
        
        Query consulta8 = new Query("pistaRandom(_,banano)");
        if(consulta8.hasSolution() == true){
            return 8;
        }
        
        Query consulta9 = new Query("pistaRandom(_,trajeDoctor)");
        if(consulta9.hasSolution() == true){
            return 9;
        }
        
        Query consulta10 = new Query("pistaRandom(_,trajePolicia)");
        if(consulta10.hasSolution() == true){
            return 10;
        }
        
        Query consulta11 = new Query("pistaRandom(_,trajeNegro)");
        if(consulta11.hasSolution() == true){
            return 11;
        }
        
        Query consulta12 = new Query("pistaRandom(_,trajeBlanco)");
        if(consulta12.hasSolution() == true){
            return 12;
        }
        
        else{
            return 0;
        }
    }

    //metodo que verifica si una pista ya fue registrada o no mediante un true o false.
    public boolean existePista(String pista){
        int largoLista = pistasEncontradas.size();
        int i = 0;
        while(i < largoLista){
            if(pistasEncontradas.get(i).equals(pista)){
                //System.out.println("si ciste");
                return true;
            }
            i++;
        
        }
        
        //System.out.println("no ciste");
        return false;
    
    }
        
    
    public void consultaQuitarPistaRandom(){
        conexionProlog();
        consulta = new Query("quitarPistaRandom()");
        consulta.hasSolution();
        //System.out.println("se ha eliminado/reseteado la pista: "+pistaRandom);
    
    }
    
    
    public void consultaTirarDado(){
        conexionProlog();
        consultaQuitarDadoRandom();  //se resetea para evitar problemas
        consulta = new Query("tirarDado()");
        consulta.hasSolution();
        System.out.println("Se ha lanzado el dado!");  
        
        consulta = new Query("caraDadoRandom(huella)");
        if(consulta.hasSolution() == true){
            this.caraDadoRandom = "huella";
            System.out.println("Ha salido huella");
        }
        
        consulta = new Query("caraDadoRandom(ojo)");
        if(consulta.hasSolution() == true){
            this.caraDadoRandom = "ojo";
            System.out.println("Ha salido ojo");
        }
        
    }
    
    public void consultaQuitarDadoRandom(){
        conexionProlog();
        consulta = new Query("descartarCaraDadoRandom()");
        consulta.hasSolution();
        System.out.println("Se ha eliminado la cara de dado aleatoria:" + this.caraDadoRandom);
        
        
    }
    
}
    
   
