/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Canciones;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IArtistaDAO {
    
    List<Artista> obtenerTodos();
    
    Artista buscarArtista(Object id);
    
    String obtenerImagenPorIdCancion(String id);
    
    List<Canciones> obtenerTodasCancionesEnArtista();
    
    List<Albumes> obtenerTodosAlbumesEnArtista();
    
}
