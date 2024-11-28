package dtos;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class FavoritoDTO {

    private String idFavorito;
    private Date fechaAgregacion;

    public FavoritoDTO() {
    }

    public FavoritoDTO(String idFavorito, Date fechaAgregacion) {
        this.idFavorito = idFavorito;
        this.fechaAgregacion = fechaAgregacion;
    }

    public String getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(String idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Date getFechaAgregacion() {
        return fechaAgregacion;
    }

    public void setFechaAgregacion(Date fechaAgregacion) {
        this.fechaAgregacion = fechaAgregacion;
    }

    @Override
    public String toString() {
        return "FavoritoDTO{" + "idFavorito=" + idFavorito + ", fechaAgregacion=" + fechaAgregacion + '}';
    }
}
