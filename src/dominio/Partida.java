package dominio;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    //ganador
    //cual es el turno
    //xq por ej si es x ya termina el juego
    
    public Jugador ganador (){
        Jugador ret;
        if(this.tablero.quienGano()==1){
            ret=this.jugador1;
        }else{
            ret=this.jugador2;
        }
        return ret;
    }
    public Partida (Jugador j1, Jugador j2){
        this.jugador1=j1;
        this.jugador2=j2;
        this.tablero=new Tablero();
    }
}
