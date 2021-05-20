/**
 * En esta clase se crean las cartas y se maneja lo que ocurre con ellas
 *
 * @author Génesis Herrera Knyght C03021
 * @version 19/5/2021
 */
public class Mazo
{
    private Carta [] cartas;
    private Carta [] revolverC;
    private Carta [] cartaEscondida;
    private String [] letras={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private Carta [] trios;
    private CartaEspecial [] especial;
    private CartaEspecial [] revolverE;
    private Visualizador visualizador;
    private final String[] opcionSiNo = {"Sí","No"};
    Jugador jugador = new Jugador();
    int numeroCarta;
    
    /**
     * Llena el mazo con pares y trios de cartas
     * @param int k = cantidad pares de cartas
     * @param int t = cantidad trios de cartas
     * @see clase Carta
     */
    public void crearCartas(int k,int t){
        int nCartas= (((2*k)+(3*t)));//tamaño del arreglo cartas
        cartas=new Carta[nCartas];// nuevo arreglo de cartas 
        trios= new Carta[t];// nuevo arreglo que contendrá una carta que forme parte de un trio

        int contador=0;
        int contarTrios=0;
        for(int i=0;i<(k);i++){
            Carta carta= new Carta(obtenerNumero(i),obtenerLetra(i));//Crea una carta nueva y le asigna un número y letra
            cartas[contador++]=carta;
            cartas[contador++]=carta;
        }
       
        for(int i=0;i<(t);i++){
            Carta carta= new Carta(obtenerNumero(i),obtenerLetra(i));//Crea una carta nueva y le asigna un número y letra
            cartas[contador++]=carta;
            cartas[contador++]=carta;
            cartas[contador++]=carta;
            trios[contarTrios]=carta;
            contarTrios++;
        }
        
    }
    
    /**
     * Brinda un número aleatorio para el contenido de las cartas
     * @param int valor=numero de carta
     * @return n
     */
    public int obtenerNumero(int valor){
        int n=0;
        
        for(int i=0;i<=valor;i++){
            n=(int)(Math.random()*52);
            
        }
        return n;
    }
    
    /**
     * Brinda una letra aleatoria para el contenido de las cartas
     * @param int valor= numero de carta 
     * @return letra
     */
    public String obtenerLetra(int valor){ 
        String letra="";
         
        for(int i=0;i<letras.length;i++){
            int numero=(int)(Math.random()*27);
            letra=letras[numero];
             
        }
        return letra;
    }
    
    /**
     * Revuelve el arreglo de cartas
     * @return revolverC=arreglo ya revuelto
     */
    public Carta [] revolverArreglo(){
        int n=cartas.length;
        revolverC= new Carta[n];
        
        int numero;
        for(int i=0;i<revolverC.length;i++){
            numero=(int)(Math.random()*revolverC.length);
            if(revolverC[numero]==null){
                
                revolverC[numero]=cartas[i];
            }else{
                while(revolverC[numero]!=null){
                   numero=(int)(Math.random()*revolverC.length); 
                }
                revolverC[numero]=cartas[i];
            }
            
        }
        return revolverC;
    }
    
    /**
     * Devuelve el arreglo revuelto
     * @return revolverC=arreglo ya revuelto
     */
    public Carta [] devolverRevolverA(){
        return revolverC;
    }
    
    /**
     * Imprime el arreglo revuelto
     * @see clase Carta
     */
    public void imprimirRevueltas(){
        
        int contador=0;
        int posicion=1;
        for (int i=0;i<revolverC.length;i++){
            
            if(contador<2){
                System.out.print(posicion);
                revolverC[i].imprimir();
                contador++;
                posicion++;
            }else{
               System.out.print(posicion);
               revolverC[i].imprimir();
               System.out.println();
               contador=0;
               posicion++;
            }
        }
    }
    
    /**
     * Imprime el arreglo de cartas
     * @see clase Carta
     */
    public void imprimir(){
       
        int contador=0;
        int posicion=1;
        for (int i=0;i<cartas.length;i++){
            
            if(contador<2){
                System.out.print(posicion);
                cartas[i].imprimir();
                contador++;
                posicion++;
            }else{
               System.out.print(posicion);
               cartas[i].imprimir();
               System.out.println();
               contador=0;
               posicion++;
            }
        }
    }
    
    /**
     * Esconde las cartas creadas
     * @see clase Carta
     */
    public void esconderCarta(){
        int n=revolverC.length;
        cartaEscondida= new Carta[n];
        
        for (int i = 0 ; i < revolverC.length; i++){
            cartaEscondida[i]=revolverC[i];
            cartaEscondida[i].letra="X";
            cartaEscondida[i].numero=0;
        }
    }
    
    /**
     * Imprime las cartas escondidas
     * @see clase Carta
     */
    public void imprimirEscondida(){
        int contador=0;
        int posicion=1;
        for (int i=0;i<cartaEscondida.length;i++){
            
            if(contador<2){
                System.out.print(posicion);
                cartaEscondida[i].imprimir();
                contador++;
                posicion++;
            }else{
               System.out.print(posicion);
               cartaEscondida[i].imprimir();
               System.out.println();
               contador=0;
               posicion++;
            }
        }
        
    }
    
    /**
     * Revela una carta en una posición dada
     * @param int c= posicion de la carta a revelar
     * @see clase Carta
     * @return cartaEscondida= arreglo con la carta revelada
     */
    public Carta[] revelarCarta(int c){
        
            if(c!=0 && (c-1)<revolverC.length){
            cartaEscondida[c-1]= revolverC[c-1];
             cartaEscondida[c-1].letra=revolverC[c-1].letra;
             cartaEscondida[c-1].numero=revolverC[c-1].numero;
            
        }else{
            while(c==0 || (c-1)>revolverC.length){
                c=visualizador.ingreseInt("Error, debe ingresar un numero válido");
            }
            cartaEscondida[c-1]= revolverC[c-1];
             cartaEscondida[c-1].letra=revolverC[c-1].letra;
             cartaEscondida[c-1].numero=revolverC[c-1].numero;
            
        }
        return cartaEscondida;
    }
    
    /**
     * Busca si la carta en la posicion dada pertenece a un trío
     * @param int c= posicion de la carta
     * @return hayTrio= bandera para saber si existe un trío
     */
    public boolean trio(int c){
        boolean hayTrio= true;
        for(int i=0;i<trios.length;i++){
            if(trios[i]==revolverC[c-1]){
                hayTrio=true;
            }
            else{
                hayTrio=false;
            }
        }
        return hayTrio;
    }
    
    /**
     * Compara las letras de dos cartas
     * @see clase Carta
     * @param int a= posicion de la primera carta
     * @param int b= posicion de la segunda carta
     * @return letraIgual= bandera para saber si la letra es igual en ambas cartas o no
     */
    public boolean compararLetra(int a,int b){
        boolean letraIgual=true;
        if(revolverC[a-1].letra== revolverC[b-1].letra){
            letraIgual=true;
        }else{
            letraIgual=false;
        }
        return letraIgual;
    }
    
    /**
     * Compara los números de dos cartas
     * @see clase Carta
     * @param int a= posicion de la primera carta
     * @param int b= posicion de la segunda carta
     * @return numeroIgual= bandera para saber si el número es igual en ambas cartas o no
     */
    public boolean compararNumero(int a,int b){
        boolean numeroIgual=true;
        numeroCarta= revolverC[a-1].numero;
        if(revolverC[a-1].numero== revolverC[b-1].numero){
            numeroIgual=true;
        }else{
            numeroIgual=false;
        }
        return numeroIgual;
    }
    
    /**
     * Compara número y letra de dos cartas
     * @param int a= posicion de la primera carta
     * @param int b= posicion de la segunda carta
     * @return ambosIgual= bandera para saber si el número y la letra es igual en ambas cartas o no
     */
    public boolean compararAmbos(int a,int b){
        boolean ambosIgual=true;
        
        if(revolverC[a-1]== revolverC[b-1]){
            ambosIgual=true;
        }else{
            ambosIgual=false;
        }
        return ambosIgual;
    }
    
    /**
     * Devuelve el número que contiene la carta
     * @see clase Carta
     * @return numero= numero de la carta
     */
    public int Darnumero(){
       int numero= numeroCarta;
       return numero;
    }
    
    /**
     * Devuelve el número que contiene la carta
     * @param int a= posición de la primera carta digitada
     * @param int b= posición de la segunda carta digitada
     * @param int c= posición de la tercera carta digitada
     * @param boolean trio= bandera que indica si hay un trio 
     * @return revolverC= arreglo con las cartas borradas
     */
    public Carta[] borrarCarta(int a,int b,int c, boolean trio){
        int contador=1;
       
            for(int i=a-1;i<revolverC.length;i++){
                revolverC[i]=revolverC[(i+1)%revolverC.length];
                contador++;
            }
            Carta nuevoA[]= new Carta [revolverC.length-1];
            for(int i=0;i<nuevoA.length;i++){
                nuevoA[i]=revolverC[i];
            }
                revolverC= nuevoA;
                
            int contador1=1;
            for(int i=b-1;i<revolverC.length;i++){
                revolverC[i]=revolverC[(i+1)%revolverC.length];
                contador1++;
            }
            Carta nuevoB[]= new Carta [revolverC.length-1];// arreglo temporal que disminuye tamaño
            for(int i=0;i<nuevoB.length;i++){
                nuevoB[i]=revolverC[i];
            }
                revolverC= nuevoB;
            if(trio==true){
                    int contador2=1;
                for(int i=c-1;i<revolverC.length;i++){
                    revolverC[i]=revolverC[(i+1)%revolverC.length];
                    contador2++;
                }
                Carta nuevoC[]= new Carta [revolverC.length-1];
                for(int i=0;i<nuevoC.length;i++){
                    nuevoC[i]=revolverC[i];
                }
                    revolverC= nuevoC;
                
            }
            
                 
        return revolverC;
    }
    
    /**
     * Crea las cartas especiales
     * @see clase CartaEspecial
     */
    public void crearEspecial(){
        especial=new CartaEspecial[10];//arreglo de cartas especiales
        for(int i=0;i<5;i++){
            CartaEspecial cartaE= new CartaEspecial("¡Duplicar!",1);// crea una carta especial  le asigna un nombre y número
            especial[i]=cartaE;

        }
        for(int i=0;i<5;i++){
            CartaEspecial cartaE= new CartaEspecial("¡Cuadruplicar!",2);// crea una carta especial  le asigna un nombre y número
            especial[i]=cartaE;

        }
    }
    
    /**
     * Revuelve el arreglo de cartas especiales
     * @return revolverE= arreglo de cartas especiales ya revuelto
     */
    public CartaEspecial [] revolverArregloE(){
        int n=especial.length;
        revolverE= new CartaEspecial[n];
        
        int numero;
        for(int i=0;i<revolverE.length;i++){
            numero=(int)(Math.random()*revolverE.length);
            if(revolverE[numero]==null){
                
                revolverE[numero]=especial[i];
            }else{
                while(revolverE[numero]!=null){
                   numero=(int)(Math.random()*revolverE.length); 
                }
                revolverE[numero]=especial[i];
            }
            
        }
        return revolverE;
    }
    
    /**
     * Borra las cartas especiales
     * @return revolverE= arreglo de cartas especiales con la carta ya borrada
     */
    public CartaEspecial[] borrarCartaE(){
        int contador=1;
       
            for(int i=0;i<revolverE.length;i++){
                revolverE[i]=revolverE[(i+1)%revolverE.length];
                contador++;
            }
            CartaEspecial nuevoE[]= new CartaEspecial [revolverE.length-1];// arreglo temporal que disminuye tamaño
            for(int i=0;i<nuevoE.length;i++){
                nuevoE[i]=revolverE[i];
            }
                revolverE= nuevoE;
                         
        return revolverE;
    }
    
    /**
     * Selecciona una carta especial
     * @return carta= carta especial seleccionada
     */
    public CartaEspecial escogerCartaE(){
        CartaEspecial carta=null;
        for(int i=0;i<1;i++){
            carta=revolverE[i];
        }
        
        return carta;
    }
    
    /**
     * Devuelve el efecto de de la carta ya aplicado a los puntos
     * @see clase CartaEspecial
     * @see clase Jugador
     * @return puntos= puntos del jugador
     */
    public int aplicarCartaE(int a){
        CartaEspecial cartaAplicar = escogerCartaE();
        int puntos=0;
        if(cartaAplicar.numero==1){
            puntos=(revolverC[a-1].numero*3)*2;
        }
        if(cartaAplicar.numero==2){
            puntos=(revolverC[a-1].numero*3)*4;
        }
        jugador.setPuntos(puntos);
        return puntos;
    }
    
    
    /**
     * Revisa si hay cartas aún que se puedan emparejar
     * @see clase Carta
     * @see clase Visualizador
     * @param int pregunta= numero que indica si el jugador desea seguir o no
     * @return seguir= bandera para saber si se´puede seguir jugando
     */
    public boolean hayCartas(int pregunta){
        boolean seguir= true;
        if(revolverC.length<(cartas.length/2)){
            for(int i=0; i<revolverC.length;i++){
                for(int j=1; j<revolverC.length;j++){
                    if(revolverC[i].letra==revolverC[j%revolverC.length].letra || revolverC[i].numero==revolverC[j%revolverC.length].numero ){
                        
                        
                        if(pregunta==0){
                           seguir=true; 
                        }else{
                            seguir=false;
                            visualizador.muestre("Ya no hay cartas por emparejar");
                        }
                    }else{
                        seguir=false;
                    }
                }
            }
        }
        return seguir;
    }

    
}

