/**
 * Clase que modela la ficha de domino.
 * 
 * @author (Gerardo G. Vazquez) 
 * @version (02/10/2023)
 */
public class Ficha {
    private int cara1;
    private int cara2;
    private boolean visible;

    /*
     * Constructor con parametros de la clase Ficha.
     */
    public Ficha(int caraA, int caraB) {
        visible = true;
        cara1 = caraA;
        cara2 = caraB;
    }
    
    /*
     * Constructor de la clase Ficha.
     */
    public Ficha()
    {
        visible = true;
        cara1 = 0;
        cara2 = 0;
    }
    
    /*
     * Metodo que voltea la ficha(no se vea)
     */
    public void voltear() {
        visible = false;
    }
    
    /*
     * Metodo que muestra la ficha.
     */
    public void mostrar() {
        visible = true;
    }

    public void setCara1(int cara1) {
        this.cara1 = cara1;
    }

    public void setCara2(int cara2) {
        this.cara2 = cara2;
    }
    
    public int getCara1() {
        return cara1;
    }

    public int getCara2() {
        return cara2;
    }

    public boolean isVisible() {
        return visible;
    }
    
    /*
     * Metodo que invierte los valores de la ficha.
     */
    public void girarCaras() {
        int aux = cara1;
        this.cara1 = cara2;
        this.cara2 = aux;
    }

    /*
     * Metodo que muestra los valores de la ficha.
     */
    public String toString() {
        if (visible) {
            return "[" + cara1 + "|" + cara2 + "]";
        } else {
            return "[?|?]";
        }
    }

}