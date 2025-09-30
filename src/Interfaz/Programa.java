//renombrar packeges con minuscula
package Interfaz;
import Dominio.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class Programa {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Sistema sistema=new Sistema();
        iniciar();
    }
    public static void iniciar(){
        String opcion = "a";
        while (!opcion.equalsIgnoreCase("e")) {
            mostrarMenu();
            opcion = Auxiliar.ingresarLetra("Ingresar opción: ");

            switch (opcion) {
                case "a":
                    registrarJugador(sistema);
                    break;
                case "b":
                    calcularCostoDePiso(edificio);
                    break;
                case "c":
                    Auxiliar.imprimirTitulo("Costo promedio de apartamento");
                    System.out.print("El costo promedio de los apartamentos en el edificio es: ");
                    System.out.println(edificio.getCostoPromedioApartamento());
                    System.out.println("");
                    break;
                case "d":
                    Auxiliar.imprimirTitulo("Piso con apartamento más caro");
                    System.out.print("El piso con el apartamento más caro en el edificio es: ");
                    System.out.println(edificio.getPisoApartamentoMasCaro());
                    System.out.println("");
                    break;
            }
        }
    }
    public static void registrarJugador(Sistema sistema){
        Auxiliar.imprimirTitulo("Ingresar costo de apartamento");

        int piso = Auxiliar.ingresarNumero("Piso (1-10): ", 1, 10);
        int apartamento = Auxiliar.ingresarNumero("Apartamento (1-4): ", 1, 4);
        int monto = Auxiliar.ingresarNumero("Precio: ", 0);

        edificio.setCosto(piso, apartamento, monto);

        System.out.println("");
    }
}
