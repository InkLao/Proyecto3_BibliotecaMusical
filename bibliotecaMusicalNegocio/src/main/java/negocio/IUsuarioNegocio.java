/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.UsuarioDTO;

/**
 *
 * @author Arturo ITSON
 */
public interface IUsuarioNegocio {
    
    
    UsuarioDTO agregarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO editarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO buscarUsuario(Object id);
    
    UsuarioDTO buscarUsuarioPorCorreo(String correo);
    
    UsuarioDTO buscarUsuarioIniciarSesion(String correo, String contra);
    
    boolean correoExiste(String correo);

}
