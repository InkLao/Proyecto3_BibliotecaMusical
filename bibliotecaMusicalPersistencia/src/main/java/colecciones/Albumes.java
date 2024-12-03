package colecciones;

import java.util.Date;
import java.util.List;

/**
 * Representa un álbum musical que contiene canciones.
 * 
 * @author Arturo
 */
public class Albumes {

    /** Identificador único del álbum. */
    private String idAlbum;

    /** Nombre del álbum. */
    private String nombre;

    /** Fecha de lanzamiento del álbum. */
    private Date fechaLanzamiento;

    /** Género musical del álbum. */
    private String genero;

    /** Ruta de la imagen asociada al álbum. */
    private String imagen;

    /** Lista de canciones que pertenecen al álbum. */
    private List<Canciones> canciones;

    /**
     * Constructor vacío para crear un álbum sin inicializar sus atributos.
     */
    public Albumes() {
    }

    /**
     * Constructor para inicializar todos los atributos de un álbum.
     * 
     * @param idAlbum Identificador único del álbum.
     * @param nombre Nombre del álbum.
     * @param fechaLanzamiento Fecha de lanzamiento del álbum.
     * @param genero Género musical del álbum.
     * @param imagen Ruta de la imagen asociada al álbum.
     * @param canciones Lista de canciones que pertenecen al álbum.
     */
    public Albumes(String idAlbum, String nombre, Date fechaLanzamiento, String genero, String imagen, List<Canciones> canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    /**
     * Constructor para inicializar un álbum sin identificador.
     * 
     * @param nombre Nombre del álbum.
     * @param fechaLanzamiento Fecha de lanzamiento del álbum.
     * @param genero Género musical del álbum.
     * @param imagen Ruta de la imagen asociada al álbum.
     * @param canciones Lista de canciones que pertenecen al álbum.
     */
    public Albumes(String nombre, Date fechaLanzamiento, String genero, String imagen, List<Canciones> canciones) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    // Getters and Setters
    /** Obtiene el identificador único del álbum. */
    public String getIdAlbum() {
        return idAlbum;
    }

    /** Establece el identificador único del álbum. */
    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    /** Obtiene el nombre del álbum. */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre del álbum. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Obtiene la fecha de lanzamiento del álbum. */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /** Establece la fecha de lanzamiento del álbum. */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /** Obtiene el género musical del álbum. */
    public String getGenero() {
        return genero;
    }

    /** Establece el género musical del álbum. */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /** Obtiene la ruta de la imagen asociada al álbum. */
    public String getImagen() {
        return imagen;
    }

    /** Establece la ruta de la imagen asociada al álbum. */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /** Obtiene la lista de canciones del álbum. */
    public List<Canciones> getCanciones() {
        return canciones;
    }

    /** Establece la lista de canciones del álbum. */
    public void setCanciones(List<Canciones> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Albumes{" +
                "idAlbum='" + idAlbum + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", genero='" + genero + '\'' +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }
}
