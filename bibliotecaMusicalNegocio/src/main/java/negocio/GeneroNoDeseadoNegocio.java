package negocio;

import colecciones.GeneroNoDeseado;
import daos.GeneroNoDeseadoDAO;
import daos.IGeneroNoDeseadoDAO;
import dtos.GeneroNoDeseadoDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class GeneroNoDeseadoNegocio implements IGeneroNoDeseadoNegocio {

    IGeneroNoDeseadoDAO generoNoDeseadoDAO = new GeneroNoDeseadoDAO();

    public GeneroNoDeseadoNegocio() {
    }

    @Override
    public GeneroNoDeseadoDTO agregarGeneroNoDeseado(GeneroNoDeseadoDTO generoDTO) {
        GeneroNoDeseado genero = this.convertirGeneroDTOAColeccion(generoDTO);
        GeneroNoDeseado generoInsertado = generoNoDeseadoDAO.agregarGeneroNoDeseado(genero);
        return this.convertirGeneroAColeccion(generoInsertado);
    }

    @Override
    public List<String> obtenerGenerosNoDeseados(Object idUsuario) {
        return generoNoDeseadoDAO.obtenerGenerosNoDeseados((ObjectId) idUsuario);
    }

    @Override
    public void eliminarGenero(Object idUsuario, String genero) {
        List<String> generos = generoNoDeseadoDAO.obtenerGenerosNoDeseados((ObjectId) idUsuario);
        if (generos == null || !generos.contains(genero)) {
            throw new IllegalArgumentException("El género no está en la lista de no deseados.");
        }
        generoNoDeseadoDAO.eliminarGenero((ObjectId) idUsuario, genero);
    }

    private GeneroNoDeseado convertirGeneroDTOAColeccion(GeneroNoDeseadoDTO generoDTO) {
        return new GeneroNoDeseado(generoDTO.getId(), generoDTO.getIdUsuario(), generoDTO.getNombreGenero());
    }

    private GeneroNoDeseadoDTO convertirGeneroAColeccion(GeneroNoDeseado genero) {
        return new GeneroNoDeseadoDTO(genero.getId(), genero.getIdUsuario(), genero.getNombreGenero());
    }
}
