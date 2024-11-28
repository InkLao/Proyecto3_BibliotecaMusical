/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.Date;

/**
 *
 * @author Arturo ITSON
 */
public class Integrantes {
    
    private String idPersona;
    private String rolBanda;
    private Date fechaIngreso;
    private Date fechaSalida;

    
    public Integrantes() {
    }

    
    public Integrantes(String idPersona, String rolBanda, Date fechaIngreso, Date fechaSalida) {
        this.idPersona = idPersona;
        this.rolBanda = rolBanda;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getRolBanda() {
        return rolBanda;
    }

    public void setRolBanda(String rolBanda) {
        this.rolBanda = rolBanda;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Integrantes{" + "idPersona=" + idPersona + ", rolBanda=" + rolBanda + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + '}';
    }
    
    
    
    
}
