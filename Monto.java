import java.util.*;
import java.util.Collections;
/**
 * Representa el conjunto de fichas de dominó que no están en juego inicialmente. 
 * Los jugadores pueden tomar fichas de aquí en su turno si no tienen una jugada válida.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monto
{
    private ArrayList<FichaDomino> monto;

    /**
     * Constructor for objects of class FichaLibre
     */
    public Monto()
    {
        monto = new ArrayList();
    }

    public ArrayList<FichaDomino> getMonto()
    {
        return monto;
    }
    
    public void llenar(int numeroJugadores)
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
                FichaDomino ficha = new FichaDomino(j,i);
                monto.add(ficha);
            }
        }
    }
    
    public void mostrarFichas()
    {
        for(int i = 0; i < monto.size(); i++)
        {
            if(i % 7 == 0)
            {
                System.out.print("\n");
            }
            System.out.print(i+1 +":" +"" +monto.get(i).toString() +" ");
        }
    }
    
    public FichaDomino tomarFicha()
    {
        if(!monto.isEmpty())
        {
            return monto.remove(0);  
        }
            else{
                return null;
            }
    }
    
    public void barajar()
    {
        Collections.shuffle(monto);
    }
    
    public boolean estaVacio()
    {
        return monto.isEmpty();
    }
}
