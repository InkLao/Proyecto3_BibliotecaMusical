package colecciones;

/**
 * Representa una canción musical dentro de un álbum.
 * 
 * @author Arturo
 */
public class Canciones {

    /** Identificador único de la canción. */
    private String idCancion;

    /** Nombre de la canción. */
    private String nombreCancion;

    /** Duración de la canción en formato mm:ss. */
    private String duracion;

    /**
     * Constructor vacío para crear una canción sin inicializar sus atributos.
     */
    public Canciones() {
    }

    /**
     * Constructor para inicializar todos los atributos de una canción.
     * 
     * @param idCancion Identificador único de la canción.
     * @param nombreCancion Nombre de la canción.
     * @param duracion Duración de la canción.
     */
    public Canciones(String idCancion, String nombreCancion, String duracion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    // Getters and Setters
    /** Obtiene el identificador único de la canción. */
    public String getIdCancion() {
        return idCancion;
    }

    /** Establece el identificador único de la canción. */
    public void setIdCancion(String idCancion) {
        this.idCancion = idCancion;
    }

    /** Obtiene el nombre de la canción. */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /** Establece el nombre de la canción. */
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    /** Obtiene la duración de la canción. */
    public String getDuracion() {
        return duracion;
    }

    /** Establece la duración de la canción. */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Canciones{" +
                "idCancion='" + idCancion + '\'' +
                ", nombreCancion='" + nombreCancion + '\'' +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
