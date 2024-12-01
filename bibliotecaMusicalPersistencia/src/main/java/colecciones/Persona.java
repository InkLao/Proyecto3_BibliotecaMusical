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
    private String idPersona;
    private String nombreCompleto;

    public Persona() {
    }

    public Persona(ObjectId id, String idPersona, String nombreCompleto) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
    }

    public Persona(String idPersona, String nombreCompleto) {
        this.idPersona = idPersona;
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

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", idPersona=" + idPersona + ", nombreCompleto=" + nombreCompleto + '}';
    }

    
    
    
 
}
