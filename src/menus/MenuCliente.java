package menus;

import banco.Banco;
import usuarios.cliente.Cliente;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n== Bienvenido " + clienteEnSesion.getNombre() + " ==\n");
        System.out.println();

        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionCliente, Banco banco, Cliente clienteEnSesion) {
        return true;
    }
}
