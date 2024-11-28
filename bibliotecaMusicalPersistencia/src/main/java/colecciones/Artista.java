/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Arturo ITSON
 */
public class Artista {
    
    private ObjectId id;
    private int idDos;
    private String nombreArtista;
    private String imagen;
    private String genero;
    private List<Integrantes> Integrantes;
    private List<Albumes> Albumes;

    
    
    public Artista() {
    }

    public Artista(ObjectId id, int idDos, String nombreArtista, String imagen, String genero, List<Integrantes> Integrantes, List<Albumes> Albumes) {
        this.id = id;
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.Integrantes = Integrantes;
        this.Albumes = Albumes;
    }

    public Artista(int idDos, String nombreArtista, String imagen, String genero, List<Integrantes> Integrantes, List<Albumes> Albumes) {
        this.idDos = idDos;
        this.nombreArtista = nombreArtista;
        this.imagen = imagen;
        this.genero = genero;
        this.Integrantes = Integrantes;
        this.Albumes = Albumes;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getIdDos() {
        return idDos;
    }

    public void setIdDos(int idDos) {
        this.idDos = idDos;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Integrantes> getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(List<Integrantes> Integrantes) {
        this.Integrantes = Integrantes;
    }

    public List<Albumes> getAlbumes() {
        return Albumes;
    }

    public void setAlbumes(List<Albumes> Albumes) {
        this.Albumes = Albumes;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", idDos=" + idDos + ", nombreArtista=" + nombreArtista + ", imagen=" + imagen + ", genero=" + genero + ", Integrantes=" + Integrantes + ", Albumes=" + Albumes + '}';
    }

    
    
    
    
}