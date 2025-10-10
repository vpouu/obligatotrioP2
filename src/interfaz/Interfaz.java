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
                    registrarJugador();
                    break;
                case "b":
                    empezarPartidas();
                    break;
                case "c":
                    Auxiliar.imprimirTitulo("Costo promedio de apartamento");
                    System.out.print("El costo promedio de los apartamentos en el edificio es: ");
                    //System.out.println(edificio.getCostoPromedioApartamento());
                    System.out.println("");
                    break;
                case "d":
                    Auxiliar.imprimirTitulo("Lista de invictos: ");
                    System.out.println(this.sistema.listaInvictos());
                    //check que funcione sout
                    break;
                default:
                    break;
            }
        }
    }
    public void empezarPartidas(){
        
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
