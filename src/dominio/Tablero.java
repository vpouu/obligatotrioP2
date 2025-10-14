

package dominio;


public class Tablero {
    private String [][] matrizLogica;
    private int turno;
    private boolean mostrarFilasYColumnas = true;
    //el blanco es 1, el negro es 2
    public Tablero(){
        this.turno = 1;
        this.matrizLogica = new String[3][6];
        
        
    }
    public boolean getMostrarFilasYColumnas(){
        return mostrarFilasYColumnas;
    }
    public void setMostrarFilasYColumnas(boolean mostrar){
        this.mostrarFilasYColumnas = mostrar;
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
    //validar que jugador invierta solo las d ee´l
    public void agregarMovimiento(String movimiento){
        String movMayus = movimiento.toUpperCase();
        char fila = movMayus.charAt(0);
        int col = Character.getNumericValue(movMayus.charAt(1))-1;
        String dibujo = "" + movMayus.charAt(2)+turno;
        char arr[] = {'A','B','C'};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==fila){
                if(dibujo.charAt(0)=='I'){
                    if(matrizLogica[i][col].equals("C")){
                        matrizLogica[i][col]="D"+turno;
                    }else{
                        matrizLogica[i][col]="C"+turno;
                    }
                    
                    
                }else{
                   
                    matrizLogica[i][col]=dibujo;
                }
                
            }
        }
        //ver su es apropiadocamviar turno aca
        cambiarTurno();
        
    }
    public boolean puedoInvertirFicha(String movimiento){
        boolean ret=false;
        char arr[] = {'A','B','C'};
        char fila=movimiento.charAt(0);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==fila){
                if(!matrizLogica[i][movimiento.charAt(1)-1].equals(null)){
                    if(matrizLogica[i][movimiento.charAt(1)-1].charAt(1)==turno){
                        ret=true;
                        agregarMovimiento(movimiento);
                    }
                }
            }
        }
        return ret;
    }
                        
    public void cambiarTurno(){
        if(this.turno==1){
            this.turno=2;
        } else{
            this.turno=1;
        }
      
    }
   
    //public String
    
    //si es I y no hay ninguna que hago
    /*● ○
    public boolean terminarPartida(){
    }
    public int quienGano(){
    
    }
    public int quienGano(){
        return 0; 
    }
    public String jugadaGanadora(){
    
    }
*/
    
}
