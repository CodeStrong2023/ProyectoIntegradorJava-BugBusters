
package ChatBot;

import java.util.Scanner;
import servicios.*;

public class AsistenteVirtual {
    private Cliente cliente;

    // Setter para el cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void mostrarMenuPrincipal(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Internet");
            System.out.println("2. Cable");
            System.out.println("3. Facturación");
            System.out.println("4. Asistencia Telefónica");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    new OpcionInternet(cliente).mostrarMenu(scanner);
                    break;
                case 2:
                    new OpcionCable(cliente).mostrarMenu(scanner);
                    break;
                case 3:
                    new OpcionFacturacion(cliente).mostrarMenu(scanner);
                    break;
                case 4:
                    new OpcionAsistenciaTelefonica(cliente).mostrarMenu(scanner);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar BugsBusters. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcion != 0);
    }

    // Función para registrar un nuevo cliente
    public Cliente registrarNuevoCliente(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.next();

        // Verificacion la edad
        if (esMayorDeEdad(fechaNacimiento)) {
            return new Cliente(nombre, apellido, dni, fechaNacimiento);
        } else {
            System.out.println("Lo siento, debes ser mayor de edad para registrarte en BugsBusters. Llama a alguien mayor para obtener ayuda.");
            return null;
        }
    }

    // Verificar si es mayor de edad (negativa la maniobra)
    private boolean esMayorDeEdad(String fechaNacimiento) {
        return fechaNacimiento.compareTo("2005-01-01") <= 0;
    }
}
