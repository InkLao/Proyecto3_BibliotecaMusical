package daos;

import colecciones.GeneroNoDeseado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import conexionBD.ConexionBD;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos para gestionar géneros musicales no deseados.
 * 
 * @author eduar
 */
public class GeneroNoDeseadoDAO implements IGeneroNoDeseadoDAO {

    /** Instancia de la base de datos MongoDB. */
    MongoDatabase baseDeDatos;

    /** Colección de documentos para la entidad GeneroNoDeseado. */
    MongoCollection<GeneroNoDeseado> collectionGeneroNoDeseado;

    /**
     * Constructor que inicializa la conexión a la base de datos y la colección GeneroNoDeseado.
     */
    public GeneroNoDeseadoDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionGeneroNoDeseado = baseDeDatos.getCollection("generoNoDeseado", GeneroNoDeseado.class);
    }

    /**
     * Agrega o actualiza géneros no deseados para un usuario específico.
     * 
     * @param genero Objeto GeneroNoDeseado que contiene los géneros no deseados a agregar.
     * @return El objeto GeneroNoDeseado que fue agregado o actualizado.
     */
    @Override
    public GeneroNoDeseado agregarGeneroNoDeseado(GeneroNoDeseado genero) {
        try {
            Document query = new Document("idUsuario", genero.getIdUsuario());
            Document update = new Document("$addToSet", new Document("nombreGenero", 
                    new Document("$each", genero.getNombreGenero())));

            collectionGeneroNoDeseado.updateOne(query, update, new UpdateOptions().upsert(true));
            return genero;
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar género no deseado: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de géneros no deseados de un usuario específico.
     * 
     * @param idUsuario Identificador del usuario.
     * @return Lista de géneros no deseados o null si no se encuentra.
     */
    @Override
    public List<String> obtenerGenerosNoDeseados(ObjectId idUsuario) {
        Document query = new Document("idUsuario", idUsuario);
        GeneroNoDeseado genero = collectionGeneroNoDeseado.find(query).first();
        return genero != null ? genero.getNombreGenero() : null;
    }

    /**
     * Elimina un género no deseado de un usuario específico. Si la lista queda vacía, elimina el documento completo.
     * 
     * @param idUsuario Identificador del usuario.
     * @param genero Género a eliminar.
     */
    @Override
    public void eliminarGenero(ObjectId idUsuario, String genero) {
        try {
            Document query = new Document("idUsuario", idUsuario);
            Document update = new Document("$pull", new Document("nombreGenero", genero));
            collectionGeneroNoDeseado.updateOne(query, update);

            GeneroNoDeseado generoNoDeseado = collectionGeneroNoDeseado.find(query).first();
            if (generoNoDeseado != null && (generoNoDeseado.getNombreGenero() == null || generoNoDeseado.getNombreGenero().isEmpty())) {
                collectionGeneroNoDeseado.deleteOne(query);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar género no deseado: " + e.getMessage());
        }
    }
}
