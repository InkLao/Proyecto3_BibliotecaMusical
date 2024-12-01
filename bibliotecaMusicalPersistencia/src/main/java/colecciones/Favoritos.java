/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class Favoritos {
    
    private ObjectId id;
    private String idUsuario;
    private List<Favorito> favorito;

    public Favoritos() {
    }

    public Favoritos(ObjectId id, String idUsuario, List<Favorito> favorito) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    
    
    public Favoritos(String idUsuario, List<Favorito> favorito) {
        this.idUsuario = idUsuario;
        this.favorito = favorito;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Favorito> getFavorito() {
        return favorito;
    }

    public void setFavorito(List<Favorito> favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "Favoritos{" + "id=" + id + ", idUsuario=" + idUsuario + ", favorito=" + favorito + '}';
    }
}
