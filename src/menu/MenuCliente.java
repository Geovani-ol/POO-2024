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
        System.out.println("4.- Salir");

        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Boolean procesarDatos(int opcionCliente, Cine cine, Cliente clienteEnSesion) {
        scanner.nextLine();
        switch (opcionCliente) {
            case 1:
                System.out.println("\n--- Mis Datos --- ");
                System.out.println(clienteEnSesion.mostrarDatos());
                break;
            case 2:
                System.out.println("\n--    Mostrar Cartelera    --\n");
                cine.mostrarCartelera();
                break;
            case 3:
                System.out.println("\n--    Comprar Boletos    --\n");

                System.out.println("Ingrese el codigo de la Pelicula: ");
                String codigoPelicula = scanner.nextLine();

                cine.comprarBoleto(codigoPelicula);
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
