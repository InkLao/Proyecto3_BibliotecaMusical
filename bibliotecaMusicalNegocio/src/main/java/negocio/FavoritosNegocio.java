package negocio;

import colecciones.Favoritos;
import colecciones.Favorito;
import daos.FavoritosDAO;
import daos.IFavoritosDAO;
import dtos.FavoritoDTO;
import dtos.FavoritosDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class FavoritosNegocio implements IFavoritosNegocio {

    IFavoritosDAO favoritosDAO = new FavoritosDAO();

    public FavoritosNegocio() {
    }

    @Override
    public FavoritosDTO agregarFavoritos(FavoritosDTO favoritosDTO) {
        Favoritos favoritos = this.convertirFavoritosDTOAColeccion(favoritosDTO);
        Favoritos coleccionInsertada = favoritosDAO.agregarFavoritos(favoritos);
        return this.convertirFavoritosAColeccion(coleccionInsertada);
    }

    @Override
    public List<FavoritoDTO> obtenerFavoritosPorUsuario(Object idUsuario) {
        List<Favorito> favoritos = favoritosDAO.obtenerFavoritosPorUsuario((ObjectId) idUsuario);
        return this.convertirListaFavoritosDTO(favoritos);
    }

    @Override
    public void eliminarFavorito(Object idUsuario, String idFavorito) {
        favoritosDAO.eliminarFavorito((ObjectId) idUsuario, idFavorito);
    }

    private Favoritos convertirFavoritosDTOAColeccion(FavoritosDTO favoritosDTO) {
        List<Favorito> favoritos = new ArrayList<>();
        for (FavoritoDTO dto : favoritosDTO.getFavorito()) {
            favoritos.add(new Favorito(dto.getIdFavorito(), dto.getFechaAgregacion()));
        }
        return new Favoritos(favoritosDTO.getIdUsuario(), favoritos);
    }

    private FavoritosDTO convertirFavoritosAColeccion(Favoritos favoritos) {
        List<FavoritoDTO> favoritosDTO = new ArrayList<>();
        for (Favorito favorito : favoritos.getFavorito()) {
            favoritosDTO.add(new FavoritoDTO(favorito.getIdFavorito(), favorito.getFechaAgregacion()));
        }
        return new FavoritosDTO(favoritos.getId(), favoritos.getIdUsuario(), favoritosDTO);
    }

    private List<FavoritoDTO> convertirListaFavoritosDTO(List<Favorito> favoritos) {
        List<FavoritoDTO> favoritosDTO = new ArrayList<>();
        for (Favorito favorito : favoritos) {
            favoritosDTO.add(new FavoritoDTO(favorito.getIdFavorito(), favorito.getFechaAgregacion()));
        }
        return favoritosDTO;
    }
}
