
package servicios;

import java.util.Scanner;
import ChatBot.*;

public class OpcionFacturacion extends OpcionMenu {
    // Constructor
    public OpcionFacturacion(Cliente cliente) {
        super(cliente);
    }

    // Implementación del método abstracto
    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcionFacturacion;

        do {
            System.out.println("\nSubmenú - Facturación:");
            System.out.println("1. Tu Factura");
            System.out.println("2. Modalidades de Pago");
            System.out.println("3. Cambio de Domicilio");
            System.out.println("4. Cambio de Titularidad");
            System.out.println("5. Baja de Servicio");
            System.out.println("6. Alta de Servicio");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcionFacturacion = scanner.nextInt();

            switch (opcionFacturacion) {
                case 1:
                    System.out.println("Ha seleccionado Tu Factura. ¿En qué puedo ayudarte?");
                    break;
                case 2:
                    System.out.println("Ha seleccionado Modalidades de Pago. ¿En qué puedo ayudarte?");
                    break;
                case 3:
                    System.out.println("Ha seleccionado Cambio de Domicilio. ¿En qué puedo ayudarte?");
                    break;
                case 4:
                    System.out.println("Ha seleccionado Cambio de Titularidad. ¿En qué puedo ayudarte?");
                    break;
                case 5:
                    System.out.println("Ha seleccionado Baja de Servicio. ¿En qué puedo ayudarte?");
                    break;
                case 6:
                    System.out.println("Ha seleccionado Alta de Servicio. ¿En qué puedo ayudarte?");
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionFacturacion != 0);
    }
}
