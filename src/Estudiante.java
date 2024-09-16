import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String idEstudiante;
    private ArrayList<Curso> cursos;

    public Estudiante(String nombre, String idEstudiante) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre del estudiante: " + getNombre() + " | ID: " + getIdEstudiante());
        System.out.println("Cursos inscritos:");
        for (Curso curso : getCursos()) {
            curso.mostrarInfoCurso();
        }
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

}
