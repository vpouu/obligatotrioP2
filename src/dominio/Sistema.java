package dominio;
/* Victoria Pou (283117) y Martina Gonzalez (332461)*/
import java.util.*;


public class Sistema {
    
    private ArrayList<Jugador> listaJugadores;
    
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
    public ArrayList<Jugador> rankingGanadores(){
        Collections.sort(listaJugadores, new Comparator<Jugador>(){
            @Override
            public int compare(Jugador j1, Jugador j2){
                return j2.getCantGanadas()-j1.getCantGanadas();
            }
        });
        return listaJugadores;
    }
    
    
 }

