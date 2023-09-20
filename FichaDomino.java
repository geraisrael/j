
/**
 * Representa una ficha de dominó con valores numéricos en sus lados. 
 * Tiene métodos para verificar la compatibilidad con otras fichas.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FichaDomino
{
    private int cara1;
    private int cara2;
    private boolean esVisible;

    /**
     * Constructor for objects of class FichaDomino
     */
    public FichaDomino()
    {
        cara1 = 0;
        cara2 = 0;
        esVisible = false;
        
    }
     
    public FichaDomino(int caraA, int caraB)
    {
        cara1 = caraA;
        cara2 = caraB;
        esVisible = true;    
    }
    
    public String toString()
    {
        if(esVisible)
            return ("[" +cara1 + "|" +cara2 +"]");
        else
            return ("[?|?]");
            
    }
    
    public void girar()
    {
        int aux = cara1;
        cara1 = cara2;
        cara2 = aux;
    }
    
    public void setCara1(int cara1)
    {
        this.cara1 = cara1;    
    }
    
    public void setCara2(int cara2)
    {
        this.cara2 = cara2;    
    }
    
    public int getCara1()
    {
        return cara1;    
    }
    
    public int getCara2()
    {
        return cara2;
    }
    
    public void mostrar()
    {
        esVisible = true;
        System.out.print(toString());
    }
    
    public void ocultar()
    {
        esVisible = false;
    }
}
