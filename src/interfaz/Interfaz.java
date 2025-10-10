/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Sistema;
import dominio.Jugador;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
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
                    registrarJugador(sistema);
                    break;
                case "b":
                    empezarPartidas(sistema);
                    break;
                case "c":
                    Auxiliar.imprimirTitulo("Costo promedio de apartamento");
                    System.out.print("El costo promedio de los apartamentos en el edificio es: ");
                    //System.out.println(edificio.getCostoPromedioApartamento());
                    System.out.println("");
                    break;
                case "d":
                    Auxiliar.imprimirTitulo("Lista de invictos: ");
                    System.out.println(sistema.listaInvictos());
                    //check que funcione sout
                    break;
            }
        }
    }
    public static void mostrarMatrizLogica (String [][] matLogica){
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
    public static String darCiruclito (int i, int k, int j, String [][] matLogica){
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
    public static void empezarPartidas(Sistema sistema){
        
    }
    public static void registrarJugador(Sistema sistema){
        Auxiliar.imprimirTitulo("Registrar jugador");
//ver si pedida de datos mas eficiente
        String nom = ingresarNombre(sistema);
        int edad = Auxiliar.ingresarNumero("ingresar edad");
        Jugador jugador=new Jugador(nom,edad);
        sistema.agregarJugador(jugador);
    }
    public static void mostrarMenu(){
        String menu = "Trabajo desarrollado por: MARTINA GONZÁLEZ (332461) Y (VICTORIA POU)"
                + "a)Registrar jugador"
                + "b)Comienzo de partida común"
                + "c)Continuación de partida"
                + "d)Terminar el programa";
        System.out.println(menu);
              
    }
    public static String ingresarNombre (Sistema sistema){
        Scanner in = new Scanner(System.in);
        Auxiliar.imprimirTitulo("Ingresar nombre");
        String nombre=in.nextLine();
        boolean valido=sistema.nombreEsUnico(nombre);
        while(!valido){
            System.out.println("nombre repetido, reingrese nombre");
            nombre=in.nextLine();       
            valido=sistema.nombreEsUnico(nombre);
        }
        return nombre;
    }
            

}
