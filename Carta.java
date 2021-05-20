
/**
 * Crea cartas
 *
 * @author Génesis Herrera Knyght
 * @version 11/5/2021
 */
public class Carta{
    
    
   public char letra;
   public int numero;
    
    public Carta(int n,char l){
        
        letra= l;
        numero= n;
    }
    public void setNumero(int numeroN){
        numero= numeroN;
    }
    public void setLetra(char letraN){
        letra=letraN;
    }
    public int getNumero(){
        return numero;
    }
    public char getLetra(){
        return letra;
    }
    
    public void imprimir(){
    
        String contenidoDeLaCarta = "La carta es: ";
        contenidoDeLaCarta = contenidoDeLaCarta  + letra+ numero;
        System.out.println(contenidoDeLaCarta);
    }
}
