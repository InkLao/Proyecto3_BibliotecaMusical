package dtos;

import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class PersonaDTO {

    private ObjectId id;
    private String idPersona;
    private String nombreCompleto;

    public PersonaDTO() {
    }

    public PersonaDTO(ObjectId id, String idPersona, String nombreCompleto) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    public PersonaDTO(String idPersona, String nombreCompleto) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    
    
    
    
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", idPersona=" + idPersona + ", nombreCompleto=" + nombreCompleto + '}';
    }


}
