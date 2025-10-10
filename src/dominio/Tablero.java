/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package dominio;


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
        return matrizLogica;
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
