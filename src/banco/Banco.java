package banco;

import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;

import java.util.ArrayList;

public class Banco {
    public ArrayList<Usuario> listaUsuarios;
    public ArrayList<Gerente> listaGerentes;
    public ArrayList<Ejecutivo> listaEjecutivos;
    public ArrayList<Cliente> listaClientes;

    Gerente gerente = new Gerente("dgol", "Geovani", "Lobato", "NDJKRBLEFJA", "NJAEKFELK", "Arriaga 45", "Norte", "123", 10000);

    public Banco() {
        // Inicializamos las listas
        this.listaUsuarios = new ArrayList<>();
        this.listaGerentes = new ArrayList<>();
        this.listaEjecutivos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaUsuarios.add(gerente);  // Añadimos gerente a la lista genérica
        this.listaGerentes.add(gerente);  // Añadimos gerente a la lista de gerentes
    }

    public Usuario validarInisioSesion(String idUsuario, String contrasenia) {
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().trim().equals(idUsuario.trim()) &&
                    usuario.getContrasenia().trim().equals(contrasenia.trim())) {
                return usuario;
            }
        }
        return null;
    }
}
