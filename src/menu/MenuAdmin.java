package menu;

import cine.Cine;
import metodoPago.MetodoPago;
import peliculas.Funciones;
import peliculas.Pelicula;
import usuarios.administradores.Administrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Administrador administradorEnSesion) {
        System.out.println("\n-- Bienvenido Administrador " + administradorEnSesion.getNombre() + " --\n");
        System.out.println("1.- Registrar Administrador");
        System.out.println("2.- Registrar Pelicula");
        System.out.println("3.- Registrar Cliente");
        System.out.println("4.- Mostrar Cartelera");
        System.out.println("5.- Mostrar Assientos de Sala");
        System.out.println("6.- Mostrar Clientes");
        System.out.println("7.- Mostrar Funciones");
        System.out.println("8.- Editar Funciones");
        System.out.println("9.- Salir");

        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Boolean procesarDatos(int opcionAdmin, Cine cine, Administrador administradorEnSesion) {
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
                System.out.println("\n╚╤σσ  Seleccionaste la opcion Registrar Pelicula   ╚◘╤╤σ\n");
                scanner.nextLine();
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
                Menu menu = new Menu();
                menu.signup();
                break;
            case 4:
                /*MetodoPago metodoPago = new MetodoPago();
                metodoPago.procesarTarjeta(administradorEnSesion);*/

                break;
            case 5:
                cine.mostrarAsientosDeSala("Sala 1");
                System.out.println("Cuantos asientos quieres reservar?");
                int numeroAsientos = scanner.nextInt();
                String[] asientos = new String[numeroAsientos];

                scanner.nextLine();

                for (int i = 0; i < asientos.length; i++) {
                    System.out.println("Selecciona un Asiento");
                    String celda = scanner.nextLine();

                    asientos[i] = celda;
                }

                cine.reservarAsientos("Sala 1", asientos);
                cine.mostrarAsientosDeSala("Sala 1");
                break;
            case 6:
                cine.mostrarClientes();
                break;
            case 7:
                cine.listaFunciones.removeAll(cine.listaFunciones);
                for (int i = 0; i < 5; i++) {
                    cine.funciones(i);
                }
                cine.mostrarFunciones();
                break;
            case 8:
                scanner.nextLine();
                int opcion = 0;
                boolean bandera = true;
                cine.mostrarFunciones();
                while(bandera) {
                    System.out.println("\n-- Seleccionaste la opcion de editar las funciones --\n");
                    System.out.println("1.- Editar Funcion");
                    System.out.println("2.- Eliminar Funcion");
                    System.out.println("3.- Regresar");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa el id de la Funcion que deseas modificar: ");
                            int idFuncion = scanner.nextInt();
                            Funciones funcion = cine.obtenerFuncionPorId(idFuncion);
                            System.out.println("La funcion que quieres editar es la siguiente: ");
                            cine.mostrarFuncionPorId(idFuncion);
                            boolean bandera2 = true;
                            while(bandera2) {
                                System.out.println("Que deseas modificar?");
                                System.out.println("1.- Hora");
                                System.out.println("2.- Sala");
                                System.out.println("3.- Pelicula");
                                System.out.println("4.- Regresar");
                                System.out.print("Seleccione una opción: ");
                                int opcion2 = scanner.nextInt();
                                switch (opcion2) {
                                    case 1:
                                        System.out.println("Ingresa la nueva hora: ");
                                        int hora = scanner.nextInt();
                                        System.out.println("Ingresa los nuevos minutos");
                                        int minutos = scanner.nextInt();
                                        funcion.setHorarioInicio(LocalTime.of(hora, minutos));
                                        System.out.println("\nCambio de hora exitoso\n");
                                        break;
                                    case 2:
                                        System.out.println("Ingresa la nueva sala: ");
                                        int sala = scanner.nextInt();
                                        funcion.sala.setNombre("Sala ".concat(String.valueOf(sala)));
                                        break;
                                    case 3:
                                        System.out.println("Ingresa el id de la nueva pelicula: ");
                                        String idNuevaPelicula = scanner.nextLine();
                                        funcion.pelicula = cine.obtenerPeliculaPorId(idNuevaPelicula);
                                        break;
                                    case 4:
                                        return false;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Ingresa el id de la Funcion que deseas eliminar: ");
                            int idFuncionEliminar = scanner.nextInt();
                            Funciones funcionEliminar = cine.obtenerFuncionPorId(idFuncionEliminar);
                            cine.listaFunciones.remove(funcionEliminar);
                            System.out.println("Funcion eliminada con exito");
                            break;
                        case 3:
                            return false;
                        default:
                            System.out.println("\nOpcion no valida\n");
                            break;
                    }
                }
                break;
            case 9:
                scanner.nextLine();
                return false;
        }
        return true;
    }
}
