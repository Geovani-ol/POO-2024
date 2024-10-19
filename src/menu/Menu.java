package menu;

import cine.Cine;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;
import usuarios.empleados.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Cine cine = new Cine();
    Scanner scanner = new Scanner(System.in);

    public void inicioSecion() {
        int intentosMaximos = 3, intentosUsuario = 0;

        System.out.println("\n***  BIENVENIDO A CINÉPOLIS  ***");

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n-- Inicia Sesión --");

            System.out.println("\nIngresa el usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contrasenia: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = cine.validarInisioSesion(usuario, contrasenia);

            if (usuarioEnSesion instanceof Usuario) {
                if (usuarioEnSesion.getRol() == Rol.ADMINISTRADOR) {
                    Administrador administradorEnSesion = (Administrador) usuarioEnSesion;
                    MenuAdmin menuAdmin = new MenuAdmin();
                    int opcionAdmin;
                    boolean sesion = true;
                    while (sesion) {
                        opcionAdmin = menuAdmin.mostrarMenu(administradorEnSesion);
                        sesion = menuAdmin.procesarDatos(opcionAdmin, cine, administradorEnSesion);
                    }
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                    Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                    MenuCliente menuCliente = new MenuCliente();
                    int opcionCliente;
                    boolean sesion = true;
                    while (sesion) {
                        opcionCliente = menuCliente.mostrarMenu(clienteEnSesion);
                        sesion = menuCliente.procesarDatos(opcionCliente, cine, clienteEnSesion);
                    }
                    intentosUsuario = 0;
                } else {
                    Empleado empleadoEnSesion = (Empleado) usuarioEnSesion;
                    MenuEmpleado menuEmpleado = new MenuEmpleado();
                    int opcionEmpleado;
                    boolean sesion = true;
                    while (sesion) {
                        opcionEmpleado = menuEmpleado.mostrarMenu(empleadoEnSesion);
                        sesion = menuEmpleado.procesarDatos(opcionEmpleado, cine, empleadoEnSesion);
                    }
                    intentosUsuario = 0;
                }
            } else {
                errorInicioSesion(intentosUsuario);
                intentosUsuario++;
            }
        }
    }

    public void errorInicioSesion(int intentosUsuarios) {
        if (intentosUsuarios >= 0 && intentosUsuarios < 2){
            System.out.println("\nUsuario o Contraseña incorrectos");
            while (true) {
                System.out.println("1.- Registrar nuevo Cliente");
                System.out.println("2.- Intentar otra vez");

                System.out.print("Seleccione una opción: ");
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
                        scanner.nextLine();
                        signup();
                        return;
                    case 2:
                        scanner.nextLine();
                        return;
                    default:
                        System.out.println("Selección Incorrecta, Intente Nuevamente");
                        break;
                }
            }
        } else {
            System.out.println("Ha excedido el número de intentos permitidos. Adiós.");
        }
    }

    public void signup() {
        System.out.println("\n-- Seleccionaste la opción de registrar Cliente --\n");

        System.out.print("Ingrese el Nombre: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("Ingrese los Apellidos: ");
        String apellidosCliente = scanner.nextLine();

        System.out.print("Ingrese el Día de Nacimiento: ");
        int diaCliente = scanner.nextInt();

        System.out.print("Ingrese el Mes de Nacimiento: ");
        int mesCliente = scanner.nextInt();

        System.out.print("Ingrese el Año de Nacimiento: ");
        int anioCliente = scanner.nextInt();

        scanner.nextLine();
        LocalDate fechaNacimientoClietne = LocalDate.of(anioCliente, mesCliente, diaCliente);

        System.out.print("Ingrese el Telefono: ");
        String telefonoCliente = scanner.nextLine();

        System.out.print("Ingrese la Dirección: ");
        String direccionCliente = scanner.nextLine();

        System.out.print("Ingrese la CURP: ");
        String curpClietne = scanner.nextLine();

        System.out.print("Ingrese la Contraseña: ");
        String contraseniaCliente = scanner.nextLine();

        String idCliente = cine.generarIdCliente(nombreCliente, apellidosCliente);

        Cliente cliente = new Cliente(idCliente, nombreCliente, apellidosCliente, fechaNacimientoClietne, telefonoCliente, direccionCliente, curpClietne, contraseniaCliente);
        cine.registrarCliente(cliente);

        System.out.println("\nCliente registrado exitosamente");
        System.out.println("Usuario del Cliente: " + idCliente);
    }
}
