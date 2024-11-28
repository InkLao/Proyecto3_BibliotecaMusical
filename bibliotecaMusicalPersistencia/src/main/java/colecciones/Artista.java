/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Arturo ITSON
 */
public class Artista {
    
    private ObjectId id;
    private Integer idDos;
    private String NombreArtista;
    private String Imagen;
    private String Genero;
    private List<Document> Integrantes;
    private List<Document> Albumes;

    
    
    public Artista() {
    }

    public Artista(ObjectId id, Integer idDos, String NombreArtista, String Imagen, String Genero, List<Document> Integrantes, List<Document> Albumes) {
        this.id = id;
        this.idDos = idDos;
        this.NombreArtista = NombreArtista;
        this.Imagen = Imagen;
        this.Genero = Genero;
        this.Integrantes = Integrantes;
        this.Albumes = Albumes;
    }

    public Artista(Integer idDos, String NombreArtista, String Imagen, String Genero, List<Document> Integrantes, List<Document> Albumes) {
        this.idDos = idDos;
        this.NombreArtista = NombreArtista;
        this.Imagen = Imagen;
        this.Genero = Genero;
        this.Integrantes = Integrantes;
        this.Albumes = Albumes;
    }

    
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getIdDos() {
        return idDos;
    }

    public void setIdDos(Integer idDos) {
        this.idDos = idDos;
    }

    public String getNombreArtista() {
        return NombreArtista;
    }

    public void setNombreArtista(String NombreArtista) {
        this.NombreArtista = NombreArtista;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public List<Document> getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(List<Document> Integrantes) {
        this.Integrantes = Integrantes;
    }

    public List<Document> getAlbumes() {
        return Albumes;
    }

    public void setAlbumes(List<Document> Albumes) {
        this.Albumes = Albumes;
    }

    
    
    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", idDos=" + idDos + ", nombreArtista=" + NombreArtista + ", imagen=" + Imagen + ", genero=" + Genero + ", integrantes=" + Integrantes + ", albumes=" + Albumes + '}';
    }
    
}
