package colecciones;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa géneros musicales no deseados asociados a un usuario.
 * 
 * @author eduar
 */
public class GeneroNoDeseado {

    /** Identificador único del documento en MongoDB. */
    private ObjectId id;

    /** Identificador único del usuario al que pertenece el género no deseado. */
    private ObjectId idUsuario;

    /** Lista de nombres de géneros no deseados. */
    private List<String> nombreGenero;

    /**
     * Constructor por defecto.
     */
    public GeneroNoDeseado() {
        this.nombreGenero = new ArrayList<>();
    }

    /**
     * Constructor que inicializa el usuario y la lista de géneros no deseados.
     * 
     * @param idUsuario Identificador único del usuario.
     * @param nombreGenero Lista de géneros no deseados.
     */
    public GeneroNoDeseado(ObjectId idUsuario, List<String> nombreGenero) {
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero != null ? nombreGenero : new ArrayList<>();
    }

    /**
     * Constructor que inicializa todos los atributos del género no deseado.
     * 
     * @param id Identificador único del documento.
     * @param idUsuario Identificador único del usuario.
     * @param nombreGenero Lista de géneros no deseados.
     */
    public GeneroNoDeseado(ObjectId id, ObjectId idUsuario, List<String> nombreGenero) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero;
    }

    /**
     * Obtiene el identificador único del documento.
     * 
     * @return ID del documento.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del documento.
     * 
     * @param id ID del documento.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador único del usuario.
     * 
     * @return ID del usuario.
     */
    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     * 
     * @param idUsuario ID del usuario.
     */
    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la lista de nombres de géneros no deseados.
     * 
     * @return Lista de géneros no deseados.
     */
    public List<String> getNombreGenero() {
        return nombreGenero;
    }

    /**
     * Establece la lista de nombres de géneros no deseados.
     * 
     * @param nombreGenero Lista de géneros no deseados.
     */
    public void setNombreGenero(List<String> nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return "GeneroNoDeseado{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombreGenero=" + nombreGenero +
                '}';
    }
}
