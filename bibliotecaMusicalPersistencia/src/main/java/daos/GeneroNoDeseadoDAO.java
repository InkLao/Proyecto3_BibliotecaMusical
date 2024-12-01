/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author eduar
 */
public class GeneroNoDeseadoDAO implements IGeneroNoDeseadoDAO {

    MongoDatabase baseDeDatos;
    MongoCollection<GeneroNoDeseado> collectionGeneroNoDeseado;

    public GeneroNoDeseadoDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionGeneroNoDeseado = baseDeDatos.getCollection("generoNoDeseado", GeneroNoDeseado.class);
    }

    @Override
    public GeneroNoDeseado agregarGeneroNoDeseado(GeneroNoDeseado genero) {
        try {
            Document query = new Document("idUsuario", genero.getIdUsuario());
            Document update = new Document("$addToSet", new Document("nombreGenero", new Document("$each", genero.getNombreGenero())));

            collectionGeneroNoDeseado.updateOne(query, update, new UpdateOptions().upsert(true)); // Crea el documento si no existe
            return genero;
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar género no deseado: " + e.getMessage());
        }
    }

    @Override
    public List<String> obtenerGenerosNoDeseados(ObjectId idUsuario) {
        Document query = new Document("idUsuario", idUsuario);
        GeneroNoDeseado genero = collectionGeneroNoDeseado.find(query).first();
        return genero != null ? genero.getNombreGenero() : null;
    }

    @Override
public void eliminarGenero(ObjectId idUsuario, String genero) {
    try {
        // Eliminar el género del array
        Document query = new Document("idUsuario", idUsuario);
        Document update = new Document("$pull", new Document("nombreGenero", genero));
        collectionGeneroNoDeseado.updateOne(query, update);

        // Verificar si el array quedó vacío
        GeneroNoDeseado generoNoDeseado = collectionGeneroNoDeseado.find(query).first();
        if (generoNoDeseado != null && (generoNoDeseado.getNombreGenero() == null || generoNoDeseado.getNombreGenero().isEmpty())) {
            collectionGeneroNoDeseado.deleteOne(query); // Eliminar el documento si el array está vacío
        }
    } catch (Exception e) {
        throw new RuntimeException("Error al eliminar género no deseado: " + e.getMessage());
    }
}

}
