package dtos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author eduar
 */
public class AlbumDTO {

    private String id;
    private String nombre;
    private Date fechaLanzamiento;
    private String genero;
    private String imagen;
    private List<CancionDTO> canciones;

    public AlbumDTO() {
    }

    public AlbumDTO(String id, String nombre, Date fechaLanzamiento, String genero, String imagen, List<CancionDTO> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    @Override
    public String toString() {
        return "AlbumDTO{" + "id=" + id + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", genero=" + genero + ", imagen=" + imagen + ", canciones=" + canciones + '}';
    }
}
