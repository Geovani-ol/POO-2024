package menus;

import Tarjetas.Tarjeta;
import banco.Banco;
import usuarios.cliente.Cliente;
import Tarjetas.Debito;
import Tarjetas.Credito;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);
    Tarjeta tarjeta = new Tarjeta();
    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n== Bienvenido " + clienteEnSesion.getNombre() + " ==\n");
        System.out.println();

        System.out.print("Seleccione una opción: ");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Ver tarjeta de debito.");
        System.out.println("3. Ver tarjeta de credito.");
        System.out.println("4. Salir.");

        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionCliente, Banco banco, Cliente clienteEnSesion) {
       switch (opcionCliente) {
           case 1:
               System.out.println(clienteEnSesion.mostrarDatos());
               break;
           case 2:
               Tarjeta.Debito(clienteEnSesion);
               break;
           case 3:
               Tarjetas.Credito(clienteEnSesion);
               break;
           case 4:
               this.scanner.nextLine();
               return false;
               break;
           default:
               System.out.println("Opcion no valida, intentelo de nuevo.");
       }
        return true;
    }

    public void depositar(Cliente clienteEnSesion) {
        System.out.println("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
    }
}
