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

    public Banco() {
        this.listaUsuarios = new ArrayList<>();
        this.listaGerentes = new ArrayList<>();
        this.listaEjecutivos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    public Usuario validarInicioSesion(String idUsuario, String contrasenia) {
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().trim().equals(idUsuario.trim()) &&
                    usuario.getContrasenia().trim().equals(contrasenia.trim())) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarGerente(Gerente gerente) {
        this.listaUsuarios.add(gerente);
        this.listaGerentes.add(gerente);
    }

    public void registrarEjecutivo(Ejecutivo ejecutivo) {
        this.listaUsuarios.add(ejecutivo);
        this.listaEjecutivos.add(ejecutivo);
    }

    public void registrarCliente(Cliente cliente) {
        this.listaUsuarios.add(cliente);
        this.listaClientes.add(cliente);
    }
}
