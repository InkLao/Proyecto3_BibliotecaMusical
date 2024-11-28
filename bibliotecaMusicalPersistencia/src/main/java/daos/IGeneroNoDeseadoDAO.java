/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.GeneroNoDeseado;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IGeneroNoDeseadoDAO {
    GeneroNoDeseado agregarGeneroNoDeseado(GeneroNoDeseado genero);
    List<String> obtenerGenerosNoDeseados(ObjectId idUsuario);
    void eliminarGenero(ObjectId idUsuario, String genero);
}
