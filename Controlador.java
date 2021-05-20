 import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 * Controla lo que ocurre en el programa, la interfáz mostrada al usuario
 * 
 * @author Génesis Herrera Knyght
 * @version 8/5/2021
 */
public class Controlador{
    
    private final String TITULO_VENTANAS = "¡Pares y Tríos!";
    private final String[] OPCIONES = {"Jugar","Manual de juego","Historial de la partida","Créditos","Salir."};
    private final String CREDITOS = "Creadora: Genesis Herrera. Carne:C03821";
    private final String[] opcionSiNo = {"Sí","No"};
    private final String[] opcionCartas = {"Cantidad de jugadores"};
    private Visualizador visualizador;
    GestorJugador gestor= new GestorJugador();
    Mazo mazo = new Mazo();
    /**
     * constructor.
     * @see clase Visualizador
     * @see 
     */
    public Controlador()
    {
        visualizador = new Visualizador(TITULO_VENTANAS);
        GestorJugador gestor = new GestorJugador();
    }
    
    /**
     * @throws correo vacío= indica al usiario que no ingreso un correo
     * @throws ArrayIndexOutOfBoundsException e= indica cuando la categoría esta vacía
     * @see clase Visualizador
     * @see clase GestorContactos
     * @see clase Contacto
     * 
     */
    public void iniciar(){
        int opcion;
        boolean resultado;
        int pares;
        int trios;
        String nombre="";
        int[] puntuaciones = {}; //Se usa para llevar las puntuaciones del jugador
        boolean control = false;// bandera de elección
        int numeroCelda=0;
        int contador=1;
        int c=1;
        String pregunta = " ";
        boolean inspector = false;// bandera de elección
        boolean FinDelJuego=false;
         do {
              opcion=visualizador.pedirOpcion(OPCIONES,"¿Que desea realizar?");
            switch (opcion){
                case 0:
                Jugador jugador= new Jugador();
                int [] agregarJugadas={};
                int [] agregarTurnor={};
                int [] agregarPuntos={};
                
                
                    inspector=false;
                    try{
                            do{
                            pares = visualizador.ingreseInt("Ingrese la cantidad de cartas pares que desea que existan");
                            if(pares == 0){
                                visualizador.muestre("Error, debe ingresar un número");
                            }else{
                                trios = visualizador.ingreseInt("Ingrese la cantidad de trios que desea que existan");
                                if(trios == 0){
                                    visualizador.muestre("Error, debe ingresar un número");
                                }else{
                                    inspector = true;
                                }
                                mazo.crearCartas(pares,trios);
                            }
                        
                    }while(inspector == false);
                }catch(NumberFormatException e) {
                        visualizador.ingreseHilera("Error, debe ingresar un numero");
                    }
                        
                int seguir=0;
                do{
                    inspector=false;
                    do{
                        nombre = visualizador.ingreseHilera("Ingrese el nombre del nuevo jugador");
                        if(nombre == ""||nombre.isEmpty()){
                            visualizador.muestre("Error, debe ingresar un nombre");
                        }else{
                            //jugador.setNombre(nombre);
                            //gestor.agregarJugador(jugador);
                            inspector = true;
                        }
                    }while(inspector == false);
                
                    boolean nombreRepetido = true;
                    inspector = false;
                    Jugador[] jugadores = gestor.getJugador();
                    if (jugadores.length != 0){
                        while (nombreRepetido == true){
                            for (int i = 0; i < jugadores.length; i++){
                                if(jugadores[i].getNombre().equals(nombre)){
                                    nombre = visualizador.ingreseHilera("Ese nombre ya está ocupado, ingrese otro nombre para su contacto.");
                                    if(!jugadores[i].getNombre().equals(nombre)){
                                        nombreRepetido = false;
                                        
                                        
                                    }
                                }
                            }
                        }
                    }
                    jugador.setNombre(nombre);
                    gestor.agregarJugador(jugador);
                    seguir = visualizador.pedirOpcion(opcionSiNo, "¿Desea agregar otro jugador?");
                }while(seguir==0);         
                            // //se ingresan los telefonos
                    // int seguir = 0;
                    // do{
                        // inspector = false;
                        // try{
                            // do{
                                // int telefono = visualizador.ingreseInt("Ingrese el número de teléfono del contacto");
    
                                // telefonosAgregar = Arrays.copyOf(telefonosAgregar, telefonosAgregar.length +1);
                                // telefonosAgregar[telefonosAgregar.length - 1] = telefono;
    
                                // seguir = visualizador.pedirOpcion(opcionSiNo, "¿Desea agregar otro número telefónico?");
                            // }while (seguir == 0);
                            // inspector = true;
                        // }catch(NumberFormatException e){
                            // visualizador.muestre("Error, debe ingresar un numero");
                        // }
                    // }while(inspector == false);
                    //se ingresa el email
                    // inspector = false;
                    // do{
                        // email = visualizador.ingreseHilera("Ingrese el email del nuevo contacto");
                        // if(email == "" || email.isEmpty()){
                            // visualizador.muestre("Error, debe ingresar un email");
                        // }else{
                            // inspector = true;
                        // }
                    // }while(inspector == false);
                        // //se le asignan los datos ingresados al nuevo contacto
                    // contacto.setAtributos(nombre, telefonosAgregar, email, categoria);
            
                break;
                case 1:
                inspector= false;
                    do{
                        Reglas r=new Reglas();
                       visualizador. muestre(r.reglas());
                       inspector = true;
                    }while(inspector == false);
                break;
                case 2:
                inspector=false;
                FinDelJuego=false;
                do{
                    
                        visualizador.muestre("No disponible hasta terminar una partida");
                        inspector = true;
                        }while(inspector == false);
                break;
                case 3:
                //Ver creadores del proyecto
                visualizador.mostrarCreditos(CREDITOS);
                break;
            }
        
        } while(opcion == 0 || opcion == 1|| opcion == 2|| opcion == 3);    
    
    }
    
    public static void main(String[] parametros){
       Controlador controlador;
        controlador = new Controlador();
        controlador.iniciar();
        
    }
    
}
