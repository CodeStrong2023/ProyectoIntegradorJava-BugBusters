
package servicios;

import ChatBot.*;
import java.util.Scanner;

public class Consulta {
    public Cliente cliente;
    protected char resuelve;
    protected char consulta;
    
    public Consulta(Cliente cliente){
        this.cliente = cliente;
    }
    
    Scanner scanner = new Scanner(System.in);

    //Metodo solucion 
    public void resolucion(Cliente cliente){
        System.out.println("¿Resolvio su consulta? s/n");
        resuelve = scanner.next().charAt(0);
        resuelve = Character.toLowerCase(resuelve);
        
        if(resuelve == 's'){
            otraConsulta();
        }
        else if(resuelve == 'n'){
           generarOrden(cliente);
        }
    }
    
    //Metodo otra consulta
    public void otraConsulta(){
        System.out.println("¿Tiene otra consulta? s/n");
        consulta = scanner.next().charAt(0);
        consulta = Character.toLowerCase(consulta);
        
        if(consulta == 's'){
            System.out.println(">> REDIRIGIENDO AL MENÚ PRINCIPAL <<");
            new AsistenteVirtual().mostrarMenuPrincipal(scanner);
        }
        else{
            salir();
        }
    }
    
    //Metodo generar orden
    public void generarOrden(Cliente cliente){
        System.out.println("""
                           --------------------------------------
                           ****~~     TICKET DE ORDEN      ~~****
                           --------------------------------------
                           """);
        int numOrden = (int) (Math.random()*100000);
        System.out.println("Número de orden: " + numOrden);
        System.out.println("La visita se realizará al domicilio: " + cliente.getDireccion());
        System.out.println("Se comunicarán con usted al teléfono: " + cliente.getTelefono());
        otraConsulta();
    }
    
    //Metodo salir
    public void salir(){
        System.out.println("\nGRACIAS POR USAR NUESTRO ASISTENTE VIRTUAL ;)");
        System.out.println("""
                          >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                          ^     Desarrolladores:                   ^
                          ^     |--------> MARCOS SENN             ^
                          ^     |--------> SANTIAGO SEGURA         ^
                          ^     |--------> DAVID ABADIE            ^
                          ^     |--------> NICOLAS NUÑEZ           ^
                          ^     |--------> BELEN LIMACHI           ^
                          ^     |--------> FRANCO PIZARRO          ^
                          <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
                           """);
        System.exit(0);
    }  
}
