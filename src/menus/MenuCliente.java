package menus;

import Tarjetas.Tarjeta;
import banco.Banco;
import usuarios.cliente.Cliente;
import Tarjetas.Debito;
import Tarjetas.Credito;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);
    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n== Bienvenido " + clienteEnSesion.getNombre() + " ==\n");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Tarjeta de debito.");
        System.out.println("3. Tarjeta de credito.");
        System.out.println("4. Salir.");

        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionCliente, Banco banco, Cliente clienteEnSesion) {
       switch (opcionCliente) {
           case 1:
               System.out.println("\n== Mi Información ==\n");
               System.out.println("\n" + clienteEnSesion.mostrarDatos());
               break;
           case 2:
               System.out.println("\n== Tarjeta De Débido ==\n");
               boolean opcion = true;
               while (opcion) {
                   System.out.println(clienteEnSesion.getTarjetaDebito().mostrarDatosTarjeta());

                   System.out.println("\n1. Depositar");
                   System.out.println("2. Retirar");
                   System.out.println("3. Salir");
                   System.out.print("Selecciona una opción: ");
                   int op = scanner.nextInt();

                   switch (op) {
                       case 1:
                           depositar(clienteEnSesion);
                           break;
                       case 2:
                           retirar(clienteEnSesion);
                           break;
                       case 3:
                           opcion = false;
                           break;
                       default:
                           System.out.println("No existe esa opcion");
                           break;
                   }
               }
               break;
           case 3:
               System.out.println("\n== Tarjeta De Crédito ==\n");
               boolean opcionC = true;
               while (opcionC) {
                   if (clienteEnSesion.getTarjetaCredito() != null) {
                       System.out.println(clienteEnSesion.getTarjetaCredito().mostrarDatosTarjeta());

                       System.out.println("\n1. Comprar");
                       System.out.println("2. Salir");
                       System.out.print("Selecciona una opción: ");
                       int opc = scanner.nextInt();

                       switch (opc) {
                           case 1:
                               comprar(clienteEnSesion);
                               break;
                           case 2:
                               opcionC = false;
                               break;
                           default:
                               System.out.println("No existe esa opción");
                               break;
                       }
                   } else {
                       System.out.println("\nNo tienes una tarjeta de crédito asociada");
                       System.out.print("\nSolicitar tarjeta de credito? (1 - Para sí, 2 - Para no): ");
                       int op = scanner.nextInt();

                       switch (op) {
                           case 1:
                               System.out.println(banco.solicitarTarjetaCredito(clienteEnSesion));
                               break;
                           case 2:
                               break;
                           default:
                               System.out.println("La opción no existe");
                       }
                       opcionC = false;
                   }
               }
               break;
           case 4:
               System.out.println("Saliendo...");
               return false;
           default:
               System.out.println("Opcion no valida, intentelo de nuevo.");
       }
        return true;
    }

    public void depositar(Cliente clienteEnSesion) {
        System.out.print("\nIngrese el monto a depositar: ");
        double deposito = scanner.nextDouble();

        clienteEnSesion.getTarjetaDebito().setSaldo(clienteEnSesion.getTarjetaDebito().getSaldo() + deposito);
        System.out.println("Deposito exitoso");
    }

    public void retirar(Cliente clienteEnSession) {
        while (true) {
            System.out.print("\nIngrese el monto a retirar: ");
            double retiro = scanner.nextDouble();

            if (clienteEnSession.getTarjetaDebito().getSaldo() >= retiro) {
                clienteEnSession.getTarjetaDebito().setSaldo(clienteEnSession.getTarjetaDebito().getSaldo() - retiro);
                System.out.println("Retiro exitoso");
                return;
            } else {
                System.out.println("El monto del retiro es mayor a tu saldo");
            }
        }
    }

    public void comprar(Cliente clienteEnSesion) {
        while (true) {
            System.out.print("\nIngrese el monto de la compra: ");
            double compra = scanner.nextDouble();

            if (clienteEnSesion.getTarjetaCredito().getLimiteDeCredito() >= compra) {
                clienteEnSesion.getTarjetaCredito().limiteDeCredito(compra);
                System.out.println("Compra exitosa");
                return;
            } else {
                System.out.println("El monto de la compra exede el limite de crédito");
            }
        }
    }
}
