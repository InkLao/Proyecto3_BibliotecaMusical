/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Arturo ITSON
 */
public interface IArtistaNegocio {
    
    
    List<ArtistaDTO> obtenerTodos();
    
    ArtistaDTO buscarArtista(Object id);
    
    String obtenerImagenPorIdCancion(String id);
    
    List<CancionDTO> obtenerTodasCancionesEnArtista();
    
    List<AlbumDTO> obtenerTodosAlbumesEnArtista();
    
    ArtistaDTO agregarArtista(ArtistaDTO artistaDTO);
    
    List<CancionDTO> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id);
    
    List<AlbumDTO> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id);
    
    AlbumDTO buscarAlbumPorId(String id);
    
    CancionDTO buscarCancionPorId(String id);
    
    ArtistaDTO buscarArtistaPorIdAlbum(String id);
    
    ArtistaDTO buscarArtistaPorIdCancion(String id);
    
    List<ArtistaDTO> obtenerTodosArtistasFiltroGeneroNoDeseado(List<String> excluir);
    
    List<AlbumDTO> obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(List<String> excluir);
    
    
    boolean InsercionArtistasArturo();
    
}
