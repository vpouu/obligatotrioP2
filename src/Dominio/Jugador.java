/*
 Martina Gonzalez y Victoria Pou*/
package Dominio;


/**
 *
 * @author victo
 */
public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int edad;
    //?????????
    private int cantGanadas;
    private int cantJugadas;
    public void setNombre( String elNombre){
        this.nombre = elNombre;
    
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setEdad(int laEdad){
        this.edad = laEdad;
    }
    public int getEdad(){
        return this.edad;
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public int getCantJugadas(){
        return this.cantGanadas;
    }
    public void setCantJugadas(int cant){
        this.cantJugadas = cant;
    }
    public int getCantGanadas(){
        return this.cantGanadas;
    }
    public void setCantGanadas(int cant){
        this.cantGanadas = cant;
    }
    public boolean esInvicto(){
        boolean es = false;
        if(cantJugadas==0 || cantGanadas==0){
            es = true;
        }
        return es;
    }

    /**
     *
     * @param elNombre
     * @param laEdad
     */
    public Jugador(String elNombre, int laEdad){
        this.cantGanadas = 0;
        this.cantJugadas = 0;
=======
    public Jugador(String elNombre, int laEdad){
>>>>>>> Stashed changes
=======
    public Jugador(String elNombre, int laEdad){
>>>>>>> Stashed changes
        this.nombre = elNombre;
        this.edad = laEdad;
        
    }
    @Override
    public int compareTo(Jugador j){
        return this.getNombre().compareTo(j.getNombre());
    }
    
}