
import javax.swing.JOptionPane;

/**
 * Contiene los métodos relevantes para la interfáz gráfica / visualizador.
 * 
 * @author Génesis Herrera Knyght C03821
 * @version 10/5/2021
 */
public class Visualizador extends JOptionPane
{
    private final String TITULO;
    //Carta carta=new Carta();
    /**
     * constructor.
     * @param elTitulo= el título de la ventana a mostrar
     */
    public Visualizador(String elTitulo)
    {
        TITULO = elTitulo;
    }
    
    //metodos para ingresar informacion
    /**
     * @param msg= mensaje que se despliega en cada ventana
     * @return devuelve un numero entero ingresado por el usuario
     */
    public int ingreseInt(String msg){ 
        // Lee valores enteros
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }
    
    /**
     * @param msg= mensaje que se despliega en cada ventana
     * @return devuelve una hilera de texto ingresada por el usuario
     */
    public String ingreseHilera(String msg){
        // Lee hileras de texto
        return JOptionPane.showInputDialog(msg);
    }
        
    /**
     * @param lasOpciones = arreglo que contiene las opciones que el usuario puede elegir
     * @param elMensaje= mensaje con indicaciones para el usuario
     * @return devuelve el número de eleccion del usuario
     */
    public int pedirOpcion(String[] lasOpciones, String elMensaje){
        int resultado;
        resultado = this.showOptionDialog(null, elMensaje, TITULO, DEFAULT_OPTION, PLAIN_MESSAGE, null, lasOpciones, null);
        return resultado;
    }
    
    //metodos para desplegar informacion
    /**
     * @param CREDITOS = parametro que contiene el nombre de los realizadores del código
     * 
     */
    public void mostrarCreditos(String CREDITOS)// método para mostrar los créditos del proyecto
    {
        this.showMessageDialog(null, CREDITOS, TITULO, PLAIN_MESSAGE);
    }
    
    /**
     * @param msj = mensaje que despliega la ventana que ve el usuario
     */
    public void muestre(String msj){
        // Despliega un mensaje
        this.showMessageDialog(null,msj,TITULO,PLAIN_MESSAGE);
    }
    
    /**
     * @param msj = mensaje que despliega la ventana que ve el usuario
     */
    public void muestreNúmero(String msj){
        // Despliega un mensaje
        this.showMessageDialog(null,msj,TITULO,PLAIN_MESSAGE);
    }
    

}