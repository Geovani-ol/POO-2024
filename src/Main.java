import cine.Cine;
import menu.Menu;

public class Main {

    public static void main(String[] args) {

        Cine cine = new Cine();
        cine.generarFunciones();
        Menu menu = new Menu(cine);

        try {
            menu.inicioSecion();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}