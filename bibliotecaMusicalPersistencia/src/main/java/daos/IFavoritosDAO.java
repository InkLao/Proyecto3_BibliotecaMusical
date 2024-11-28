/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Favorito;
import colecciones.Favoritos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IFavoritosDAO {
    Favoritos agregarFavoritos(Favoritos favoritos);
    List<Favorito> obtenerFavoritosPorUsuario(ObjectId idUsuario);
    void eliminarFavorito(ObjectId idUsuario, String idFavorito);
}
