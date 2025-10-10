
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
                    Auxiliar.imprimirTitulo("Lista de invictos: ");
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
        
        boolean imprimio =Auxiliar.imprimirLista(sistema.listaJugadores, "Se necesitan al menos dos jugadores", 2);
        int numJugador1 = 0;
        int numJugador2 = 0;
        String mensajeError = "Elija un número de los que aparecen en la lista";
        if(imprimio){
            
            numJugador1 = Auxiliar.ingresarNumero("Ingrese numero del jugador que arranca",1,sistema.listaJugadores.size(),mensajeError);
            numJugador2 = Auxiliar.ingresarNumero("Ingrese numero del jugador 2",1,sistema.listaJugadores.size(),mensajeError);
            Jugador jugador1 = sistema.listaJugadores.get(numJugador1 - 1);
            Jugador jugador2 = sistema.listaJugadores.get(numJugador2 - 1);
            Partida partida = new Partida(jugador1, jugador2);
            
        }
        //elegir jugador a participar, new partida, 
    }
    public void mostrarMatrizLogica (String [][] matLogica){
        String separador= "+--+--+--+--+--+--+";
        System.out.println(separador);
        for (int i = 0; i < matLogica.length; i++) {
            for(int k=1; k<=3;k++){
                String cadena="|";
                for (int j = 0; j < matLogica[i].length; j++) {
                    cadena +=darCiruclito(i,k,j,matLogica)+"|";
                }
                System.out.println(cadena);
            }
            System.out.println(separador);                  
        }
    }
    public String darCiruclito (int i, int k, int j, String [][] matLogica){
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
   
    public void registrarJugador(){
        Auxiliar.imprimirTitulo("Registrar jugador");
//ver si pedida de datos mas eficiente
        String nom = ingresarNombre();
        int edad = Auxiliar.ingresarNumero("ingresar edad");
        Jugador jugador=new Jugador(nom,edad);
        this.sistema.agregarJugador(jugador);
    }
    public void mostrarMenu(){
        String menu = "Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y (VICTORIA POU)"
                + "a)Registrar jugador"
                + "b)Comienzo de partida común"
                + "c)Continuación de partida"
                + "d)Terminar el programa";
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
