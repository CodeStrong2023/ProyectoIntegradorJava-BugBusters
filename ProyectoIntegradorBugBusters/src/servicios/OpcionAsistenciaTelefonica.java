
package servicios;

import ChatBot.*;
import java.util.Scanner;

public class OpcionAsistenciaTelefonica extends OpcionMenu {
     // Constructor
    public OpcionAsistenciaTelefonica(Cliente cliente) {
        super(cliente);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarMenu(Scanner scanner) {
        System.out.println("En instantes nuestro asistente virtual se comunicará con usted.");
        System.out.println("GRACIAS POR UTILIZAR NUESTRO ASISTENTE VIRTUAL");
    }
}
