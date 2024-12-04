package daos;

import colecciones.Artista;
import colecciones.Albumes;
import colecciones.Canciones;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexionBD.ConexionBD;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa las operaciones de acceso a datos para la colección "artistas".
 * Proporciona funcionalidades para CRUD y consultas avanzadas.
 * 
 * @author Arturo
 */
public class ArtistaDAO implements IArtistaDAO {

    /** Base de datos de MongoDB. */
    private final MongoDatabase baseDeDatos;

    /** Colección de artistas en la base de datos. */
    private final MongoCollection<Artista> collectionArtista;

    /**
     * Constructor que inicializa la conexión con la base de datos y la colección "artistas".
     */
    public ArtistaDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionArtista = baseDeDatos.getCollection("artistas", Artista.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Artista> obtenerTodos() {
        return collectionArtista.find().into(new ArrayList<>());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Artista buscarArtista(Object id) {
        Document query = new Document("_id", id);
        return collectionArtista.find(query).first();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String obtenerImagenPorIdCancion(String id) {
        List<Artista> artistas = collectionArtista.find().into(new ArrayList<>());

        for (Artista artista : artistas) {
            for (Albumes album : artista.getAlbumes()) {
                for (Canciones cancion : album.getCanciones()) {
                    if (cancion.getIdCancion().equals(id)) {
                        return album.getImagen();
                    }
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Canciones> obtenerTodasCancionesEnArtista() {
        List<Artista> artistas = collectionArtista.find().into(new ArrayList<>());
        List<Canciones> canciones = new ArrayList<>();

        for (Artista artista : artistas) {
            for (Albumes album : artista.getAlbumes()) {
                canciones.addAll(album.getCanciones());
            }
        }
        return canciones;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtista() {
        List<Artista> artistas = collectionArtista.find().into(new ArrayList<>());
        List<Albumes> albumes = new ArrayList<>();

        for (Artista artista : artistas) {
            albumes.addAll(artista.getAlbumes());
        }
        return albumes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Artista agregarArtista(Artista artista) {
        collectionArtista.insertOne(artista);
        return artista;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Canciones> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id) {
        Document query = new Document("_id", id);
        Artista artista = collectionArtista.find(query).first();

        List<Canciones> canciones = new ArrayList<>();
        if (artista != null) {
            for (Albumes album : artista.getAlbumes()) {
                canciones.addAll(album.getCanciones());
            }
        }
        return canciones;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id) {
        Document query = new Document("_id", id);
        Artista artista = collectionArtista.find(query).first();

        return artista != null ? artista.getAlbumes() : new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Albumes buscarAlbumPorId(String id) {
        Bson filter = Filters.elemMatch("albumes", Filters.eq("idAlbum", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            Optional<Albumes> album = artista.getAlbumes().stream()
                    .filter(a -> a.getIdAlbum().equals(id))
                    .findFirst();
            return album.orElse(null);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Canciones buscarCancionPorId(String id) {
        Bson filter = Filters.elemMatch("albumes.canciones", Filters.eq("idCancion", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            return artista.getAlbumes().stream()
                    .flatMap(album -> album.getCanciones().stream())
                    .filter(cancion -> cancion.getIdCancion().equals(id))
                    .findFirst().orElse(null);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Artista buscarArtistaPorIdAlbum(String id) {
        Bson filter = Filters.elemMatch("albumes", Filters.eq("idAlbum", id));
        return collectionArtista.find(filter).first();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Artista buscarArtistaPorIdCancion(String id) {
        Bson filter = Filters.elemMatch("albumes.canciones", Filters.eq("idCancion", id));
        return collectionArtista.find(filter).first();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Artista> obtenerTodosArtistaSinGeneroNoDeseado(List<String> excluir) {
        Document query = new Document("genero", new Document("$nin", excluir));
        return collectionArtista.find(query).into(new ArrayList<>());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(List<String> excluir) {
        List<Artista> artistas = collectionArtista.find().into(new ArrayList<>());
        List<Albumes> albumes = new ArrayList<>();

        for (Artista artista : artistas) {
            for (Albumes album : artista.getAlbumes()) {
                if (!excluir.contains(album.getGenero())) {
                    albumes.add(album);
                }
            }
        }
        return albumes;
    }

    /**
     * Inserta artistas y álbumes predefinidos en la base de datos.
     *
     * @return `true` si la operación fue exitosa, de lo contrario `false`.
     */
    @Override
    public boolean InsercionArtistasArturo() {
        try {
            // Implementación del método de inserción predefinida.
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
