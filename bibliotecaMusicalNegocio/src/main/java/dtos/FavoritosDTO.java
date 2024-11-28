package dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class FavoritosDTO {
    
    private ObjectId id;
    private ObjectId idUsuario;
    private List<FavoritoDTO> favorito;

    public FavoritosDTO() {
    }

    public FavoritosDTO(ObjectId id, ObjectId idUsuario, List<FavoritoDTO> favorito) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<FavoritoDTO> getFavorito() {
        return favorito;
    }

    public void setFavorito(List<FavoritoDTO> favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "FavoritosDTO{" + "id=" + id + ", idUsuario=" + idUsuario + ", favorito=" + favorito + '}';
    }
}
