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
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionGerente, Banco banco, Gerente gerenteEnSesion) {
        return true;
    }
}
