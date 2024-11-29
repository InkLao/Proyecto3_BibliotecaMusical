/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import colecciones.Albumes;
import colecciones.Canciones;
import colecciones.Integrantes;
import dtos.AlbumDTO;
import dtos.CancionDTO;
import dtos.IntegrantesDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ConversorDTO {
    
    public static Albumes convertirAlbumDTOAAlbum(AlbumDTO albumDTO) {
        List<Canciones> canciones = new ArrayList<>();
        for (CancionDTO cancionDTO : albumDTO.getCanciones()) {
            canciones.add(new Canciones(cancionDTO.getIdCancion(), cancionDTO.getNombreCancion(), cancionDTO.getDuracion()));
        }
        return new Albumes(albumDTO.getIdAlbum(), albumDTO.getNombre(), albumDTO.getFechaLanzamiento(), albumDTO.getImagen(), canciones);
    }

    public static List<Albumes> convertirListaAlbumDTOAAlbum(List<AlbumDTO> albumesDTO) {
        List<Albumes> albumes = new ArrayList<>();
        for (AlbumDTO albumDTO : albumesDTO) {
            albumes.add(convertirAlbumDTOAAlbum(albumDTO));
        }
        return albumes;
    }

    public static Integrantes convertirIntegrantesDTOAIntegrantes(IntegrantesDTO integranteDTO) {
        return new Integrantes(integranteDTO.getIdPersona(), integranteDTO.getRolBanda(), integranteDTO.getFechaIngreso(), integranteDTO.getFechaSalida());
    }

    public static List<Integrantes> convertirListaIntegrantesDTOAIntegrantes(List<IntegrantesDTO> integrantesDTO) {
        List<Integrantes> integrantes = new ArrayList<>();
        for (IntegrantesDTO integranteDTO : integrantesDTO) {
            integrantes.add(convertirIntegrantesDTOAIntegrantes(integranteDTO));
        }
        return integrantes;
    }
}
