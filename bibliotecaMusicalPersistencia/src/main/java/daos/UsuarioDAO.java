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
 * Clase que implementa las operaciones de acceso a datos para la colección "usuarios".
 * 
 * @author Arturo
 */
public class UsuarioDAO implements IUsuarioDAO {

    /** Base de datos de MongoDB. */
    MongoDatabase baseDeDatos;

    /** Colección de usuarios en la base de datos. */
    MongoCollection<Usuario> collectionUsuario;

    /**
     * Constructor que inicializa la conexión con la base de datos y la colección "usuarios".
     */
    public UsuarioDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionUsuario = baseDeDatos.getCollection("usuarios", Usuario.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        try {
            System.out.println("Guardando usuario: " + usuario);
            collectionUsuario.insertOne(usuario);
            return usuario;
        } catch (Exception e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
            throw new RuntimeException("Error al guardar usuario.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario editarUsuario(Usuario usuario) {
        Document query = new Document("_id", new ObjectId(usuario.getId().toString()));

        collectionUsuario.updateOne(
                Filters.eq("_id", new ObjectId(usuario.getId().toString())),
                Updates.combine(
                        Updates.set("contrasena", usuario.getContrasena()),
                        Updates.set("correo", usuario.getCorreo()),
                        Updates.set("nombres", usuario.getNombres()),
                        Updates.set("apellidoP", usuario.getApellidoP()),
                        Updates.set("apellidoM", usuario.getApellidoM()),
                        Updates.set("imagen", usuario.getImagen())
                )
        );
        return usuario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario buscarUsuario(Object id) {
        try {
            ObjectId objectId = new ObjectId(id.toString());
            return collectionUsuario.find(Filters.eq("_id", objectId)).first();
        } catch (IllegalArgumentException ex) {
            System.err.println("El ID proporcionado no es válido: " + id);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existeCorreo(String correo) {
        long count = collectionUsuario.countDocuments(Filters.eq("correo", correo));
        return count > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        Usuario usuario = collectionUsuario.find(Filters.eq("correo", correo)).first();
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("No se encontró usuario para el correo: " + correo);
        }
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioIniciarSesion(String correo, String contra) {
        throw new UnsupportedOperationException("Método obsoleto. Usa buscarUsuarioPorCorreo para obtener el usuario.");
    }
}
