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
        System.out.println("Por favor, ingrese sus datos para acceder a la consulta");
        Cliente nuevoCliente = asistente.registrarNuevoCliente(scanner);
            if (nuevoCliente != null) {
                asistente.setCliente(nuevoCliente);

                // Menú principal
                asistente.mostrarMenuPrincipal(nuevoCliente);
            }
        
        scanner.close();
    }
}
