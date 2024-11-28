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
    
    private String id;
    private String nombre;
    private Date fechaLanzamiento;
    private String imagen;
    private List<Canciones> canciones;

    public Albumes() {
    }

    public Albumes(String id, String nombre, Date fechaLanzamiento, String imagen, List<Canciones> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    public Albumes(String id, String nombre, Date fechaLanzamiento, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
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

    @Override
    public String toString() {
        return "Albumes{" + "id=" + id + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", imagen=" + imagen + ", canciones=" + canciones + '}';
    }
    
    
    
}
