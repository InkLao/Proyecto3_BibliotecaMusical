/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Artista;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Arturo ITSON
 */
public class ArtistaDAO implements IArtistaDAO{
    
    
    MongoDatabase baseDeDatos;
    MongoCollection<Artista> collectionArtista;
    
    
    public ArtistaDAO(){
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionArtista = baseDeDatos.getCollection("artistas", Artista.class);
    }

    
    
    @Override
    public List<Artista> obtenerTodos() {

        List<Artista> artistas;
        
        
        artistas = collectionArtista.find().into(new ArrayList<>());
                
        return artistas;
    }
    
    
    @Override
    public Artista buscarArtista(Object id) {

        Document query = new Document("_id", id);
        
        Artista artista = collectionArtista.find(query).first();
        
        return artista;
        
    }
    
}
