package dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class GeneroNoDeseadoDTO {

    private ObjectId id;
    private ObjectId idUsuario;
    private List<String> nombreGenero;

    public GeneroNoDeseadoDTO() {
    }

    public GeneroNoDeseadoDTO(ObjectId id, ObjectId idUsuario, List<String> nombreGenero) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero;
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

    public List<String> getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(List<String> nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return "GeneroNoDeseadoDTO{" + "id=" + id + ", idUsuario=" + idUsuario + ", nombreGenero=" + nombreGenero + '}';
    }
}
