
/**
 * Controla lo que ocurre con el jugador
 *@author Génesis Herrera Knyght
 * @version 8/5/2021
 */
public class Jugador
{ 
        private String nombre;
        private int jugadas[]={};
        private int turno[] ={};
        private int []puntos={};
    
    public Jugador crearJugador(){
        //constructor
        Jugador nuevoJ = new Jugador();
        return nuevoJ;
    }
    
    /**
     * @param nombreNuevo= nombre del jugador
     */
    public void setNombre(String nombreNuevo){
        nombre = nombreNuevo;
    }
    
    public void setJugadas(int[] jugadasJuego){
        jugadas = jugadasJuego;
    }
    
    public void setTurno(int []turnoNuevo){
        turno = turnoNuevo;
    }
    
    public void setPuntos(int []puntosJugador){
        puntos = puntosJugador;
    }
    
    public void setAtributos(String nombreNuevo, int[] jugadasJuego, 
    int []turnoNuevo, int []puntosJugador){
        nombre = nombreNuevo;
        jugadas = jugadasJuego;
        turno = turnoNuevo;
        puntos = puntosJugador;
    }
    public String getNombre(){
        return nombre;
    }
    public int[] jugadasJuego(){
        return jugadas;
    }
    public int []turnoNuevo(){
        return turno;
    }
    public int []puntosJugador(){
        return puntos;
    }
}
