/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Usuario;

/**
 *
 * @author Arturo ITSON
 */
public interface IUsuarioDAO {
    
    
    Usuario agregarUsuario(Usuario usuario);
    
    Usuario editarUsuario(Usuario usuario);
    
    Usuario buscarUsuario(Object id);
    
}
