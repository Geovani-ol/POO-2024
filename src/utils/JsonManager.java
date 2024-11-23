package utils;

import banco.Banco;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonManager {
    private static final Gson gson;

    static {
        // Crear un RuntimeTypeAdapterFactory que maneje las clases derivadas de Usuario
        RuntimeTypeAdapterFactory<Usuario> adapterFactory = RuntimeTypeAdapterFactory
                .of(Usuario.class, "rol")  // "rol" es el campo que indica el tipo
                .registerSubtype(Gerente.class, "GERENTE")
                .registerSubtype(Ejecutivo.class, "EJECUTIVO")
                .registerSubtype(Cliente.class, "CLIENTE");



        // Configurar Gson para usar este adaptador
        gson = new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .setPrettyPrinting()
                .create();
    }

    // Guardar el estado del banco en un archivo JSON
    public static void guardarBancoEnJson(Banco banco, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            String json = gson.toJson(banco);
            System.out.println(json);  // Verifica el contenido del JSON
            gson.toJson(banco, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }


    // Cargar el estado del banco desde un archivo JSON
    public static Banco cargarBancoDesdeJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Banco>() {}.getType();
            Banco banco = gson.fromJson(reader, type);
            System.out.println(gson.toJson(banco));  // Verifica el contenido cargado
            return banco;
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo JSON: " + e.getMessage());
            return new Banco();  // Retornar un banco vacío en caso de error
        }
    }

}
