package menus;

import banco.Banco;
import usuarios.gerente.Gerente;

import java.util.Scanner;

public class MenuGerente {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Gerente gerenteEnSesion) {
        System.out.println("\n== Bienvenido Gerente " + gerenteEnSesion.getNombre() + " ==\n");
        System.out.println();

        System.out.print("Seleccione una opción: ");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Registrar ejecutivo.");
        System.out.println("3. Ver Clientes. ");
        System.out.println("4. Ver Ejecutivos. ");
        System.out.println("5. Salir ");
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionGerente, Banco banco, Gerente gerenteEnSesion) {
        switch (opcionGerente) {
            case 1:
                System.out.println(gerenteEnSesion.mostrarDatos());
                break;
            case 2: this.scanner.nextLine();
                System.out.println("--INGRESAR NUEVO EJECUTIVO--");

                System.out.println("Ingrese el nombre del empleado: ");
                String nombreEjecutivo = scanner.next();

                System.out.println("Ingrese el apellido del empleado: ");
                String apellidoEjecutivo = scanner.nextLine();

                System.out.println("Ingrese la CURP del empleado: ");
                String curpEjecutivo = scanner.nextLine();

                System.out.println("Ingrese el RFC del empleado: ");
                String rfcEjecutivo = scanner.nextLine();

                System.out.println("Ingrese la dirección del empleado: ");
                String direccionEjecutivo = scanner.nextLine();

                System.out.println("Ingrese la sucursal afiliada al empleado: ");
                String sucursalEjecutivo = scanner.nextLine();

                System.out.println("Ingrese una contraseña segura y guardela: ");
                String contraseniaEjecutivo = scanner.nextLine();

                System.out.println("Ingrese el salario mensual que se le asignara al empleado: ");
                double salarioEjecutivo = scanner.nextDouble();
                break;
            case 3:
                banco.mostrarClientes();
                break;
            case 4:
                banco.mostrarEjecutivos();
                break;
            case 5:
                this.scanner.nextLine();
                return false;
            default:
                System.out.println("Opcion no valida, intentelo de nuevo: ");
        }
        return true;
    }
}
