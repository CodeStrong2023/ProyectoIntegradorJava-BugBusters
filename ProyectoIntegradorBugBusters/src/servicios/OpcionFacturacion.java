package servicios;

import servicios.GestorPagos;
import servicios.Facturacion;
import java.util.Scanner;
import ChatBot.*;




public class OpcionFacturacion extends OpcionMenu {
    private boolean bajaInternet = false;
    private boolean bajaCable = false;
    private double importeFactura;
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
                case 5: // VER!!!
                    System.out.println("Ha seleccionado Baja de Servicio");
                    if(importeFactura == 0){
                        System.out.println("Usted no tiene servicios contratados");
                    }
                    while(bajaInternet == false || bajaCable == false){
                        System.out.println("Qué servicio desea dar de baja?");
                        System.out.println("1.Internet\n2.Cable\n3.Salir");
                        int bajaServicio = scanner.nextInt();
                        
                        switch(bajaServicio){
                            case 1: 
                                if(bajaInternet == false){
                                    importeFactura -= factura.getImporteInternet();
                                    bajaInternet = true;
                                    System.out.println("El servicio de Internet se ha dado de baja con exito!");
                                    mostrarMenu(scanner);
                                }else{
                                    System.out.println("El servicio de Internet ya se encuentra dado de baja");
                                    mostrarMenu(scanner);
                                }
                                break;
                            case 2:
                                if(bajaCable == false){
                                    importeFactura -= factura.getImporteCable();
                                    bajaCable = true;
                                    System.out.println("El servicio de Cable se ha dado de baja con exito!");
                                    mostrarMenu(scanner);
                                }else{
                                    System.out.println("El servicio de Cable ya se encuentra dado de baja");
                                    mostrarMenu(scanner);
                                }
                                break;
                            case 3:
                                mostrarMenu(scanner);
                            default:
                                System.out.println("Opción invalida");
                                bajaServicio = scanner.nextInt();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ha seleccionado Alta de Servicio.");
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