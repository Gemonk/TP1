
/**
 * Write a description of class Mazo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mazo
{
    private Carta [] cartas;
    private int [] revolverC;
    private Carta [] cartaEscondida;
    int sgt=0;

    // public Mazo(){
    // this.crearCartas();
    // }

    public void crearCartas(int k,int t){
        int nCartas= ((2*k)+(3*t));
        cartas=new Carta[nCartas];

        int contador=0;

        for(int i=0;i<(k);i++){
            Carta carta= new Carta(obtenerNumero(i),obtenerLetra(i));
            cartas[contador++]=carta;
            cartas[contador++]=carta;
            // contador++;

        }
        // int contador1=contador-1;
        for(int i=0;i<(t);i++){
            Carta carta= new Carta(obtenerNumero(i),obtenerLetra(i));
            cartas[contador++]=carta;
            cartas[contador++]=carta;
            cartas[contador++]=carta;
            // contador1++;
        }
    }

    public int obtenerNumero(int valor){
        int n=0;
        //char letraSalida= ' ';
        for(int i=0;i<=valor;i++){
            n=(int)(Math.random()*52);
            //letraSalida+=letra; 
        }
        return n;
    }

    public char obtenerLetra(int valor){
        char letra=64;
        //char letraSalida= ' ';
        for(int i=0;i<27;i++){
            letra+=(char)(Math.random()*1);
            //letraSalida+=letra; 
        }
        return letra;
    }

    public void revolverArreglo(){
        for (int i=0;i<cartas.length;i++){
            revolverC[i]=-1; //VACIO
        }
        int pos;
        for (int i=0;i<cartas.length;i++){
            do{
                pos=(int)(Math.random()*52);
            }while (revolverC[pos]!=-1);
            revolverC[pos]=i;
        }
    }

    public Carta deCarta(){
        return cartas[revolverC[sgt++]];
    }

    public Carta[] esconderCarta(){
        for (int i = 0 ; i < cartas.length; i++){
            cartaEscondida[i]= cartas[i];
            cartaEscondida[i].letra='X';
            cartaEscondida[i].numero=0;
        }
        return cartaEscondida;
    }

    public void imprimir(){
        // for(Carta imprimirCarta:cartas){
        // imprimirCarta.imprimir();
        for (int i=0;i<cartas.length;i++){
            //System.out.println("i="+i+"carta = "+cartas[i]);
            cartas[i].imprimir();
        }
    }

    public void imprimirEsconder(){
        for (int i = 0 ; i < cartaEscondida.length; i++){
            cartaEscondida[i].imprimir();
        }
    }

    public Carta [] revelarCarta(int c){
        boolean columnaDigitada=false;
        if(columnaDigitada){
            cartaEscondida[c]= cartas[c];
        }
        return cartaEscondida;
    }

    public static void main(String args[]){
        Mazo mazo = new Mazo();
        mazo.crearCartas(4,3);
        mazo.imprimir();

    }
}
