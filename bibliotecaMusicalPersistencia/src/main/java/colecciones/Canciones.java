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
 
    private String idCancion;
    private String nombreCancion;
    private String duracion;

    public Canciones() {
    }

    public Canciones(String idCancion, String nombreCancion, String duracion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(String idCancion) {
        this.idCancion = idCancion;
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
        return "Canciones{" + "idCancion=" + idCancion + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + '}';
    }
    
    
}
