/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Favorito;
import colecciones.Favoritos;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class FavoritosDAO implements IFavoritosDAO{
    MongoDatabase baseDeDatos;
    MongoCollection<Favoritos> collectionFavoritos;

    public FavoritosDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionFavoritos = baseDeDatos.getCollection("favoritos", Favoritos.class);
    }

    @Override
    public Favoritos agregarFavoritos(Favoritos favoritos) {
        collectionFavoritos.insertOne(favoritos);
        return favoritos;
    }
    
    @Override
    public Favoritos actualizarFavoritos(Favoritos favoritos){
        
        try{
        
        Document query = new Document("idUsuario", favoritos.getIdUsuario());

        
        Document update = new Document("$push", new Document("favorito", new Document("idFavorito", favoritos.getFavorito().get(0).getIdFavorito()).append
                                                            ("fechaAgregacion", favoritos.getFavorito().get(0).getFechaAgregacion())));
        
        collectionFavoritos.updateOne(query, update);
        
        return favoritos;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Favorito> obtenerFavoritosPorUsuario(String idUsuario) {
        Document query = new Document("idUsuario", idUsuario);
        Favoritos favoritos = collectionFavoritos.find(query).first();
        return favoritos != null ? favoritos.getFavorito() : new ArrayList<>();
    }

    @Override
    public void eliminarFavorito(String idUsuario, String idFavorito) {
        Document query = new Document("idUsuario", idUsuario);
        Document update = new Document("$pull", new Document("favorito", new Document("idFavorito", idFavorito)));
        collectionFavoritos.updateOne(query, update);
    }
    
}
