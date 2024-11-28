/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class Favorito {
    private String idFavorito;
    private Date fechaAgregacion;

    public Favorito() {
    }

    public Favorito(String idFavorito, Date fechaAgregacion) {
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
        return "Favorito{" + "idFavorito=" + idFavorito + ", fechaAgregacion=" + fechaAgregacion + '}';
    }
}
