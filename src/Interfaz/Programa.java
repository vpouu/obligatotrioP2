//renombrar packeges con minuscula
//hacer cantPartidasGanas++ cuando un jugador gana una partida
package interfaz;
import dominio.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Programa {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        iniciar();
    }
    public static void iniciar(){
        Sistema sistema=new Sistema();
        String opcion = "a";
        while (!opcion.equalsIgnoreCase("e")) {
            mostrarMenu();
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ");

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
                    System.out.println(edificio.getCostoPromedioApartamento());
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
