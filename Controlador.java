
/**
 * Controla lo que ocurre en el programa, la interfáz mostrada al usuario y 
 * qué hacer según la elección en el menú.
 * 
 * @author Génesis Herrera Knyght
 * @version 18/5/2021
 */
public class Controlador{
    
    
    private final String[] OPCIONES = {"Jugar","Manual de juego","Historial de la partida","Créditos","Salir."};
    private final String CREDITOS = "Creadora: Genesis Herrera. Carne:C03821";
    private final String[] opcionSiNo = {"Sí","No"};
    private final String[] opcionComparacion = {"Letra","Número","Ambos"};
    private final String[] opcionCartas = {"Cantidad de jugadores"};
    private Visualizador visualizador;
    GestorJugador gestor= new GestorJugador();
    Mazo mazo = new Mazo();
    /**
     * constructor.
     * @see clase Visualizador
     * @see clase GestorJugador
     */
    public Controlador()
    {
        visualizador = new Visualizador("<<>>----------->><< ¡Pares y Tríos! >><<-----------<<>>");
        GestorJugador gestor = new GestorJugador();
    }
    
    /**
     * @throws NumberFormatException= indica al usiario que no ingreso un numero correcto
     * @see clase Visualizador
     * @see clase GestorJugador
     * @see clase Jugador
     * @see clase Reglas
     * @see clase CartaEspecial
     * @see clase Mazo
     * 
     */
    public void iniciar(){
        int opcion;//opcion que puede elegir el usuario en el menú principal
        int comparar;// almacena cómo el usuario desea comparar las cartas
        boolean nombreRepetido = true; // bandera para conocer si existe un nombre repetido
        int pares=0;// almacena la cantidad de pares que el usuario quiere para el juego
        int trios=0;// almacena la cantidad de trios que el usuario quiere para el juego
        String nombre="";// almacena nombre de jugador
        boolean inspector = false;// bandera de elección
        boolean FinDelJuego=false;// bandera de elección
         do {
              opcion=visualizador.pedirOpcion(OPCIONES,"¿Que desea realizar?");
            switch (opcion){
                case 0:// jugar
                Jugador jugador= new Jugador();
                int [] agregarJugadas={};
                int [] agregarTurnor={};
                int [] agregarPuntos={};
                
                
                    inspector=false;
                    try{
                            do{
                            pares = visualizador.ingreseInt("Ingrese la cantidad de cartas pares que desea que existan");// solicita los pares que el usuario desea crear
                            if(pares == 0){
                                visualizador.muestre("Error, debe ingresar un número");
                            }else{
                                trios = visualizador.ingreseInt("Ingrese la cantidad de trios que desea que existan");// solicita los trios que el usuario desea crear
                                if(trios == 0){
                                    visualizador.muestre("Error, debe ingresar un número");
                                }else{
                                    inspector = true;
                                }
                                mazo.crearCartas(pares,trios);
                            }
                        
                    }while(inspector == false);
                }catch(NumberFormatException e) {
                        visualizador.ingreseHilera("Error, debe ingresar un numero válido");
                    }
                        
                int seguir=0;
                do{
                    inspector=false;
                    do{
                        nombre = visualizador.ingreseHilera("Ingrese el nombre del nuevo jugador");// solicita el nombre del usuario
                        if(nombre == ""||nombre.isEmpty()){
                            visualizador.muestre("Error, debe ingresar un nombre");
                        }else{

                            inspector = true;
                        }
                    }while(inspector == false);
                
                    nombreRepetido = true;
                    inspector = false;
                    Jugador[] jugadores = gestor.getJugador();// compara los nombres existentes
                    if (jugadores.length != 0){
                        while (nombreRepetido == true){
                            for (int i = 0; i < jugadores.length; i++){
                                if(jugadores[i].getNombre().equals(nombre)){
                                    nombre = visualizador.ingreseHilera("Ese nombre ya está ocupado, ingrese otro nombre para el jugador.");// almacena otro nombre cuando se repite el nombre
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
                //--------------------------------------------------------------------------------<<<>>>--------------------------------------------------------------
                                                        // empieza juego
                //--------------------------------------------------------------------------------<<<>>>--------------------------------------------------------------
                mazo.crearCartas(pares,trios);// llama a crear el mazo
                mazo.revolverArreglo();// revuelve el mazo
                mazo.esconderCarta();// esconde las cartas existentes
                mazo.crearEspecial();// crea cartas especiales
                mazo.revolverArregloE();// baraja las cartas especiales
                boolean acertar=true;
                boolean hayTrio=true;
                int contadorTurno=0;
                int revelarPosicion1= 0;
                int revelarPosicion2= 0;
                int revelarPosicion3= 0;
                int terceraCarta=0;
                int puntosTrio=0;
                int preguntarSeguir=0;
                while(FinDelJuego=false){
                    String nombreTurno=gestor.jugadorTurno(contadorTurno);// selecciona el nombre del jugador al turno
                    visualizador.muestre(nombreTurno);// muestra el nombre del jugador al turno
                    mazo.imprimirEscondida();// imprime las cartas escondidas
                    
                    revelarPosicion1= visualizador.ingreseInt("¿Cuál carta desea revelar primero?");// solicita la posicion de la carta a revelar
                    mazo.revelarCarta(revelarPosicion1);// pasa la posicion al método revelar
                    jugador.setTurno(contadorTurno);// guarda el turno del jugador
                    comparar=visualizador.pedirOpcion(opcionComparacion,"¿Cómo desea comparar las cartas?");
                    switch (comparar){
                        case 0:// decide comparar por letra
                           revelarPosicion2= visualizador.ingreseInt("¿Cuál carta desea revelar ahora?");// solicita la posicion de la carta a revelar
                           mazo.revelarCarta(revelarPosicion2);
                           acertar= mazo.compararLetra(revelarPosicion1,revelarPosicion2);// pasa las posiciones al metodo que compara letras
                            mazo.imprimirEscondida();// revela la carta
                           if(acertar==true){
                                
                                    hayTrio=false;
                                    visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                    visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                    mazo.borrarCarta(revelarPosicion1,revelarPosicion2,0,hayTrio);// borra las cartas acertadas
                                    jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                    preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                    FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                            }else{
                                visualizador.muestre("No son iguales");
                                    mazo.esconderCarta();
                                hayTrio=false;
                                    visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                    visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                    preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                    FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                            }
                        break;
                        
                        case 1:// decide comparar por número
                            revelarPosicion2= visualizador.ingreseInt("¿Cuál carta desea revelar ahora?");// solicita la posicion de la carta a revelar
                            mazo.revelarCarta(revelarPosicion2);// revela la posicion 2
                            
                            acertar= mazo.compararNumero(revelarPosicion1,revelarPosicion2);// compara si son iguales
                            mazo.imprimirEscondida();//revela la segunda carta
                           if(acertar==true){
                                
                                    hayTrio=false;
                                    visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                    visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                    mazo.borrarCarta(revelarPosicion1,revelarPosicion2,0,hayTrio);//borra las acertadas
                                    jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                    preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                    FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                            }else{
                                visualizador.muestre("No son iguales");
                                    mazo.esconderCarta();
                                hayTrio=false;
                                    visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                    visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                    preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                    FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                            }
                        break;
                        
                        case 2://comparar por número y letra
                            revelarPosicion2= visualizador.ingreseInt("¿Cuál carta desea revelar ahora?");// solicita la posicion de la carta a revelar
                            mazo.revelarCarta(revelarPosicion2);//revelar carta
                            acertar= mazo.compararAmbos(revelarPosicion1,revelarPosicion2);// compara los valores
                            mazo.imprimirEscondida();// revela la carta
                           if(acertar==true){
                                hayTrio=mazo.trio(revelarPosicion2);// evalúa si la carta forma parte de un trio
                                if(hayTrio==true){
                                 terceraCarta=visualizador.pedirOpcion(opcionSiNo, "Existe una tercera carta, ¿conoce su posición?");//recibe si se sabe donde esta la tercera carta
                                 if(terceraCarta==0){
                                    revelarPosicion3=visualizador.ingreseInt("¿Dónde se encuetra la tercera carta?");// recibe la tercera posicion
                                    mazo.revelarCarta(revelarPosicion3);// revela posicion 3
                                    acertar= mazo.compararAmbos(revelarPosicion1,revelarPosicion3);// compara las cartas
                                     mazo.imprimirEscondida();//muestra la tercera carta
                                     
                                    if (acertar==true){
                                        visualizador.muestre("¡Ha acertado!");
                                        
                                        
                                        mazo.escogerCartaE();//escoge la carta especial
                                        puntosTrio=mazo.aplicarCartaE(revelarPosicion3);// aplica la carta
                                        mazo.borrarCartaE();
                                        
                                        visualizador.muestre("Puntos ganados: "+ puntosTrio);// muestra puntos ganados
                                        visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                        jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                        mazo.borrarCarta(revelarPosicion1,revelarPosicion2,revelarPosicion3,hayTrio);// borra la carta acertada
                                        preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                        FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                                    }else{
                                        hayTrio=false;
                                       visualizador.muestre("No ha acertado");
                                       visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                       visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                       mazo.borrarCarta(revelarPosicion1,revelarPosicion2,0,hayTrio);// borra la carta acertada
                                       mazo.esconderCarta();//esconde las cartas
                                       jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                       preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                       FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                                    }
                                    }else{
                                        hayTrio=false;
                                       visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                       visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                       mazo.borrarCarta(revelarPosicion1,revelarPosicion2,0,hayTrio);// borra la carta acertada
                                       jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                       preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                       FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                                    }
                                }else{
                                    hayTrio=false;
                                       visualizador.muestre("Puntos ganados: "+ gestor.jugadorPuntos());// muestra puntos ganados
                                       visualizador.muestre("Puntuación actual: "+ jugador.sumaPuntos());// puntuacion actual
                                       mazo.borrarCarta(revelarPosicion1,revelarPosicion2,0,hayTrio);// borra la carta acertada
                                       jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                       preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                       FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                                }
                            }else{
                                visualizador.muestre("No son iguales");
                                    mazo.esconderCarta();//esconde las cartas
                                jugador.setJugadas(revelarPosicion1);// guarda la jugada
                                preguntarSeguir=visualizador.pedirOpcion(opcionSiNo, "¿Desea seguir jugando?");// el jugador decide si desea seguir jugando
                                FinDelJuego=mazo.hayCartas(preguntarSeguir);// define si es el final del juego
                            }
                        break;
                
                }
                contadorTurno++;
            } 
             visualizador.muestre("--- ¡Gracias por Jugar! ---");// si el juego acaba se muestra este mensaje
             visualizador.muestre("Ganador: "+gestor.ganadorNombre()+"con: "+gestor.ganadorPuntos()+"puntos");// muestra al ganador
               
                break;
                case 1:// muestra manual
                inspector= false;
                    do{
                        Reglas r=new Reglas();
                       visualizador. muestre(r.reglas());
                       inspector = true;
                    }while(inspector == false);
                break;
                //--------------------------------------
                case 2:// Historial
                inspector=false;
                
                do{
                    
                        visualizador.muestre("No disponible hasta terminar una partida");
                        inspector = true;
                }while(inspector == false);
                
                if(FinDelJuego==true){
                    gestor.imprimirHistorial();// llama a imprimir el historial
                }

                break;
                case 3://Ver creadores del proyecto
                visualizador.mostrarCreditos(CREDITOS);
                break;
            }
        
        } while(opcion == 0 || opcion == 1|| opcion == 2|| opcion == 3);    
    
    }
    
    public static void main(String[] parametros){
       Controlador controlador;
        controlador = new Controlador();
        controlador.iniciar();// inicia el programa
        
    }
    
}
