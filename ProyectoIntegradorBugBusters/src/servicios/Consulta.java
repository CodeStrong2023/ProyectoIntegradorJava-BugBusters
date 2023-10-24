
package servicios;

import ChatBot.*;
import java.util.Scanner;

public class Consulta {
    protected Cliente cliente;
    protected char resuelve;
    protected char consulta;
    
    public Consulta(Cliente cliente){
        this.cliente = cliente;
    }
    
    Scanner scanner = new Scanner(System.in);

    Consulta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Metodo solucion 
    public void resolucion(Cliente cliente){
        System.out.println("¿Resolvio su consulta? s/n");
        resuelve = scanner.next().charAt(0);
        
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
        
        System.out.println("La visita se realizara al domicilio: " + cliente.getDireccion());
        System.out.println("Se comunicaran con usted al numero: " + cliente.getTelefono());
        otraConsulta();
    }
    
    //Metodo salir
    public void salir(){
        System.out.println("GRACIAS POR USAR NUESTRO ASISTENTE VIRTUAL ;)");
        System.out.println("""
                          >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                          ^    Desarrolladores:                   ^
                          ^    |--------> MARCOS SENN             ^
                          ^    |--------> SANTIAGO SEGURA         ^
                          ^    |--------> DAVID ABADIE            ^
                          ^    |--------> NICOLAS NUÑEZ           ^
                          ^    |--------> BELEN LIMACHI           ^
                          ^    |--------> FLORENCIA CAMONA        ^
                          ^    |--------> FRANCO PIZARRO          ^
                          <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
                           """);
        System.exit(0);
    }  
}
