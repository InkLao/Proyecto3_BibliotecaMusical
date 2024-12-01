/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.FavoritoDTO;
import dtos.FavoritosDTO;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IFavoritosNegocio {
    FavoritosDTO agregarFavoritos(FavoritosDTO favoritosDTO);
    
    List<FavoritoDTO> obtenerFavoritosPorUsuario(String idUsuario);
    
    void eliminarFavorito(String idUsuario, String idFavorito);
    
    FavoritosDTO actualizarFavoritos(FavoritosDTO favoritosDTO);
    
}
