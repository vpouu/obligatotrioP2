/* Victoria Pou y Martina Gonzalez*/

package interfaz;

import java.util.*;


public class Auxiliar {
    public static void main(String[] args) {
        ArrayList<String> lista=new ArrayList ();
        lista.add("hola");
        lista.add("hola");
        lista.add("hola");
        lista.add("hola");
 
        imprimirLista(lista, "esta vacio");
    }
   
    public static void imprimirTitulo(String titulo) {
        System.out.println("=====================");
        System.out.println(titulo);
        System.out.println("=====================");
        System.out.println("");
    }
    public static void imprimirLista (ArrayList lista, String error, int minLength){
         Iterator it=lista.iterator();
         int i=1;
         
         if(lista.size()<minLength){
             System.out.println(error);
         }else{
            while(it.hasNext()){
                System.out.println(i + ". " + it.next());
                i++;
            }
        }
         
    }
    

    public static String ingresarLetra(String texto, String [] opciones) {
        Scanner in = new Scanner(System.in);
        boolean valido=false;
        System.out.print(texto);
        String ret = in.nextLine();
        for(String opcion:opciones){
            if(opcion.equalsIgnoreCase(ret)){
                valido=true;
            }
        }
        while (!valido){
            System.out.println("la letra ingresada no es válida");
            ret = in.nextLine();
            for(String opcion:opciones){
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
    public static String ingresarPalabras (String texto){
        Scanner in = new Scanner(System.in);
        System.out.print(texto);
        return in.nextLine();
    }
}
