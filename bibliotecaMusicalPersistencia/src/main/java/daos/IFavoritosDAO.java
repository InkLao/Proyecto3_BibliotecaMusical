/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Favorito;
import colecciones.Favoritos;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IFavoritosDAO {
    Favoritos agregarFavoritos(Favoritos favoritos);
    List<Favorito> obtenerFavoritosPorUsuario(String idUsuario);
    void eliminarFavorito(String idUsuario, String idFavorito);
    
    Favoritos actualizarFavoritos(Favoritos favoritos);
}
