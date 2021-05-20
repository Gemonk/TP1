import java.util.Arrays;
/**
 * Write a description of class GestorJugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestorJugador{
    
    private Jugador [] jugadores={};
    
    public GestorJugador creeGestor(){
        //constructor
        GestorJugador gestorNuevo = new GestorJugador();
        return gestorNuevo;
    }
    public void agregarJugador(Jugador jugadorNuevo){
        jugadores = Arrays.copyOf(jugadores, jugadores.length + 1);
        jugadores[jugadores.length - 1] = jugadorNuevo; 
    }
    public Jugador[] getJugador (){
        return jugadores;
    }
    public void setJugador(Jugador[] nuevoTamano){
         jugadores = nuevoTamano;
    }
}
