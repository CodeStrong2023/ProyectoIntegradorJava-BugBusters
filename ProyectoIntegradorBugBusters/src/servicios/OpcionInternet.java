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
            System.out.println("2. Lentitud y Microcortes");
            System.out.println("3. Test de Velocidad");
            System.out.println("4. Cambio de Contraseña del Router");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcionInternet = scanner.nextInt();

            switch (opcionInternet) {
                // Implementar lógica específica para cada opción del submenú
                case 1:
                    sinServicio(scanner);
                    break;
                case 2:
                    lentitudMicroCortes(scanner);
                    break;
                case 3:
                    testVelocidad(scanner);
                    break;
                case 4:
                    cambioContrasenia(scanner);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    new AsistenteVirtual().mostrarMenuPrincipal(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionInternet != 0);
    }

    //Método para la opción "Sin servicio"
    public void sinServicio(Scanner scanner) {
        int encendido, tipo;
        char opciones, opcion;

        do {
            System.out.println("");
            System.out.println("""
                                >>>> VERIFICACIÓN DEL SERVICIO <<<<
                                ¿Cómo se encuentran las luces del router?
                                1. Todas las luces apagadas
                                2. Luces parcialmente apagadas
                                """);
            encendido = scanner.nextInt();

            switch (encendido) {
                case 1:
                    do {
                        System.out.println("");
                        System.out.println("""
                                   >> Verifique la alimentación eléctrica del router.
                                   ¿Está conectada la ficha power de la fuente al router?
                                   s = SI
                                   n = NO
                                   """);
                        opciones = scanner.next().charAt(0);
                        //Se pasa el caracter a minúscula
                        opcion = Character.toLowerCase(opciones);
                        if (opcion != 's' && opcion != 'n') {
                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                        }
                    } while (opcion != 's' && opcion != 'n');

                    if (opcion == 'n') {
                        System.out.println("\n>> Por favor conecte la ficha power al equipo.");
                        new Consulta(cliente).resolucion(cliente);
                    } else if (opcion == 's') {
                        do {
                            System.out.println("");
                            System.out.println("""
                                        ¿Verificó que su tomacorriente funciona corectamente?
                                        s = SI
                                        n = NO
                                        """);
                            opciones = scanner.next().charAt(0);
                            opcion = Character.toLowerCase(opciones);
                            if (opcion != 's' && opcion != 'n') {
                                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                            }
                        } while (opcion != 's' && opcion != 'n');

                        if (opcion == 'n') {
                            System.out.println("\n>> Por favor, pruebe en otro tomacorriente.");
                            new Consulta(cliente).resolucion(cliente);
                            break;
                        } else if (opcion == 's') {
                            do {
                                System.out.println("");
                                System.out.println("""
                                            ¿El botón de encendido está en la posición (ON)?
                                            s = SI
                                            n = NO
                                            """);
                                opciones = scanner.next().charAt(0);
                                opcion = Character.toLowerCase(opciones);
                                if (opcion != 's' && opcion != 'n') {
                                    System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                }
                            } while (opcion != 's' && opcion != 'n');

                            if (opcion == 'n') {
                                System.out.println("\n>> Por favor, cambie el botón de encendido a ON.");
                                new Consulta(cliente).resolucion(cliente);
                                break;
                            } else if (opcion == 's') {
                                System.out.println("\nSu equipo se ve operacional.");
                                new Consulta(cliente).otraConsulta();
                                break;
                            }
                        }
                    }
                    break;

                case 2:
                    do {
                        System.out.println("""
                                   >> Seleccione el tipo de router que posee:
                                   1. Router WiFi (servicio aéreo)
                                   2. Router FTTH (fibra óptica)
                                   """);
                        tipo = scanner.nextInt();
                        if (tipo != 1 && tipo != 2) {
                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                        }
                    } while (tipo != 1 && tipo != 2);

                    switch (tipo) {
                        case 1:
                            do {
                                System.out.println("");
                                System.out.println("""
                                               La luz con el indicador WAN ¿está encendida?
                                               s = SI
                                               n = NO
                                               """);
                                opciones = scanner.next().charAt(0);
                                opcion = Character.toLowerCase(opciones);
                                if (opcion != 's' && opcion != 'n') {
                                    System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                }
                            } while (opcion != 's' && opcion != 'n');
                            if (opcion == 'n') {
                                do {
                                    System.out.println("");
                                    System.out.println("""
                                                   >> Verifique que el POE (fuente o transformador) tenga la luz verde activada.
                                                   
                                                   ¿El POE tiene la luz verde encendida?
                                                   s = SI
                                                   n = NO
                                                   """);
                                    opciones = scanner.next().charAt(0);
                                    opcion = Character.toLowerCase(opciones);
                                    if (opcion != 's' && opcion != 'n') {
                                        System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                    }
                                } while (opcion != 's' && opcion != 'n');
                                if (opcion == 's') {
                                    do {
                                        System.out.println("");
                                        System.out.println("""
                                                       >> Llega energía al POE, por favor verifique el cable Ethernet."
                                                        Dicho cable puede ser de color amarillo, gris, o blanco,
                                                        y se conecta en el puerto WAN del router y puerto LAN de la fuente.
                                                        Verifique que las fichas no estén flojas, o el cbale dañado.
                                                        Si tiene otro cable, por favor pruebe cambiandolo.
                                                       
                                                       ¿Se resolvió su inconveniente?
                                                       s = SI
                                                       n = NO
                                                       """);
                                        opciones = scanner.next().charAt(0);
                                        opcion = Character.toLowerCase(opciones);
                                        if (opcion != 's' && opcion != 'n') {
                                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                        }
                                    } while (opcion != 's' && opcion != 'n');
                                    if (opcion == 'n') {
                                        new Consulta(cliente).generarOrden(cliente);

                                    } else {
                                        new Consulta(cliente).otraConsulta();

                                    }
                                } else {
                                    do {
                                        System.out.println("""
                                                       >> Verifique que el POE esté correctamente enchufado al tomacorriente.
                                                        Si es posible, pruebe en otro tomacorriente para descartar que sea ese el problema.
                                                        
                                                       ¿Se resolvió su inconveniente?
                                                        s = SI
                                                        n = NO
                                                       """);
                                        opciones = scanner.next().charAt(0);
                                        opcion = Character.toLowerCase(opciones);
                                        if (opcion != 's' && opcion != 'n') {
                                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                        }
                                    } while (opcion != 's' && opcion != 'n');
                                    if (opcion == 's') {
                                        new Consulta(cliente).otraConsulta();

                                    } else {
                                        new Consulta(cliente).generarOrden(cliente);

                                    }
                                }
                            } else {
                                do {
                                    System.out.println("""
                                                       La luz con el indicador WIFI ¿Está encendida?
                                                       s = SI
                                                       n = NO
                                                       """);
                                    opciones = scanner.next().charAt(0);
                                    opcion = Character.toLowerCase(opciones);
                                    if (opcion != 's' && opcion != 'n') {
                                        System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                    }
                                } while (opcion != 's' && opcion != 'n');
                                if (opcion == 's') {
                                    do {
                                        System.out.println("""
                                                       ¿Le aparece su red wifi visible en el dispositivo que intenta conectarse?
                                                       s = SI
                                                       n = NO
                                                       """);
                                        opciones = scanner.next().charAt(0);
                                        opcion = Character.toLowerCase(opciones);
                                        if (opcion != 's' && opcion != 'n') {
                                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                        }
                                    } while (opcion != 's' && opcion != 'n');
                                    if (opcion == 's') {
                                        System.out.println("""
                                                           >> Según las luces del equipo está operacional, verifique su dispoitivo.
                                                            Pruebe descativando el wifi y volviendolo a activar. 
                                                            Pruebe olvidando la red y vuelva a conectarse.
                                                           """);
                                        new Consulta(cliente).resolucion(cliente);

                                    } else {
                                        do {
                                            System.out.println("""
                                                           >> Es posible que se haya reiniciado de fábrica. Siga los siguientes pasos:
                                                            . Identifique en la etiqutea de su router (se encuentra debajo del mismo)
                                                             el nombre de red. Figurará como SSID. Una vez identificado, busque ese nombre
                                                             entre las redes dispoinibles en su dispositivo. 
                                                            . Ahora para conectarse a esa red, deberá escribir la contraseña predeterminada,
                                                             la cual le figura en la etiqueta como WirelessPasswordPIN: (numero de 8 digitos).
                                                            . Una vez conectado, deberá configurarlo nuevamente o puede usarlo así. 
                                                             Para configurarlo deberá ingresar al administrador de su router, para ello puede
                                                             buscar en la etiqueta el modelo, y en su navegador buscar como configurar su equipo.
                                                             
                                                            También puede cambiar la contraseña desde el bot
                                                            ¿Desea configurar red y contraseña nueva?
                                                             s = SI
                                                             n = NO
                                                           """);
                                            opciones = scanner.next().charAt(0);
                                            opcion = Character.toLowerCase(opciones);
                                            if (opcion != 's' && opcion != 'n') {
                                                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                            }
                                        } while (opcion != 's' && opcion != 'n');
                                        if (opcion == 's') {
                                            cambioContrasenia(scanner);
                                        } else {
                                            new Consulta(cliente).resolucion(cliente);
                                        }
                                    }
                                } else {
                                    System.out.println("\nSe generará una orden por incidencia técnica en el router.\n");
                                    new Consulta(cliente).generarOrden(cliente);

                                }
                                break;
                            }

                        case 2:
                            do {
                                System.out.println("");
                                System.out.println("""
                                                   ¿Como se encuentran las luces en su modem?
                                                   1. Broadband apagada o en rojo y service apagada
                                                   2. Wifi apagada
                                                   """);
                                encendido = scanner.nextInt();
                            } while (encendido != 1 && encendido != 2);
                            if (encendido == 1) {
                                System.out.println("");
                                System.out.println("""
                                                   >> Por favor verifique que su cable de fibra no se encuentre 
                                                     pisado por algún objeto o mueble, o que se encuentre doblado.
                                                   """);
                                new Consulta(cliente).resolucion(cliente);
                            } else {
                                System.out.println("\nSe generará una orden por incidencia técnica en el router.\n");
                                new Consulta(cliente).generarOrden(cliente);
                            }
                            break;
                        default:
                            System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                            break;
                    }
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }
        } while (encendido != 1 && encendido != 2);
    }

    //Método vara la opción Lentitud y Microcortes
    public void lentitudMicroCortes(Scanner scanner) {
        char opciones, opcion;
        System.out.println("""
                                                     SUGERENCIAS PARA VERIFICAR SU SERVICIO:
                           ---------------------------------------------------------------------------------------------
                            >> Verifique que la cantidad de dispositivos no supere el ancho de banda recibido.
                            >> Desconecte todos los dispositivos y realice pruebas de calidad, por ejemplo:
                              Ingrese con dispositivo a youtube, escriba 1080p, y reproduzca un video durante 1 minuto.
                              Luego conecte otro dispositivo y realice la misma prueba de manera simultánea.
                           ---------------------------------------------------------------------------------------------
                           """);
        do {
            System.out.println("\n¿El video reproduce en buena calidad y sin cortes?");
            System.out.println("""
                               s = SI
                               n = NO
                               """);
            opciones = scanner.next().charAt(0);
            opcion = Character.toLowerCase(opciones);
            if (opcion != 's' && opcion != 'n') {
                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 's' && opcion != 'n');
        if (opcion == 's') {
            System.out.println("\n>> El servicio llega correctamente, por favor verifique su consumo de red.");
            new Consulta(cliente).otraConsulta();
        } else {
            do {
                System.out.println("\n¿Dese realizar un testeo de velocidad?");
                System.out.println("""
                               s = SI
                               n = NO
                               """);
                opciones = scanner.next().charAt(0);
                opcion = Character.toLowerCase(opciones);
                if (opcion != 's' && opcion != 'n') {
                    System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                }
            } while (opcion != 's' && opcion != 'n');
            if (opcion == 's') {
                testVelocidad(scanner);
            } else {
                do {
                    System.out.println("\n¿Qué tipo de servicio tiene?");
                    System.out.println("""
                                       1. Aéreo
                                       2. Fibra Óptica
                                       """);
                    opcion = scanner.next().charAt(0);
                    if (opcion != '1' && opcion != '2') {
                        System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                    }
                } while (opcion != '1' && opcion != '2');
                if (opcion == '1') {
                    System.out.println("\nSegún nos indica, su antena puede estar desorientada con respecto al panel principal, por lo tanto se generará una orden de visita técnica.");
                    new Consulta(cliente).generarOrden(cliente);
                } else {
                    System.out.println("\nSegún nos indica, la fibra puede estar atenuada, por lo tanto se generará una orden de visita técnica.");
                    new Consulta(cliente).generarOrden(cliente);
                }
            }
        }
    }

    //Método para el test de velocidad
    public void testVelocidad(Scanner scanner) {

    }

    //Método para cambiar la contraseña del router
    public void cambioContrasenia(Scanner scanner) {

    }
}
