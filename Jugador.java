import java.util.*;
/**
 * Representa a un jugador con un nombre y una mano de fichas de dominó. 
 * Puede seleccionar fichas para jugar en su turno y tomar fichas del FichaAlmacen si es necesario.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    private ArrayList<FichaDomino> mano;
    private int numeroJugador;
    private int puntos;
    public Jugador()
    {
        mano = new ArrayList();
        numeroJugador = 0;
        puntos = 0;
    }
    
    public Jugador(int numeroJugador)
    {
        mano = new ArrayList();
        this.numeroJugador = numeroJugador;
        puntos = 0;
    }
    
    public void setMano(ArrayList<FichaDomino> mano)
    {
        this.mano = mano;    
    }
    
    public ArrayList<FichaDomino> getMano()
    {
        return mano;
    }
    
    public int getNumero()
    {
        return numeroJugador;
    }
    
    public void tomarFichaMonto(Monto monto)
    {
        if(!monto.estaVacio())
        {
            FichaDomino ficha = monto.tomarFicha();
            mano.add(ficha);
        }
    }
    
    public void ponerFichaTablero(FichaDomino ficha, Tablero tablero)
    {
        if(tablero.movimientoValido(ficha))
        {
            tablero.colocarFicha(ficha);
            mano.remove(ficha);
        }
    }
}
