/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Usuario;
import conexionBD.ConexionBD;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
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
        
        System.out.println("antes de editat" + usuario.toString());
        
        Document query = new Document("_id", new ObjectId(usuario.getId().toString()));
        
        // Actualizaciones que deseas hacer
        collectionUsuario.updateOne(
            Filters.eq("_id", new ObjectId(usuario.getId().toString())), // Filtro por _id
            Updates.combine(
                Updates.set("contrasena", usuario.getContrasena()),
                Updates.set("correo", usuario.getCorreo()),
                Updates.set("nombres", usuario.getNombres()),
                Updates.set("apellidoP", usuario.getApellidoP()),
                Updates.set("apellidoM", usuario.getApellidoM()),
                Updates.set("imagen", usuario.getImagen())
            )
        );
        
        
//        
//        Document update = new Document();
//        update.append("$set", new Document("apellidoM", usuario.getApellidoM()));
//        update.append("$set", new Document("apellidoP", usuario.getApellidoP()));
//        update.append("$set", new Document("contrasena", usuario.getContrasena()));
//        update.append("$set", new Document("correo", usuario.getCorreo()));
//        update.append("$set", new Document("imagen", usuario.getImagen()));
//        update.append("$set", new Document("nombres", usuario.getNombres()));
        
        

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
