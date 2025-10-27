package interfaz;
import dominio.*;
import interfaz.Auxiliar;
import java.util.*;
import java.util.regex.Pattern;
/* Victoria Pou (283117) y Martina Gonzalez(332461)*/
public class Interfaz {
    private final Sistema sistema;

    public Interfaz(Sistema elS) {
        this.sistema = elS;
    }
     public void iniciar(){
        Auxiliar.imprimirTitulo("MEDIO TA TE TI");
         System.out.println("Explicación breve del juego:"
                 + "\n- El objetivo del juego es formar círculos (jugador blanco) o cruces (jugador negro)"
                 + "\n- Comienza el jugador que se elige primero al comenzar la partida (va a ser el blanco)"
                 + "\n- Se pueden formar círculos o cruces, tanto en vertical, como en horizontal o diagonal"
                 + "\n ");
        String opcion = "a";
        while (!opcion.equalsIgnoreCase("e")) {

            

            System.out.println("Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y VICTORIA POU (283117) \n" + mostrarMenu());

            String [] letrasValidas={"a","b","c","d","e"};
            System.out.println("");
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ", letrasValidas, "Ingrese una de las letras válidas del menú (a,b,c,d,e): \n"+mostrarMenu());

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
                        String losMovimientos =Auxiliar.ingresarPalabras("Ingrese las jugadas, con espacios (ej.: A3D B3C A3I C4C):");
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
                    System.out.println("");
                    Auxiliar.imprimirTitulo("Ranking ganadores en orden decreciente: ");
                    Auxiliar.imprimirLista(this.sistema.rankingGanadores(), "No hay jugadores", 1);
                    
                    System.out.println("");
                    
                    break;
                default:
                    break;
            }
        }
    }
    
    public boolean ingresarJugadoresNuevaPartida(){
        boolean imprimio =Auxiliar.imprimirLista(sistema.ordenarAlfabetic(), "Se necesitan al menos dos jugadores", 2);
        
        return imprimio;
    }
    public Partida empezarPartida(){
        Partida part=null;
        String mensajeError = "Elija un número de los que aparecen en la lista";
        
        
        int numJugador1 = Auxiliar.ingresarNumero("Ingrese numero del jugador que arranca",1,sistema.getListaJugadores().size(),mensajeError);
        int numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del otro jugador",1,sistema.getListaJugadores().size(),mensajeError);
        
        while(numJugador2==numJugador1){
            Auxiliar.imprimirSubtitulo("Se deben elegir jugadores diferentes, reingrese el número del jugador que va segundo");
            Auxiliar.imprimirLista(sistema.ordenarAlfabetic(), "Se necesitan al menos dos jugadores", 2);
            numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del otro jugador",1,sistema.getListaJugadores().size(),mensajeError);

        }
        Jugador jugador1 = sistema.getListaJugadores().get(numJugador1 - 1);
        Jugador jugador2 = sistema.getListaJugadores().get(numJugador2 - 1);
        part = new Partida(jugador1, jugador2);
        
              
        return part;
        
    }
    public void mostrarTurno(Partida partida){
        String ret ="Es el turno del jugador "+ partida.jugadorBlaONeg() + " (" + partida.getJugadorActual().getNombre() + ")";
        Auxiliar.imprimirSubtitulo(ret);
    }
    public void jugando(Partida partida){
        boolean termino=false;
        
        while(!termino){
            
            
            System.out.print(mostrarMatrizLogica(partida));
            mostrarTurno(partida);
            System.out.println(mostrarMenuJugando());
            termino =leerEntrada(partida);

            

        }
    }
    public String mostrarMenuJugando(){
        String ret="Puede ingresar: \n"
                + "-FilaColumnaSentido (ej.: A2C), para COLOCAR su FICHA (circulitos)"
                + " \n  Fila: A, B o C"
                + " \n  Columna: del 1 a 6"
                + " \n  Sentido: C o D"
                + "\n-FilColumnaI (ej.:A2I) si quiere INVERTIR una FICHA PROPIA, de C pasa a D o al revés (se indican la filas y columnas igual que arriba)"
                + "\n-X: TERMINA la partida y usted pierde"
                + "\n-H: solicita AYUDA (jugada ganadora)"
                + "\n-B: solicita MOSTRAR los ÍNDICES(A,B,C,1,...,6) en los bordes del tablero"
                + "\n-N: solicita OCULTAR los ÍNDICES(A,B,C,1,...,6) de los bordes del tablero"
                + "\n-T: solicita EMPATE";
        return ret;
    }
    public String mostrarMatrizLogica (Partida partida){
        System.out.println("");
        
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
        Auxiliar.imprimirTitulo("Gano el jugador/a "+ jugador.getNombre());
        
        
     }
      return gano;
    } 


    public boolean leerEntrada(Partida partida) {
        boolean termino = false;
        String[][] matrizLogica = partida.getTablero().getMatrizLogica();
        String opcion = "";
        String jugada = "";
        if (partida.getTablero().empataron()) {
            opcion = "E";
            termino = true;
        } else {
            System.out.println("");
            opcion = Auxiliar.ingresarLetra("Ingrese jugada", generarArrayOpcionesValidas(), "El/Los caracter/es ingresados no son válidos. " + mostrarMenuJugando());
            jugada = "";
            if (opcion.length() == 3) {
                jugada = opcion;
                opcion = "J";

            }

        }

        switch (opcion.toUpperCase()) {
            case "J":

                Auxiliar.imprimirTitulo("JUGANDO...");

                if (jugada.toUpperCase().charAt(2) == 'I') {
                    if (!partida.getTablero().puedoInvertirFicha(jugada)) {
                        Auxiliar.imprimirSubtitulo("No se puede invertir eso porque usted no colocó una ficha ahí anteriormente");
                    } else {
                        Auxiliar.imprimirSubtitulo("Ficha invertida con éxito");
                        Jugador jugadorGanador = partida.ganador();
                        if (ganoAlguien(jugadorGanador)) {
                            termino = true;
                            System.out.print(mostrarMatrizLogica(partida));

                        }
                    }
                } else {

                    if (!partida.getTablero().agregarMovimiento(jugada)) {
                        Auxiliar.imprimirSubtitulo("No puede colocar una ficha en ese lugar, porque ya hay una, ingrese una ficha en otro lugar");
                    } else {
                        Jugador jugadorGanador = partida.ganador();
                        if (ganoAlguien(jugadorGanador)) {
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
                String[] opci = {"s", "n"};
                partida.getTablero().cambiarTurno();
                mostrarTurno(partida);
                String quiso = Auxiliar.ingresarLetra("Confirma que desea empatar? S/N", opci, "Debe ingresar S o N");
                if (quiso.equalsIgnoreCase("S")) {
                    Auxiliar.imprimirTitulo("Empataron");
                    termino = true;
                } else {
                    partida.getTablero().cambiarTurno();
                }

                break;
            case "H":
                System.out.println("Seleccionó ayuda");
                if (partida.getTablero().movimientoAyuda() == null) {
                    Auxiliar.imprimirSubtitulo("No hay jugada posible para ganar");
                } else {
                    Auxiliar.imprimirSubtitulo("La jugada ganadora es: " + partida.getTablero().movimientoAyuda());
                }
                break;
            case "X":
                termino = true;
                Auxiliar.imprimirTitulo("Perdió el jugador/a: " + partida.getJugadorActual());
                break;
            case "E":
                termino = true;
                Auxiliar.imprimirTitulo("Empataron porque se lleno el tablero");
            default:
                Auxiliar.imprimirSubtitulo("Las opciones válidas son: " + mostrarMenuJugando());
                break;

        }
        return termino;
    }
     public void registrarJugador () {
        Auxiliar.imprimirTitulo("Registrar jugador");
        String regex = "^[a-zA-Z]+$";
        
        String nom = ingresarNombre();
        
        while(!Pattern.matches(regex,nom)){
            Auxiliar.imprimirSubtitulo("Ingrese una cadena de texto como nombre, no vacía y sin números");
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

            
    

   
   