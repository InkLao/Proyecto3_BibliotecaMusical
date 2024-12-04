package colecciones;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa un álbum musical con detalles como nombre, fecha de lanzamiento, género, imagen y canciones.
 * Contiene la relación con canciones incluidas en el álbum.
 * 
 * @author eduar
 */
public class Album {

    /** Identificador único del álbum. */
    private String idAlbum;

    /** Nombre del álbum. */
    private String nombre;

    /** Fecha de lanzamiento del álbum. */
    private Date fechaLanzamiento;

    /** Género musical del álbum. */
    private String genero;

    /** Ruta de la imagen representativa del álbum. */
    private String imagen;

    /** Lista de canciones incluidas en el álbum. */
    private List<Cancion> canciones;

    /**
     * Constructor por defecto.
     */
    public Album() {
    }

    /**
     * Constructor para inicializar todos los atributos de un álbum.
     *
     * @param idAlbum Identificador único del álbum.
     * @param nombre Nombre del álbum.
     * @param fechaLanzamiento Fecha de lanzamiento del álbum.
     * @param genero Género musical del álbum.
     * @param imagen Ruta de la imagen representativa del álbum.
     * @param canciones Lista de canciones incluidas en el álbum.
     */
    public Album(String idAlbum, String nombre, Date fechaLanzamiento, String genero, String imagen, List<Cancion> canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    /**
     * Obtiene el identificador único del álbum.
     * 
     * @return ID del álbum.
     */
    public String getIdAlbum() {
        return idAlbum;
    }

    /**
     * Establece el identificador único del álbum.
     * 
     * @param idAlbum ID del álbum.
     */
    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    /**
     * Obtiene el nombre del álbum.
     * 
     * @return Nombre del álbum.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del álbum.
     * 
     * @param nombre Nombre del álbum.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de lanzamiento del álbum.
     * 
     * @return Fecha de lanzamiento.
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento del álbum.
     * 
     * @param fechaLanzamiento Fecha de lanzamiento.
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Obtiene el género musical del álbum.
     * 
     * @return Género del álbum.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género musical del álbum.
     * 
     * @param genero Género del álbum.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la ruta de la imagen representativa del álbum.
     * 
     * @return Ruta de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen representativa del álbum.
     * 
     * @param imagen Ruta de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la lista de canciones incluidas en el álbum.
     * 
     * @return Lista de canciones.
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Establece la lista de canciones incluidas en el álbum.
     * 
     * @param canciones Lista de canciones.
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" + "idAlbum=" + idAlbum + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento +
               ", genero=" + genero + ", imagen=" + imagen + ", canciones=" + canciones + '}';
    }
}
