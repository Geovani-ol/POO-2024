package menu;

import cine.Cine;
import usuarios.clientes.Cliente;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n-- Bienvenido " + clienteEnSesion.getNombre() + " --\n");
        System.out.println("1.- Ver mis datos");
        System.out.println("2.- Ver cartelera");
        System.out.println("3.- Comprar boletos");
        System.out.println("4.- Dulceria");
        System.out.println("5.- Salir");

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
                System.out.println("\n--    Mostrar Cartelera    --\n");
                break;
            case 3:
                System.out.println("\n--    Comprar Boletos    --\n");
                //trabajando en la compra de boletos
                break;
            case 4:
                System.out.println("\n--    Dulceria    --\n");
                break;
            case 5:
                scanner.nextLine();
                return false;
        }
        return true;
    }
}
