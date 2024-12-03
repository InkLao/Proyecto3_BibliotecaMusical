package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa un artista musical con información básica como nombre, género, y relaciones con álbumes e integrantes.
 * 
 * @author Arturo ITSON
 */
public class Artista {

    /** Identificador único del artista en MongoDB. */
    private ObjectId id;

    /** Identificador secundario único del artista. */
    private String idDos;

    /** Nombre del artista o banda. */
    private String nombreArtista;

    /** Ruta de la imagen representativa del artista. */
    private String imagen;

    /** Género musical del artista. */
    private String genero;

    /** Lista de integrantes que forman parte del artista o banda. */
    private List<Integrantes> integrantes;

    /** Lista de álbumes publicados por el artista. */
    private List<Albumes> albumes;

    /**
     * Constructor por defecto.
     */
    public Artista() {
    }

    /**
     * Constructor para inicializar todos los atributos del artista.
     *
     * @param id Identificador único del artista en MongoDB.
     * @param idDos Identificador secundario único del artista.
     * @param nombreArtista Nombre del artista o banda.
     * @param imagen Ruta de la imagen representativa del artista.
     * @param genero Género musical del artista.
     * @param integrantes Lista de integrantes que forman parte del artista o banda.
     * @param albumes Lista de álbumes publicados por el artista.
     */
    public Artista(ObjectId id, String idDos, String nombreArtista, String imagen, String genero, List<Integrantes> integrantes, List<Albumes> albumes) {
        this.id = id;
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.integrantes = integrantes;
        this.albumes = albumes;
    }

    /**
     * Constructor sin el identificador único principal.
     * 
     * @param idDos Identificador secundario único del artista.
     * @param nombreArtista Nombre del artista o banda.
     * @param imagen Ruta de la imagen representativa del artista.
     * @param genero Género musical del artista.
     * @param integrantes Lista de integrantes que forman parte del artista o banda.
     * @param albumes Lista de álbumes publicados por el artista.
     */
    public Artista(String idDos, String nombreArtista, String imagen, String genero, List<Integrantes> integrantes, List<Albumes> albumes) {
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.integrantes = integrantes;
        this.albumes = albumes;
    }

    /**
     * Obtiene el identificador único del artista en MongoDB.
     * 
     * @return ID del artista.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del artista en MongoDB.
     * 
     * @param id ID del artista.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador secundario único del artista.
     * 
     * @return Identificador secundario.
     */
    public String getIdDos() {
        return idDos;
    }

    /**
     * Establece el identificador secundario único del artista.
     * 
     * @param idDos Identificador secundario.
     */
    public void setIdDos(String idDos) {
        this.idDos = idDos;
    }

    /**
     * Obtiene el nombre del artista o banda.
     * 
     * @return Nombre del artista.
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Establece el nombre del artista o banda.
     * 
     * @param nombreArtista Nombre del artista.
     */
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    /**
     * Obtiene la ruta de la imagen representativa del artista.
     * 
     * @return Ruta de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen representativa del artista.
     * 
     * @param imagen Ruta de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el género musical del artista.
     * 
     * @return Género del artista.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género musical del artista.
     * 
     * @param genero Género del artista.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la lista de integrantes que forman parte del artista o banda.
     * 
     * @return Lista de integrantes.
     */
    public List<Integrantes> getIntegrantes() {
        return integrantes;
    }

    /**
     * Establece la lista de integrantes que forman parte del artista o banda.
     * 
     * @param integrantes Lista de integrantes.
     */
    public void setIntegrantes(List<Integrantes> integrantes) {
        this.integrantes = integrantes;
    }

    /**
     * Obtiene la lista de álbumes publicados por el artista.
     * 
     * @return Lista de álbumes.
     */
    public List<Albumes> getAlbumes() {
        return albumes;
    }

    /**
     * Establece la lista de álbumes publicados por el artista.
     * 
     * @param albumes Lista de álbumes.
     */
    public void setAlbumes(List<Albumes> albumes) {
        this.albumes = albumes;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", idDos=" + idDos +
                ", nombreArtista=" + nombreArtista +
                ", imagen=" + imagen +
                ", genero=" + genero +
                ", integrantes=" + integrantes +
                ", albumes=" + albumes +
                '}';
    }
}
