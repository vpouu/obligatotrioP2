/* Victoria Pou y Martina Gonzalez*/
package Dominio;
import java.util.*;


public class Sistema {

    /**
     * @param args the command line arguments
     */
    
    
    private ArrayList<Jugador> listaJugadores;
    //hacer getter o setter de la lista?
    public boolean nombreEsUnico(String elNombre){
        boolean esUnico = true;
        for(Jugador jugador: listaJugadores){
            if(jugador.getNombre().equals(elNombre)){
                esUnico = false;
            }
        }
        return esUnico;
                
    
    }
    //es un set?
    public void agregarJugador(Jugador elJugador){
        listaJugadores.add(elJugador);       
    }

    public ArrayList<Jugador> ordenarAlfabetic(){
        Collections.sort(listaJugadores);
        return listaJugadores;
         
    }
    public ArrayList<Jugador> listaInvictos(){
        ArrayList<Jugador> listaOrdenada= ordenarAlfabetic();
        ArrayList<Jugador> listaInvictos= new ArrayList<>();
        for(Jugador jugador: listaOrdenada){
            if(jugador.esInvicto()){
                listaInvictos.add(jugador);
                
            }
        }
        return listaInvictos;
        
    
    }
    //hacer uno que ordene decreciente por cantidad partidas ganadas
    
 }

