package metodoPago;

import usuarios.administradores.Administrador;
import usuarios.clientes.Cliente;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MetodoPago {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

    public void procesarPago(Cliente clienteEnSesion) {
        System.out.println("\n-- Procesar Pago --\n");
        System.out.println("1.- Efectivo");
        System.out.println("2.- Tarjeta");
        int opcion = scanner.nextInt();

        if (opcion == 2) {
            Tarjeta nuevaTarjeta = registrarTarjeta(clienteEnSesion);
            System.out.println(nuevaTarjeta.mostrarInformacion());
            System.out.println("El pago esta realizado");
        } else {
            System.out.println("El pago esta realizado");
            return;
        }
    }

    public Tarjeta registrarTarjeta(Cliente clienteEnSesion) {
        System.out.println("\n-- Registrar Tarjeta --\n");
        System.out.println("Numero de Tarjeta:");
        String numeroTarjeta = scanner.nextLine();

        System.out.println("Fecha de Vencimiento:");
        String fecha = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth fechaVencimiento = YearMonth.parse(fecha, formatter);
        YearMonth fechaActual = YearMonth.now();
        if (fechaVencimiento.isBefore(fechaActual)) {
            System.out.println("La tarjeta ha expirado.");
            return null;
        }

        System.out.println("CVV: ");
        String cvv = scanner.nextLine();

        System.out.println("Tipo de Tarjeta (Credito / Debito):");
        String tipoTarjeta = scanner.nextLine();

        Tarjeta tarjeta = new Tarjeta(clienteEnSesion, numeroTarjeta, fechaVencimiento, cvv, tipoTarjeta);
        this.listaTarjetas.add(tarjeta);
        System.out.println(tarjeta.mostrarInformacion());
        return tarjeta;
    }
}
