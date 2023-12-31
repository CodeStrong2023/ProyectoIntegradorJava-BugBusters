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
                    new AsistenteVirtual().mostrarMenuPrincipal(cliente);
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
        int opcionMenu;

        do {
            System.out.println("------------------------------------------------------------------");
            System.out.println("\t>> TEST DE VELOCIDAD DE INTERNET <<");
            System.out.println("");
            System.out.println(" Para comenzar, seleccione una de las siguientes opciones: ");
            System.out.println("");
            System.out.println("(1) INDICACIONES PARA REALIZAR EL TEST DE VELOCIDAD DE TU INTERNET");
            System.out.println("(2) INTERPRETACION DE LOS RESULTADOS DEL TEST DE VELOCIDAD");
            System.out.println("(3) SALIR AL MENÚ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("");
            opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    System.out.println(">> Por favor, siga las siguientes instrucciones:");
                    System.out.println("\t1. Conecta tu dispositivo a la red Wi-Fi de tu hogar");
                    System.out.println("\t2. Abre un navegador web en el dispositivo");
                    System.out.println("\t3. Visita el sitio web www.speedtest.net");
                    System.out.println("\t4. Haz click en el boton >Iniciar Test< para comenzar la prueba");
                    System.out.println("\t5. Espera a que la prueba finalice y obtendrás los resultados de velocidad");
                    interpretacionResultados(scanner);
                    break;
                case 2:
                    interpretacionResultados(scanner);
                    break;
                case 3:
                    System.out.println("\nVolviendo al Menú Principal...");
                    new AsistenteVirtual().mostrarMenuPrincipal(cliente);
                    break;
                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcionMenu <= 0 || opcionMenu >= 4);
    }

    //En base a los resultados del test, se muestra el diagnostico 
    public void interpretacionResultados(Scanner scanner) {
        double velocidad_bajada_ideal = 30;
        double velocidad_subida_ideal = 3;

        int diagnostico;

        do {
            System.out.println("\nPara evaluar tus resultados, por favor selecciona una opción: ");
            System.out.println("");
            System.out.println(" (1) DIAGNÓSTICO GENERAL");
            System.out.println(" (2) DIAGNÓSTICO POR ACTIVIDAD");
            diagnostico = scanner.nextInt();
        } while (diagnostico <= 0 || diagnostico >= 3);

        switch (diagnostico) {
            case 1:
                double velocidad_bajada,
                 velocidad_subida;

                System.out.println("\nPor favor, ingrese los valores obtenidos:");
                System.out.print("Velocidad de CARGA en megabits (Mbps): ");
                velocidad_subida = scanner.nextDouble();
                System.out.print("Velocidad de DESCARGA en megabits (Mbps): ");
                velocidad_bajada = scanner.nextDouble();

                if ((velocidad_subida >= velocidad_subida_ideal) && (velocidad_bajada >= velocidad_bajada_ideal)) {
                    System.out.println("");
                    System.out.println("\t----- RESULTADO -----");
                    System.out.println("\t==== SATISFACTORIO ===");
                    System.out.println(" Parámetros de velocidad excelente\n");
                    new Consulta(cliente).otraConsulta();

                } else if ((velocidad_subida > 2 && velocidad_subida < velocidad_subida_ideal)
                        || (velocidad_bajada < velocidad_bajada_ideal && velocidad_bajada > 25)) {
                    System.out.println("");
                    System.out.println("\t------ RESULTADO ------");
                    System.out.println("\t==== SATISFACTORIO ===");
                    System.out.println(" Parámetros de velocidad normales\n");
                    new Consulta(cliente).otraConsulta();

                } else {
                    System.out.println("");
                    System.out.println("\t------- RESULTADO -------");
                    System.out.println("\t==== NO SATISFACTORIO ===");
                    System.out.println(" Parámetros de velocidad insuficientes\n");
                    new Consulta(cliente).otraConsulta();

                }
                break;

            case 2:
                velocidadSegunActividad(scanner);
                break;
        }
    }

    public void velocidadSegunActividad(Scanner scanner) {
        int velocidad_descarga_medida;
        int filaIndice;
        int RTA;

        System.out.print("\nPor favor, ingresar la velocidad de Descarga medida: ");
        velocidad_descarga_medida = scanner.nextInt();

        do {
            System.out.println("\n >> Por favor, selecciona la actividad en línea para verificar la capacidad de su Velocidad >>");
            System.out.println("    1- Streaming");
            System.out.println("    2- Navegacion Web General");
            System.out.println("    3- Reunión virtual");
            System.out.println("    4- Juegos en Línea");
            System.out.println("    5- Descarga y subida de documentos\n");
            filaIndice = scanner.nextInt();
        } while (filaIndice <= 0 || filaIndice >= 6);

        int[][] matriz = {
            {1, 5, velocidad_descarga_medida},
            {2, 8, velocidad_descarga_medida},
            {3, 33, velocidad_descarga_medida},
            {4, 50, velocidad_descarga_medida},
            {5, 40, velocidad_descarga_medida}
        };
        int filaIndiceNuevo = filaIndice - 1;

        String textoCompleto = "Se necesita un mínimo de: " + matriz[filaIndiceNuevo][1] + " Mbps para poder realizar esta actividad\n";

        if (matriz[filaIndiceNuevo][1] < velocidad_descarga_medida) {
            System.out.println("Su velocidad de internet SI ES SUFICIENTE para esta actividad\n");
        } else {
            System.out.println("Su velocidad de internet NO ES SUFICIENTE para esta actividad\n");
            System.out.println(textoCompleto);
        }
        do {
            System.out.println(" ¿Quiere consultar por otra actividad en Línea? ");
            System.out.println(" (1) SI / Volver a consultar");
            System.out.println(" (2) NO / Volver al menú principal\n");
            RTA = scanner.nextInt();

            if (RTA == 1) {
                velocidadSegunActividad(scanner);
            } else if (RTA == 2) {
                new AsistenteVirtual().mostrarMenuPrincipal(cliente);
            } else {
                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (RTA <= 0 || RTA >= 3);
    }

    //Método para cambiar la contraseña del router
    public void cambioContrasenia(Scanner scanner) {
        int opcion;
        String claveManual;

        do {
            System.out.println("\n¿Desea que su contraseña sea aleatoria o manual");
            System.out.println("1. Aleatoria");
            System.out.println("2. Manual");
            System.out.println("3. Salir al menú");
            opcion = scanner.nextInt();
            scanner.nextLine(); //Consume la nueva línea pendiente

            switch (opcion) {
                case 1: // Clave Aleatorio
                    System.out.println("\n Usted a elegido la opcion de crear la contraseña aleatoriamente.");
                    System.out.println(" Se creara una contraseña de 15 digitos para una mayor seguridad");
                    System.out.println(" Su nueva contraseña es: ");
                    System.out.println(generaContrasena());
                    System.out.println("Contraseña segura. Gracias por usar el programa\n");
                    new Consulta(cliente).otraConsulta();
                    break;

                case 2: // Clave Manual
                    do {
                        System.out.println("\n*CONSEJO*");
                        System.out.println("Para que su contraseña sea segura, por favor ingresar minimo 8 digitos.");
                        System.out.println("Ingrese su nueva contraseña manualmente: ");
                        claveManual = scanner.next();

                        if (claveManual.length() < 8) {
                            System.out.println("\n***CONTRASEÑA INSEGURA***");
                            System.out.println("Debe tener al menos 8 digitos\n");
                        } else {
                            System.out.println("\n***CONSTRASEÑA SEGURA***");
                            System.out.println("Gracias por usar el programa");
                            new Consulta(cliente).otraConsulta();
                            break;
                        }
                    } while (claveManual.length() < 8);
                    break;

                case 3: // Salir al menú principal
                    new AsistenteVirtual().mostrarMenuPrincipal(cliente);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo");
            }
        } while (opcion != 3);
    }

    static String generaContrasena() {
        char[] mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] minusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] simbolos = {'!', '¡', '?', '¿', '@', '#', '$', '&', '*', '(', ')', '-', '_', ':', ';', '.'};

        //Unimos todos los caracteres en uno solo con StringBuilder
        StringBuilder caracteres = new StringBuilder();
        caracteres.append(mayusculas);
        caracteres.append(minusculas);
        caracteres.append(numeros);
        caracteres.append(simbolos);

        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i <= 15; i++) {
            int cantidadCaracteres = caracteres.length();
            int numeroRamdom = (int) (Math.random() * cantidadCaracteres);

            contrasena.append((caracteres.toString()).charAt(numeroRamdom));
        }
        return contrasena.toString();
    }
}
