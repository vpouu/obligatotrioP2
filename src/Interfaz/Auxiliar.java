/* Victoria Pou y Martina Gonzalez*/

package Interfaz;

import java.util.Scanner;


public class Auxiliar {

    public static void imprimirTitulo(String titulo) {
        System.out.println("=====================");
        System.out.println(titulo);
        System.out.println("=====================");
        System.out.println("");
    }
    

    public static String ingresarLetra(String texto) {
        Scanner in = new Scanner(System.in);
        boolean valido=false;
        String [] letras={"a","b","c","d","e"};
        System.out.print(texto);
        String ret = in.nextLine();
        for(String opcion:letras){
            if(opcion.equalsIgnoreCase(ret)){
                valido=true;
            }
        }
        while (!valido){
            System.out.println("la letra ingresada no es válida");
            ret = in.nextLine();
            for(String opcion:letras){
                if(opcion.equalsIgnoreCase(ret)){
                    valido=true;
                }
            }
        }
        System.out.println("");
        
        return ret;
    }
    public static int ingresarNumero(String texto) {
        Scanner in = new Scanner(System.in);
        System.out.print(texto);
        int ret = in.nextInt();
        return ret;
    }
}
