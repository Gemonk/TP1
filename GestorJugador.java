
/**
 * Controla lo que ocurre con los jugadores
 *
 * @author Génesis Herrera Knyght C03021
 * @version 19/5/2021
 */
public class GestorJugador{
    
    private Jugador [] jugadores={};
    Jugador jugador = new Jugador();
    Mazo mazo = new Mazo();
    int numero=0;
    int mayor=0;
    
    /**
     * Costructor de la clase
     * @return Devuelve gestor del jugador nuevo 
     * 
     */
    public GestorJugador creeGestor(){
        //constructor
        GestorJugador gestorNuevo = new GestorJugador();
        return gestorNuevo;
    }
    
    /**
     * Guarda a un nuevo jugador
     * @param Jugador jugadorNuevo = nuevo jugador y todos sus datos
     * 
     */
    public void agregarJugador(Jugador jugadorNuevo){
        int contador=0;
        
        Jugador [] temporal=new Jugador[jugadores.length+1];// crea un arreglo temporal
        if (jugadorNuevo!=null){
           
          temporal[contador] = jugadorNuevo;
          if(jugadores!=null){
              for(int i=0;i<temporal.length;i++){
                    temporal[i]=jugadores[i];
                }
            jugadores= temporal;
              contador++;
          
            }
            else{ 
                jugadores= new Jugador[jugadores.length+1];// incrementa el tamaño del arreglo
                jugadores[contador]=jugadorNuevo;// coloca el dato recibido en la posición del contador
                contador++;
            }
        }
    }
    
    /**
     * @return jugadores dentro de un arreglo
     */
    public Jugador[] getJugador (){
        return jugadores;
    }
    
    /**
     * Devuelve un número aleatorio de jugador en el arreglo que comienza
     * @return número aleatorio
     */
    public int turno1(){
        
        if(jugadores.length>0){
            numero=(int)(Math.random()*jugadores.length);
        }else{
            numero=0;
        }
        return numero;
    }
    
    /**
     * Devuelve un nombre de un un jugador
     * @return nombre del jugador
     */
    public String jugadorTurno(int turno){
        String nombreJ="";
       if(turno==0){
         nombreJ="Empieza: "+ jugadores[turno1()].getNombre();
        }else{
        nombreJ="Turno de: "+ jugadores[numero+turno%jugadores.length].getNombre();
        }
        return nombreJ;
    }
    
    /**
     * Devuelve la suma de puntos por jugada del jugador
     * @see clase Mazo
     * @see clase Jugador
     * @return puntaje
     */
    public int jugadorPuntos(){
        int puntaje=0;
        
        puntaje=mazo.Darnumero();//pide el número de la carta jugada
        puntaje*=2;
        jugador.setPuntos(puntaje);//guarda los puntos que ganó el jugador
        
        return puntaje;
    }
    
    /**
     * Devuelve el nombre del jugador ganador
     * @see clase Jugador
     * @return nombre
     */
      public String ganadorNombre(){
       String nombre="";
    //compara puntuaciones de jugadores   
       for(int i=0; i<jugadores.length;i++){
           for (int j=1; j<jugadores.length;j++){
                if(jugadores[i].sumaPuntos()>jugadores[j].sumaPuntos()){
                mayor= i;
            
        
            }
        }
    }
    
    nombre= jugadores[mayor].getNombre();// toma el nombre del jugador de mayor puntaje
    
    return nombre;
 }
  
     /**
     * Devuelve el puntaje del jugador ganador
     * @see clase Jugador
     * @return puntaje
     */
      public int ganadorPuntos(){
      int puntaje=0;  
      puntaje=jugadores[mayor].sumaPuntos();//devuelve puntos del jugador ganador
      return puntaje;
    }
    
    /**
     * Muestra los datos de cada jugador
     * @see clase Jugador
     * 
     */
    public void imprimirHistorial(){
        int contador=0;
        int posicion=1;
            System.out.print("\t\t\t:::--------------------<<<>>>--------------------:::");
            
        for (int i=0;i<jugadores.length;i++){
            for (int j=0; j<jugadores[i].jugadasJuego().length;j++){
                System.out.print("\t\t\t----------<<<>>>----------");
                System.out.print("Jugador: "+posicion+jugadores[i].getNombre());//Imprime nombre del jugador en l aposición i del arreglo jugadores
                System.out.print("\t\t\t----------------");
                System.out.println("Jugadas: ");
                System.out.print(j+"-"+jugadores[i].jugadasJuego()[j]);//Imprime jugadas del jugador i 
                
            }
            for (int j=0; j<jugadores[i].turnoNuevo().length;j++){
                
                System.out.println();
                System.out.println("Turnos: ");
                System.out.print(j+"-"+jugadores[i].turnoNuevo()[j]);//Imprime los turnos del jugador i
                
            }
            for (int j=0; j<jugadores[i].puntosJugador().length;j++){
                System.out.print(jugadores[i].puntosJugador());
                System.out.println();
                System.out.println("Puntos: ");
                System.out.print(j+"-"+jugadores[i].puntosJugador()[j]);// Imprime los puntos del jugador i
            }
              System.out.print("\t\t\t----------<<<>>>----------");  
            posicion++;
        }
        System.out.print("\t\t\t:::--------------------<<<>>>--------------------:::");
    }
}
