package dtos;

/**
 * Representa una canción en el sistema, incluyendo información básica
 * como su identificador, nombre y duración.
 */
public class CancionDTO {

    private String idCancion; // Identificador único de la canción.
    private String nombreCancion; // Nombre de la canción.
    private String duracion; // Duración de la canción en formato de texto (e.g., "3:45").

    /**
     * Constructor por defecto.
     */
    public CancionDTO() {}

    /**
     * Constructor con parámetros.
     * @param idCancion Identificador único de la canción.
     * @param nombreCancion Nombre de la canción.
     * @param duracion Duración de la canción.
     */
    public CancionDTO(String idCancion, String nombreCancion, String duracion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    // Métodos Getter y Setter.

    /**
     * Obtiene el identificador único de la canción.
     * @return idCancion
     */
    public String getIdCancion() {
        return idCancion;
    }

    /**
     * Establece el identificador único de la canción.
     * @param idCancion Nuevo identificador de la canción.
     */
    public void setIdCancion(String idCancion) {
        this.idCancion = idCancion;
    }

    /**
     * Obtiene el nombre de la canción.
     * @return nombreCancion
     */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /**
     * Establece el nombre de la canción.
     * @param nombreCancion Nuevo nombre de la canción.
     */
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    /**
     * Obtiene la duración de la canción.
     * @return duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la canción.
     * @param duracion Nueva duración de la canción.
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información de la canción en formato de texto.
     */
    @Override
    public String toString() {
        return "CancionDTO{" +
                "idCancion='" + idCancion + '\'' +
                ", nombreCancion='" + nombreCancion + '\'' +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
