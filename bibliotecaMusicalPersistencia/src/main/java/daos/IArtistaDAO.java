/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Artista;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IArtistaDAO {
    
    List<Artista> obtenerTodos();
    
    Artista buscarArtista(Object id);
    
}
