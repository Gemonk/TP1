
/**
 * Crea cartas
 *
 * @author Génesis Herrera Knyght C03021
 * @version 11/5/2021
 */
public class CartaEspecial{
    
    
   public String nombre;
   public int numero;
    
   /**
    * Constructor de clase
    * @param String= nombre de la carta
    * @param int num= numero del efecto de la carta
    */
    public CartaEspecial(String n,int num){ 
        nombre= n;
        numero= num;
    }
    
    /**
     * Guarda el nombre de la carta
     * @param int String nombreN=recibe el nombre nuevo de la carta
     */
    public void setNombre(String nombreN){
        nombre=nombreN;
    }
    
    /**
     * Muestra el nombre de la carta
     *  @return el nombre de la carta
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Guarda el número de la carta
     * @param int int numeroN=recibe el número nuevo de la carta
     */
    public void setNumero(int numeroN){
        numero=numeroN;
    }
    
    /**
     * Muestra el número de la carta
     *  @return el número de la carta
     */
    public int getNumero(){
        return numero;
    }
    
    /**
     * Imprime el contenido de la carta
     * 
     */
    public void imprimir(){
            String contenidoDeLaCarta = "->";
            contenidoDeLaCarta = contenidoDeLaCarta  + nombre+"\t\t";
            System.out.print(contenidoDeLaCarta);
            
    }
}
