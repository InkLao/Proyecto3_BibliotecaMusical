/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Canciones;
import daos.ArtistaDAO;
import daos.IArtistaDAO;
import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class ArtistaNegocio implements IArtistaNegocio{
    
    IArtistaDAO artistaDAO = new ArtistaDAO();
    
    public ArtistaNegocio(){
    
    }

    
    @Override
    public List<ArtistaDTO> obtenerTodos() {

       List<Artista> artistas =  artistaDAO.obtenerTodos();
        
        try {
            return this.convertirListaArtistaDTO(artistas);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    @Override
    public ArtistaDTO buscarArtista(Object id) {
        
        ArtistaDTO artistaDTO = this.convertirArtistaADTO(artistaDAO.buscarArtista(id));
        
        return artistaDTO;
    }
    
    
    @Override
    public List<CancionDTO> obtenerTodasCancionesEnArtista(){
    
        List<Canciones> canciones = artistaDAO.obtenerTodasCancionesEnArtista();
        System.out.println("negocioCan" + canciones.get(0).getIdCancion());
        
        try {
            return this.convertirListaCancionDTO(canciones);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    
    @Override
    public List<AlbumDTO> obtenerTodosAlbumesEnArtista(){
    
        List<Albumes> albumes = artistaDAO.obtenerTodosAlbumesEnArtista();
        System.out.println("negocio" + albumes.get(0).getIdAlbum());
        System.out.println("album" + albumes.get(0).toString());
        
        try {
            return this.convertirListaAlbumDTO(albumes);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    
    
    @Override
    public String obtenerImagenPorIdCancion(String id){
    
        return artistaDAO.obtenerImagenPorIdCancion(id);
        
    }
    
    private List<ArtistaDTO> convertirListaArtistaDTO(List<Artista> artistas) throws Exception {
        if (artistas == null) {
            throw new Exception("No se pudieron obtener los artistas. No hay registros.");
        }
        
            List<ArtistaDTO> artistaDTO = new ArrayList<>();
        for (Artista artista : artistas) {
            ArtistaDTO dto = new ArtistaDTO();
            dto.setAlbumes(artista.getAlbumes());
            dto.setGenero(artista.getGenero());
            dto.setId(artista.getId());
            dto.setIdDos(artista.getIdDos());
            dto.setImagen(artista.getImagen());
            dto.setIntegrantes(artista.getIntegrantes());
            dto.setNombreArtista(artista.getNombreArtista());
            
            

            artistaDTO.add(dto);
        }
        return artistaDTO;
    } 
    
    
    
    
    private ArtistaDTO convertirArtistaADTO(Artista artista){
    
        return new ArtistaDTO(artista.getId(), artista.getIdDos(), artista.getNombreArtista(), artista.getImagen(), artista.getGenero(), artista.getIntegrantes(), artista.getAlbumes());
    }
    
        
    private List<CancionDTO> convertirListaCancionDTO(List<Canciones> canciones) throws Exception {
        if (canciones == null) {
            throw new Exception("No se pudieron obtener las canciones. No hay registros.");
        }
        
            List<CancionDTO> cancionesDTO = new ArrayList<>();
                for (Canciones cancion : canciones) {
                CancionDTO dto = new CancionDTO();
                dto.setDuracion(cancion.getDuracion());
                dto.setIdCancion(cancion.getIdCancion());
                dto.setNombreCancion(cancion.getNombreCancion());
      

            cancionesDTO.add(dto);
        }
        return cancionesDTO;
    } 
    
    
    
    private List<AlbumDTO> convertirListaAlbumDTO(List<Albumes> albumes) throws Exception {
        if (albumes == null) {
            throw new Exception("No se pudieron obtener los albumes. No hay registros.");
        }
        
            List<AlbumDTO> albumesDTO = new ArrayList<>();
                for (Albumes album : albumes) {
                AlbumDTO dto = new AlbumDTO();
                dto.setCanciones(this.convertirListaCancionDTO(album.getCanciones()));
                dto.setFechaLanzamiento(album.getFechaLanzamiento());
                dto.setIdAlbum(album.getIdAlbum());
                dto.setImagen(album.getImagen());
                dto.setNombre(album.getNombre());
                
      

            albumesDTO.add(dto);
        }
        return albumesDTO;
    }
    
}
