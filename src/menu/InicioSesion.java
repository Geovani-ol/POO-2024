package menu;

import cine.Cine;
import usuarios.Usuario;
import usuarios.administradores.Administrador;
import usuarios.utils.Rol;

import java.util.Scanner;

public class InicioSesion {
    private Cine cine = new Cine();
    private Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    public void inicioSecion() {
        int intentosMaximos = 3, intentosUsuario = 0;

        System.out.println("***  BIENVENIDO  ***");

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\nIngresa el usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contrasenia: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = cine.validarInisioSesion(usuario, contrasenia);

            if (usuarioEnSesion instanceof Usuario) {
                if (usuarioEnSesion.getRol() == Rol.ADMINISTRADOR){
                    Administrador administradorEnSesion =(Administrador) usuarioEnSesion;
                    menu.menuAdministrador(administradorEnSesion);
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
                System.out.println("1.- Si es Cliente nuevo, favor de registrarse");
                System.out.println("2.- Intentar otra vez");

                System.out.print("Seleccione una opción: ");
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
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
            System.out.println("Se acavaron tus oportunidades, Usuario o Contraseña incorrecto, Adios");
        }
    }

    public void signup() {

    }
}
