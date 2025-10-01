
package Dominio;


public class Tablero {
    private String [][][][] matrizAMostrar;
    private String [][] matrizLogica;
    private int turno;
    //el blanco es 1, el negro es 2
    public Tablero(){
        this.turno = 1;
        this.matrizAMostrar = new String[4][7][3][2];
        this.matrizLogica = new String[3][6];
        
    }
    /*
    public void analizarEntrada(){}
    public String agregarMovimiento(String movimiento){
    }
    public boolean terminarPartida(){
    }
    public int quienGano(){
    
    }
    public String jugadaGanadora(){
    
    }
    public String tableroAMostrar(){
    }
    public void ocultarFilas(){
    }
*/
    
}
