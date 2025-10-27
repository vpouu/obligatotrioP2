package dominio;
//Martina Gonzalez(332461) y Victoria Pou (283117)

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private Jugador jugadorActual;
    
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
    public Jugador ganador (){
        Jugador ret=null;
        if(this.tablero.logicaGanadora()==1){
            ret=this.jugador1;
            jugador1.setCantGanadas(jugador1.getCantGanadas()+1);
        }else{
            if(this.tablero.logicaGanadora()==2){// es necesario???
                ret=this.jugador2;
                jugador2.setCantGanadas(jugador2.getCantGanadas()+1);
            }
        }
        
        return ret;
    }
    //se asume valido significa que no va a intentar invertir algo que no le correspode???
    public void partidaComenzada(String movimientos){
        for(int i=0; i<movimientos.length(); i=i+4){
           tablero.agregarMovimiento(movimientos.substring(i, i+3));
        }
        
    }
    
    public Partida (Jugador j1, Jugador j2){
        this.jugador1=j1;
        
        this.jugador2=j2;
        this.jugador1.setCantJugadas(this.jugador1.getCantJugadas()+1);
        this.jugador2.setCantJugadas(this.jugador2.getCantJugadas()+1);
        this.tablero=new Tablero();
    }
    
    
    
}
