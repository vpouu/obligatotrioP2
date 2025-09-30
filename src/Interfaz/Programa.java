//renombrar packeges con minuscula
package Interfaz;
import Dominio.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class Programa {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Auxiliar.imprimirTitulo("Manejo de Edificio");
    }
}
