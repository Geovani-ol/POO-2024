package menu;

import cine.Cine;
import peliculas.Pelicula;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;
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
                if (usuarioEnSesion.getRol() == Rol.ADMINISTRADOR){
                    Administrador administradorEnSesion =(Administrador) usuarioEnSesion;
                    menuAdministrador(administradorEnSesion);
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                    Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                    menuCliente(clienteEnSesion);
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
        System.out.println("\n-- Seleccionaste la opción de registrar Cliente --");

        System.out.print("\nIngrese el Nombre: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("\nIngrese los Apellidos: ");
        String apellidosCliente = scanner.nextLine();

        System.out.print("\nIngrese el Día de Nacimiento: ");
        int diaCliente = scanner.nextInt();

        System.out.print("\nIngrese el Mes de Nacimiento: ");
        int mesCliente = scanner.nextInt();

        System.out.print("\nIngrese el Año de Nacimiento: ");
        int anioCliente = scanner.nextInt();

        scanner.nextLine();
        LocalDate fechaNacimientoClietne = LocalDate.of(anioCliente, mesCliente, diaCliente);

        System.out.print("\nIngrese el Telefono: ");
        String telefonoCliente = scanner.nextLine();

        System.out.print("\nIngrese la Dirección: ");
        String direccionCliente = scanner.nextLine();

        System.out.print("\nIngrese la CURP: ");
        String curpClietne = scanner.nextLine();

        System.out.print("\nIngrese la Contraseña: ");
        String contraseniaCliente = scanner.nextLine();

        String idCliente = cine.generarIdCliente(nombreCliente, apellidosCliente);

        Cliente cliente = new Cliente(idCliente, nombreCliente, apellidosCliente, fechaNacimientoClietne, telefonoCliente, direccionCliente, curpClietne, contraseniaCliente);
        cine.registrarCliente(cliente);

        System.out.println("\nCliente registrado exitosamente");
        System.out.println("Usuario del Cliente: " + idCliente);
    }

    public void menuAdministrador(Administrador administradorEnSesion) {
        while (true) {
            System.out.println("\n** Bienvenido Administrador " + administradorEnSesion.getNombre() + " **");
            System.out.println("1.- Registrar Administrador");
            System.out.println("2.- Registrar Pelicula");
            System.out.println("3.- Registrar Cliente");
            System.out.println("4.- Mostrar Cartelera");
            System.out.println("5.- Mostrar Empleados");
            System.out.println("6.- Mostrar Clientes");
            System.out.println("7.- Salir");

            System.out.print("Seleccione una opción: ");
            int opcionAdmin = scanner.nextInt();

            switch (opcionAdmin) {
                case 1:
                    scanner.nextLine();

                    System.out.println("\n--- Registrar Administrado ---");

                    System.out.print("\nIngrese el Nombre: ");
                    String nombreAdmin = scanner.nextLine();

                    System.out.print("\nIngrese los Apellidos: ");
                    String apellidosAdmin = scanner.nextLine();

                    System.out.print("\nIngrese el Día de Nacimiento: ");
                    int diaAdmin = scanner.nextInt();

                    System.out.print("\nIngrese el Mes de Nacimiento: ");
                    int mesAdmin = scanner.nextInt();

                    System.out.print("\nIngrese el Año de Nacimiento: ");
                    int anioAdmin = scanner.nextInt();

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

                    String idAdmin = cine.generarIdAdministrador(nombreAdmin, apellidosAdmin);

                    Administrador administrador = new Administrador(idAdmin, nombreAdmin, apellidosAdmin, fechaNacimientoAdmin, telefonoAdmin, direccionAdmin, rfcAdmin, sueldoAdmin, antiguedadAdmin, contraseniaAdmin);
                    cine.registrarAdministrador(administrador);
                    cine.listaUsuarios.add(administrador);

                    System.out.println("\nAdministrador registrado exitosamente");

                    break;
                case 2:
                    System.out.println("Ingrese el título de la película:");
                    String titulo = scanner.nextLine();

                    System.out.println("Ingrese el género de la película:");
                    String genero = scanner.nextLine();

                    System.out.println("Ingrese la duración de la película:");
                    String duracion = scanner.nextLine();

                    System.out.println("Ingrese la clasificación de la película:");
                    String clasificacion = scanner.nextLine();

                    System.out.println("Ingrese la sinopsis de la película:");
                    String sinopsis = scanner.nextLine();

                    String idPelicula = cine.generarIdPelicula(titulo, duracion, clasificacion);

                    Pelicula pelicula = new Pelicula(idPelicula, titulo, genero, duracion, clasificacion, sinopsis);
                    cine.registrarPelicula(pelicula);

                    break;
                case 3:
                    scanner.nextLine();
                    signup();
                    break;
                case 4:
                    cine.mostrarCartelera();
                    break;
                case 5:
                    break;
                case 6:
                    cine.mostrarClientes();
                    break;
                case 7:
                    scanner.nextLine();
                    return;
            }
        }
    }

    public void menuCliente(Cliente clienteEnSesion) {
        while (true) {
            System.out.println("\n** Bienvenido " + clienteEnSesion.getNombre() + " **");
            System.out.println("1.- Ver mis datos");
            System.out.println("2.- Ver cartelera");
            System.out.println("3.- Comprar boletos");
            System.out.println("4.- Dulceria");
            System.out.println("5.- Salir");

            System.out.print("Seleccione una opción: ");
            int opcionCliente = scanner.nextInt();

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
                    return;
            }
        }
    }
}
