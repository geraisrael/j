import java.util.*;
/**
 * Write a description of class OneArmedDomino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    // instance variables - replace the example below with your own
    private Tablero tableroJuego;
    private Monto montoJuego;
    private Jugador[] jugadores;
    private int player;
    private int turno;
    
    /**
     * Constructor for objects of class OneArmedDomino
     */
    public Juego()
    {
        this.tableroJuego = new Tablero();
        montoJuego = new Monto();
        player = cantidadJugadores();
        jugadores = new Jugador[player];
        for(int i = 0; i < player; i++)
        {
            jugadores[i] = new Jugador(i + 1);    
        }
        
    }

    public int cantidadJugadores()
    {
        Scanner cantidad = new Scanner(System.in);
        System.out.println("Cuantos Jugadores Seran ?");
        player = cantidad.nextInt();
        while(player < 2 || player > 10)
        {
            System.out.println("Debes de ingresar una cantidad valida.");
            System.out.println("Cuantos Jugadores Seran ?");
            player = cantidad.nextInt();
        }
        
        return player;
    }
    
    public void inicializarJuego()
    {
        int numJugadores = jugadores.length;
        montoJuego.llenar(numJugadores);
        montoJuego.barajar();
        
        //Distribuir 3 fichas a cada jugador
        for(Jugador jugador: jugadores)
        {
            for(int i = 0; i < 3; i++)
            {
                jugador.tomarFichaMonto(montoJuego);    
            }
        }
        
        Jugador jugadorInicial = jugadorInicial();
        //Establecer el turno en el jugador inicial
        turno = jugadorInicial.getNumero();
        
    }
    
    public Jugador jugadorInicial()
    {
        Jugador jugadorFichaMaxima = jugadores[0];
        
        for(Jugador jugador: jugadores)
        {
            int sumaFicha = sumaPuntosFichas(jugador.getMano());
            if(sumaFicha > sumaPuntosFichas(jugadorFichaMaxima.getMano()))
            {
                jugadorFichaMaxima = jugador;
            }
            
        }
        return jugadorFichaMaxima;
        
    }
    
    public int sumaPuntosFichas(ArrayList<FichaDomino> fichas)
    {
        int suma = 0;
        for(FichaDomino ficha: fichas)
        {
            suma += ficha.getCara1() + ficha.getCara2();
        }
        return suma;
    }
    
    public int getTurno()
    {
        return turno;
    }
    
    public Jugador[] getJugadores()
    {
        return jugadores;
    }
}
