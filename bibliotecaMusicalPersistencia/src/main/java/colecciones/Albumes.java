/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public class Albumes {
    
    private String idAlbum;
    private String nombre;
    private Date fechaLanzamiento;
    private String genero;
    private String imagen;
    private List<Canciones> canciones;

    public Albumes() {
    }

    public Albumes(String idAlbum, String nombre, Date fechaLanzamiento, String genero, String imagen, List<Canciones> canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    public Albumes(String nombre, Date fechaLanzamiento, String genero, String imagen, List<Canciones> canciones) {
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

    public List<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Canciones> canciones) {
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
        return "Albumes{" + "idAlbum=" + idAlbum + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", genero=" + genero + ", imagen=" + imagen + ", canciones=" + canciones + '}';
    }



    
    

    
    
    
}
