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
        return scanner.nextInt();
    }

    public boolean procesarDatos(int opcionEjecutivo, Banco banco, Ejecutivo ejecutivoEnSesion) {
        return true;
    }
}
