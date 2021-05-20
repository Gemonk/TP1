
/**
 * Controla lo que ocurre con el jugador
 *@author Génesis Herrera Knyght C03021
 * @version 18/5/2021
 */
public class Jugador
{ 
        private String nombre;
        private int jugadas[]={};
        private int turno[] ={};
        private int []puntos={};
    
    /**
     * Costructor de la clase
     * @return Devuelve el jugador nuevo 
     * 
     */
    public Jugador crearJugador(){
        Jugador nuevoJ = new Jugador();
        return nuevoJ;
    }
    
    /**
     * Recibe el nombre del jugador
     * @param nombreNuevo= nombre del jugador
     */
    public void setNombre(String nombreNuevo){
        nombre = nombreNuevo;
    }
    
    /**
     * Guarda las jugadas del jugador
     * @param int jugadasJuego= posicion que jugó el jugador
     * 
     */
    public void setJugadas(int jugadasJuego){
        int contador=0;
        int [] temporal=new int[jugadas.length+1];// crea un arreglo temporal
        if (jugadasJuego!=-1){
           
          temporal[contador] = jugadasJuego;
          if(jugadas!=null){
              for(int i=0;i<temporal.length;i++){
                    temporal[i]=jugadas[i];
                }
            jugadas= temporal;
              contador++;
          
            }
            else{ 
                jugadas= new int[jugadas.length+1];// incrementa el tamaño del arreglo
                jugadas[contador]=jugadasJuego;// coloca el dato recibido en la posición del contador
                contador++;
            }
        }
    }
    
    /**
     * Guarda el turno del jugador
     * @param int turnoNuevo= turno del jugador
     * 
     */
    public void setTurno(int turnoNuevo){
        int contador=0;
        int [] temporal=new int[turno.length+1];// crea un arreglo temporal
        if (turnoNuevo!=-1){
           
          temporal[contador] = turnoNuevo;
          if(turno!=null){
              for(int i=0;i<temporal.length;i++){
                    temporal[i]=turno[i];
                }
            turno= temporal;
              contador++;
          
            }
            else{
                turno= new int[turno.length+1];// incrementa el tamaño del arreglo
                turno[contador]=turnoNuevo;// coloca el dato recibido en la posición del contador
                contador++;
            }
        }
        
    }
    
    
    /**
     * Guarda los puntos del jugador
     * @param int puntosJugador= puntos nuevos del jugador
     * 
     */
    public void setPuntos(int puntosJugador){
        int contador=0;
        int [] temporal=new int[turno.length+1];// crea un arreglo temporal
        if (puntosJugador!=-1){
           
          temporal[contador] = puntosJugador;
          if(puntos!=null){
              for(int i=0;i<temporal.length;i++){
                    temporal[i]=puntos[i];
                }
            puntos= temporal;
              contador++;
          
            }
            else{ puntos= new int[puntos.length+1];// incrementa el tamaño del arreglo
                turno[contador]=puntosJugador;// coloca el dato recibido en la posición del contador
                contador++;
            }
        }
    }
    
    /**
     * Suma los puntos del jugador
     * @return puntos del jugador sumados
     * 
     */
    public int sumaPuntos(){
        int puntosSuma=0;
        for(int i=0; i<puntos.length;i++){
            puntosSuma+=puntos[i];
        }
        return puntosSuma;
    }
    
    /**
     * @return Devuelve nombre del jugador
     * 
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * @return Devuelve arreglo con las jugadas del jugador
     * 
     */
    public int[] jugadasJuego(){
        return jugadas;
    }
    
    /**
     * @return Devuelve arreglo los turnos del jugador
     * 
     */
    public int []turnoNuevo(){
        return turno;
    }
    
    /**
     * @return Devuelve arreglo con los puntos del jugador
     * 
     */
    public int []puntosJugador(){
        return puntos;
    }
}
