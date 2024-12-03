package daos;

import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Canciones;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz para definir las operaciones de acceso a datos relacionadas con Artista.
 * 
 * @author Arturo
 */
public interface IArtistaDAO {

    /** Obtiene todos los artistas almacenados. */
    List<Artista> obtenerTodos();

    /** Busca un artista por su identificador. */
    Artista buscarArtista(Object id);

    /** Obtiene la imagen asociada a una canción por su identificador. */
    String obtenerImagenPorIdCancion(String id);

    /** Obtiene todas las canciones de todos los artistas. */
    List<Canciones> obtenerTodasCancionesEnArtista();

    /** Obtiene todos los álbumes de todos los artistas. */
    List<Albumes> obtenerTodosAlbumesEnArtista();

    /** Agrega un nuevo artista a la base de datos. */
    Artista agregarArtista(Artista artista);

    /** Obtiene todas las canciones de un artista específico. */
    List<Canciones> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id);

    /** Obtiene todos los álbumes de un artista específico. */
    List<Albumes> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id);

    /** Busca un álbum por su identificador. */
    Albumes buscarAlbumPorId(String id);

    /** Busca una canción por su identificador. */
    Canciones buscarCancionPorId(String id);

    /** Busca el artista asociado a un álbum por el identificador del álbum. */
    Artista buscarArtistaPorIdAlbum(String id);

    /** Busca el artista asociado a una canción por el identificador de la canción. */
    Artista buscarArtistaPorIdCancion(String id);

    /** Obtiene todos los artistas excluyendo géneros no deseados. */
    List<Artista> obtenerTodosArtistaSinGeneroNoDeseado(List<String> excluir);

    /** Obtiene todos los álbumes filtrados por géneros no deseados. */
    List<Albumes> obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(List<String> excluir);

    /** Inserta artistas predefinidos para pruebas o inicialización. */
    boolean InsercionArtistasArturo();
}
