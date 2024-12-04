package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa la colección de favoritos de un usuario.
 * Contiene una lista de elementos marcados como favoritos por un usuario.
 * 
 * @author Edu
 */
public class Favoritos {

    /** Identificador único del documento en la base de datos. */
    private ObjectId id;

    /** Identificador del usuario propietario de los favoritos. */
    private String idUsuario;

    /** Lista de favoritos asociados al usuario. */
    private List<Favorito> favorito;

    /**
     * Constructor por defecto.
     */
    public Favoritos() {
    }

    /**
     * Constructor para inicializar todos los campos.
     *
     * @param id Identificador único.
     * @param idUsuario Identificador del usuario.
     * @param favorito Lista de favoritos.
     */
    public Favoritos(ObjectId id, String idUsuario, List<Favorito> favorito) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    /**
     * Constructor para inicializar sin identificador único.
     *
     * @param idUsuario Identificador del usuario.
     * @param favorito Lista de favoritos.
     */
    public Favoritos(String idUsuario, List<Favorito> favorito) {
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    /** @return El identificador único. */
    public ObjectId getId() {
        return id;
    }

    /** @param id El identificador único a asignar. */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /** @return El identificador del usuario propietario. */
    public String getIdUsuario() {
        return idUsuario;
    }

    /** @param idUsuario El identificador del usuario a asignar. */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /** @return La lista de favoritos. */
    public List<Favorito> getFavorito() {
        return favorito;
    }

    /** @param favorito La lista de favoritos a asignar. */
    public void setFavorito(List<Favorito> favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "Favoritos{" + "id=" + id + ", idUsuario=" + idUsuario + ", favorito=" + favorito + '}';
    }
}
