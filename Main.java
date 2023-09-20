import java.util.*;
public class Main {
    /*public static void pruebaInicializacionJuego() {
    Juego juego = new Juego();
    juego.inicializarJuego();
    
    for (Jugador jugador : juego.getJugadores()) {
        System.out.println("Jugador " + jugador.getNumero() + ": " + jugador.getMano());
    }

    System.out.println("Jugador inicial: " + juego.getTurno());
}*/

    public static void pruebaSumaFichas()
    {
        Jugador jugador = new Jugador(1);
        ArrayList<FichaDomino> mano = new ArrayList<>();
        mano.add(new FichaDomino(3,5));
        mano.add(new FichaDomino(1,6));
        
        jugador.setMano(mano);
        Juego juego = new Juego();
        int suma = juego.sumaPuntosFichas(jugador.getMano());
        System.out.print("La suma es:" + suma);
    }


}
