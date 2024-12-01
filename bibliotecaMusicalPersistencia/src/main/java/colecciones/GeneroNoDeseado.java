/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class GeneroNoDeseado {
    private ObjectId id;
    private ObjectId idUsuario;
    private List<String> nombreGenero;

    public GeneroNoDeseado() {
        this.nombreGenero = new ArrayList<>();
    }    

    public GeneroNoDeseado(ObjectId idUsuario, List<String> nombreGenero) {
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero != null ? nombreGenero : new ArrayList<>();
    }

    public GeneroNoDeseado(ObjectId id, ObjectId idUsuario, List<String> nombreGenero) {
        this.id=id;
        this.idUsuario = idUsuario;
        this.nombreGenero = nombreGenero;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<String> getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(List<String> nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return "GeneroNoDeseado{" + "id=" + id + ", idUsuario=" + idUsuario + ", nombreGenero=" + nombreGenero + '}';
    }
}
