import java.util.*;
import java.util.Collections;

/**
 * Clase que representa el boneyard(cementerio) del juego.
 * 
 * @author (Gerardo G. Vazquez) 
 * @version (02/10/2023)
 */
public class BoneYard
{
    ArrayList <Ficha> monto;
    /**
     * Constructor for objects of class Boneyard
     */
    public BoneYard()
    {
        monto = new ArrayList();
    }

    /*
     * Metodo que crea las fichas dependiendo de la cantidad de jugadores.
     */
    public void llenarBoneYard(int numeroJugadores)
    {
        int maximo = 6; //Valor predeterminado para 2-3 jugadores.
        
        if(numeroJugadores >= 4 && numeroJugadores <=6 ){
            maximo = 9;
        }else if(numeroJugadores >= 7 && numeroJugadores <= 10){
            maximo = 12;
        }
        
        for(int i = 0; i <= maximo; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                Ficha ficha = new Ficha(j,i);
                monto.add(ficha);
            }
        }
        
    }
    
    /*
     * Metodo que muestra las fichas que estan en el boneyard.
     */
    public void mostrarBoneyard() {
        System.out.println("Fichas en el Boneyard:");
        for (Ficha ficha : monto) {
            System.out.print(ficha.toString() + " ");
        }
        System.out.println();
    }

    /*
     * Metodo que entrega las fichas iniciales a cada jugador.
     */
    public void repartirFichasJugadores(Jugador[] jugadores) {
        Collections.shuffle(monto);
        //Entrega 3 fichas aleatorias a cada jugador
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 3; i++) {
                if (!monto.isEmpty()) {
                    Ficha ficha = monto.remove(0);
                    jugador.recibirFicha(ficha);
                }
            }
        }
    }

    /*
     * Metodo que entrega a cada jugador una ficha aleatoria.
     */
    public Ficha tomarFichaAleatoria() {
        if (!monto.isEmpty()) {
            int indiceAleatorio = new Random().nextInt(monto.size()); // Genera un índice aleatorio
            Ficha ficha = monto.remove(indiceAleatorio); // Toma la ficha aleatoria del boneyard
            return ficha;
        } else {
            System.out.println("El boneyard está vacío.");
            return null; // Devuelve null si el boneyard está vacío
        }
    }

    /*
     * Metodo que regresa el tamano del boneyard.
     */
    public int numeroFichasRestantes() {
        return monto.size();
    }
}