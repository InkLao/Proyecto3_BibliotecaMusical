/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.GeneroNoDeseado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class GeneroNoDeseadoDAO implements IGeneroNoDeseadoDAO{
    MongoDatabase baseDeDatos;
    MongoCollection<GeneroNoDeseado> collectionGeneroNoDeseado;

    public GeneroNoDeseadoDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionGeneroNoDeseado = baseDeDatos.getCollection("generoNoDeseado", GeneroNoDeseado.class);
    }

    @Override
    public GeneroNoDeseado agregarGeneroNoDeseado(GeneroNoDeseado genero) {
        collectionGeneroNoDeseado.insertOne(genero);
        return genero;
    }

    @Override
    public List<String> obtenerGenerosNoDeseados(ObjectId idUsuario) {
        Document query = new Document("idUsuario", idUsuario);
        GeneroNoDeseado genero = collectionGeneroNoDeseado.find(query).first();
        return genero != null ? genero.getNombreGenero() : null;
    }

    @Override
    public void eliminarGenero(ObjectId idUsuario, String genero) {
        Document query = new Document("idUsuario", idUsuario);
        Document update = new Document("$pull", new Document("nombreGenero", genero));
        collectionGeneroNoDeseado.updateOne(query, update);
    }
}
