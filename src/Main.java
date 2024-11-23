import banco.Banco;
import menus.MenuAcceso;
import usuarios.Usuario;
import utils.JsonManager;

public class Main {

    public static void main(String[] args) {

        //Banco banco;
        //String filePath = "banco.json";

        //banco = JsonManager.cargarBancoDesdeJson(filePath);*/

        MenuAcceso menuAcceso = new MenuAcceso();
        menuAcceso.iniciarSesion();

        //JsonManager.guardarBancoEnJson(banco, filePath);

    }

}