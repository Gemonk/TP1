
/**
 * Instrucciones para jugar
 *
 * @author Génesis Herrera Knyght C03821
 * @version 10/5/2021
 */
public class Reglas
{
    /**
     * Contiene las reglas del juego
     * @return devuelve un String con todas las reglas
     * 
     */
    public String reglas(){
        String reglas="Instrucciones generales:\n\n\t\t       1- Al iniciar cada partida se debe decidir cuántos pares y trios existan en las cartas."
        +"\n\t\t       2- Se debe ingresar el nombre de cada uno de los participantes de la partida, el juego decidirá aleatoriamente quién empezará a jugar."
        +"\n\t\t       3- Al final de cada partida se prodrá obsevar el historial de jugadas de cada jugador."
        +"\n\nReglas del juego:\n\n\t\t       1- Una vez definido al jugador que inicia el juego,se colocará cada carta sobre un grid en una posición dada que durante el juego va a ser invariante. "
        +"\n\t\t       2- Se permitirá al jugador al turno, voltear 2 cartas con la idea de formar grupos, solo que al tener las cartas 2 símbolos, el jugador debe indicar cuál de estos usará para crear su par: sea la  letra, el número o bien sean ambos.  "
        +"\n\t\t       3- Si se acierta en cualquiera de estos casos, ganará la cantidad de puntos indicada por la suma del número de las cartas. Si no acierta, las cartas volteadas que no han formado un par,se voltearán nuevamente para ocultar su valor. El turno se pasará al siguiente jugador. "
        +"\n\t\t       4- Si se elige la opción hacer par con número y letra, si existe una tercera carta igual, se preguntará al jugador en turno por la ubicación de esta tercera carta, si el jugador la identifica correctamente, se le otorgará una carta de  premio.  "
        +"\n\t\t       5- El juego terminará cuando ya no existan más cartas por emparejar ni por letra ni por número, o bien cuando los jugadores así lo decidan, en ambos casos ganará el jugador que lleve mayor puntuación hasta el momento."
        +"\n\nCartas premio:\n\n\t\tExisten dos tipos de carta premio: \n\t\t       --> Duplicar puntos: \n\t\t              Hay 5 cartas de este tipo en cada partida,produce que los puntos obtenidos hasta el momento sean duplicados. "
        +"\n\t\t       --> Cuadriplicar puntos: \n\t\t              Hay 5 cartas de este tipo en cada partida,produce que los puntos obtenidos hasta el momento sean cuadriplicados. ";
        
        
        return reglas;
    }

}
