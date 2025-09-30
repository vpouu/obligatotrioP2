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
    
    public static int ingresarNumero(String texto, int min) {
        return ingresarNumero(texto, min, Integer.MAX_VALUE);
    }

    public static int ingresarNumero(String texto, int min, int max) {
        int ret = Integer.MIN_VALUE;
        Scanner in = new Scanner(System.in);

        while (ret < min || ret > max) {
            System.out.print(texto);
            ret = in.nextInt();
            if (ret < min || ret > max) {
                System.out.println("Ingreso es inválido.");
            }
        }

        System.out.println("");
        
        return ret;
    }
}
