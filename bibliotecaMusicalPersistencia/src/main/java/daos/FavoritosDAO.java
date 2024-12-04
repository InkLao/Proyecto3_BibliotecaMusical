package daos;

import colecciones.Favorito;
import colecciones.Favoritos;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Clase de acceso a datos para gestionar favoritos en la base de datos.
 * 
 * @author eduar
 */
public class FavoritosDAO implements IFavoritosDAO {

    /** Instancia de la base de datos MongoDB. */
    MongoDatabase baseDeDatos;

    /** Colección de documentos para la entidad Favoritos. */
    MongoCollection<Favoritos> collectionFavoritos;

    /**
     * Constructor que inicializa la conexión a la base de datos y la colección Favoritos.
     */
    public FavoritosDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionFavoritos = baseDeDatos.getCollection("favoritos", Favoritos.class);
    }

    /**
     * Agrega un conjunto de favoritos a la colección.
     * 
     * @param favoritos Objeto Favoritos que contiene la lista de favoritos a agregar.
     * @return El objeto Favoritos que fue agregado.
     */
    @Override
    public Favoritos agregarFavoritos(Favoritos favoritos) {
        
        
        collectionFavoritos.insertOne(favoritos);
        return favoritos;
    }

    /**
     * Actualiza la lista de favoritos para un usuario. Si el usuario no tiene favoritos, se crea uno nuevo.
     * 
     * @param favoritos Objeto Favoritos que contiene la lista a actualizar.
     * @return El objeto Favoritos actualizado o null si ocurre un error.
     */
    @Override

    public Favoritos actualizarFavoritos(Favoritos favoritos) {
            try {

                Document query = new Document("idUsuario", favoritos.getIdUsuario());
                Document update = new Document("$push", new Document("favorito", 
                        new Document("idFavorito", favoritos.getFavorito().get(0).getIdFavorito())
                                .append("fechaAgregacion", favoritos.getFavorito().get(0).getFechaAgregacion())));

                collectionFavoritos.updateOne(query, update);
                return favoritos;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        

        return null;
    }

    /**
     * Obtiene la lista de favoritos para un usuario específico.
     * 
     * @param idUsuario Identificador del usuario.
     * @return Lista de favoritos del usuario o una lista vacía si no tiene favoritos.
     */
    @Override
    public List<Favorito> obtenerFavoritosPorUsuario(String idUsuario) {
        Document query = new Document("idUsuario", idUsuario);
        Favoritos favoritos = collectionFavoritos.find(query).first();
        return favoritos != null ? favoritos.getFavorito() : new ArrayList<>();
    }

    /**
     * Elimina un favorito específico de un usuario.
     * 
     * @param idUsuario Identificador del usuario.
     * @param idFavorito Identificador del favorito a eliminar.
     */
    @Override
    public void eliminarFavorito(String idUsuario, String idFavorito) {
        Document query = new Document("idUsuario", idUsuario);
        Document update = new Document("$pull", new Document("favorito", new Document("idFavorito", idFavorito)));
        collectionFavoritos.updateOne(query, update);
    }
}
