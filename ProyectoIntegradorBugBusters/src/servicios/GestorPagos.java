package servicios;

import java.util.Scanner;

public class GestorPagos {
    public static void gestionarPagoFacil() {
        System.out.println("Puede realizar el pago en cualquier sucursal de PagoFacil con el código de barras que se encuentra en el dorso de su factura o con su número de cliente");
    }

    public static void gestionarMercadoPago() {
        System.out.println("Escanee el código desde la web y luego presione aceptar para realizar el pago");
    }

    public static void gestionarTransferencia() {
        System.out.println("Puede realizar la transferencia del monto exacto al CBU 1234567891234567891234, el pago se validará en las próximas 72 horas");
    }

    public static void gestionarCreditoDebito(Scanner scanner) {
        System.out.println("Ha seleccionado Crédito/Débito.");
        System.out.print("¿Desea adherir el débito automático? (1-si / 2-No): ");
        int opcionDebitoAutomatico = scanner.nextInt();

        if (opcionDebitoAutomatico == 1) {
            // Pedir datos de tarjeta
            System.out.println("Por favor, ingrese los datos de su tarjeta de crédito/débito:");
            System.out.print("Por favor, ingrese el número de tarjeta: ");
            String numeroTarjeta = scanner.next();

            System.out.print("Por favor, ingrese la fecha de vencimiento (MM/YY): ");
            String fechaVencimiento = scanner.next();

            System.out.print("Por favor, ingrese el código de seguridad: ");
            int codigoSeguridad = scanner.nextInt();

            System.out.println("Pago efectuado con éxito, si desea seleccione otra opcion del menu");
        } else if (opcionDebitoAutomatico == 2) {
            System.out.print("Por favor, ingrese el número de tarjeta: ");
            String numeroTarjeta = scanner.next();

            System.out.print("Por favor, ingrese la fecha de vencimiento (MM/YY): ");
            String fechaVencimiento = scanner.next();

            System.out.print("Por favor, ingrese el código de seguridad: ");
            int codigoSeguridad = scanner.nextInt();


            System.out.println("Pago efectuado con éxito, si desea seleccione otra opcion del menu");
        }
    }
}
