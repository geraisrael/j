import java.util.*;
/**
 * Representa el tablero de juego donde se colocan las fichas de dominó. 
 * Lleva un registro de las fichas jugadas y valida si una ficha se puede colocar en el tablero.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero
{
    // instance variables - replace the example below with your own
    private ArrayList<FichaDomino> fichaJuego;

    /**
     * Constructor for objects of class Tablero
     */
    public Tablero()
    {
        fichaJuego = new ArrayList();
        
    }

    public boolean movimientoValido(FichaDomino ficha)
    {
        for(FichaDomino fichaTablero: fichaJuego)
        {
            if(ficha.getCara1() == ficha.getCara1() || ficha.getCara1() == ficha.getCara2()
            || ficha.getCara2() == ficha.getCara1() || ficha.getCara2() == ficha.getCara2())
            {
                return true;    
            }
        }
        
        return false;
    }
    
    public void colocarFicha(FichaDomino ficha)
    {
        if(movimientoValido(ficha))
        {
            fichaJuego.add(ficha);
        }
        else
        {
            System.out.println("No se puede colocar esta ficha, tiene que tener la misma cantidad de puntos.");
        }
    }
    
}
