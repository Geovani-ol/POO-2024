package menus;

import java.util.Scanner;

public class MenuAcceso {
    public void iniciarSesion() {
        System.out.println("Bienvenido al PonyBank");
        System.out.println("Dame tu nombre: ");
        Scanner leer = new Scanner(System.in);
        String nombre = leer.nextLine();
    }
}
