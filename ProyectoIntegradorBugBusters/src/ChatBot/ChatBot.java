/*
 Comenzamos el proyecto
 */
package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AsistenteVirtual asistente = new AsistenteVirtual();

        System.out.println("Bienvenido a BugsBusters - Servicio de Asistencia Virtual");
        
        System.out.print("¿Eres cliente? (1: Sí / 2: No): ");
        int respuestaCliente = scanner.nextInt();

        if (respuestaCliente == 1) {
            Cliente cliente = new Cliente();
            asistente.setCliente(cliente);

            // Menú principal
            asistente.mostrarMenuPrincipal(scanner);
        } else {
            System.out.println("¡Bienvenido! Vamos a comenzar el proceso de registro.");
            Cliente nuevoCliente = asistente.registrarNuevoCliente(scanner);

            if (nuevoCliente != null) {
                asistente.setCliente(nuevoCliente);

                // Menú principal
                asistente.mostrarMenuPrincipal(scanner);
            } else {
                System.out.println("Registro cancelado. ¡Hasta luego!");
            }
        }

        scanner.close();
    }
}
