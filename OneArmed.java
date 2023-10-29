import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase que ejecuta el juego.
 * 
 * @author (Gerardo G. Vazquez) 
 * @version (02/10/2023)
 */
public class OneArmed {
    private BoneYard boneYard;
    private boolean hayFichasEnBoneyard = true;
    private boolean juegoEnCurso;
    public OneArmed()
    {
        boneYard = new BoneYard();
        juegoEnCurso = true;
    }
    
    /*
     * Metodo que inicializa el juego y termina cuando se encuentra un ganador.
     */
    public void inicializarJuego() {
        Scanner scanner = new Scanner(System.in);
        int cantidadJugadores = obtenerCantidadJugadores(scanner);
        Jugador[] jugadores = crearJugadores(cantidadJugadores, scanner);
        
        Ficha fichaSeleccionada = new Ficha();
        boneYard = new BoneYard();
        boneYard.llenarBoneYard(cantidadJugadores);
        boneYard.repartirFichasJugadores(jugadores);

        ArrayList<Ficha> tablero = new ArrayList<>();
        int jugadorActual = 0;

        while (juegoEnCurso) {
            Jugador jugador = jugadores[jugadorActual];

            System.out.println("Turno de " + jugador.getNombre());
            jugador.mostrarMano();

            boolean fichaColocada = false;

            while (!fichaColocada) {
                System.out.println("Ingresa el indice de la ficha: ");
                System.out.println("(presiona 'N' para cambiar de turno cuando se requiera, ");
                System.out.println("presiona 0 para tomar fichas del boneyard.): ");
                String opcion = scanner.next();
                
                if (opcion.equalsIgnoreCase("N")) {
                    if (!hayFichasEnBoneyard) {
                        // El jugador decide pasar su turno
                        jugador.mostrarMano();
                        mostrarTablero(tablero);
                        fichaColocada = true;
                    } else {
                        System.out.println("No puedes pasar tu turno mientras haya fichas en el boneyard.");
                    }
                } else {
                    try {
                        int indice = Integer.parseInt(opcion);
                        if (indice == 0) {
                            if (hayFichasEnBoneyard) {
                                Ficha fichaAleatoria = boneYard.tomarFichaAleatoria();
                                if (fichaAleatoria != null) {
                                    mostrarTablero(tablero);
                                    jugador.recibirFicha(fichaAleatoria);
                                    jugador.mostrarMano();
                                    System.out.println("Fichas restantes en el Boneyard: " + boneYard.numeroFichasRestantes());
                                    if (boneYard.numeroFichasRestantes() == 0) {
                                        hayFichasEnBoneyard = false;
                                    }
                                } else {
                                    System.out.println("El boneyard está vacío. Debes elegir una ficha de tu mano.");
                                }
                            } else {
                                System.out.println("Ya no quedan fichas en el boneyard.");
                            }
                        } else if (indice > 0 && indice <= jugador.getMano().size()) {
                            fichaSeleccionada = jugador.getMano().get(indice - 1);
                            
                            if (movimientoValidoFicha(fichaSeleccionada, tablero)) {
                                if (tablero.isEmpty()) {
                                    tablero.add(fichaSeleccionada);
                                } else {
                                    int ultimaFicha = tablero.get(tablero.size() - 1).getCara2();
                                    int fichaActual = fichaSeleccionada.getCara1();

                                    if (ultimaFicha != fichaActual) {
                                        fichaSeleccionada.girarCaras();
                                    }
                                    tablero.add(fichaSeleccionada);
                                }
                                jugador.getMano().remove(indice - 1);
                                jugador.mostrarMano();
                                mostrarTablero(tablero);

                                fichaColocada = true;
                            } else {
                                System.out.println("No puedes colocar la ficha en el tablero.");
                            }
                        }
                    }   catch (NumberFormatException e) {
                        // Captura excepción si el jugador ingresa una acción no válida
                        System.out.println("Acción no válida. Ingresa el índice de la ficha que deseas colocar o 'S' para pasar.");
                    }
                }
            }

            if (jugador.isEmpty()) {
                System.out.println("¡" + jugador.getNombre() + " ya no tiene fichas!");

                int puntuacionTotal = calcularPuntuacion(jugadores);
                System.out.println("Puntuación total de todos los jugadores: " + puntuacionTotal);

                if (puntuacionTotal < 20) {
                    System.out.println("La puntuación total no supera  los 20 puntos. Se reinicia el juego.");

                    for (Jugador j : jugadores) {
                        j.reiniciarMano();
                    }
                    boneYard = new BoneYard();
                    boneYard.llenarBoneYard(cantidadJugadores);
                    boneYard.repartirFichasJugadores(jugadores);

                    tablero.clear();
                    hayFichasEnBoneyard = true;
                } else {
                    System.out.println("La puntuación total supera los 20 puntos. Game Over.");
                    juegoEnCurso = false;
                }
            }

            jugadorActual = (jugadorActual + 1) % jugadores.length;
        }
    }

    /*
     * Metodo que regresa la cantidad de jugadores a jugar.
     */
    public int obtenerCantidadJugadores(Scanner scanner)
    {
        System.out.println("Cuantos jugadores seran ? ");
        int cantidadJugadores = scanner.nextInt();
        
        return cantidadJugadores;
    }
    
    /*
     * Metodo que crea a los jugadores y los mete al arreglo de jugadores.
     */
    public Jugador[] crearJugadores(int cantidad, Scanner scanner)
    {
        Jugador[] jugadores = new Jugador[cantidad];
            for (int i = 0; i < cantidad; i++) {
            System.out.print("Jugador" + (i + 1) + " " + "Ingresa tu nombre:");
            String nombre = scanner.next();
            jugadores[i] = new Jugador(nombre);
        }
        
        return jugadores;
    }
    
    /*
     * Metodo que verifica si una ficha se puede poner en el tablero.
     */
    public boolean movimientoValidoFicha(Ficha ficha, ArrayList<Ficha> tablero) {
        if (tablero.isEmpty()) {
            return true; // Puede colocar cualquier ficha si el tablero está vacía
        } else {
            Ficha ultimaFicha = tablero.get(tablero.size() - 1);

            int ultimaFichaCara2 = ultimaFicha.getCara2();
            int fichaNuevaCara1 = ficha.getCara1();
            int fichaNuevaCara2 = ficha.getCara2();

            if (ultimaFichaCara2 == fichaNuevaCara1) {
                ficha.girarCaras(); // Voltear la ficha si coincide la cara derecha con la izquierda
            } else if (ultimaFichaCara2 != fichaNuevaCara2) {
                ficha.girarCaras(); 
            }

            return ultimaFichaCara2 == fichaNuevaCara1 || ultimaFichaCara2 == fichaNuevaCara2;
        }
    }

    /*
     * Metodo que calcula la puntuacion de todos los jugadores.
     */
    public int calcularPuntuacion(Jugador[] jugadores) {
        int puntuacionTotal = 0;
        for (Jugador jugador : jugadores) {
            puntuacionTotal += jugador.calcularPuntuacion();
        }
        return puntuacionTotal;
    }

    /*
     * Metodo que muestra las fichas que estan en el tablero.
     */
    public void mostrarTablero(ArrayList<Ficha> tablero) {
        System.out.println("Tablero:");
        for (Ficha ficha : tablero) {
            System.out.print(ficha.toString() + " ");
        }
        System.out.println();
    }
}