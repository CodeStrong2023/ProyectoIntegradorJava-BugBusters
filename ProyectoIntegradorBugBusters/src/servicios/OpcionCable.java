
package servicios;

import java.util.Scanner;
import ChatBot.*;

public class OpcionCable extends OpcionMenu {
    
    // Constructor
    public OpcionCable(Cliente cliente) {
        super(cliente);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcionCable;

        do {
            System.out.println("\nSubmenú - Cable:");
            System.out.println("1. Sin Señal");
            System.out.println("2. Falta de Canales o Canales Desconectados");
            System.out.println("3. Equipo no Funciona");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcionCable = scanner.nextInt();

            switch (opcionCable) {
                case 1:
                    System.out.println("Ha seleccionado Sin Señal. ¿En qué puedo ayudarte?");
                    break;
                case 2:
                    System.out.println("Ha seleccionado Falta de Canales o Canales Desconectados. ¿En qué puedo ayudarte?");
                    break;
                case 3:
                    System.out.println("Ha seleccionado Equipo no Funciona. ¿En qué puedo ayudarte?");
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionCable != 0);
    }
}
