/* Victoria Pou y Martina Gonzalez*/
package Dominio;
import java.util.*;


public class Sistema {

    /**
     * @param args the command line arguments
     */
    
    
    private ArrayList<Jugador> listaJugadores;
    public boolean nombreEsUnico(String elNombre){
        boolean esUnico = true;
        for(Jugador jugador: listaJugadores){
            if(jugador.getNombre().equals(elNombre)){
                esUnico = false;
            }
        }
        return esUnico;
                
    
    }
    public void agregarJugador(Jugador elJugador){
        listaJugadores.add(elJugador);       
    }
}
