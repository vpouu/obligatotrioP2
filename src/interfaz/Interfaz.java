
package interfaz;

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
            mostrarMenu();
            String [] letrasValidas={"a","b","c","d","e"};
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ", letrasValidas);

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
        String ret ="Es el turno del jugador "+ partida.jugadorBlaONeg() + " ( " + partida.getJugadorActual();
        System.out.println(ret);
    }
    public void jugando(Partida partida){
        boolean termino=false;
        while(!termino){
            String [][] matLogica=partida.getTablero().getMatrizLogica();
            mostrarTurno(partida);
            mostrarMatrizLogica(matLogica);
            if(leerEntrada){
                termino = true;
            }
        }
    }
    public void mostrarMatrizLogica (String [][] matLogica){
        String separador= "+--+--+--+--+--+--+";
        System.out.println(separador);
        for (int i = 0; i < matLogica.length; i++) {
            for(int k=1; k<=3;k++){
                String cadena="|";
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
        String [] cadenasPosibles = new int[32];

        for(int i=0 ; i<cadenaFilas.length; i++){
            for (int j = 0; j < cadenaColumnas.length; j++) {
                for(int k=0; k<cadenaSentidos.length; k++){
                    cadenasPosibles = ""+cadenaFilas.charAt(i)+cadenaColumnas.charAt(j)+cadenaSentidos(k);

                }
                
            }
        }
        cadenasPosibles[]
    
}
//tenemos que hacer un metodo en tablero que valide si se puede invertir(si ya hay una ficha y es de jugador) y que llame al agregar movimiento. otro metodo en interfaz qaue llame el de si es valido invertir y eso lo ponemos en el case
    public boolean leerEntrada(){
        boolean termino = false;
        generarArrayOpcionesValidas();
        Auxiliar.ingresarLetra("Ingrese jugada",)

            switch (opcion) {
                case :
                   
                    System.out.println("");
                    break;
                case "B"://pero puede ser minuscula tmb
                    
                    System.out.println("");
                    break;
                case "N":
                    
                    System.out.println("");
                    break;
                case "T":
                    
                    System.out.println("");
                    //check que funcione sout
                    break;
                default:
                    break;
            }
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
    public void mostrarMenu(){
        String menu = "Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y (VICTORIA POU) \n"
                + "a)Registrar jugador \n"
                + "b)Comienzo de partida común \n"
                + "c)Continuación de partida \n"
                + "d)Mostrar ranking de invictos \n"
                + "e)Salir del programa";
        
        System.out.println(menu);
              
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
