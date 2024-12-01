/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import colecciones.Usuario;
import daos.IUsuarioDAO;
import daos.UsuarioDAO;
import dtos.UsuarioDTO;

/**
 *
 * @author Arturo ITSON
 */
public class UsuarioNegocio implements IUsuarioNegocio{

    
    IUsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public UsuarioNegocio(){
        
    }
    
    
    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuario) {
        
        UsuarioDTO usuarioDTO = this.convertirUsuarioADTO(usuarioDAO.agregarUsuario(this.convertirUsuarioDTOAColeccion(usuario)));
        
        return usuarioDTO;
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
    public UsuarioDTO buscarUsuarioIniciarSesion(String correo, String contra){
        
        UsuarioDTO usuarioDTO = this.convertirUsuarioADTO(usuarioDAO.buscarUsuarioIniciarSesion(correo, contra));
        
        return usuarioDTO;
    }
    
    
    
    private Usuario convertirUsuarioDTOAColeccion(UsuarioDTO usuario){
    
        return new Usuario(usuario.getId(), usuario.getNombres(), usuario.getApellidoP(), usuario.getApellidoM(), usuario.getCorreo(), usuario.getContrasena(), usuario.getImagen());
    }
    
    private UsuarioDTO convertirUsuarioADTO(Usuario usuario){
    
        return new UsuarioDTO(usuario.getId(), usuario.getNombres(), usuario.getApellidoP(), usuario.getApellidoM(), usuario.getCorreo(), usuario.getContrasena(), usuario.getImagen());
    }
}
