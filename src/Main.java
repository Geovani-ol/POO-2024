import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Habitacion> habitacions = new ArrayList<>();
        habitacions.add(new Habitacion("Individual", 50.0, true));
        habitacions.add(new Habitacion("Doble", 75, true));
        habitacions.add(new Habitacion("Suite", 150, true));

        while (true) {
            System.out.println("\n=== SISTEMA DE RESERVAS DE HABITACIONES ===");
            System.out.println("1.- Mostrar detalles de las habitaciones");
            System.out.println("2.- Realizar una reserva");
            System.out.println("3.- Liberar una habitación");
            System.out.println("4.- Salir");

            try {
                System.out.print("Seleccione una opción: ");
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
                        mostrarHabitaciones(habitacions);
                        break;
                    case 2:
                        realizarRaserva(scanner, habitacions);
                        break;
                    case 3:
                        librarHabitacion(scanner, habitacions);
                        break;
                    case 4:
                        System.out.println("\n Hasta luego");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.next();
            }
        }

    }

    private static void mostrarHabitaciones(ArrayList<Habitacion> habitacions) {
        System.out.println("\n-- Habitaciones --");
        for (Habitacion habitacion: habitacions) {
            habitacion.mostrarDetalles();
            System.out.println();
        }
    }

    private static void realizarRaserva(Scanner scanner, ArrayList<Habitacion> habitacions) {
        while (true) {
            System.out.println("\n-- Resarva de Habitación");
            System.out.println("1.- Individual");
            System.out.println("2.- Doble");
            System.out.println("3.- Suite");

            try {
                System.out.print("Ingrese una habitación: ");
                int THabitacion = scanner.nextInt();

                if (THabitacion < 1 || THabitacion > habitacions.size()) {
                    throw new IllegalArgumentException("Número de habitación inálido");
                }

                System.out.print("Ingrese el número de noches a reservar: ");
                int noches = scanner.nextInt();

                if (noches <= 0) {
                    throw new IllegalArgumentException("El número de noches a reservar debe ser mayor a 0");
                }

                Habitacion habitacion = habitacions.get(THabitacion - 1);
                habitacion.reservar(noches);
                System.out.println("\nReserva exitosa para " + noches + " noche/s");
                System.out.println("Costo total de la reserva: " + (habitacion.getPrecioPorNoche() * noches));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("\nError en la reserva: " + e.getMessage());
                System.out.println("Intente Nuevamente");
            } catch (HabitacionNoDisponibleException | NumeroDeNochesInvalidoException e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Intente Nuevamente");
            }
        }
    }

    private static void librarHabitacion(Scanner scanner, ArrayList<Habitacion> habitacions) {
        System.out.println("\n-- Liberar Habitación");
        System.out.println("1.- Individual");
        System.out.println("2.- Doble");
        System.out.println("3.- Suite");

        try {
            System.out.print("Ingresa una opción: ");
            int THabitacion = scanner.nextInt();

            if (THabitacion < 1 || THabitacion > habitacions.size()) {
                throw new IllegalArgumentException("Número de habitación inálido");
            }

            Habitacion habitacion = habitacions.get(THabitacion - 1);

            if (habitacion.isDisponibilidad()) {
                throw new IllegalArgumentException("La habitación ya esta disponible");
            } else {
                habitacion.setDisponibilidad(true);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

}