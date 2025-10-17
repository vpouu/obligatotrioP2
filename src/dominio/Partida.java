package dominio;

import java.util.HashSet;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    // esta bien ???????
    private Jugador jugadorActual;

    public Jugador getJugadorActual() {
        this.jugadorActual=jugador2;
        if(tablero.getTurno()==1){
            this.jugadorActual=jugador1;
        }
        return jugadorActual;
    
    }
    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
    
    public String jugadorBlaONeg(){
        String ret="Blanco";
        if(this.tablero.getTurno()==2){
            ret="Negro";
        }
        return ret;
    }
      
    
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    //ganador
    //cual es el turno
    //xq por ej si es x ya termina el juego
    
    public Jugador ganador (){
        Jugador ret=null;
        if(this.tablero.logicaGanadora()==1){
            ret=this.jugador1;
        }else{
            if(this.tablero.logicaGanadora()==2){
                ret=this.jugador2;
            }
        }
        /*if(ret!=null){
            
        }*/
        return ret;
    }
    public void partidaComenzada(String movimientos){
        for(int i=0; i<movimientos.length(); i=i+3){
           
        }
        
    }
    public void sumarPartidasJugadas(){
        this.jugador1.setCantJugadas(this.jugador1.getCantJugadas()+1);
        this.jugador2.setCantJugadas(this.jugador2.getCantJugadas()+1);
        
        
    }
    public Partida (Jugador j1, Jugador j2){
        this.jugador1=j1;
        this.jugador2=j2;
        this.tablero=new Tablero();
    }
    
    
    
}
