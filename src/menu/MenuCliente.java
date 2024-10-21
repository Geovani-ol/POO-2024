package menu;

import cine.Cine;
import dulceria.Dulceria;
import usuarios.clientes.Cliente;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n-- Bienvenido " + clienteEnSesion.getNombre() + " --\n");
        System.out.println("1.- Ver mis datos");
        System.out.println("2.- Comprar boletos");
        System.out.println("3.- Mostrar Funciones");
        System.out.println("4.- Salir");

        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Boolean procesarDatos(int opcionCliente, Cine cine, Cliente clienteEnSesion) {
        switch (opcionCliente) {
            case 1:
                System.out.println("\n--- Mis Datos --- ");
                System.out.println(clienteEnSesion.mostrarDatos());
                break;
            case 2:
                System.out.println("\n--    Comprar Boletos    --");
                cine.comprarBoleto(clienteEnSesion);
                break;
            case 3:
                cine.mostrarFunciones();
                break;
            case 4:
                scanner.nextLine();
                return false;
            default:
                System.out.println("Selección Incorrecta, Intente Nuevamente");
                break;
        }
        return true;
    }
}
