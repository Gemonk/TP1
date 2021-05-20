
/**
 * Write a description of class pruebas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pruebas
{
   
    public void letra(){
        char letra=64;
        
        while(letra!=90){
            letra+=1;
             System.out.println(letra);
             //letra++;
            
        }
     
    }
    
    public static void main (String [] a){
        pruebas p = new pruebas();
        p.letra();
    }
}
