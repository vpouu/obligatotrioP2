package dominio;


public class Tablero {
    private String [][] matrizLogica;
    private int turno;
    private boolean mostrarFilasYColumnas = true;
    private int cantMov;
    //el blanco es 1, el negro es 2
    public Tablero(){
        this.turno = 1;
        this.matrizLogica = new String[3][6];
        this.cantMov=0;
        
        
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
    public int logicaGanadora(){
        int ret=0;
        if(this.cantMov>=6){
            if(hayGanador(this.turno)){
                ret=this.turno;
            }else{
                int otroTurno=1;
                if(otroTurno==this.turno){
                    otroTurno=2;
                }
                if(hayGanador(otroTurno)){
                    ret=2;
                }
           
            }
        }
        return ret;          
        
    }
    public boolean hayGanador(int elTurno){
        char primeraLetra = 'D';
        char segundaLetra='C';
        if(elTurno==1){
            primeraLetra = 'C';
            segundaLetra = 'D';
        }
        boolean encontro=false;
        for (int i = 0; i < matrizLogica.length && !encontro; i++) {
            boolean filaGanadora=true;
            for (int j = 0; j < matrizLogica[i].length-1 && filaGanadora; j+=2) {
                if(matrizLogica[i][j] != null && matrizLogica[i][j+1] != null){
                    if(matrizLogica[i][j].charAt(0)!=primeraLetra || matrizLogica[i][j+1].charAt(0)!=segundaLetra){
                        filaGanadora=false;
                    }
                }else{
                    filaGanadora=false;
                }
            }
            if(filaGanadora){
                encontro=true;
            }
        }
        for (int j = 0; j < matrizLogica[0].length-1 && !encontro; j+=2) {
            boolean columnaGanadora=true;
            for (int i = 0; i < matrizLogica.length && columnaGanadora; i++) {
                if(matrizLogica[i][j] != null && matrizLogica[i][j +1] != null){
                    if(matrizLogica[i][j].charAt(0)!=primeraLetra || matrizLogica[i][j+1].charAt(0)!=segundaLetra){
                        columnaGanadora=false;
                    }
                }else{
                    columnaGanadora = false;
                }
            }
            if(columnaGanadora){
                encontro=true;
            }
        }
        
        int i=0;
        int j=0;
        
        if(!encontro){
            
            for (int k = 0; k < 3; k++) {
                boolean diagonalGanadora=true;
                j=k;
                i=0;
                while(posValida(i,j) && posValida(i,j+1) && diagonalGanadora){
                    if(matrizLogica[i][j]!=null && matrizLogica[i][j+1] != null){
                        if(matrizLogica[i][j].charAt(0)!=primeraLetra || matrizLogica[i][j+1].charAt(0)!=segundaLetra){
                            diagonalGanadora=false;
                        }
                    }else{
                        diagonalGanadora = false;
                    }
                    i++;
                    j++;
                }
                if(diagonalGanadora){
                    encontro=true;
                }
            }
            
        }
        if(!encontro){
                 
            
            for (int k = 0; k < 3; k++) {
                boolean diagonalGanadora=true;
                j=k;
                i=2;
                //posvalida esta bie????
                while(posValida(i,j+1) && posValida(i,j)&& diagonalGanadora){
                    if(matrizLogica[i][j] != null && matrizLogica[i][j+1] != null){
                        if(matrizLogica[i][j].charAt(0)!=primeraLetra || matrizLogica[i][j+1].charAt(0)!=segundaLetra){
                            diagonalGanadora=false;
                        }
                    }else{
                        diagonalGanadora = false;
                    }
                    i--;
                    j++;
                }
                if(diagonalGanadora){
                    encontro=true;
                }
            }
            
        }
        
        
            
        
        return encontro;
    }
    public boolean posValida(int i, int j){
        return i<matrizLogica.length && i>=0 && j<matrizLogica[0].length && j>=0;
                
    }
    
    
    //public void analizarEntrada(){}
    //si el ingreso es valido, eso va en la interfaz pero si el movimiento no es valido se verifica en
    //validar que jugador invierta solo las d ee´l
    //ARREGLAR QUE SI YA HAY UNA FICHA PUESTA QUE NO DEJE VOLVER A PONER!!!!!!!!!!!!!!!!!!!
    public boolean agregarMovimiento(String movimiento){
        boolean pudoAgregarlo=true;
        String movMayus = movimiento.toUpperCase();
        char fila = movMayus.charAt(0);
        int col = Character.getNumericValue(movMayus.charAt(1))-1;
        String dibujo = "" + movMayus.charAt(2)+turno;
        char arr[] = {'A','B','C'};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==fila){
                if(dibujo.charAt(0)=='I'){
                    if(matrizLogica[i][col].equals("C"+turno)){
                        matrizLogica[i][col]="D"+turno;
                    }else{
                        matrizLogica[i][col]="C"+turno;
                    }
                    cambiarTurno();
                }else{
                   if(matrizLogica[i][col] != null){
                       pudoAgregarlo=false;
                   }
                   else{
                        matrizLogica[i][col]=dibujo;     
                        cambiarTurno();
                   }
                }
                
            }
        }
        if(pudoAgregarlo){
            this.cantMov++;
        }
        //ver su es apropiadocamviar turno aca
        return pudoAgregarlo;
        
    }
    public char letraOpuesta(char letra){
        char ret='C';
        if(letra=='C'||letra == 'c'){
            ret='D';
        }
        return ret;
    }
  
    public boolean puedoInvertirFicha(String movimiento){
        boolean ret=false;
        char arr[] = {'A','B','C'};
        char fila=movimiento.toUpperCase().charAt(0);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==fila){
                if(matrizLogica[i][Character.getNumericValue(movimiento.charAt(1))-1]!=null){
                    if(Character.getNumericValue(matrizLogica[i][Character.getNumericValue(movimiento.charAt(1))-1].charAt(1))==turno){
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
    public char transformarNumALetra (int num){
        char letr []= {'A', 'B','C'};
        return letr[num];
    }
    public String movimientoAyuda(){
        String mov=null;
        if(cantMov>=6){
            for (int i = 0; i < matrizLogica.length && mov==null; i++) {
                for (int j = 0; j < matrizLogica[0].length && mov==null; j++) {
                    if(matrizLogica[i][j]!= null && Character.getNumericValue(matrizLogica[i][j].charAt(1))==this.turno){
                        String aux= matrizLogica[i][j];
                        matrizLogica[i][j]=""+letraOpuesta(matrizLogica[i][j].charAt(0))+turno;
                        if(hayGanador(this.turno)){
                            mov=""+(transformarNumALetra(i))+""+(j+1)+"I";
                            System.out.println(i);
                            System.out.println(j);
                            System.out.println(mov);
                      
                            System.out.println(transformarNumALetra(i));
                        }
                        matrizLogica[i][j]=aux;
                        
                    }else{
                        char[]COD={'C','D'};
                        for(int k=0; k<2 && mov==null; k++){
                            matrizLogica[i][j]=""+COD[k]+turno;
                            if(hayGanador(this.turno)){
                                mov=""+(transformarNumALetra(i))+""+(j+1)+COD[k];
                                
                            }
                            if(mov!=null){
                                System.out.println(i);
                                System.out.println(j);
                                System.out.println(mov);
                                System.out.println(k);
                                System.out.println(transformarNumALetra(i));
                            }
                            matrizLogica[i][j]=null;
                        }
                    }
                    
                    
                }
                
            }
        }           
        return mov;
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
