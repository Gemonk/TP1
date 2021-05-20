
/**
 * Crea cartas
 *
 * @author Génesis Herrera Knyght C03021
 * @version 11/5/2021
 */
public class Carta{
    
    
   public String letra;
   public int numero;
    
   /**
    * Constructor de clase
    * @param int n= numero de la carta
    * @param String l= letra de la carta
    */
    public Carta(int n,String l){
        
        letra= l;
        numero= n;
    }
    /**
     * Guarda el número de la carta
     * @param int numeroN=recibe el número nuevo de la carta
     */
    public void setNumero(int numeroN){
        numero= numeroN;
    }
    
    /**
     * Guarda la letra de la carta
     * @param String letraN=recibe la letra nueva de la carta
     */
    public void setLetra(String letraN){
        letra=letraN;
    }
    
    /**
     * Muestra el número de la carta
     *  @return numero de la carta
     */
    public int getNumero(){
        return numero;
    }
    
    /**
     * Muestra la letra de la carta
     *  @return la letra de la carta
     */
    public String getLetra(){
        return letra;
    }
    
    /**
     * Imprime el contenido de la carta
     * 
     */
    public void imprimir(){
        
           
            String contenidoDeLaCarta = "->";
            contenidoDeLaCarta = contenidoDeLaCarta  + letra+ numero+"\t\t";
            System.out.print(contenidoDeLaCarta);
            
            
        
        
    }
}