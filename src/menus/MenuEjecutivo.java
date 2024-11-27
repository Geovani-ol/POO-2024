package menus;

import banco.Banco;
import usuarios.ejecutivo.Ejecutivo;

import java.util.Scanner;

public class MenuEjecutivo {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Ejecutivo ejecutivoEnSesion) {
        System.out.println("\n== Bienvenido Ejecutivo " + ejecutivoEnSesion.getNombre() + " ==\n");
        System.out.println();

        System.out.print("Seleccione una opción: ");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Ver clientes.");
        System.out.println("3. Ingresar nuevo cliente.");
        System.out.println("4. Salir ");
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionEjecutivo, Banco banco, Ejecutivo ejecutivoEnSesion) {
        switch (opcionEjecutivo) {
            case 1:
                System.out.println(ejecutivoEnSesion.mostrarDatos());
                break;
            case 2:
                banco.mostrarClientes();
                break;
            case 3:
                this.scanner.nextLine();
                System.out.println("--INGRESAR NUEVO CLIENTE--");

                System.out.println("Ingrese el nombre del cliente: ");
                String nombreCliente = scanner.next();

                System.out.println("Ingrese el apellido del cliente: ");
                String apellidoCliente = scanner.nextLine();

                System.out.println("Ingrese la CURP del cliente: ");
                String curpCliente = scanner.nextLine();

                System.out.println("Ingrese el RFC del cliente: ");
                String rfcCliente = scanner.nextLine();

                System.out.println("Ingrese la dirección del cliente: ");
                String direccionCliente = scanner.nextLine();

                System.out.println("Ingrese la sucursal afiliada al cliente: ");
                String sucursalCliente = scanner.nextLine();

                System.out.println("Ingrese una contraseña segura y guardela: ");
                String contraseniaCliente = scanner.nextLine();
                break;
            case 4:
                return false;
        }
        return true;
    }
}
