package banco;

import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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

    public String generarIdUsuario(String nombre, Rol rolNuevo) {
        int mes = LocalDate.now().getMonthValue();
        int anio = LocalDate.now().getYear();
        String nom = nombre.substring(0, 3).toUpperCase();
        String inicial = "";

        if (rolNuevo == Rol.GERENTE) {
            inicial = "G";
        } else if (rolNuevo == Rol.EJECUTIVO) {
            inicial = "E";
        } else {
            inicial = "C";
        }

        Random random = new Random();
        int numeroRandom = random.nextInt(100);

        return String.format("%s-%s%d%d%02d", inicial, nom, anio, mes, numeroRandom);
    }

    public String generarCurp() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String vocales = "AEIOU";
        String numeros = "0123456789";
        Random random = new Random();

        return String.valueOf(letras.charAt(random.nextInt(letras.length()))) +
                vocales.charAt(random.nextInt(vocales.length())) +

                // Primera letra del segundo apellido
                letras.charAt(random.nextInt(letras.length())) +

                // Primera letra del primer nombre
                letras.charAt(random.nextInt(letras.length())) +

                // Fecha de nacimiento (Año-Mes-Día)
                String.format("%02d", random.nextInt(100)) + // Últimos 2 dígitos del año
                String.format("%02d", 1 + random.nextInt(12)) + // Mes
                String.format("%02d", 1 + random.nextInt(28)) + // Día

                // Sexo (H/M)
                (random.nextBoolean() ? "H" : "M") +

                // Entidad federativa (2 letras)
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

                // Primeras consonantes internas de los apellidos y nombre
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

                // Homoclave (2 letras y 1 número)
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +
                numeros.charAt(random.nextInt(numeros.length()));
    }

    public String generarRfc() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();

        StringBuilder rfc = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            rfc.append(letras.charAt(random.nextInt(letras.length())));
        }

        rfc.append(String.format("%02d", random.nextInt(100))); // Últimos 2 dígitos del año
        rfc.append(String.format("%02d", 1 + random.nextInt(12))); // Mes
        rfc.append(String.format("%02d", 1 + random.nextInt(28))); // Día

        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                rfc.append(letras.charAt(random.nextInt(letras.length())));
            } else {
                rfc.append(numeros.charAt(random.nextInt(numeros.length())));
            }
        }

        return rfc.toString();
    }   
}
