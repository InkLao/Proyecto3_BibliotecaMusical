package dtos;

import colecciones.Albumes;
import colecciones.Integrantes;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa a un artista musical en la aplicación.
 * Contiene información como el nombre del artista, género musical, imagen asociada,
 * lista de integrantes y álbumes relacionados.
 */
public class ArtistaDTO {

    private ObjectId id; // Identificador único del artista
    private String idDos; // Identificador adicional del artista
    private String nombreArtista; // Nombre del artista o banda
    private String imagen; // Ruta o URL de la imagen asociada al artista
    private String genero; // Género musical del artista
    private List<Integrantes> integrantes; // Lista de integrantes de la banda
    private List<Albumes> albumes; // Lista de álbumes del artista

    /**
     * Constructor por defecto.
     */
    public ArtistaDTO() {}

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param id Identificador único del artista.
     * @param idDos Identificador adicional del artista.
     * @param nombreArtista Nombre del artista o banda.
     * @param imagen Ruta o URL de la imagen asociada.
     * @param genero Género musical del artista.
     * @param integrantes Lista de integrantes del artista.
     * @param albumes Lista de álbumes del artista.
     */
    public ArtistaDTO(ObjectId id, String idDos, String nombreArtista, String imagen, String genero, List<Integrantes> integrantes, List<Albumes> albumes) {
        this.id = id;
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.integrantes = integrantes;
        this.albumes = albumes;
    }

    /**
     * Constructor sin identificador único.
     *
     * @param idDos Identificador adicional del artista.
     * @param nombreArtista Nombre del artista o banda.
     * @param imagen Ruta o URL de la imagen asociada.
     * @param genero Género musical del artista.
     * @param integrantes Lista de integrantes del artista.
     * @param albumes Lista de álbumes del artista.
     */
    public ArtistaDTO(String idDos, String nombreArtista, String imagen, String genero, List<Integrantes> integrantes, List<Albumes> albumes) {
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.integrantes = integrantes;
        this.albumes = albumes;
    }

    // Métodos Getter y Setter con documentación.

    /**
     * Obtiene el identificador único del artista.
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del artista.
     * @param id Nuevo identificador del artista.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador adicional del artista.
     * @return idDos
     */
    public String getIdDos() {
        return idDos;
    }

    /**
     * Establece el identificador adicional del artista.
     * @param idDos Nuevo identificador adicional.
     */
    public void setIdDos(String idDos) {
        this.idDos = idDos;
    }

    /**
     * Obtiene el nombre del artista.
     * @return nombreArtista
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Establece el nombre del artista.
     * @param nombreArtista Nuevo nombre del artista.
     */
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    /**
     * Obtiene la imagen asociada al artista.
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen asociada al artista.
     * @param imagen Nueva ruta o URL de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el género musical del artista.
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género musical del artista.
     * @param genero Nuevo género musical.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la lista de integrantes del artista.
     * @return integrantes
     */
    public List<Integrantes> getIntegrantes() {
        return integrantes;
    }

    /**
     * Establece la lista de integrantes del artista.
     * @param integrantes Nueva lista de integrantes.
     */
    public void setIntegrantes(List<Integrantes> integrantes) {
        this.integrantes = integrantes;
    }

    /**
     * Obtiene la lista de álbumes del artista.
     * @return albumes
     */
    public List<Albumes> getAlbumes() {
        return albumes;
    }

    /**
     * Establece la lista de álbumes del artista.
     * @param albumes Nueva lista de álbumes.
     */
    public void setAlbumes(List<Albumes> albumes) {
        this.albumes = albumes;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información del artista en formato de texto.
     */
    @Override
    public String toString() {
        return "ArtistaDTO{" +
                "id=" + id +
                ", idDos='" + idDos + '\'' +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", imagen='" + imagen + '\'' +
                ", genero='" + genero + '\'' +
                ", integrantes=" + integrantes +
                ", albumes=" + albumes +
                '}';
    }
}
