package menu;

import cine.Cine;
import usuarios.administradores.Administrador;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Cine cine = new Cine();
    Scanner scanner = new Scanner(System.in);

    public void menuAdministrador(Administrador administradorEnSesion) {
        while (true) {
            System.out.println("\n** Bienvenido Administrador " + administradorEnSesion.getNombre() + " **");
            System.out.println("1.- Registrar Administrador");
            System.out.println("2.- Registrar Empleado");
            System.out.println("3.- Registrar Cliente");
            System.out.println("4.- Mostrar Administradores");
            System.out.println("5.- Mostrar Empleados");
            System.out.println("6.- Mostrar Clientes");
            System.out.println("7.- Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n-- Seleccionaste la opción de registrar Administrado --");

                    System.out.print("\nIngrese el Nombre: ");
                    String nombreAdmin = scanner.nextLine();

                    System.out.print("\nIngrese los Apellidos: ");
                    String apellidosAdmin = scanner.nextLine();

                    String idAdmin = cine.generarIdAdministrador(nombreAdmin, apellidosAdmin);

                    System.out.print("\nIngrese el Año de Nacimiento: ");
                    int anioAdmin = scanner.nextInt();

                    System.out.print("\nIngrese el Mes de Nacimiento: ");
                    int mesAdmin = scanner.nextInt();

                    System.out.print("\nIngrese el Día de Nacimiento: ");
                    int diaAdmin = scanner.nextInt();

                    LocalDate fechaNacimientoAdmin = LocalDate.of(anioAdmin, mesAdmin, diaAdmin);

                    System.out.print("\nIngrese el Telefono: ");
                    String telefonoAdmin = scanner.nextLine();

                    System.out.print("\nIngrese la Dirección: ");
                    String direccionAdmin = scanner.nextLine();

                    System.out.print("\nIngrese el RFC: ");
                    String rfcAdmin = scanner.nextLine();

                    System.out.print("\nIngrese el Sueldo: ");
                    Double sueldoAdmin = scanner.nextDouble();

                    System.out.print("\nIngrese la Antiguedad: ");
                    int antiguedadAdmin = scanner.nextInt();

                    System.out.print("\nIngrese la Contraseña: ");
                    String contraseniaAdmin = scanner.nextLine();

                    Administrador administrador = new Administrador(idAdmin, nombreAdmin, apellidosAdmin, fechaNacimientoAdmin, telefonoAdmin, direccionAdmin, rfcAdmin, sueldoAdmin, antiguedadAdmin, contraseniaAdmin);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return;
            }
        }
    }
}
