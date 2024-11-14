import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== PROGRAMAS DE TAREAS ===");
            System.out.println("1.- Escribir Tarea");
            System.out.println("2.- Leer Tareas");
            System.out.println("3.- Terminar");
            try {
                System.out.print("Ingresa una opción: ");
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
                        scanner.nextLine();
                        escribirTarea();
                        break;
                    case 2:
                        leerTareas();
                        break;
                    case 3:
                        System.out.println("\nPrograma Terminado");
                        return;
                    default:
                        System.out.println("\nNo existe esa opción, Intenta de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida");
            }
        }

    }

    public static void escribirTarea() {
        System.out.println("\n== Escribir Tareas ==");
        System.out.print("Ingresa tarea: ");
        String tarea = scanner.nextLine();

        try (FileWriter escribir = new FileWriter("Tareas.txt", true)) {
            escribir.write(tarea + "\n");
            System.out.println("Tarea guardada");
        } catch (IOException e) {
            System.out.println("\nOcurrió un error al escribir en el archivo: " + e);
        }
    }

    public static void leerTareas() {
        System.out.println("\n== Leer Tareas ==");

        try (BufferedReader leer = new BufferedReader(new FileReader("Tareas.txt"))) {
            String tareas;

            while ((tareas = leer.readLine()) != null) {
                System.out.println(tareas);
            }
        } catch (IOException e) {
            System.out.println("\nOcurrió un error al leer el archivo: " + e);
        }

    }

}