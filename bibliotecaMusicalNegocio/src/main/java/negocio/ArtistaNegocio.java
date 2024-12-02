package negocio;

import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Canciones;
import colecciones.Integrantes;
import daos.ArtistaDAO;
import daos.IArtistaDAO;
import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import dtos.IntegrantesDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author Arturo ITSON
 */
public class ArtistaNegocio implements IArtistaNegocio {

    IArtistaDAO artistaDAO = new ArtistaDAO();

    public ArtistaNegocio() {

    }

    @Override
    public List<ArtistaDTO> obtenerTodos() {

        List<Artista> artistas = artistaDAO.obtenerTodos();

        try {
            return this.convertirListaArtistaDTO(artistas);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    @Override
    public List<ArtistaDTO> obtenerTodosArtistasFiltroGeneroNoDeseado(List<String> excluir) {

        List<Artista> artistas = artistaDAO.obtenerTodosArtistaSinGeneroNoDeseado(excluir);

        try {
            return this.convertirListaArtistaDTO(artistas);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    @Override
    public List<AlbumDTO> obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(List<String> excluir) {

        List<Albumes> albumes = artistaDAO.obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(excluir);

        try {
            return this.convertirListaAlbumDTO(albumes);
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
    public List<CancionDTO> obtenerTodasCancionesEnArtista() {

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
    public List<AlbumDTO> obtenerTodosAlbumesEnArtista() {

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
    public String obtenerImagenPorIdCancion(String id) {

        return artistaDAO.obtenerImagenPorIdCancion(id);

    }
    
    
    
    @Override
    public List<CancionDTO> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id) {

        List<Canciones> canciones = artistaDAO.obtenerTodasCancionesEnArtistaEspecifico(id);
        System.out.println("negocioCan" + canciones.get(0).getIdCancion());

        try {
            return this.convertirListaCancionDTO(canciones);
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public List<AlbumDTO> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id) {

        List<Albumes> albumes = artistaDAO.obtenerTodosAlbumesEnArtistaEspecifico(id);
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
    public AlbumDTO buscarAlbumPorId(String id){
    
        Albumes albumes = artistaDAO.buscarAlbumPorId(id);
        
        return this.convertirAlbumADTO(albumes);
    }
    
    
    @Override
    public CancionDTO buscarCancionPorId(String id){
    
        Canciones canciones = artistaDAO.buscarCancionPorId(id);

        return this.convertirCancionADTO(canciones);
    }
    
    
    @Override
    public ArtistaDTO buscarArtistaPorIdAlbum(String id){
    
        return this.convertirArtistaADTO(artistaDAO.buscarArtistaPorIdAlbum(id));
    }
    
    
    
    @Override
    public ArtistaDTO buscarArtistaPorIdCancion(String id){
        
        return this.convertirArtistaADTO(artistaDAO.buscarArtistaPorIdCancion(id));
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

    private ArtistaDTO convertirArtistaADTO(Artista artista) {

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
            dto.setGenero(album.getGenero());
            dto.setNombre(album.getNombre());

            albumesDTO.add(dto);
        }
        return albumesDTO;
    }
    
    
    private AlbumDTO convertirAlbumADTO(Albumes album) {

        try {
            return new AlbumDTO(album.getIdAlbum(), album.getNombre(), album.getFechaLanzamiento(), album.getGenero(), album.getImagen(), this.convertirListaCancionDTO(album.getCanciones()));
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    private CancionDTO convertirCancionADTO(Canciones cancion) {

        try {
            return new CancionDTO(cancion.getIdCancion(), cancion.getNombreCancion(), cancion.getDuracion());
        } catch (Exception ex) {
            Logger.getLogger(ArtistaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    

    @Override
    public ArtistaDTO agregarArtista(ArtistaDTO artistaDTO) {
        try {
            // Convertir ArtistaDTO a Artista
            Artista artista = new Artista();
            artista.setId(new ObjectId());
            artista.setIdDos(artistaDTO.getIdDos());
            artista.setNombreArtista(artistaDTO.getNombreArtista());
            artista.setImagen(artistaDTO.getImagen());
            artista.setGenero(artistaDTO.getGenero());
            artista.setIntegrantes(artistaDTO.getIntegrantes());
            artista.setAlbumes(artistaDTO.getAlbumes());

            // Insertar usando el DAO
            Artista artistaInsertado = artistaDAO.agregarArtista(artista);
            if (artistaInsertado != null) {
                System.out.println("Artista insertado en la base de datos.");
                return this.convertirArtistaADTO(artistaInsertado);
            } else {
                System.err.println("Error al insertar el artista.");
            }
        } catch (Exception e) {
            System.err.println("Error en la capa de negocio: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean InsercionArtistasArturo(){
        
        try{
        artistaDAO.InsercionArtistasArturo();
        
        return true;
        }
        catch(Exception e){
        
            System.out.println(e.getMessage());
        }
        
        return false;
    }

}
