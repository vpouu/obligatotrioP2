

package dominio;


public class Tablero {
    private String [][] matrizLogica;
    private int turno;
    //el blanco es 1, el negro es 2
    public Tablero(){
        this.turno = 1;
        this.matrizLogica = new String[3][6];
        
        
    }

    public String[][] getMatrizLogica() {
        return matrizLogica;
    }

    private void setMatrizLogica(String[][] matrizLogica) {
        this.matrizLogica = matrizLogica;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    public int quienGano(){
        //TO DO: definir quien gano
        return 0;
    }
    
    //public void analizarEntrada(){}
    //si el ingreso es valido, eso va en la interfaz pero si el movimiento no es valido se verifica en
    public String[][] agregarMovimiento(String movimiento){
        String movMayus = movimiento.toUpperCase();
        char fila = movMayus.charAt(0);
        char col = movMayus.charAt(1);
        String dibujo = "" + movMayus.charAt(2)+turno;
        char arr[] = {'A','B','C'};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==fila){
                if(dibujo.charAt(0)=='I'){
                    if(matrizLogica[i][col].equals("C")){
                        matrizLogica[i][col]="D";
                    }else{
                        matrizLogica[i][col]="C";
                    }
                    
                    
                }else{
                    matrizLogica[i][col]=dibujo;
                }
                
            }
        }
        //ver su es apropiadocamviar turno aca
        cambiarTurno();
        return matrizLogica;
    }
    public int cambiarTurno (){
        int elTurno=1;
        if(this.turno==elTurno){
            this.turno=2;
        } 
        return turno;
    }
    //public String
    //si es I y no hay ninguna que hago
    /*● ○
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
