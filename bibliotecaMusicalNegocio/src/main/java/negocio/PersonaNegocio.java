package negocio;

import colecciones.Persona;
import daos.IPersonaDAO;
import daos.PersonaDAO;
import dtos.PersonaDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class PersonaNegocio implements IPersonaNegocio {

    IPersonaDAO personaDAO = new PersonaDAO();

    public PersonaNegocio() {
    }

    @Override
    public PersonaDTO agregarPersona(PersonaDTO personaDTO) {
        Persona persona = this.convertirPersonaDTOAColeccion(personaDTO);
        Persona personaInsertada = personaDAO.agregarPersona(persona);
        return this.convertirPersonaAColeccion(personaInsertada);
    }

    @Override
    public List<PersonaDTO> obtenerTodas() {
        List<Persona> personas = personaDAO.obtenerTodas();
        return this.convertirListaPersonaDTO(personas);
    }

//    @Override
//    public PersonaDTO buscarPersonaPorId(Object id) {
//        Persona persona = personaDAO.buscarPersonaPorId((ObjectId) id);
//        return this.convertirPersonaAColeccion(persona);
//    }
    
    @Override
    public PersonaDTO buscarPersonaPorId(String id) {
        Persona persona = personaDAO.buscarPersonaPorId(id);
        return this.convertirPersonaAColeccion(persona);
    }
    

    private Persona convertirPersonaDTOAColeccion(PersonaDTO personaDTO) {
        return new Persona(personaDTO.getIdPersona(), personaDTO.getNombreCompleto());
    }

    private PersonaDTO convertirPersonaAColeccion(Persona persona) {
        return new PersonaDTO(persona.getId(), persona.getIdPersona(), persona.getNombreCompleto());
    }

    private List<PersonaDTO> convertirListaPersonaDTO(List<Persona> personas) {
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Persona persona : personas) {
            personasDTO.add(this.convertirPersonaAColeccion(persona));
        }
        return personasDTO;
    }
}
