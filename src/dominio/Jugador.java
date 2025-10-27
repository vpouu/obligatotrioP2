package dominio;


/*
 Martina Gonzalez (332461) y Victoria Pou (283117) */

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int edad;
    private int cantGanadas;
    private int cantJugadas;
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre( String elNombre){
        this.nombre = elNombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int laEdad){
        this.edad = laEdad;
    }
    public int getCantJugadas(){
        return this.cantJugadas;
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
        
        if(cantJugadas==0 || (cantGanadas==cantJugadas)){
            es = true;
        }
        return es;
    }

    public Jugador(String elNombre, int laEdad){
        this.cantGanadas = 0;
        this.cantJugadas = 0;
        this.nombre = elNombre;
        this.edad = laEdad;
        
    }
    @Override
    public String toString() {
        return this.nombre + " - cantidad de partidas jugadas: " + cantJugadas + " - cantidad de partidas ganadas: "+ cantGanadas ;
    }
    @Override
    public int compareTo(Jugador j){
        return this.getNombre().compareTo(j.getNombre());
    }
   
}