
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
                    System.out.println("Ha seleccionado (1) Sin Señal.");
                    sinSenal();
                    break;
                case 2:
                    System.out.println("Ha seleccionado (2) Falta de Canales o Canales Desconectados.");
                    faltanCanales();
                    break;
                case 3:
                    System.out.println("Ha seleccionado (3) Equipo no Funciona.");
                    equipo();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    new AsistenteVirtual().mostrarMenuPrincipal(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionCable != 0);
    }
    
    public void sinSenal(){
        System.out.println("""
                           
                           
                           --------------------------------------------
                           ****~~      VERIFICACION DE SEÑAL     ~~****
                           --------------------------------------------
                           
                           En caso que en la pantalla del televisor aparezca la leyenda {SIN SEÑAL}, siga las siguientes verificaciones
                           -Verificar que el decodificador se encuentre encendido
                           -Veriique las entradas de HDMI o AV esten seleccionadas correctamente
                           Esta seleccion se soluciona desde el control remoto del televisor
                           
                           *******************************************************************
                           
                           Si en la pantalla de su televisor aparece la imagen de {MENU}, realizar la configuracion del decoficador con el control remoto del mismo.
                           Esta seleccion se soluciona desde el control remoto del televisor

                           1: Presionar el boton menu
                           2: Ir a la pestaña instalacion (imagen de antena)
                           3: Seleccionar instalacion DVBC - Busqueda por rango
                           4:Configuracion:
                           	- RED: 5.360 QAM
                           	- FRECUENCIA DE INICIO: 663.00
                           	- FRECUENCIA DE FIN: 843.00
                           	- LISTA DE CANALES: NUEVO
                           	- BUSQUEDA DE RED: NO
                           	- ORDENAR POR SERVICE ID: SI
                           5: Ir hasta boton [BUSCAR] y presionar OK
                           6: Esperar busqueda
                           7: Ante el cartel de busqueda finalizada presionar OK
                           8: Presionar el boton [SALIR] o [EXIT] tres veces
                           """);
        
        new Consulta(cliente).resolucion(cliente);
    }
    
    public void faltanCanales(){
        System.out.println("""
                           
                           
                           ----------------------------------------------
                           ****~~      VERIFICACION DE CANALES     ~~****
                           ----------------------------------------------
                           
                           Si cuenta con la imagen congelada en algunos canales
                           - Verificar que los cables de la instalacion del decodificador esten conectados correctamente
                           - La ficha del cable que ingresa al domicilio debe colocarse en la entrada del decodificador [IN]
                           
                           *******************************************************************
                           
                           Si la grilla de canales aparace incompleta, verificar que los cables de la instalacion del decodificador esten conectados correctamnete
                           y si continua con el inconveniente, realizar la configuracion del decodificador';
                                                                                 
                           1: Presionar el boton menu
                           2: Ir a la pestaña instalacion (imagen de antena)
                           3: Seleccionar instalacion DVBC - Busqueda por rango
                           4:Configuracion:
                                - RED: 5.360 QAM
                                - FRECUENCIA DE INICIO: 663.00
                                - FRECUENCIA DE FIN: 843.00
                                - LISTA DE CANALES: NUEVO
                                - BUSQUEDA DE RED: NO
                                - ORDENAR POR SERVICE ID: SI
                           5: Ir hasta boton [BUSCAR] y presionar OK
                           6: Esperar busqueda
                           7: Ante el cartel de busqueda finalizada presionar OK
                           8: Presionar el boton [SALIR] o [EXIT] tres veces
                           """);
        new Consulta(cliente).resolucion(cliente);
    }
    
    public void equipo(){
        System.out.println("""
                           
                           
                           ----------------------------------------------
                           ****~~      VERIFICACION DEL EQUIPO     ~~****
                           ----------------------------------------------
                           
                           1. Verifique que el boton power atras del decodificador se encuentre en la pocision ON.
                           2. Verificar que la ficha este conectada correctamente.
                           3. Corroborar en otro enchufe'
                           
                           """);
        new Consulta(cliente).resolucion(cliente);
    }
}
