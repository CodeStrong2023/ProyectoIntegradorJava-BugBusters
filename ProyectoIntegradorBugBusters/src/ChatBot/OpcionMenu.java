
package ChatBot;

import java.util.Scanner;

public abstract class OpcionMenu {
    protected Cliente cliente;

    // Constructor
    public OpcionMenu(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método abstracto para mostrar el menú específico de cada opción
    public abstract void mostrarMenu(Scanner scanner);
}
