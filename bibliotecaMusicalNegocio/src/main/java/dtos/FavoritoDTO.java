package dtos;

import java.util.Date;

/**
 * Representa un elemento favorito de un usuario en el sistema.
 * Contiene información como identificador y fecha de agregación.
 */
public class FavoritoDTO {

    private String idFavorito; // Identificador único del favorito.
    private Date fechaAgregacion; // Fecha en la que se agregó a favoritos.

    /**
     * Constructor por defecto.
     */
    public FavoritoDTO() {}

    /**
     * Constructor con parámetros.
     * @param idFavorito Identificador único del favorito.
     * @param fechaAgregacion Fecha en la que se agregó el favorito.
     */
    public FavoritoDTO(String idFavorito, Date fechaAgregacion) {
        this.idFavorito = idFavorito;
        this.fechaAgregacion = fechaAgregacion;
    }

    // Métodos Getter y Setter.

    /**
     * Obtiene el identificador único del favorito.
     * @return idFavorito
     */
    public String getIdFavorito() {
        return idFavorito;
    }

    /**
     * Establece el identificador único del favorito.
     * @param idFavorito Nuevo identificador del favorito.
     */
    public void setIdFavorito(String idFavorito) {
        this.idFavorito = idFavorito;
    }

    /**
     * Obtiene la fecha en la que se agregó a favoritos.
     * @return fechaAgregacion
     */
    public Date getFechaAgregacion() {
        return fechaAgregacion;
    }

    /**
     * Establece la fecha en la que se agregó a favoritos.
     * @param fechaAgregacion Nueva fecha de agregación.
     */
    public void setFechaAgregacion(Date fechaAgregacion) {
        this.fechaAgregacion = fechaAgregacion;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información del favorito en formato de texto.
     */
    @Override
    public String toString() {
        return "FavoritoDTO{" +
                "idFavorito='" + idFavorito + '\'' +
                ", fechaAgregacion=" + fechaAgregacion +
                '}';
    }
}
