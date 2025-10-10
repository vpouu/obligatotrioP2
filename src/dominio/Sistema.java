/* Victoria Pou y Martina Gonzalez*/
package dominio;
import java.util.*;


public class Sistema {

    /**
     * @param args the command line arguments
     */
    
    //ranking
    //suma poner comentarios
    private ArrayList<Jugador> listaJugadores;
    //hacer getter o setter de la lista?
    public Sistema (){
        listaJugadores= new ArrayList<>();
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    public boolean nombreEsUnico(String elNombre){
        boolean esUnico = true;
        for(Jugador jugador: listaJugadores){
            if(jugador.getNombre().equalsIgnoreCase(elNombre)){
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

