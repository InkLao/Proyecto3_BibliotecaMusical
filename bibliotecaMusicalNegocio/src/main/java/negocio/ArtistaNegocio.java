/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


import colecciones.Artista;
import daos.ArtistaDAO;
import daos.IArtistaDAO;
import dtos.ArtistaDTO;
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
    
}
