package dtos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa los géneros musicales no deseados por un usuario.
 * Contiene información sobre el usuario y la lista de géneros.
 */
public class GeneroNoDeseadoDTO {

    private ObjectId id; // Identificador único del registro.
    private ObjectId idUsuario; // Identificador del usuario asociado.
    private List<String> nombreGenero; // Lista de géneros no deseados.

    /**
     * Constructor por defecto.
     */
    public GeneroNoDeseadoDTO() {}

    /**
     * Constructor con parámetros.
     * @param id Identificador único del registro.
     * @param idUsuario Identificador del usuario.
     * @param nombreGenero Lista de géneros no deseados.
     */
    public GeneroNoDeseadoDTO(ObjectId id, ObjectId idUsuario, List<String> nombreGenero) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero;
    }

    // Métodos Getter y Setter.

    /**
     * Obtiene el identificador único del registro.
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del registro.
     * @param id Nuevo identificador del registro.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del usuario asociado.
     * @return idUsuario
     */
    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario asociado.
     * @param idUsuario Nuevo identificador del usuario.
     */
    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la lista de géneros no deseados.
     * @return nombreGenero
     */
    public List<String> getNombreGenero() {
        return nombreGenero;
    }

    /**
     * Establece la lista de géneros no deseados.
     * @param nombreGenero Nueva lista de géneros no deseados.
     */
    public void setNombreGenero(List<String> nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información de los géneros no deseados en formato de texto.
     */
    @Override
    public String toString() {
        return "GeneroNoDeseadoDTO{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombreGenero=" + nombreGenero +
                '}';
    }
}
