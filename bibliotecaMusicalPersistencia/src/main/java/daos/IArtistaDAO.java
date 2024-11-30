/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Canciones;
import java.util.List;
import org.bson.types.ObjectId;

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
    
    Artista agregarArtista(Artista artista);
    
    List<Canciones> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id);
    
    List<Albumes> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id);
    
    Albumes buscarAlbumPorId(String id);
    
    Canciones buscarCancionPorId(String id);
    
    Artista buscarArtistaPorIdAlbum(String id);
    
    Artista buscarArtistaPorIdCancion(String id);
    
    
}
