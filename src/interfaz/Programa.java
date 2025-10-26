package interfaz;
import dominio.Sistema;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
//Martina Gonzalez (332461) y Victoria Pou (283117)
public class Programa {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Sistema sistema=new Sistema();
        Interfaz interfaz=new Interfaz(sistema);
        interfaz.iniciar();
    }
}
