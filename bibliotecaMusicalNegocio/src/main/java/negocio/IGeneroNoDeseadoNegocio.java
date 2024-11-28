/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.GeneroNoDeseadoDTO;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IGeneroNoDeseadoNegocio {
    GeneroNoDeseadoDTO agregarGeneroNoDeseado(GeneroNoDeseadoDTO generoDTO);
    List<String> obtenerGenerosNoDeseados(Object idUsuario);
    void eliminarGenero(Object idUsuario, String genero);
}
