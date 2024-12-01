/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dtos.PersonaDTO;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IPersonaNegocio {
    PersonaDTO agregarPersona(PersonaDTO personaDTO);
    List<PersonaDTO> obtenerTodas();
    //PersonaDTO buscarPersonaPorId(Object id);
    PersonaDTO buscarPersonaPorId(String id);
}
