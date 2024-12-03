package colecciones;

import java.util.Date;

/**
 * Representa un integrante de una banda o grupo musical.
 * Contiene información sobre el rol, ingreso y salida del integrante.
 * 
 * @author Arturo
 */
public class Integrantes {

    /** Identificador único de la persona. */
    private String idPersona;

    /** Rol del integrante dentro de la banda. */
    private String rolBanda;

    /** Fecha en la que el integrante ingresó a la banda. */
    private Date fechaIngreso;

    /** Fecha en la que el integrante dejó la banda (null si sigue activo). */
    private Date fechaSalida;

    /**
     * Constructor por defecto.
     */
    public Integrantes() {
    }

    /**
     * Constructor para inicializar todos los campos.
     *
     * @param idPersona Identificador único de la persona.
     * @param rolBanda Rol del integrante.
     * @param fechaIngreso Fecha de ingreso a la banda.
     * @param fechaSalida Fecha de salida de la banda.
     */
    public Integrantes(String idPersona, String rolBanda, Date fechaIngreso, Date fechaSalida) {
        this.idPersona = idPersona;
        this.rolBanda = rolBanda;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    /** @return El identificador único de la persona. */
    public String getIdPersona() {
        return idPersona;
    }

    /** @param idPersona El identificador único de la persona a asignar. */
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    /** @return El rol del integrante en la banda. */
    public String getRolBanda() {
        return rolBanda;
    }

    /** @param rolBanda El rol del integrante a asignar. */
    public void setRolBanda(String rolBanda) {
        this.rolBanda = rolBanda;
    }

    /** @return La fecha de ingreso a la banda. */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /** @param fechaIngreso La fecha de ingreso a la banda a asignar. */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /** @return La fecha de salida de la banda. */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /** @param fechaSalida La fecha de salida de la banda a asignar. */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Integrantes{" + "idPersona=" + idPersona + ", rolBanda=" + rolBanda + 
               ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + '}';
    }
}
