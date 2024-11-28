/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class Persona {
    private ObjectId id;
    private String nombreCompleto;

    public Persona() {
    }

    public Persona(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
