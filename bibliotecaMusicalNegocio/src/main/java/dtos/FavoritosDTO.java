package dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa una colección de favoritos asociados a un usuario.
 * Contiene información sobre el usuario y sus elementos favoritos.
 */
public class FavoritosDTO {

    private ObjectId id; // Identificador único de la colección de favoritos.
    private String idUsuario; // Identificador del usuario propietario de los favoritos.
    private List<FavoritoDTO> favorito; // Lista de elementos favoritos.

    /**
     * Constructor por defecto.
     */
    public FavoritosDTO() {}

    /**
     * Constructor con parámetros.
     * @param id Identificador único de la colección de favoritos.
     * @param idUsuario Identificador del usuario.
     * @param favorito Lista de elementos favoritos.
     */
    public FavoritosDTO(ObjectId id, String idUsuario, List<FavoritoDTO> favorito) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    // Métodos Getter y Setter.

    /**
     * Obtiene el identificador único de la colección de favoritos.
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la colección de favoritos.
     * @param id Nuevo identificador de la colección.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del usuario propietario de los favoritos.
     * @return idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario propietario de los favoritos.
     * @param idUsuario Nuevo identificador del usuario.
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la lista de elementos favoritos.
     * @return favorito
     */
    public List<FavoritoDTO> getFavorito() {
        return favorito;
    }

    /**
     * Establece la lista de elementos favoritos.
     * @param favorito Nueva lista de favoritos.
     */
    public void setFavorito(List<FavoritoDTO> favorito) {
        this.favorito = favorito;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información de la colección de favoritos en formato de texto.
     */
    @Override
    public String toString() {
        return "FavoritosDTO{" +
                "id=" + id +
                ", idUsuario='" + idUsuario + '\'' +
                ", favorito=" + favorito +
                '}';
    }
}
