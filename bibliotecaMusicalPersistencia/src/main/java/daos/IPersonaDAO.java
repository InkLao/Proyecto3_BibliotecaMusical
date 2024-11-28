/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import colecciones.Persona;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IPersonaDAO {
    List<Persona> obtenerTodas();
    Persona buscarPersonaPorId(ObjectId id);
    Persona agregarPersona(Persona persona);
}
