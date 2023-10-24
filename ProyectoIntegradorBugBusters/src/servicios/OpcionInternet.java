//REVISAR LINEA 125, hay un bucle al indicar que tiene otra consulta e intenta salir del menú
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
                    System.out.println("Ha seleccionado Lentitud y Microcortes. ¿En qué puedo ayudarte?");
                    break;
                case 3:
                    System.out.println("Ha seleccionado Test de Velocidad. ¿En qué puedo ayudarte?");
                    break;
                case 4:
                    System.out.println("Ha seleccionado Cambio de Contraseña del Router. ¿En qué puedo ayudarte?");
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }

        } while (opcionInternet != 0);
    }
    
    //Método para la opción "Sin servicio"
    public void sinServicio(Scanner scanner){
        int encendido;
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
            
        }while (encendido < 1 && encendido > 2);
        
        switch (encendido) {
            case 1:
                do{
                    
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
                    
                    if (opcion == 'n'){
                        System.out.println("\n>> Por favor conecte la ficha power al equipo.");
                        new Consulta(cliente).resolucion(cliente);
                        break;
                    }else if(opcion == 's'){
                        do{
                            
                            System.out.println("");
                            System.out.println("""
                                           ¿Verificó que su tomacorriente funciona corectamente?
                                           s = SI
                                           n = NO
                                           """);
                             opciones = scanner.next().charAt(0);
                             opcion = Character.toLowerCase(opciones);
                        
                            if(opcion == 'n'){
                                System.out.println("\n>> Por favor, pruebe en otro tomacorriente.");
                                new Consulta(cliente).resolucion(cliente);
                                break;
                            }else if(opcion == 's'){
                                do{
                                    
                                    System.out.println("");
                                    System.out.println("""
                                                   ¿El botón de encendido está en la posición (ON)?
                                                   s = SI
                                                   n = NO
                                                   """);
                                    opciones = scanner.next().charAt(0);
                                    opcion = Character.toLowerCase(opciones);
                                
                                    if(opcion == 'n'){
                                        System.out.println("\n>> Por favor, cambie el botón de encendido a ON.");
                                        new Consulta(cliente).resolucion(cliente);
                                        break;
                                    }else if(opcion == 's'){
                                        new Consulta(cliente).otraConsulta();
//                                        do{
//                                            
//                                            System.out.println("\n¿Resolvió su inconveniente?");
//                                            System.out.println("s = SI");
//                                            System.out.println("n = NO");
//                                            opciones = scanner.next().charAt(0);
//                                            opcion = Character.toLowerCase(opciones);
//                                            
//                                            if(opcion == 's'){
//                                                System.out.println("\nProblema solucionado!! Será redirigido al menú principal.");
//                                                new AsistenteVirtual().mostrarMenuPrincipal(scanner);
//                                                break;
//                                            }else if(opcion == 'n'){
//                                                System.out.println("\nSe generará una orden de visita técnica. ");
//                                                new Consulta(cliente).generarOrden(cliente);
//                                            }else{
//                                                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
//                                            }
//                                            
//                                        }while(opcion != 's' || opcion != 'n');
                                    break;    
                                    }else{
                                        System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                                    }
                                    
                                }while(opcion != 's' || opcion != 'n');
                            break;    
                            }else{
                                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");
                            }
                            
                        }while(opcion != 's' || opcion != 'n'); 
                    break;
                    }else{
                        System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");                
                    }
                    
                }while(opcion != 's' || opcion != 'n');   
            break;
            
            case 2:
                System.out.println("""
                                   >> Seleccione el tipo de router que posee:
                                   1. Router WiFi
                                   2. Router FTTH
                                   """);
                break;
            default:
                System.out.println("\nOpción no válida. Por favor, seleccione una opción correcta.");  
        }
    }
    
}
