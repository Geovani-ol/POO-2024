package menu;

import cine.Cine;
import usuarios.empleados.Empleado;

import java.util.Scanner;

public class MenuEmpleado {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Empleado empleadoEnSesion) {
        System.out.println("Bienvenido " + empleadoEnSesion.getNombre()+"\n");
        System.out.println("1.- Registrar entrada.");
        System.out.println("2.- Registrar salida.");
        System.out.println("3.- Ver mis datos.");
        System.out.println("4.- Mostrar Registro de horarios y salidas");
        System.out.println("5.- Salir");
        System.out.println("\nSeleccione una opción: ");
        return scanner.nextInt();
    }

    public Boolean procesarDatos(int opcionEmpleado, Cine cine, Empleado empleadoEnSesion) {
        switch (opcionEmpleado) {
            case 1:
                //empleadoEnSesion.registrarEntrada();
            case 2:
                //empleadoEnSesion.registrarSalida();
            case 3:
                System.out.println(empleadoEnSesion.mostrarDatos());
            case 4:
                //empleadoEnSesion.mostrarRegistros();
            case 5:
                scanner.nextLine();
                return false;
            default:
                System.out.println("Selección Incorrecta, Intente Nuevamente");
                break;
        }
        return true;
    }
}
