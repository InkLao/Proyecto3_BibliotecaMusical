package dtos;

import org.bson.types.ObjectId;

/**
 * Representa una persona en el sistema, generalmente un integrante de una banda musical.
 */
public class PersonaDTO {

    private ObjectId id; // Identificador único en MongoDB.
    private String idPersona; // Identificador único de la persona.
    private String nombreCompleto; // Nombre completo de la persona.

    /**
     * Constructor por defecto.
     */
    public PersonaDTO() {}

    /**
     * Constructor con parámetros.
     * @param id Identificador único en MongoDB.
     * @param idPersona Identificador único de la persona.
     * @param nombreCompleto Nombre completo de la persona.
     */
    public PersonaDTO(ObjectId id, String idPersona, String nombreCompleto) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Constructor con parámetros sin el identificador de MongoDB.
     * @param idPersona Identificador único de la persona.
     * @param nombreCompleto Nombre completo de la persona.
     */
    public PersonaDTO(String idPersona, String nombreCompleto) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    // Métodos Getter y Setter.

    /**
     * Obtiene el identificador único en MongoDB.
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único en MongoDB.
     * @param id Nuevo identificador de MongoDB.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador único de la persona.
     * @return idPersona
     */
    public String getIdPersona() {
        return idPersona;
    }

    /**
     * Establece el identificador único de la persona.
     * @param idPersona Nuevo identificador de la persona.
     */
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Obtiene el nombre completo de la persona.
     * @return nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona.
     * @param nombreCompleto Nuevo nombre completo de la persona.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información de la persona en formato de texto.
     */
    @Override
    public String toString() {
        return "PersonaDTO{" +
                "id=" + id +
                ", idPersona='" + idPersona + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
