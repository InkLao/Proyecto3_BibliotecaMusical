package dtos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author eduar
 */
public class AlbumDTO {

    private String idAlbum;
    private String nombre;
    private Date fechaLanzamiento;
    private String genero;
    private String imagen;
    private List<CancionDTO> canciones;

    public AlbumDTO() {
    }

    public AlbumDTO(String idAlbum, String nombre, Date fechaLanzamiento, String genero, String imagen, List<CancionDTO> canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    public AlbumDTO(String nombre, Date fechaLanzamiento, String genero, String imagen, List<CancionDTO> canciones) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }



    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<CancionDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<CancionDTO> canciones) {
        this.canciones = canciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "AlbumDTO{" + "idAlbum=" + idAlbum + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", genero=" + genero + ", imagen=" + imagen + ", canciones=" + canciones + '}';
    }




}
