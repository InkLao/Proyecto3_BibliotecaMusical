package daos;

import colecciones.Usuario;

/**
 * Interfaz para definir las operaciones de acceso a datos relacionadas con Usuarios.
 * 
 * @author Arturo
 */
public interface IUsuarioDAO {

    /** Agrega un nuevo usuario a la base de datos. */
    Usuario agregarUsuario(Usuario usuario);

    /** Edita los datos de un usuario existente. */
    Usuario editarUsuario(Usuario usuario);

    /** Busca un usuario por su identificador. */
    Usuario buscarUsuario(Object id);

    /** Busca un usuario por su correo y contraseña. */
    Usuario buscarUsuarioIniciarSesion(String correo, String contra);

    /** Verifica si un correo ya está registrado en la base de datos. */
    boolean existeCorreo(String correo);

    /** Busca un usuario por su correo. */
    Usuario buscarUsuarioPorCorreo(String correo);
}
