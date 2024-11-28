package dtos;

import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class PersonaDTO {

    private ObjectId id;
    private String nombreCompleto;

    public PersonaDTO() {
    }

    public PersonaDTO(ObjectId id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
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
        return "PersonaDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
