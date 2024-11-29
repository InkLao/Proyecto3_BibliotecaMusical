/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Album;
import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Cancion;
import colecciones.Canciones;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Arturo ITSON
 */
public class ArtistaDAO implements IArtistaDAO {

    MongoDatabase baseDeDatos;
    MongoCollection<Artista> collectionArtista;

    public ArtistaDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionArtista = baseDeDatos.getCollection("artistas", Artista.class);
    }

    @Override
    public List<Artista> obtenerTodos() {

        List<Artista> artistas;

        artistas = collectionArtista.find().into(new ArrayList<>());

        return artistas;
    }

    @Override
    public Artista buscarArtista(Object id) {

        Document query = new Document("_id", id);

        Artista artista = collectionArtista.find(query).first();

        return artista;

    }

    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtista() {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Lista donde se almacenarán todos los álbumes
        List<Albumes> listaAlbumes = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Crear un nuevo objeto Album con todos los datos (incluyendo el id)
                Albumes nuevoAlbum = new Albumes();
                nuevoAlbum.setIdAlbum(album.getIdAlbum());
                nuevoAlbum.setNombre(album.getNombre());
                nuevoAlbum.setImagen(album.getImagen());
                nuevoAlbum.setFechaLanzamiento(album.getFechaLanzamiento());
                nuevoAlbum.setCanciones(album.getCanciones());

                // Agregar el álbum a la lista
                listaAlbumes.add(nuevoAlbum);
            }
        }

        return listaAlbumes;
    }

    @Override
    public List<Canciones> obtenerTodasCancionesEnArtista() {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Lista donde se almacenarán todas las canciones
        List<Canciones> listaCanciones = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Recorrer las canciones de cada álbum
                if (album.getCanciones() != null) {
                    for (Canciones cancion : album.getCanciones()) {
                        // Crear una nueva Canción con todos los datos (incluyendo el id)
                        Canciones nuevaCancion = new Canciones();
                        nuevaCancion.setIdCancion(cancion.getIdCancion());
                        nuevaCancion.setNombreCancion(cancion.getNombreCancion());
                        nuevaCancion.setDuracion(cancion.getDuracion());

                        // Agregar la canción a la lista
                        listaCanciones.add(nuevaCancion);
                    }
                }
            }
        }

        return listaCanciones;

    }

    @Override
    public String obtenerImagenPorIdCancion(String id) {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Variable para almacenar la imagen del álbum
        String imagenAlbum = null;

        // Iterar sobre los artistas y buscar la canción
        for (Artista artista : listaArtistas) {
            List<Albumes> albumes = artista.getAlbumes();
            if (albumes != null) {
                for (Albumes album : albumes) {
                    List<Canciones> canciones = album.getCanciones();
                    if (canciones != null) {
                        for (Canciones cancion : canciones) {
                            if (cancion.getIdCancion().equals(id)) {
                                // Encontramos la canción, obtenemos la imagen del álbum
                                imagenAlbum = album.getImagen();

                                return imagenAlbum;

                            }
                        }
                    }
                    if (imagenAlbum != null) {
                        break; // Salir del bucle si ya encontramos la canción
                    }
                }
            }
            if (imagenAlbum != null) {
                break; // Salir del bucle si ya encontramos la canción
            }
        }

        // Mostrar el resultado
        if (imagenAlbum != null) {
            System.out.println("Imagen del álbum: " + imagenAlbum);
        } else {
            System.out.println("No se encontró la canción con el ID proporcionado.");
        }

        return null;
    }

    @Override
    public Artista agregarArtista(Artista artista) {
        try {
            // Insertar el artista en la colección
            collectionArtista.insertOne(artista);
            System.out.println("Artista agregado con éxito: " + artista.getNombreArtista());
            return artista;
        } catch (Exception e) {
            System.err.println("Error al agregar el artista: " + e.getMessage());
            return null;
        }
    }

}
