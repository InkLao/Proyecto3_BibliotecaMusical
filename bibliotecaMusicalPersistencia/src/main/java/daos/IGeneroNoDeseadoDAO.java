package daos;

import colecciones.GeneroNoDeseado;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Interfaz para definir las operaciones de acceso a datos relacionadas con Géneros no deseados.
 * 
 * @author Edu
 */
public interface IGeneroNoDeseadoDAO {

    /** Agrega un género no deseado para un usuario. */
    GeneroNoDeseado agregarGeneroNoDeseado(GeneroNoDeseado genero);

    /** Obtiene los géneros no deseados de un usuario. */
    List<String> obtenerGenerosNoDeseados(ObjectId idUsuario);

    /** Elimina un género no deseado específico de un usuario. */
    void eliminarGenero(ObjectId idUsuario, String genero);
}
