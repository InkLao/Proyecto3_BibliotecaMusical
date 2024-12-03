/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import colecciones.Usuario;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dtos.UsuarioDTO;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Arturo ITSON
 */
public class UsuarioNegocio implements IUsuarioNegocio {

    IUsuarioDAO usuarioDAO = new UsuarioDAO();

    public UsuarioNegocio() {

    }

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuario) {
        // Validación de datos básicos
        if (usuario.getCorreo().isEmpty() || usuario.getContrasena().isEmpty()) {
            throw new IllegalArgumentException("Correo y contraseña son obligatorios.");
        }

        if (usuarioDAO.existeCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Encriptar contraseña
        usuario.setContrasena(encryptPassword(usuario.getContrasena()));

        Usuario usuarioColeccion = convertirUsuarioDTOAColeccion(usuario);
        usuarioDAO.agregarUsuario(usuarioColeccion);

        return convertirUsuarioADTO(usuarioColeccion);
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO usuario) {

        UsuarioDTO usuarioDTO = this.convertirUsuarioADTO(usuarioDAO.editarUsuario(this.convertirUsuarioDTOAColeccion(usuario)));

        return usuarioDTO;

    }

    @Override
    public UsuarioDTO buscarUsuario(Object id) {

        UsuarioDTO usuarioDTO = this.convertirUsuarioADTO(usuarioDAO.buscarUsuario(id));

        return usuarioDTO;
    }

    @Override
    public UsuarioDTO buscarUsuarioPorCorreo(String correo) {
        Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correo);
        return usuario != null ? convertirUsuarioADTO(usuario) : null;
    }

    @Override
    public UsuarioDTO buscarUsuarioIniciarSesion(String correo, String contra) {
        Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correo);

    if (usuario == null) {
        throw new IllegalArgumentException("Correo o contraseña incorrectos.");
    }

    // Verifica la contraseña encriptada
    boolean coincide = BCrypt.checkpw(contra, usuario.getContrasena());
    if (!coincide) {
        throw new IllegalArgumentException("Correo o contraseña incorrectos.");
    }

    return convertirUsuarioADTO(usuario);
    }

    private Usuario convertirUsuarioDTOAColeccion(UsuarioDTO usuario) {

        return new Usuario(usuario.getId(), usuario.getNombres(), usuario.getApellidoP(), usuario.getApellidoM(), usuario.getCorreo(), usuario.getContrasena(), usuario.getImagen());
    }

    private UsuarioDTO convertirUsuarioADTO(Usuario usuario) {

        return new UsuarioDTO(usuario.getId(), usuario.getNombres(), usuario.getApellidoP(), usuario.getApellidoM(), usuario.getCorreo(), usuario.getContrasena(), usuario.getImagen());
    }

    private String encryptPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean correoExiste(String correo) {
        return usuarioDAO.existeCorreo(correo);
    }

}
