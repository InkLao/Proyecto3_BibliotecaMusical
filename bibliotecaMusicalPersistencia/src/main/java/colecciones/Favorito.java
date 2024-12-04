package colecciones;

import java.util.Date;

/**
 * Clase que representa un favorito, incluyendo la fecha en la que fue agregado.
 * 
 * @author eduar
 */
public class Favorito {

    /** Identificador único del favorito. */
    private String idFavorito;

    /** Fecha en la que el favorito fue agregado. */
    private Date fechaAgregacion;

    /**
     * Constructor por defecto.
     */
    public Favorito() {
    }

    /**
     * Constructor que inicializa todos los atributos del favorito.
     * 
     * @param idFavorito Identificador único del favorito.
     * @param fechaAgregacion Fecha en la que el favorito fue agregado.
     */
    public Favorito(String idFavorito, Date fechaAgregacion) {
        this.idFavorito = idFavorito;
        this.fechaAgregacion = fechaAgregacion;
    }

    /**
     * Obtiene el identificador único del favorito.
     * 
     * @return ID del favorito.
     */
    public String getIdFavorito() {
        return idFavorito;
    }

    /**
     * Establece el identificador único del favorito.
     * 
     * @param idFavorito ID del favorito.
     */
    public void setIdFavorito(String idFavorito) {
        this.idFavorito = idFavorito;
    }

    /**
     * Obtiene la fecha en la que el favorito fue agregado.
     * 
     * @return Fecha de agregación.
     */
    public Date getFechaAgregacion() {
        return fechaAgregacion;
    }

    /**
     * Establece la fecha en la que el favorito fue agregado.
     * 
     * @param fechaAgregacion Fecha de agregación.
     */
    public void setFechaAgregacion(Date fechaAgregacion) {
        this.fechaAgregacion = fechaAgregacion;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "idFavorito='" + idFavorito + '\'' +
                ", fechaAgregacion=" + fechaAgregacion +
                '}';
    }
}
