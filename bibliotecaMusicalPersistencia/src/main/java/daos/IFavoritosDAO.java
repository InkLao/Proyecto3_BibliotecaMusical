package daos;

import colecciones.Favorito;
import colecciones.Favoritos;
import java.util.List;

/**
 * Interfaz para definir las operaciones de acceso a datos relacionadas con Favoritos.
 * 
 * @author Edu
 */
public interface IFavoritosDAO {

    /** Agrega un nuevo conjunto de favoritos para un usuario. */
    Favoritos agregarFavoritos(Favoritos favoritos);

    /** Obtiene los favoritos de un usuario por su identificador. */
    List<Favorito> obtenerFavoritosPorUsuario(String idUsuario);

    /** Elimina un favorito específico de un usuario. */
    void eliminarFavorito(String idUsuario, String idFavorito);

    /** Actualiza la lista de favoritos para un usuario. */
    Favoritos actualizarFavoritos(Favoritos favoritos);
}
