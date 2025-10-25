package interfaz;
import dominio.*;
import interfaz.Auxiliar;
import java.util.*;
import java.util.regex.Pattern;

public class Interfaz {
    private final Sistema sistema;

    public Interfaz(Sistema elS) {
        this.sistema = elS;
    }
     public void iniciar(){
        Auxiliar.imprimirTitulo("MEDIO TA TE TI");
        String opcion = "a";
        while (!opcion.equalsIgnoreCase("e")) {

            

            System.out.println("Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y VICTORIA POU (283117) \n" + mostrarMenu());

            String [] letrasValidas={"a","b","c","d","e"};
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ", letrasValidas, "esas no son letras válidas, las letras validas son: \n"+mostrarMenu());

            switch (opcion) {
                case "a":
                    registrarJugador();
                    System.out.println("");
                    break;
                case "b":
                    boolean imprimio= ingresarJugadoresNuevaPartida();
                    if(imprimio){
                        jugando(empezarPartida());
                    }
                    System.out.println("");
                    break;
                case "c":
                    Auxiliar.imprimirTitulo("Continuacion de partida");
                    System.out.println("");
                    imprimio= ingresarJugadoresNuevaPartida();
                    if(imprimio){
                        Partida part= empezarPartida();
                        String losMovimientos =Auxiliar.ingresarPalabras("Ingrese las jugadas, con espacios:");
                        part.partidaComenzada(losMovimientos.toUpperCase());
                        Jugador jugadorGanador = part.ganador();
                        if(ganoAlguien(jugadorGanador)){
                            System.out.println(mostrarMatrizLogica(part));
                                
                        }else{
                            jugando(part);
                        }
                    }
                    
                    
                    break;
                case "d":
                    Auxiliar.imprimirTitulo("Lista de invictos: ");
                    Auxiliar.imprimirLista(this.sistema.listaInvictos(),"La lista de invictos está vacía", 1);
                    Auxiliar.imprimirTitulo("Ranking ganadores en orden decreciente: ");
                    Auxiliar.imprimirLista(this.sistema.rankingGanadores(), "No hay jugadores", 1);
                    
                    System.out.println("");
                    //check que funcione sout
                    break;
                default:
                    break;
            }
        }
    }
    public int validarNumeroJugador(){
        return 0;
        //VALIDAR NUMMM
    }
    //cambié esto!!!!!!!!!!!!!!!!!
    public boolean ingresarJugadoresNuevaPartida(){
        boolean imprimio =Auxiliar.imprimirLista(sistema.ordenarAlfabetic(), "Se necesitan al menos dos jugadores", 2);
        
        String mensajeError = "Elija un número de los que aparecen en la lista";
        return imprimio;
    }
    public Partida empezarPartida(){
        Partida part=null;
        String mensajeError = "Elija un número de los que aparecen en la lista";
        //boolean imprimio= ingresarJugadoresNuevaPartida();
        
        int numJugador1 = Auxiliar.ingresarNumero("Ingrese numero del jugador que arranca",1,sistema.getListaJugadores().size(),mensajeError);
        int numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del otro jugador",1,sistema.getListaJugadores().size(),mensajeError);
        //esto va aca???????
        while(numJugador2==numJugador1){
            System.out.println("Se deben elegir jugadores diferentes, reingrese el número del jugador que va segundo");
            Auxiliar.imprimirLista(sistema.ordenarAlfabetic(), "Se necesitan al menos dos jugadores", 2);
            numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del otro jugador",1,sistema.getListaJugadores().size(),mensajeError);

        }
        Jugador jugador1 = sistema.getListaJugadores().get(numJugador1 - 1);
        Jugador jugador2 = sistema.getListaJugadores().get(numJugador2 - 1);
        part = new Partida(jugador1, jugador2);
        
              
        return part;
        
        }
    public void mostrarTurno(Partida partida){
        String ret ="Es el turno del jugador "+ partida.jugadorBlaONeg() + " (" + partida.getJugadorActual() + ")";
        System.out.println(ret);
    }
    public void jugando(Partida partida){
        boolean termino=false;
        
        while(!termino){
            mostrarTurno(partida);
            
            System.out.print(mostrarMatrizLogica(partida));
            System.out.println(mostrarMenuJugando());
  
            termino =leerEntrada(partida);

            

        }
    }
    public String mostrarMenuJugando(){
        String ret="Puede ingresar: \n"
                + "-FilaColumnaSentido (ej.: A2C), para colocar su ficha (circulitos)"
                + " \n Fila: A, B o C"
                + " \n Columna: 1 a 6"
                + " \n Sentido C o D"
                + "\n-FilColumnaI (ej.:A2I) si quiere invertir una ficha propia, de C pasa a D o al revés (se indica la filas y columnas de la forma arriba)"
                + "\n'X', si usted quiere terminar la partida y perder"
                + "\n'H' si quiere ayuda"
                + "\n'B' si quiere ver los títulos en los bordes"
                + "\n'N' si no quiere ver los títulos en los bordes"
                + "\n'T', si termina en empate";
        return ret;
    }
    public String mostrarMatrizLogica (Partida partida){
        String matLogica [][] = partida.getTablero().getMatrizLogica();
        String ret ="";
        boolean mostrarFilasYColumnas = partida.getTablero().getMostrarFilasYColumnas();
        if(mostrarFilasYColumnas){
            String numeros ="  1  2  3  4  5  6";
            ret += numeros + "\n";
        }
        String separador= " +--+--+--+--+--+--+";
        String filas = "ABC";
        ret += separador +"\n";
        for (int i = 0; i < matLogica.length; i++) {
            for(int k=1; k<=3;k++){
                String cadena=" |";
                if(k==2 && mostrarFilasYColumnas){
                    cadena = ""+filas.charAt(i) +"|";
                }
                for (int j = 0; j < matLogica[i].length; j++) {
                    int elTurno = partida.getTablero().logicaGanadora();
                                       
                    if(!(partida.getTablero().hayGanador(elTurno))){
                        cadena +=darCirculito(i,k,j,matLogica,"o","●")+"|";
                        
                    }else{
                        cadena += darCirculitoGanador(i,k,j,partida.getTablero().getMatrizGanadores(),partida.getTablero().getMatrizLogica(),elTurno)+"|";
                    }
                    
                }
                ret += cadena + "\n";
            }
            ret += separador + "\n";                  
        }
        return ret;
    }
    
    public String darCirculito (int i, int k, int j, String [][] matLogica,String circulBla, String circulNeg){
        String circulito="";
        String ret="  ";
        if(null!=matLogica[i][j]){
            if(matLogica[i][j].charAt(1)=='1'){
                circulito=circulBla;
            }else{
                circulito=circulNeg;
            }
            char COD=matLogica[i][j].toUpperCase().charAt(0);
            if((COD=='C' && k%2!=0) || (COD=='D'&&k%2==0)){
                ret=" "+ circulito;
            }else{
                ret=circulito + " ";
            }
            
        }
        return ret;
        
    }
    public String darCirculitoGanador(int i, int k, int j, boolean [][] matGanadores, String [][]matLogica, int turno){
        String ret ="";
        
       if(matGanadores[i][j]){
           if(turno==1){
               ret += "OO";
           }else{
               ret += "XX";
           }          
           
       }else{
           ret = darCirculito(i,k,j,matLogica,"o","●");
       }
       return ret; 
    }
    public String []generarArrayOpcionesValidas(){
        String [] cadenaFilas = {"A","B","c"};
        String [] cadenaColumnas = {"1","2","3","4","5","6"};
        String [] cadenaSentidos = {"C","D","I"};
        String [] cadenasPosibles = new String[59];
        int l=0;
        for(int i=0 ; i<cadenaFilas.length; i++){
            for (int j = 0; j < cadenaColumnas.length; j++) {
                for(int k=0; k<cadenaSentidos.length; k++){
                    cadenasPosibles[l]= cadenaFilas[i]+cadenaColumnas[j]+cadenaSentidos[k];
                    l++;
                }
                
            }
        }
        String [] letras = {"B","N","T","H","X"};
        int j=0;
        for(int i=54; i<59; i++){
            cadenasPosibles[i] = letras[j];
            j++;

            }
        return cadenasPosibles;
             
}

  public boolean ganoAlguien(Jugador jugador){
      boolean gano = false;
      if(jugador != null){
        gano = true;
        System.out.println("Gano el jugador/a "+ jugador.getNombre());
        
        
     }
      return gano;
  } 


    public boolean leerEntrada(Partida partida){
        boolean termino = false;
        //borrar????
        String [][] matrizLogica = partida.getTablero().getMatrizLogica();
        //hay que especidicar que esta mal ????
        String opcion=Auxiliar.ingresarLetra("Ingrese jugada", generarArrayOpcionesValidas(), "Lo/s caracter/es ingresados no son válidos. "+ mostrarMenuJugando());
        String jugada="";
        if(opcion.length()==3){
            jugada=opcion;
            opcion="J";
            
        }
            switch (opcion.toUpperCase()) {
                case "J":                   
                    
                    Auxiliar.imprimirTitulo("JUGANDO...");
                    if (jugada.toUpperCase().charAt(2)=='I') {
                        if(!partida.getTablero().puedoInvertirFicha(jugada)){
                            System.out.println("No se puede invertir eso porque usted no colocó una ficha ahí anteriormente");
                        }else {
                            System.out.println("Ficha invertida con éxito");
                            Jugador jugadorGanador = partida.ganador();
                            if(ganoAlguien(jugadorGanador)){
                                termino = true;
                                System.out.print(mostrarMatrizLogica(partida));
                                
                            }
                        }
                    }else{
                        
                            
                        if(!partida.getTablero().agregarMovimiento(jugada)){
                            System.out.println("No puede colocar una ficha en ese lugar, porque ya hay una, ingrese una ficha en otro lugar");
                        }else{
                            Jugador jugadorGanador = partida.ganador();
                            if(ganoAlguien(jugadorGanador)){
                                termino = true;
                                System.out.print(mostrarMatrizLogica(partida));
                            
                           }

                        }
                        
                    }
                    
                    break;
                case "B"://se muestran filas y columnas
                    partida.getTablero().setMostrarFilasYColumnas(true);
                    mostrarMatrizLogica(partida);
                    System.out.println("");
                    break;
                case "N"://se ocultan filas y columans
                    partida.getTablero().setMostrarFilasYColumnas(false);
                    mostrarMatrizLogica(partida);
                    System.out.println("");
                    break;
                case "T":
                    System.out.println("Seleccionó empatar");
                    String [] opci={"s","n"};
                    //ESTA MAL CAMBIAR EL TURNO PORQUE SI EL OTRO DICE QUE NO, NO LE DA LA POSIBLIDAD DE JUGAR, por eso hay que volver a cambiarlo
                    partida.getTablero().cambiarTurno();
                    mostrarTurno(partida);
                    String quiso=Auxiliar.ingresarLetra("Confirma que desea empatar? S/N",opci , "Debe ingresar S o N");
                    if(quiso.equalsIgnoreCase("S")){
                        termino=true;
                    }else{
                        partida.getTablero().cambiarTurno();
                    }
                    //creo que no hay que poner else
                    
                    break;
                case "H":
                    System.out.println("Seleccionó ayuda");
                    if(partida.getTablero().movimientoAyuda()==null){
                        System.out.println("No hay jugada posible para ganar");
                    }else{
                        System.out.println("La jugada ganadora es: "+ partida.getTablero().movimientoAyuda());
                    }
                    break;
                case "X":
                    termino = true;
                    Auxiliar.imprimirTitulo("Ganó el jugador: "+partida.eligioPerder());       
                    break;
                    
                default:
                    System.out.println("Las opciones valias son y el texto de marti");
                    break;
                    
            }
            return termino;
        }
     public void registrarJugador () {
        Auxiliar.imprimirTitulo("Registrar jugador");
//ver si pedida de datos mas eficiente
        String regex = "^[a-zA-Z]+$";
        
        String nom = ingresarNombre();
        
        while(!Pattern.matches(regex,nom)){
            System.out.println("Ingrese una cadena de texto como nombre, no vacia y sin numeros");
            nom = ingresarNombre();
        }
        int edad = Auxiliar.ingresarNumero("ingresar edad", 5,100,"Error, la edad debe estar entre 5 y 100 (inclusive)");
            
        Jugador jugador=new Jugador(nom,edad);
        this.sistema.agregarJugador(jugador);
    }
    public String mostrarMenu(){
        String menu = 
                "a)Registrar jugador \n"
                + "b)Comienzo de partida común \n"
                + "c)Continuación de partida \n"
                + "d)Mostrar ranking de invictos \n"
                + "e)Salir del programa";
        
        return menu;
              
    }
    public String ingresarNombre (){
        String nombre=Auxiliar.ingresarPalabras("Ingrese nombre");
        boolean valido=this.sistema.nombreEsUnico(nombre);
        while(!valido){
            nombre=Auxiliar.ingresarPalabras("Reingrese nombre, el nombre que ingreso anteriormente ya está registado");
            valido=this.sistema.nombreEsUnico(nombre);
        }
        return nombre;
    }
    }

            
    

   
   