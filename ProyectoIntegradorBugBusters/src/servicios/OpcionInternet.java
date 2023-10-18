
package servicios;

import java.util.Scanner;
import ChatBot.*;


public class OpcionInternet extends OpcionMenu {
    // Constructor
    public OpcionInternet(Cliente cliente) {
        super(cliente);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcionInternet;

        do {
            System.out.println("\nSubmenú - Internet:");
            System.out.println("1. Sin Servicio");
            System.out.println("2. Lentitud");
            System.out.println("3. Microcortes");
            System.out.println("4. Test de Velocidad");
            System.out.println("5. Cambio de Contraseña del Router");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcionInternet = scanner.nextInt();

            switch (opcionInternet) {
                // Implementar lógica específica para cada opción del submenú
                case 1:
                    System.out.println("Ha seleccionado Sin Servicio. ¿En qué puedo ayudarte?");
                    break;
                case 2:
                    System.out.println("Ha seleccionado Lentitud. ¿En qué puedo ayudarte?");
                    break;
                case 3:
                    System.out.println("Ha seleccionado Microcortes. ¿En qué puedo ayudarte?");
                    break;
                case 4:
                    System.out.println("Ha seleccionado Test de Velocidad. ¿En qué puedo ayudarte?");
                    break;
                case 5:
                    System.out.println("Ha seleccionado Cambio de Contraseña del Router. ¿En qué puedo ayudarte?");
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionInternet != 0);
    }
}
