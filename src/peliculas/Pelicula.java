package peliculas;

public class Pelicula {
    public String id;
    public String titulo;
    public String genero;
    public String duracion;
    public String clasificacion;
    public String sinopsis;

    public Pelicula(String id, String titulo, String genero, String duracion, String clasificacion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String mostrarInformacion() {
        return String.format("Id: %s  |  Titulo: %s  |  Genero: %s  |  Duracion: %s  |  Clasificacion: %s  |  Sinopsis: %s",
                getId(),
                getTitulo(),
                getGenero(),
                getDuracion(),
                getClasificacion(),
                getSinopsis());
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n%s", getTitulo(), getDuracion(), getGenero(), getClasificacion());
    }

}
