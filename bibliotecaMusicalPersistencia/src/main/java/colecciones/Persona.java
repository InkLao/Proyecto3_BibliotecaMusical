package colecciones;

import org.bson.types.ObjectId;

/**
 * Representa una persona asociada a un grupo musical o como usuario.
 * Contiene información básica como el nombre completo y el identificador.
 * 
 * @author Edu
 */
public class Persona {

    /** Identificador único del documento en la base de datos. */
    private ObjectId id;

    /** Identificador alternativo de la persona. */
    private String idPersona;

    /** Nombre completo de la persona. */
    private String nombreCompleto;

    /**
     * Constructor por defecto.
     */
    public Persona() {
    }

    /**
     * Constructor para inicializar todos los campos.
     *
     * @param id Identificador único.
     * @param idPersona Identificador alternativo.
     * @param nombreCompleto Nombre completo de la persona.
     */
    public Persona(ObjectId id, String idPersona, String nombreCompleto) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Constructor para inicializar sin identificador único.
     *
     * @param idPersona Identificador alternativo.
     * @param nombreCompleto Nombre completo de la persona.
     */
    public Persona(String idPersona, String nombreCompleto) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    /** @return El identificador único. */
    public ObjectId getId() {
        return id;
    }

    /** @param id El identificador único a asignar. */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /** @return El identificador alternativo de la persona. */
    public String getIdPersona() {
        return idPersona;
    }

    /** @param idPersona El identificador alternativo a asignar. */
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    /** @return El nombre completo de la persona. */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /** @param nombreCompleto El nombre completo a asignar. */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", idPersona=" + idPersona + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
