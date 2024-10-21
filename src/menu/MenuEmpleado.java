package menu;

import cine.Cine;
import usuarios.clientes.Cliente;
import usuarios.empleados.Empleado;

import java.util.Scanner;

public class MenuEmpleado {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Empleado empleadoEnSesion) {
        System.out.println("Bienvenido " + empleadoEnSesion.getNombre()+"\n");
        System.out.println("1.- Compra en taquilla");
        System.out.println("2.- Ver mis datos.");
        System.out.println("3.- Salir");
        System.out.println("\nSeleccione una opción: ");
        return scanner.nextInt();
    }

    public Boolean procesarDatos(int opcionEmpleado, Cine cine, Empleado empleadoEnSesion) {
        switch (opcionEmpleado) {
            case 1:
                scanner.nextLine();
                System.out.println("\nSeleccionaste la opcion de comprar en taquilla: \n");
                System.out.println("Introduce el usuario del cliente: ");
                String usuario = scanner.nextLine();
                Cliente cliente = cine.obtenerClientePorId(usuario);
                cine.comprarBoleto(cliente);
                break;
            case 2:
                scanner.nextLine();
                System.out.println(empleadoEnSesion.mostrarDatos());

            case 3:
                scanner.nextLine();
                return false;
            default:
                System.out.println("Selección Incorrecta, Intente Nuevamente");
                break;
        }
        return true;
    }
}
