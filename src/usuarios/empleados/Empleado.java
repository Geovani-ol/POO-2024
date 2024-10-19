package usuarios.empleados;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Empleado extends Usuario {
    public String rfc;

    public Empleado(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String direccion, String contrasenia, String rfc) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, direccion, contrasenia, Rol.EMPLEADO);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public String mostrarDatos(){
        return String.format("Id: %s  |  Nombre: %s  |  Apellidos: %s  |  Fecha de Nacimiento: %s  |  Telefono: %s  |  Dirección: %s  |  RFC: %s",
                getId(),
                getNombre(),
                getApellidos(),
                getFechaNacimiento(),
                getTelefono(),
                getDireccion(),
                getRfc());
    }

    /*public void registrarEntrada() {
        RegistroEmpleados nuevoRegistro = new RegistroEmpleados();
        registros.add(nuevoRegistro);
        System.out.println(nombre + " ha registrado la entrada.");
    }

    public void registrarSalida() {
        if (!registros.isEmpty() && registros.get(registros.size() - 1).getSalida() == null) {
            registros.get(registros.size() - 1).registrarSalida();
            System.out.println(nombre + " ha registrado la salida.");
        }
        else {
            System.out.println("No se encontró una entrada sin salida.");
        }
    }

    public void mostrarRegistros() {
        System.out.println("Registros de " + nombre + ":");
        for (RegistroEmpleados registro : registros) {
            System.out.println(registro);
        }
    }*/
}
