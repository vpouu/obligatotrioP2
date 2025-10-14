package interfaz;
//tengo qwue explicar en serio como se juega???????
import dominio.*;


public class Interfaz {
    private final Sistema sistema;

    public Interfaz(Sistema elS) {
        this.sistema = elS;
    }
     public void iniciar(){
        Auxiliar.imprimirTitulo("MEDIO TA TE TI");
        String opcion = "a";
        while (!opcion.equalsIgnoreCase("e")) {

            System.out.println(mostrarMenu());

            System.out.println("Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y VICTORIA POU (283117) \n" + mostrarMenu());

            String [] letrasValidas={"a","b","c","d","e"};
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ", letrasValidas, "esas no son letras válidas, las letras validas son:"+mostrarMenu());

            switch (opcion) {
                case "a":
                    registrarJugador();
                    System.out.println("");
                    break;
                case "b":
                    empezarPartida();
                    System.out.println("");
                    break;
                case "c":
                    Auxiliar.imprimirTitulo("Continuacion de partida");
                    System.out.println("");
                    break;
                case "d":
                    Auxiliar.imprimirTitulo("Ranking de invictos: ");
                    System.out.println(this.sistema.listaInvictos());
                    System.out.println("");
                    //check que funcione sout
                    break;
                default:
                    break;
            }
        }
    }
    public void empezarPartida(){
        
        boolean imprimio =Auxiliar.imprimirLista(sistema.ordenarAlfabetic(), "Se necesitan al menos dos jugadores", 2);
        int numJugador1 = 0;
        int numJugador2 = 0;
        String mensajeError = "Elija un número de los que aparecen en la lista";
        if(imprimio){
            
            numJugador1 = Auxiliar.ingresarNumero("Ingrese numero del jugador que arranca",1,sistema.getListaJugadores().size(),mensajeError);
            numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del jugador 2",1,sistema.getListaJugadores().size(),mensajeError);
            Jugador jugador1 = sistema.getListaJugadores().get(numJugador1 - 1);
            Jugador jugador2 = sistema.getListaJugadores().get(numJugador2 - 1);
            Partida partida = new Partida(jugador1, jugador2);
            jugando(partida);
        }
        //elegir jugador a participar, new partida, 
    }
    public void mostrarTurno(Partida partida){
        String ret ="Es el turno del jugador "+ partida.jugadorBlaONeg() + " (" + partida.getJugadorActual() + ")";
        System.out.println(ret);
    }
    public void jugando(Partida partida){
        boolean termino=false;
        while(!termino){
            mostrarTurno(partida);
            
            mostrarMatrizLogica(partida);
            System.out.println(mostrarMenuJugando());
  
            termino =leerEntrada(partida);

            if(termino){
                termino = true;
                System.out.println("entro");
            }

        }
    }
    public String mostrarMenuJugando(){
        String ret="Puede ingresar: \n"
                + "-FilaColumnaSentido (ej.: A2C), para colocar su ficha (circulitos)"
                + " \tab Fila: A, B o C"
                + " \tab Columna: 1 a 6"
                + " \tab Sentido C o D"
                + "-FilColumnaI (ej.:A2I) si quiere invertir una ficha propia, de C pasa a D o al revés (se indica la filas y columnas de la forma arriba)"
                + "'X', si usted quiere terminar la partida y perder"
                + "'H' si quiere ayuda"
                + "'B' si quiere ver los títulos en los bordes"
                + "'N' si no quiere ver los títulos en los bordes"
                + "'T', si termina en empate";
        return ret;
    }
    public void mostrarMatrizLogica (Partida partida){
        String matLogica [][] = partida.getTablero().getMatrizLogica();
        boolean mostrarFilasYColumnas = partida.getTablero().getMostrarFilasYColumnas();
        if(mostrarFilasYColumnas){
            String numeros ="  1  2  3  4  5  6";
            System.out.println(numeros);
        }
        String separador= " +--+--+--+--+--+--+";
        String filas = "ABC";
        System.out.println(separador);
        for (int i = 0; i < matLogica.length; i++) {
            for(int k=1; k<=3;k++){
                String cadena=" |";
                if(k==2 && mostrarFilasYColumnas){
                    cadena = ""+filas.charAt(i) +"|";
                }
                for (int j = 0; j < matLogica[i].length; j++) {
                    
                    cadena +=darCirculito(i,k,j,matLogica)+"|";
                }
                System.out.println(cadena);
            }
            System.out.println(separador);                  
        }
    }
    //darCirculito va en intefaz
    public String darCirculito (int i, int k, int j, String [][] matLogica){
        String circulito="";
        String ret="  ";
        if(null!=matLogica[i][j]){
            if(matLogica[i][j].charAt(1)=='1'){
                circulito="o";
            }else{
                circulito="●";
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
    public String []generarArrayOpcionesValidas(){
        String [] cadenaFilas = {"A","B","c"};
        String [] cadenaColumnas = {"1","2","3"};
        String [] cadenaSentidos = {"C","D","I"};
        String [] cadenasPosibles = new String[32];
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
        for(int i=27; i<32; i++){
            cadenasPosibles[i] = letras[j];
            j++;

            }
        return cadenasPosibles;
             
}

    

//tenemos que hacer un metodo en tablero que valide si se puede invertir(si ya hay una ficha y es de jugador) y que llame al agregar movimiento. otro metodo en interfaz qaue llame el de si es valido invertir y eso lo ponemos en el case
    public boolean leerEntrada(Partida partida){
        boolean termino = false;
        
        String [][] matrizLogica = partida.getTablero().getMatrizLogica();
        //hay que especidicar que esta mal ????
        String opcion=Auxiliar.ingresarLetra("Ingrese jugada", generarArrayOpcionesValidas(), "Lo/s caracter/es ingresados no son válidos, lo valido es:"+ mostrarMenuJugando());
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
                        }
                    }else{
                        
                        partida.getTablero().agregarMovimiento(jugada);
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
                    partida.getTablero().cambiarTurno();
                    mostrarTurno(partida);
                    String quiso=Auxiliar.ingresarLetra("Confirma que desea empatar?",opci , "Debe ingresar S o N");
                    if(quiso.equalsIgnoreCase("S")){
                        termino=true;
                    }
                    //creo que no hay que poner else
                    
                    break;
                case "H":
                    System.out.println("Seleccionó ayuda");
                    //System.out.println(partida.getTablero().movimientoAyuda());
                case "X":
                    termino = true;
                default:
                    System.out.println("Las opciones valias son y el texto de marti");
                    
            }
            return termino;
        }
     public void registrarJugador(){
        Auxiliar.imprimirTitulo("Registrar jugador");
//ver si pedida de datos mas eficiente
        String nom = ingresarNombre();
        int edad = Auxiliar.ingresarNumero("ingresar edad");
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

            
    

   
   