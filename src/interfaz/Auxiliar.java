package interfaz;
import java.util.*;

/* Victoria Pou y Martina Gonzalez*/


public class Auxiliar {
    public static void main(String[] args) {
        ingresarNumero("hola");
        ingresarNumero("hola", 0, 3, "ese numero no es valido");
    }
    
    public static void imprimirTitulo(String titulo) {
        System.out.println("=====================");
        System.out.println(titulo);
        System.out.println("=====================");
        System.out.println("");
    }
    
    public static boolean imprimirLista (ArrayList lista, String error, int minLength){
         Iterator it=lista.iterator();
         int i=1;
         boolean pudoImprimir=false;
         if(lista.size()<minLength){
             System.out.println(error);
         }else{
            while(it.hasNext()){
                System.out.println(i + ". " + it.next());
                i++;
            }
            pudoImprimir=true;
        }
        return pudoImprimir;
    }
    

    public static String ingresarLetra(String texto, String [] opciones, String mensajeDeError) {
        Scanner in = new Scanner(System.in);
        boolean valido=false;
        System.out.println(texto);
        String ret = in.nextLine();
        ret=ret.toLowerCase();
        for(String opcion:opciones){
            if(opcion.equalsIgnoreCase(ret)){
                valido=true;
            }
        }
        while (!valido){
            System.out.println(mensajeDeError);
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
        return ingresarNumero(texto, Integer.MIN_VALUE, Integer.MAX_VALUE,"error");
    }
    public static int ingresarNumero(String texto, int numMin, int numMax, String error) {
        Scanner in = new Scanner(System.in);
        System.out.println(texto);
        int auxMin=numMin;
        numMin= Math.min(numMin, numMax);
        numMax= Math.max(auxMin, numMax);
        boolean valido=false;
        int ret=0;
        while(!valido){
            try{
                ret = in.nextInt();
                valido=true;
            }
            catch (InputMismatchException e){
                System.out.println("Debe ingresar un número entre " + numMin+ " y " + numMax + ". Reingréselo" );        
                ret=in.nextInt();
                
            }catch (Exception e){
                System.out.println("Error, reingrese número");
                ret=in.nextInt();
            }
        }
        while(ret>numMax || ret<numMin){
            System.out.println(error);
            System.out.println("Reingrese numero");
            ret=in.nextInt();
        }
        return ret;
    }
    public static String ingresarPalabras (String texto){
        Scanner in = new Scanner(System.in);
        System.out.println(texto);
        return in.nextLine();
    }
    //cuando me pide ingresar la edad si le pongo una letra se rompe el porgrama
}
