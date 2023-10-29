import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
/**
 * Clase que representa el jugador del juego.
 * 
 * @author (Gerardo G. Vazquez) 
 * @version (02/10/2023)
 */

public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;
    private int puntuacion;

    /*
     * Constructor de la clase jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        puntuacion = 0;
    }
    
    /*
     * Metodo que regresa el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Metodo que regresa la mano del jugador.
     */
    public ArrayList<Ficha> getMano() {
        return mano;
    }
    
    /*
     * metodo que regresa si el Array mano esta vacio.
     */
    public boolean isEmpty() {
        return mano.isEmpty();
    }
    
    /*
     * Metodo que recibe las fichas para el jugador.
     */
    public void recibirFicha(Ficha ficha) {
        mano.add(ficha);
    }

    /*
     * Metodo que reinicia mano.
     */
    public void reiniciarMano() {
        mano.clear();
    }
    
    /*
     * Metodo que muestra la mano del jugador.
     */
    public void mostrarMano() {
        System.out.println("Mano de " + nombre + ":");
        for (Ficha ficha : mano) {
            ficha.mostrar();
            System.out.println(ficha.toString() + " ");
        }
        
    }
    
    /*
     * Metodo que calcula la suma de los puntos de sus fichas.
     */
    public int calcularPuntuacion() {
        for (Ficha ficha : mano) {
            puntuacion += ficha.getCara1() + ficha.getCara2();
        }
        return puntuacion;
    }

}
