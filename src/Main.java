import Tarjetas.Tarjeta;
import banco.Banco;
import menus.MenuAcceso;
import utils.JsonManager;

public class Main {

    public static void main(String[] args) {

        String filePath = "banco.json";
        Banco banco = JsonManager.cargarBancoDesdeJson(filePath);

        MenuAcceso menuAcceso = new MenuAcceso(banco);
        menuAcceso.iniciarSesion();
        Tarjeta tarjeta = new Tarjeta();

        JsonManager.guardarBancoEnJson(banco, filePath);

    }

}