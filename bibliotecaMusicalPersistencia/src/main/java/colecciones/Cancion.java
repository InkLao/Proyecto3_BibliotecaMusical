package colecciones;

/**
 * Clase que representa una canción con detalles básicos como nombre y duración.
 * Es utilizada para modelar canciones incluidas en un álbum.
 * 
 * @author eduar
 */
public class Cancion {

    /** Identificador único de la canción. */
    private String id;

    /** Nombre de la canción. */
    private String nombreCancion;

    /** Duración de la canción en formato "mm:ss". */
    private String duracion;

    /**
     * Constructor por defecto.
     */
    public Cancion() {
    }

    /**
     * Constructor para inicializar los atributos de una canción.
     *
     * @param id Identificador único de la canción.
     * @param nombreCancion Nombre de la canción.
     * @param duracion Duración de la canción en formato "mm:ss".
     */
    public Cancion(String id, String nombreCancion, String duracion) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    /**
     * Obtiene el identificador único de la canción.
     * 
     * @return ID de la canción.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la canción.
     * 
     * @param id ID de la canción.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la canción.
     * 
     * @return Nombre de la canción.
     */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /**
     * Establece el nombre de la canción.
     * 
     * @param nombreCancion Nombre de la canción.
     */
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    /**
     * Obtiene la duración de la canción en formato "mm:ss".
     * 
     * @return Duración de la canción.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la canción en formato "mm:ss".
     * 
     * @param duracion Duración de la canción.
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + '}';
    }
}
