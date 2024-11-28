/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

/**
 *
 * @author Arturo ITSON
 */
public class Canciones {
 
    private String id;
    private String nombreCancion;
    private String duracion;

    public Canciones() {
    }

    public Canciones(String id, String nombreCancion, String duracion) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Canciones{" + "id=" + id + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + '}';
    }
    
    
}
