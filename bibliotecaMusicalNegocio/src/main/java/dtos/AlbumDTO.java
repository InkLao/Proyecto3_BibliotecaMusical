package dtos;

import java.util.Date;
import java.util.List;

/**
 * Representa un álbum musical en la aplicación.
 * Contiene información como nombre, género, fecha de lanzamiento e imagen asociada.
 * Además, incluye una lista de canciones asociadas al álbum.
 */
public class AlbumDTO {

    private String idAlbum; // Identificador único del álbum
    private String nombre; // Nombre del álbum
    private Date fechaLanzamiento; // Fecha de lanzamiento del álbum
    private String genero; // Género del álbum
    private String imagen; // Ruta o URL de la imagen asociada al álbum
    private List<CancionDTO> canciones; // Lista de canciones del álbum

    /**
     * Constructor por defecto.
     */
    public AlbumDTO() {}

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param idAlbum Identificador único del álbum.
     * @param nombre Nombre del álbum.
     * @param fechaLanzamiento Fecha de lanzamiento del álbum.
     * @param genero Género del álbum.
     * @param imagen Ruta o URL de la imagen asociada.
     * @param canciones Lista de canciones del álbum.
     */
    public AlbumDTO(String idAlbum, String nombre, Date fechaLanzamiento, String genero, String imagen, List<CancionDTO> canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    /**
     * Constructor sin identificador del álbum.
     *
     * @param nombre Nombre del álbum.
     * @param fechaLanzamiento Fecha de lanzamiento del álbum.
     * @param genero Género del álbum.
     * @param imagen Ruta o URL de la imagen asociada.
     * @param canciones Lista de canciones del álbum.
     */
    public AlbumDTO(String nombre, Date fechaLanzamiento, String genero, String imagen, List<CancionDTO> canciones) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    // Métodos Getter y Setter con documentación.

    /**
     * Obtiene el identificador único del álbum.
     * @return idAlbum
     */
    public String getIdAlbum() {
        return idAlbum;
    }

    /**
     * Establece el identificador único del álbum.
     * @param idAlbum Nuevo identificador del álbum.
     */
    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    /**
     * Obtiene el nombre del álbum.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del álbum.
     * @param nombre Nuevo nombre del álbum.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de lanzamiento del álbum.
     * @return fechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento del álbum.
     * @param fechaLanzamiento Nueva fecha de lanzamiento.
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Obtiene el género del álbum.
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del álbum.
     * @param genero Nuevo género del álbum.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la imagen asociada al álbum.
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen asociada al álbum.
     * @param imagen Nueva ruta o URL de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la lista de canciones del álbum.
     * @return canciones
     */
    public List<CancionDTO> getCanciones() {
        return canciones;
    }

    /**
     * Establece la lista de canciones del álbum.
     * @param canciones Nueva lista de canciones.
     */
    public void setCanciones(List<CancionDTO> canciones) {
        this.canciones = canciones;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información del álbum en formato de texto.
     */
    @Override
    public String toString() {
        return "AlbumDTO{" +
                "idAlbum='" + idAlbum + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", genero='" + genero + '\'' +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }
}
