/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Usuario;
import conexionBD.ConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author Arturo ITSON
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    
    MongoDatabase baseDeDatos;
    MongoCollection<Usuario> collectionUsuario;
    
    
    public UsuarioDAO(){
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionUsuario = baseDeDatos.getCollection("usuarios", Usuario.class);
    }

    
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        
       
            collectionUsuario.insertOne(usuario);  
            
            return usuario;
    
    }
    

    @Override
    public Usuario editarUsuario(Usuario usuario) {

        Document query = new Document("_id", usuario.getId());
        
        Document update = new Document("Nombres", usuario.getNombres()).append
                                      ("ApellidoPaterno", usuario.getApellidoP()).append
                                      ("ApellidoMaterno", usuario.getApellidoM()).append
                                      ("Correo", usuario.getCorreo()).append
                                      ("Contrasena", usuario.getImagen()).append
                                      ("Imagen", usuario.getImagen());
        
            collectionUsuario.updateOne(query, update);
            
            return usuario;
        
    }
    

    @Override
    public Usuario buscarUsuario(Object id) {

        Document query = new Document("_id", id);
        
        Usuario usuario = collectionUsuario.find(query).first();
        
        return usuario;
        
    }
    
    
    @Override
    public Usuario buscarUsuarioIniciarSesion(String correo, String contra){
    
        Document query = new Document("correo", correo).append("contrasena", contra);
        
        Usuario usuario = collectionUsuario.find(query).first();
        
        return usuario;
        
    }
    
}
