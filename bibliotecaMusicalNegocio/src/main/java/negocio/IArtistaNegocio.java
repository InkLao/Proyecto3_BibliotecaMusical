/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.ArtistaDTO;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IArtistaNegocio {
    
    
    List<ArtistaDTO> obtenerTodos();
    
    ArtistaDTO buscarArtista(Object id);
    
}
