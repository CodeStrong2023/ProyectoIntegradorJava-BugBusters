package servicios;

import servicios.GestorPagos;
import servicios.Facturacion;
import java.util.Scanner;
import ChatBot.*;




public class OpcionFacturacion extends OpcionMenu {
    private Facturacion factura;
    // Constructor

    public OpcionFacturacion(Cliente cliente) {
        super(cliente);
        factura = new Facturacion();
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
                    System.out.println("--------------------------------------");
                    System.out.println("Importe Cable: " + factura.getImporteCable());
                    System.out.println("Importe Internet: " + factura.getImporteInternet());
                    System.out.println("Importe Total: " + factura.getImporteTotal());
                    System.out.println("Titular: " + cliente.getNombre() + " " + cliente.getApellido());
                    System.out.println("Fehca de venicimiento: " + factura.getFechaVencimiento());
                    System.out.println("--------------------------------------");

                    break;
                case 2:
                    System.out.println("Ha seleccionado Modalidades de Pago. ¿En qué puedo ayudarte?");
                    System.out.println("Ha seleccionado Modalidades de Pago. ¿En qué puedo ayudarte?");
                    System.out.println("Modalidades de pago disponibles:");
                    System.out.println("1. PagoFácil");
                    System.out.println("2. MercadoPago");
                    System.out.println("3. Transferencia");
                    System.out.println("4. Crédito/Débito");
                    System.out.print("Seleccione una modalidad de pago (1-4): ");
                    int opcionModalidadPago = scanner.nextInt();

                    switch (opcionModalidadPago) {
                        case 1:
                            GestorPagos.gestionarPagoFacil();
                            break;
                        case 2:
                            GestorPagos.gestionarMercadoPago();
                            break;
                        case 3:
                            GestorPagos.gestionarTransferencia();
                            break;
                        case 4:
                            GestorPagos.gestionarCreditoDebito(scanner);
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                            break;
                    }
                    break;
                case 3:
                    String direccionActual = cliente.getDireccion();
                    System.out.println("Su direccion acutal es: " + direccionActual);
                    System.out.println("Ingrese su nuevo domicilio: ");
                    scanner.nextLine();
                    String nevaDireccion = scanner.nextLine();
                    cliente.setDireccion(nevaDireccion);
                    System.out.println("Se modifico el domicilio " + direccionActual +" el nuevo domicilio es: " + cliente.getDireccion());
                    break;
                case 4:
                    System.out.println("Ha seleccionado Cambio de Titularidad.");
                    System.out.println("Ingrese el nombre del nuevo titular: ");
                    scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
                    cliente.setNombre(scanner.nextLine());
                    System.out.println("Ingrese el apellido del nuevo titular: ");
                    cliente.setApellido(scanner.nextLine());
                    System.out.println("Ingrese el DNI del nuevo titular: ");
                    cliente.setDni(scanner.nextLine());
                    System.out.println("Ingrese la fecha de nacimiento del nuevo titular: ");
                    cliente.setFechaNacimiento(scanner.nextLine());
                    System.out.println("Ingrese la dirección del nuevo titular: ");
                    cliente.setDireccion(scanner.nextLine());
                    System.out.println("Se ha cambiado el titular de la cuenta.");
                    System.out.println("Sus nuevos datos son");
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Apellido: " + cliente.getApellido());
                    System.out.println("DNI: " + cliente.getDni());
                    System.out.println("Fecha de Nacimiento: " + cliente.getFechaNacimiento());
                    System.out.println("Dirección: " + cliente.getDireccion());
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