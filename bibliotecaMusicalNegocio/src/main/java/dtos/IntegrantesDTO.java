package dtos;

import java.util.Date;

/**
 * Representa un integrante de una banda musical en el sistema.
 * Contiene información como el identificador de la persona, su rol en la banda,
 * y fechas de ingreso y salida.
 */
public class IntegrantesDTO {

    private String idPersona; // Identificador único de la persona.
    private String rolBanda; // Rol desempeñado en la banda (e.g., vocalista, guitarrista).
    private Date fechaIngreso; // Fecha en la que ingresó a la banda.
    private Date fechaSalida; // Fecha en la que dejó la banda.

    /**
     * Constructor por defecto.
     */
    public IntegrantesDTO() {}

    /**
     * Constructor con parámetros.
     * @param idPersona Identificador único de la persona.
     * @param rolBanda Rol desempeñado en la banda.
     * @param fechaIngreso Fecha de ingreso a la banda.
     * @param fechaSalida Fecha de salida de la banda.
     */
    public IntegrantesDTO(String idPersona, String rolBanda, Date fechaIngreso, Date fechaSalida) {
        this.idPersona = idPersona;
        this.rolBanda = rolBanda;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    // Métodos Getter y Setter.

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
     * Obtiene el rol desempeñado en la banda.
     * @return rolBanda
     */
    public String getRolBanda() {
        return rolBanda;
    }

    /**
     * Establece el rol desempeñado en la banda.
     * @param rolBanda Nuevo rol en la banda.
     */
    public void setRolBanda(String rolBanda) {
        this.rolBanda = rolBanda;
    }

    /**
     * Obtiene la fecha de ingreso a la banda.
     * @return fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso a la banda.
     * @param fechaIngreso Nueva fecha de ingreso.
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene la fecha de salida de la banda.
     * @return fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida de la banda.
     * @param fechaSalida Nueva fecha de salida.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información del integrante en formato de texto.
     */
    @Override
    public String toString() {
        return "IntegrantesDTO{" +
                "idPersona='" + idPersona + '\'' +
                ", rolBanda='" + rolBanda + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
